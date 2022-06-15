package com.sofka.tareas.controller;
import com.sofka.tareas.domain.SubTarea;
import com.sofka.tareas.service.SubTareaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@CrossOrigin
@RestController
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

    @PutMapping(path = "/api/subtarea/{id}")
    public SubTarea updateSubtarea(@RequestBody SubTarea subTarea, @PathVariable(value="id") Long id ) {
        subTareaRepository.actualizarSubtarea(id, subTarea);
        return null;
    }

    @DeleteMapping(path = "api/subtarea/{id}")
    public void deleteSubtarea(@PathVariable("id")Long id){
        subTareaRepository.borrarSubtarea(id);
    }
}