package com.co.sofka.tareas.repository;

import com.co.sofka.tareas.model.Subtask;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface ISubTaskRepository extends JpaRepository<Subtask, Long> {

   // public abstract ArrayList<Subtask> findByIdTask(Long idTask);
}
