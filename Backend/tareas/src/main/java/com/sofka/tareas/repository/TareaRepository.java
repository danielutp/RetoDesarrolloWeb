package com.sofka.tareas.repository;
import com.sofka.tareas.domain.Tarea;
import org.springframework.data.repository.CrudRepository;

public interface TareaRepository extends CrudRepository<Tarea, Long> {
}