package com.proyecto.integrador.hotel.libertador.controllers;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.proyecto.integrador.hotel.libertador.models.dao.IArchivosDao;
import com.proyecto.integrador.hotel.libertador.models.entity.Archivos;
import com.proyecto.integrador.hotel.libertador.models.entity.Categoria;
import com.proyecto.integrador.hotel.libertador.models.entity.Habitacion;
import com.proyecto.integrador.hotel.libertador.models.service.IArchivoService;
import com.proyecto.integrador.hotel.libertador.models.service.ICategoriaService;
import com.proyecto.integrador.hotel.libertador.models.service.IHabitacionService;

@CrossOrigin(origins= {"http://localhost:5173"})
@RestController
@RequestMapping("/api")
public class ArchivosRestController {

	@Autowired
    private IArchivoService archivoService;

    @Autowired
    private IArchivosDao archivosDao;
    
    @Autowired
    private ICategoriaService categoriaService;

    @Autowired
    private IHabitacionService habitacionService;
    
    @PostMapping("/archivo/subir")
    public ResponseEntity<?> subirArchivo(
            @RequestParam("archivo") MultipartFile archivo,
            @RequestParam("tipoEntidad") String tipoEntidad,
            @RequestParam("idEntidad") Long idEntidad) {

        Map<String, Object> response = new HashMap();

        Archivos archivos = new Archivos();

        switch (tipoEntidad.toLowerCase()) {
            case "categoria":
                Categoria categoria = categoriaService.findById(idEntidad);
                archivos.setCategoria(categoria);
                break;
            case "habitacion":
                Habitacion habitacion = habitacionService.findById(idEntidad);
                archivos.setHabitacion(habitacion);
                break;
            // Puedes agregar más casos para otros tipos de entidad si es necesario
            default:
                response.put("mensaje", "Tipo de entidad no válido");
                return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
        }

        if (!archivo.isEmpty()) {
            String nombreArchivo = null;
            try {
                nombreArchivo = archivoService.subir(archivo);

                archivos.setNombre(nombreArchivo);
                archivosDao.save(archivos);

                response.put("archivos", archivos);
                response.put("mensaje", "Se ha subido correctamente el archivo " + nombreArchivo);
            } catch (IOException e) {
                response.put("mensaje", "Error al subir el archivo");
                response.put("error", e.getMessage().concat(":").concat(e.getCause().getMessage()));
                return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } else {
            response.put("mensaje", "El archivo está vacío");
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }
}
    
    
    
    
    
      
/*

    @GetMapping("/cargar/{nombreArchivo}")
    public ResponseEntity<Resource> cargarArchivo(@PathVariable String nombreArchivo) {
        try {
            Resource recurso = archivoService.cargar(nombreArchivo);
            return ResponseEntity.ok()
                    .header("Content-Disposition", "attachment; filename=\"" + recurso.getFilename() + "\"")
                    .body(recurso);
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @DeleteMapping("/eliminar/{nombreArchivo}")
    public ResponseEntity<String> eliminarArchivo(@PathVariable String nombreArchivo) {
        if (archivoService.eliminar(nombreArchivo)) {
            return ResponseEntity.ok("Archivo eliminado exitosamente: " + nombreArchivo);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se pudo eliminar el archivo: " + nombreArchivo);
        }
    }
}
	*/

