package com.sofka.tareas.repository;
import com.sofka.tareas.domain.Tarea;
import org.springframework.data.repository.CrudRepository;

/**
 * Repositorio para la entidad Tarea
 *
 * @version 1.0.0 2022-06-17
 * @author Daniel Steven Gil Cruz <danistcruz@gmail.com>
 * @since 1.0.0
 */
public interface TareaRepository extends CrudRepository<Tarea, Long> {
}