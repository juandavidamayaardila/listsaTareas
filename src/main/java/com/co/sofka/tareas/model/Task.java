package com.co.sofka.tareas.model;

import javax.persistence.*;
import java.util.List;
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
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true, nullable = false)
    private Long id;
    private String description;

    /**
     * Relacion de one a muchos,
     * una tarea tiene muchas subtareas.
     */
    @OneToMany
    @JoinColumn(name = "id_Task")
    private List<Subtask> listSubTasks;

    public Task() {

    }

    public Task(Long id, String description) {
        this.id = id;
        this.description = description;
    }

    public Task(String description) {
        this.description = description;
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



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return id.equals(task.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", description='" + description + '\'' +
                '}';
    }
}
