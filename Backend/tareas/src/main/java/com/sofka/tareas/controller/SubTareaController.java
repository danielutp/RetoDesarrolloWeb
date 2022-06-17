package com.sofka.tareas.controller;
import com.sofka.tareas.domain.SubTarea;
import com.sofka.tareas.service.SubTareaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.DeleteMapping;

/**
 * Controlador para Tarea
 *
 * @version 1.0.0 2022-06-17
 * @author Daniel Steven Gil Cruz <danistcruz@gmail.com>
 * @since 1.0.0
 */
@Slf4j
@CrossOrigin
@RestController
public class SubTareaController {
    @Autowired
    private SubTareaService subTareaRepository;

    /**
     * Devuelve una lista de subtareas
     *
     * @author Daniel Steven Gil Cruz <danistcruz@gmail.com>
     * @since 1.0.0
     */
    @GetMapping(path = "api/subtareas")
    public Iterable<SubTarea> list(){
        return subTareaRepository.list();
    }

    /**
     * Crea una subtarea
     *
     * @param subTarea Objeto de la subtarea
     *
     * @author Daniel Steven Gil Cruz <danistcruz@gmail.com>
     * @since 1.0.0
     */
    @PostMapping(path = "api/subtarea")
    public SubTarea crearSubtarea(@RequestBody SubTarea subTarea){
        return subTareaRepository.crearSubtarea(subTarea);
    }

    /**
     * Actualiza una subtarea
     *
     * @param subTarea Objeto de subTarea
     * @param id de la subTarea
     *
     * @author Daniel Steven Gil Cruz <danistcruz@gmail.com>
     * @since 1.0.0
     */
    @PutMapping(path = "/api/subtarea/{id}")
    public SubTarea updateSubtarea(@RequestBody SubTarea subTarea, @PathVariable(value="id") Long id ) {
        subTareaRepository.actualizarSubtarea(id, subTarea);
        return null;
    }

    /**
     * Borra una subtarea
     *
     * @param id de la subtarea a borrar
     *
     * @author Daniel Steven Gil Cruz <danistcruz@gmail.com>
     * @since 1.0.0
     */
    @DeleteMapping(path = "api/subtarea/{id}")
    public void deleteSubtarea(@PathVariable("id")Long id){
        subTareaRepository.borrarSubtarea(id);
    }
}