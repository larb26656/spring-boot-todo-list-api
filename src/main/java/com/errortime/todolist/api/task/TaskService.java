package com.errortime.todolist.api.task;

import com.errortime.todolist.entity.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@Transactional
public class TaskService {

    @Autowired
    private TaskRepository repository;

    public Task save(Task task) {
        return repository.save(task);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public Task findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new ResponseStatusException(
                HttpStatus.NOT_FOUND, "entity not found"
        ));
    }

    public List<Task> findByUserId(Long id) {
        return repository.findByUserId(id);
    }

    public List<Task> findALl() {
        return repository.findAll();
    }

    public Task update(Task task, Long id) {
        return save(task);
    }

}
