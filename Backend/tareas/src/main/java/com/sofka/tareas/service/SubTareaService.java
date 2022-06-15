package com.sofka.tareas.service;
import com.sofka.tareas.domain.SubTarea;
import com.sofka.tareas.repository.SubTareaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;

@Service
public class SubTareaService {
    @Autowired
    private SubTareaRepository subTareaRepository;
    public Iterable<SubTarea> list(){
        return subTareaRepository.findAll();
    }

    public SubTarea crearSubtarea(SubTarea subTarea){
        subTarea.setCompletado(false);
        return subTareaRepository.save(subTarea);
    }

    public void borrarSubtarea(Long id){
        subTareaRepository.delete(get(id));
    }
    public SubTarea get(Long id){
        return subTareaRepository.findById(id).orElseThrow();
    }
    @Transactional
    public SubTarea actualizarSubtarea(Long id, SubTarea subTarea) {
        subTarea.setId(id);
        subTareaRepository.save(subTarea);
        return subTarea;
    }
}