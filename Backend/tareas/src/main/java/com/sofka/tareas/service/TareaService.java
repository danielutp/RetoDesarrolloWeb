package com.sofka.tareas.service;
import com.sofka.tareas.domain.Tarea;
import com.sofka.tareas.repository.TareaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class TareaService {

    @Autowired
    private TareaRepository tareaRepository;

    public Iterable<Tarea> list(){
        return tareaRepository.findAll();
    }

    public Tarea crearTarea(Tarea tarea){
        return tareaRepository.save(tarea);
    }

    public void borrarTarea(Long id){
        tareaRepository.delete(get(id));
    }

    public Tarea get(Long id){
        return tareaRepository.findById(id).orElseThrow();
    }

}
