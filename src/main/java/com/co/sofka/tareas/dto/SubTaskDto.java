package com.co.sofka.tareas.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Objects;

public class SubTaskDto {


    private Long id;
    @NotBlank
    @Size(min = 3)
    private String description;
    private TaskDto taskDto;

    public SubTaskDto() {

    }

    public SubTaskDto(Long id, String description, TaskDto taskDto) {
        this.id = id;
        this.description = description;
        this.taskDto = taskDto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TaskDto getTaskDto() {
        return taskDto;
    }

    public void setTaskDto(TaskDto taskDto) {
        this.taskDto = taskDto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SubTaskDto that = (SubTaskDto) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
