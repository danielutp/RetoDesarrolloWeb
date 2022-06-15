package com.sofka.tareas.repository;
import com.sofka.tareas.domain.SubTarea;
import org.springframework.data.repository.CrudRepository;

public interface SubTareaRepository extends CrudRepository<SubTarea, Long> {

    static SubTarea save(SubTarea subTarea, Long idTarea) {
        return subTarea;
    }
}