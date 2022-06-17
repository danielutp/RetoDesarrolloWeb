package com.sofka.tareas.service;
import com.sofka.tareas.domain.Tarea;
import com.sofka.tareas.repository.TareaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Clase de tipo Servicio para el manejo de la Tarea
 *
 * @version 1.0.0 2022-06-17
 * @author Daniel Steven Gil Cruz <danistcruz@gmail.com>
 * @since 1.0.0
 */
@Service
public class TareaService {

    /**
     * Repositorio de Tarea
     */
    @Autowired
    private TareaRepository tareaRepository;

    /**
     * Devuelve una lista de tareas con todas las subtareas
     *
     * @return list
     *
     * @author Daniel Steven Gil Cruz <danistcruz@gmail.com>
     * @since 1.0.0
     */
    public Iterable<Tarea> list(){
        return tareaRepository.findAll();
    }

    /**
     * Crea una Tarea
     *
     * @param tarea Objeto Tarea a crear
     * @return Objeto Tarea creado
     *
     * @author Daniel Steven Gil Cruz <danistcruz@gmail.com>
     * @since 1.0.0
     */
    public Tarea crearTarea(Tarea tarea){
        return tareaRepository.save(tarea);
    }

    /**
     * Borra una tarea
     *
     * @param id Identificador de la tarea a borrar
     *
     * @author Daniel Steven Gil Cruz <danistcruz@gmail.com>
     * @since 1.0.0
     */
    public void borrarTarea(Long id){
        tareaRepository.delete(get(id));
    }

    /**
     * Encuentra una tarea por el ID
     *
     * @param id de la tarea a buscar
     * @return Objeto Tarea
     *
     * @author Daniel Steven Gil Cruz <danistcruz@gmail.com>
     * @since 1.0.0
     */
    public Tarea get(Long id){
        return tareaRepository.findById(id).orElseThrow();
    }
}