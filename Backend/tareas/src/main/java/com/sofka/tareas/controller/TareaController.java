package com.sofka.tareas.controller;
import com.sofka.tareas.domain.Tarea;
import com.sofka.tareas.service.TareaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
public class TareaController {
    @Autowired
    private TareaService tareaRepository;

    /**
     * Devuelve la lista de tareas
     *
     * @return list
     *
     * @author Daniel Steven Gil Cruz <danistcruz@gmail.com>
     * @since 1.0.0
     */
    @GetMapping(value = "api/tareas")
    public Iterable<Tarea> list(){
        return tareaRepository.list();
    }

    /**
     * Crea una Tarea
     *
     * @param tarea a crear
     *
     * @author Daniel Steven Gil Cruz <danistcruz@gmail.com>
     * @since 1.0.0
     */
    @PostMapping(value = "api/tarea")
    public Tarea crearTarea(@RequestBody Tarea tarea){
        return tareaRepository.crearTarea(tarea);
    }

    /**
     * Elimina una tarea
     *
     * @param id de la tarea a borrar
     *
     * @author Daniel Steven Gil Cruz <danistcruz@gmail.com>
     * @since 1.0.0
     */
    @DeleteMapping(value = "api/tarea/{id}")
    public void borrarTarea(@PathVariable("id")Long id){
        tareaRepository.borrarTarea(id);
    }
}