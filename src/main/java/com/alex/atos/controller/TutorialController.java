package com.alex.atos.controller;


import com.alex.atos.entity.Tutorial;
import com.alex.atos.repository.TutorialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * The type Tutorial controller.
 */
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class TutorialController {
    /**
     * The Tutorial repository.
     */
    @Autowired
    TutorialRepository tutorialRepository;

    /**
     * Gets todos tutoriales.
     *
     * @param titulo the titulo
     * @return the todos tutoriales
     */
    @GetMapping("/tutoriales")
    public ResponseEntity<List<Tutorial>> getTodosTutoriales(@RequestParam(required = false) String titulo) {
        try {
            List<Tutorial> tutoriales = new ArrayList<Tutorial>();
            if (titulo == null)
                tutorialRepository.findAll().forEach(tutoriales::add);
            else
                tutorialRepository.findByTituloContaining(titulo).forEach(tutoriales::add);
            if (tutoriales.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(tutoriales, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Gets tutoriales por id.
     *
     * @param id the id
     * @return the tutoriales por id
     */
    @GetMapping("/tutoriales/{id}")
    public ResponseEntity<Tutorial> getTutorialesPorId(@PathVariable("id") long id) {
        Optional<Tutorial> tutorialData = tutorialRepository.findById(id);
        if (tutorialData.isPresent()) {
            return new ResponseEntity<>(tutorialData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Crear tutorial response entity.
     *
     * @param tutorial the tutorial
     * @return the response entity
     */
    @PostMapping("/tutoriales")
    public ResponseEntity<Tutorial> crearTutorial(@RequestBody Tutorial tutorial) {
        try {
            Tutorial _tutorial = tutorialRepository

                    .save(new Tutorial(tutorial.getTitulo(), tutorial.getDescripcion(), false));

            return new ResponseEntity<>(_tutorial, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Actualizar tutorial response entity.
     *
     * @param id       the id
     * @param tutorial the tutorial
     * @return the response entity
     */
    @PutMapping("/tutoriales/{id}")
    public ResponseEntity<Tutorial> actualizarTutorial(@PathVariable("id") long id, @RequestBody Tutorial tutorial) {
        Optional<Tutorial> tutorialData = tutorialRepository.findById(id);
        if (tutorialData.isPresent()) {
            Tutorial _tutorial = tutorialData.get();
            _tutorial.setTitulo(tutorial.getTitulo());
            _tutorial.setDescripcion(tutorial.getDescripcion());
            _tutorial.setPublicado(tutorial.esPublicado());
            return new ResponseEntity<>(tutorialRepository.save(_tutorial), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Eliminar tutorial response entity.
     *
     * @param id the id
     * @return the response entity
     */
    @DeleteMapping("/tutoriales/{id}")
    public ResponseEntity<HttpStatus> eliminarTutorial(@PathVariable("id") long id) {
        try {
            tutorialRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Eliminar todos tutoriales response entity.
     *
     * @return the response entity
     */
    @DeleteMapping("/tutoriales")
    public ResponseEntity<HttpStatus> eliminarTodosTutoriales() {
        try {
            tutorialRepository.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Buscar por publicado response entity.
     *
     * @return the response entity
     */
    @GetMapping("/tutoriales/publicado")
    public ResponseEntity<List<Tutorial>> buscarPorPublicado() {
        try {
            List<Tutorial> tutoriales = tutorialRepository.findByPublicado(true);
            if (tutoriales.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(tutoriales, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
