package com.sofka.tareas.domain;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.OneToMany;
import javax.persistence.FetchType;
import javax.persistence.CascadeType;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import java.util.ArrayList;
import java.util.List;


/**
 * Entidad Tarea
 *
 * @version 1.0.0 2022-06-17
 * @author Daniel Steven Gil Cruz <danistcruz@gmail.com>
 * @since 1.0.0
 */
@RequiredArgsConstructor
@Data
@Entity
@Table(name = "tarea")
public class Tarea {

    /**
     * Identificador de la tupla
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tarea", nullable = false)
    private Long id;


    /**
     * Nombre de la tarea
     */
    @Column(name = "nombre", nullable = false, length = 45)
    private String nombre;

    /**
     * Punto de enlace entre la entidad del Tarea y Subtarea (una tarea puede tener muchas subtareas)
     */
    @OneToMany(fetch = FetchType.EAGER,
            targetEntity = SubTarea.class,
            cascade = CascadeType.REMOVE,
            mappedBy = "tarea"
    )
    @JsonManagedReference
    private List<SubTarea> subtareas = new ArrayList<>();
}