package com.co.sofka.tareas.model;

import javax.persistence.*;

@Entity
public class Subtask {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 50, nullable = false)
    private String description;

    @ManyToOne
    @JoinColumn(name = "id_Task")
    private Task task;

    public Subtask() {

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
    public String toString() {
        return "Subtarea{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", tarea=" + task +
                '}';
    }
}
