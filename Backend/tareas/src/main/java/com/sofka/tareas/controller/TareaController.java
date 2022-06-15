package com.sofka.tareas.controller;
import com.sofka.tareas.domain.Tarea;
import com.sofka.tareas.service.TareaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
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
    public Tarea save(@RequestBody Tarea tarea){
        return tareaRepository.save(tarea);
    }

    @PutMapping(value = "api/tarea")
    public Tarea update(@RequestBody Tarea tarea){
        if(tarea.getId() != null){
            return tareaRepository.save(tarea);
        }
        throw new RuntimeException("No existe el id para actualziar");
    }

    @DeleteMapping(value = "api/{id}/tarea")
    public void delete(@PathVariable("id")Long id){
        tareaRepository.delete(id);
    }

    @GetMapping(value = "api/{id}/tarea")
    public Tarea get(@PathVariable("id") Long id){
        return tareaRepository.get(id);
    }

}