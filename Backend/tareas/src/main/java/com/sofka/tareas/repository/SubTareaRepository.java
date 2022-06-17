package com.sofka.tareas.repository;
import com.sofka.tareas.domain.SubTarea;
import org.springframework.data.repository.CrudRepository;

/**
 * Repositorio para la entidad Subtarea
 *
 * @version 1.0.0 2022-06-17
 * @author Daniel Steven Gil Cruz <danistcruz@gmail.com>
 * @since 1.0.0
 */
public interface SubTareaRepository extends CrudRepository<SubTarea, Long> {

}