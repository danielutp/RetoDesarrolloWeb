package com.sofka.tareas.controller;
import com.sofka.tareas.domain.Tarea;
import com.sofka.tareas.service.TareaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@CrossOrigin
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

    @DeleteMapping(value = "api/tarea/{id}")
    public void borrarTarea(@PathVariable("id")Long id){
        tareaRepository.borrarTarea(id);
    }

}
