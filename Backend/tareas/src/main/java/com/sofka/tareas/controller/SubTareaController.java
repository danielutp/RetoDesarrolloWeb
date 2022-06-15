package com.sofka.tareas.controller;
import com.sofka.tareas.domain.SubTarea;
import com.sofka.tareas.domain.Tarea;
import com.sofka.tareas.service.SubTareaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

public class SubTareaController {
    @Autowired
    private SubTareaService subTareaRepository;

    @GetMapping(path = "api/subtareas")
    public Iterable<SubTarea> list(){
        return subTareaRepository.list();
    }

    @PostMapping(path = "api/subtarea")
    public SubTarea crearSubtarea(@RequestBody SubTarea subTarea){
        return subTareaRepository.crearSubtarea(subTarea);
    }

//    @PutMapping(value = "api/subtarea")
//    public SubTarea update(@RequestBody SubTarea subTarea, Tarea tarea){
//        if(subTarea.getId() != null){
//            return subTareaRepository.save(subTarea,tarea);
//        }
//        throw new RuntimeException("No existe el id para actualziar");
//    }

    @DeleteMapping(value = "api/{id}/subtarea")
    public void delete(@PathVariable("id")Long id){
        subTareaRepository.delete(id);
    }

    @GetMapping(value = "api/{id}/subtarea")
    public SubTarea get(@PathVariable("id") Long id){
        return subTareaRepository.get(id);
    }
}
