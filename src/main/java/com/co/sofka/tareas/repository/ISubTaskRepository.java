package com.co.sofka.tareas.repository;

import com.co.sofka.tareas.model.Subtask;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface ISubTaskRepository extends JpaRepository<Subtask, Long> {
      @Query(value = "select * from Subtask t where t.id_task = :idTask", nativeQuery = true)
      public  ArrayList<Subtask> findById_task(Long idTask);
}
