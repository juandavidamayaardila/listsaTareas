package com.co.sofka.tareas.service;


import com.co.sofka.tareas.model.Subtask;
import com.co.sofka.tareas.repository.ISubTaskRepository;
import org.modelmapper.ModelMapper;

import org.springframework.stereotype.Service;
import java.util.ArrayList;


@Service
public class SubTaskService {

    final
    ISubTaskRepository subTaskRepository;

    final
    ModelMapper modelMapper;


    /**
     * Inyactamos la depencia del repositorio.
     *
     * @param subTaskRepository repository
     */
    public SubTaskService(ISubTaskRepository subTaskRepository, ModelMapper modelMapper) {
        this.subTaskRepository = subTaskRepository;
        this.modelMapper = modelMapper;
    }

    /**
     * Permite obtener todas las subtareas almacenadas.
     *
     * @return lista de subtareas.
     */
    public ArrayList<Subtask> getSubtasAll(){

        return (ArrayList<Subtask>) subTaskRepository.findAll();
    }

    public ArrayList<Subtask> getSubtaskByIdTask(Long idTask){

        return (ArrayList<Subtask>) subTaskRepository.findById_task(idTask);
    }

    /**
     * Permite almacenar un subtarea en base de datos.
     *
     * @param subtask subtarea a ser almacenada.
     * @return suptarea almacenada con su id.
     */
    public Subtask saveSubTask(Subtask subtask){

        return subTaskRepository.save(subtask);
    }

    public Boolean deleteSubTaskId(Long idSubTask){
        try {
            subTaskRepository.deleteById(idSubTask);
            return true;
        }catch (Exception err){
            return false;
        }
    }

}
