package com.co.sofka.tareas.model;

import javax.persistence.*;
import java.util.Objects;

/**
 * Clase entity representa la tabla
 * donde se almacenara las subtareas.
 *
 *  @version  01.02.003 16/06/2022
 *  @author JD-Amaya
 *  @since 01.
 *
 */
@Entity
public class Subtask {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true, nullable = false)
    private Long id;

    @Column(length = 50, nullable = false)
    private String description;

    /**
     * Relacion de muchos a uno
     * donde una tarea tiene muchas subtareas.
     */
    @ManyToOne()
    @JoinColumn(name = "id_Task")
    private Task task;

    public Subtask() {

    }


    public Subtask(Long id, String description, Task task) {
        this.id = id;
        this.description = description;
        this.task = task;
    }

    public Subtask(String description, Task task) {
        this.description = description;
        this.task = task;
    }

    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Task getTarea() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Subtask subtask = (Subtask) o;
        return id.equals(subtask.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Subtarea{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", tarea=" + task +
                '}';
    }
}
