package com.sofka.tareas.controller;
import com.sofka.tareas.domain.Tarea;
import com.sofka.tareas.service.TareaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class TareaController {

    @Autowired
    private TareaService tareaRepository;

    @GetMapping(value = "api/tareas")
    public Iterable<Tarea> list(){
        return tareaRepository.list();
    }

    @PostMapping(value = "api/tarea")
    public Tarea crearTarea(@RequestBody Tarea tarea){
        return tareaRepository.crearTarea(tarea);
    }

    @DeleteMapping(value = "api/{id}/tarea")
    public void borarTarea(@PathVariable("id")Long id){
        tareaRepository.borrarTarea(id);
    }

}