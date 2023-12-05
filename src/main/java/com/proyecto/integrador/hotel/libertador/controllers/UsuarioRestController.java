package com.proyecto.integrador.hotel.libertador.controllers;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.proyecto.integrador.hotel.libertador.models.entity.Archivos;
import com.proyecto.integrador.hotel.libertador.models.entity.Usuario;
import com.proyecto.integrador.hotel.libertador.models.service.IArchivosService;
import com.proyecto.integrador.hotel.libertador.models.service.IS3Service;
import com.proyecto.integrador.hotel.libertador.models.service.IUploadFileService;
import com.proyecto.integrador.hotel.libertador.models.service.IUsuarioService;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Valid;

@CrossOrigin(origins= {"http://localhost:5173"})
@RestController
@RequestMapping("/api")
public class UsuarioRestController {
	@Autowired
	private IUsuarioService usuarioService;
	
	@Autowired
	private IS3Service S3Service;
	
	@Autowired
	private IArchivosService archivoService;
	
	private final Logger log=LoggerFactory.getLogger(UsuarioRestController.class);

	@GetMapping("/usuarios")
	public List<Usuario> index() {
		return usuarioService.findAll();
	}
	
	@GetMapping("/usuarios/page/{page}")
	public Page<Usuario> index(@PathVariable Integer page) {
	    Pageable pageable = PageRequest.of(page, 10);
	    return usuarioService.findAll(pageable);
	}

	@GetMapping("/usuarios/{id}")
	public ResponseEntity<?> show(@PathVariable Long id) {
		Usuario usuario = null;
		Map<String, Object> response = new HashMap();

		try {
			usuario = usuarioService.findById(id);

		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta en la base de datos");
			response.put("error", e.getMessage().concat(":").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		if (usuario == null) {
			response.put("mensaje", "El cliente ID: ".concat(id.toString().concat(" no existe en la base de datos")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
	}

	@PostMapping("/usuarios")
	public ResponseEntity<?> create(@Valid @RequestBody Usuario usuario, BindingResult result) {
		Usuario nuevoUsuario=null;
		Map<String, Object> response = new HashMap();
		
		if(result.hasErrors()) {
			List<String> errors=result.getFieldErrors()
					.stream()
					.map(err->"El campo '"+err.getField()+"' "+err.getDefaultMessage())
					.collect(Collectors.toList());
			
			response.put("errors", errors);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}	
		
		try {
			nuevoUsuario=usuarioService.save(usuario);
			
		}catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar el insert en la base de datos");
			response.put("error", e.getMessage().concat(":").concat(e.getMostSpecificCause().getMessage()));
			if (e.getCause() instanceof ConstraintViolationException) {
	            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CONFLICT);
	        }

	        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "El usuario se creo con exito");
		response.put("usuario", nuevoUsuario);
		response.put("IdUsuario", nuevoUsuario.getId());
		return new ResponseEntity<Map<String,Object>>(response ,HttpStatus.CREATED);
	}
	
	@PutMapping("/usuarios/{id}")
	public ResponseEntity<?> update(@Valid @RequestBody Usuario usuario, BindingResult result, @PathVariable Long id) {
		Usuario usuarioActual=usuarioService.findById(id);
		Usuario usuarioActualizado=null; 
		
		Map<String, Object> response = new HashMap();
		
		if(result.hasErrors()) {
			List<String> errors=result.getFieldErrors()
					.stream()
					.map(err->"El campo '"+err.getField()+"' "+err.getDefaultMessage())
					.collect(Collectors.toList());
			
			response.put("errors", errors);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}
		
		if (usuarioActual == null) {
			response.put("mensaje", "Error, no se puede editar, el usuario ID: ".concat(id.toString().concat(" no existe en la base de datos")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		try {
			usuarioActual.setEmail(usuario.getEmail());
		    usuarioActual.setContrasena(usuario.getContrasena());
		    usuarioActual.setNombre(usuario.getNombre());
		    usuarioActual.setTelefono(usuario.getTelefono());
		    usuarioActual.setTipo(usuario.getTipo());
			usuarioActual.setApellido(usuario.getApellido());
			
			usuarioActualizado= usuarioService.save(usuarioActual);
			
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al actualizar el usuario en la base de datos");
			response.put("error", e.getMessage().concat(":").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "El usuario se actualizo con exito");
		response.put("usuario", usuarioActual);
		return new ResponseEntity<Map<String,Object>>(response ,HttpStatus.CREATED);	
	}
	
	

	
	/*@PostMapping("usuarios/upload")
	public ResponseEntity<?> upload(@RequestParam("archivo") MultipartFile archivo, @RequestParam("id") Long id){
		Map<String, Object> response = new HashMap();
		
		Usuario usuario=usuarioService.findById(id);
		
		if(!archivo.isEmpty()) {
			String nombreArchivo=null;
			try {
				nombreArchivo=uploadService.copiar(archivo);
			} catch (IOException e) {
				response.put("mensaje", "Error al subir la imagen");
				response.put("error", e.getMessage().concat(":").concat(e.getCause().getMessage()));
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
			}
			
			String nombreFotoAnterior=usuario.getFoto();
			
			uploadService.eliminar(nombreFotoAnterior);
			
			usuario.setFoto(nombreArchivo);
			usuarioService.save(usuario);
			response.put("usuario", usuario);
			response.put("mensaje", "Se ha subido correctamente la imagen"+nombreArchivo);
		}
		return new ResponseEntity<Map<String,Object>>(response ,HttpStatus.CREATED);	
	}
	*/

	
	@PostMapping("/usuarios/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> loginRequest) {
        String email = loginRequest.get("email");
        String contrasena = loginRequest.get("contrasena");

        Usuario usuario = usuarioService.findByEmailAndContrasena(email, contrasena);

        if (usuario == null) {
            Map<String, Object> response = new HashMap<>();
            response.put("mensaje", "Usuario no encontrado o credenciales incorrectas");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(usuario, HttpStatus.OK);
    }
}