package com.sofka.tareas.service;
import com.sofka.tareas.domain.SubTarea;
import com.sofka.tareas.domain.Tarea;
import com.sofka.tareas.repository.SubTareaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubTareaService {
    @Autowired
    private SubTareaRepository subTareaRepository;

    public Iterable<SubTarea> list(){
        return subTareaRepository.findAll();
    }

    public SubTarea crearSubtarea(SubTarea subTarea){
       // subTarea.setCompletado(false);
        return subTareaRepository.save(subTarea);
    }

    public void delete(Long id){
        subTareaRepository.delete(get(id));
    }
    public SubTarea get(Long id){
        return subTareaRepository.findById(id).orElseThrow();
    }

}