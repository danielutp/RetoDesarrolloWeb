package com.sofka.tareas.domain;
import com.fasterxml.jackson.annotation.JsonBackReference;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import lombok.Data;

/**
 * Entidad Subtarea
 *
 * @version 1.0.0 2022-06-17
 * @author Daniel Steven Gil Cruz <danistcruz@gmail.com>
 * @since 1.0.0
 */
@Data
@Entity
@Table(name = "subTarea")
public class SubTarea {

    /**
     * Identificador de la tupla
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_subTarea", nullable = false)
    private Long id;

    /**
     * Nombre de la subtarea
     */
    @Column(name = "nombre", nullable = false, length = 45)
    private String nombre;

    /**
     * Variable para saber si esta completada la tarea
     */
    @Column(name = "completado")
    private boolean completado;

    /**
     * Punto de enlace entre la entidad de la Tarea y Subtarea (una tarea puede tener muchas subtareas)
     */
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "Tarea_id_tarea", nullable = false)
    @JsonBackReference
    private Tarea tarea;
}