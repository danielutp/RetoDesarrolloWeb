package com.sofka.tareas.service;
import com.sofka.tareas.domain.SubTarea;
import com.sofka.tareas.repository.SubTareaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;

/**
 * Clase de tipo Servicio para el manejo de la Subtarea
 *
 * @version 1.0.0 2022-06-17
 * @author Daniel Steven Gil Cruz <danistcruz@gmail.com>
 * @since 1.0.0
 */
@Service
public class SubTareaService {

    /**
     * Repositorio de SubTarea
     */
    @Autowired
    private SubTareaRepository subTareaRepository;

    /**
     * Devuelve una lista de las subtareas
     *
     * @return list
     *
     * @author Daniel Steven Gil Cruz <danistcruz@gmail.com>
     * @since 1.0.0
     */
    public Iterable<SubTarea> list(){
        return subTareaRepository.findAll();
    }

    /**
     * Crea una SubTarea
     *
     * @param subTarea Objeto SubTarea a crear
     * @return Objeto SubTarea creado
     *
     * @author Daniel Steven Gil Cruz <danistcruz@gmail.com>
     * @since 1.0.0
     */
    public SubTarea crearSubtarea(SubTarea subTarea){
        subTarea.setCompletado(false);
        return subTareaRepository.save(subTarea);
    }

    /**
     * Borra una Subtarea
     *
     * @param id Identificador de la subtarea a borrar
     *
     * @author Daniel Steven Gil Cruz <danistcruz@gmail.com>
     * @since 1.0.0
     */
    public void borrarSubtarea(Long id){
        subTareaRepository.delete(get(id));
    }

    /**
     * Encuentra una subtarea por el ID
     *
     * @param id de la subtarea a buscar
     * @return Objeto Tarea
     *
     * @author Daniel Steven Gil Cruz <danistcruz@gmail.com>
     * @since 1.0.0
     */
    public SubTarea get(Long id){
        return subTareaRepository.findById(id).orElseThrow();
    }

    /**
     * Actualiza una subtarea
     *
     * @param id id de la subtarea
     * @param subTarea Objeto a actualizar
     * @return subTarea
     *
     * @author Daniel Steven Gil Cruz <danistcruz@gmail.com>
     * @since 1.0.0
     */
    @Transactional
    public SubTarea actualizarSubtarea(Long id, SubTarea subTarea) {
        subTarea.setId(id);
        subTareaRepository.save(subTarea);
        return subTarea;
    }
}