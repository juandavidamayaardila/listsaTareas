package com.co.sofka.tareas.service;


import com.co.sofka.tareas.model.Task;
import com.co.sofka.tareas.repository.ITaskRepository;
import org.modelmapper.ModelMapper;

import org.springframework.stereotype.Service;
import java.util.ArrayList;


@Service
public class TaskService {

    final
    ITaskRepository taskRepository;

    final
    ModelMapper modelMapper;

    public TaskService(ITaskRepository taskRepository, ModelMapper modelMapper) {
        this.taskRepository = taskRepository;
        this.modelMapper = modelMapper;
    }

    /**
     * Permite obtener todas las tareas almacenadas.
     *
     * @return lista de tareas.
     */
    public ArrayList<Task> getTaskAll(){

        return (ArrayList<Task>) taskRepository.findAll();

    }

    /**
     * Permite guardar en base de datos una tarea
     *
     * @param task tarea a ser almacenada
     * @return tarea almacenada con su id incluido
     */
    public Task saveTask(Task task){

        return taskRepository.save(task);

    }

    public Boolean deleteTask(Long idTask){
        try {
            taskRepository.deleteById(idTask);
            return true;
        }catch (Exception err){
            return false;
        }
    }

}
