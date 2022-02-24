package com.errortime.todolist.api.task;

import com.errortime.todolist.entity.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/task")
@RestController
public class TaskController {

    @Autowired
    private TaskService service;

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody @Validated Task task) {
        service.save(task);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Task> findById(@PathVariable("id") Long id) {
        Task task = service.findById(id);
        return ResponseEntity.ok(task);
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<List<Task>> findByUserId(@PathVariable("id") Long id) {
        List<Task> taskList = service.findByUserId(id);
        return ResponseEntity.ok(taskList);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        service.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<Task>> findAll() {
        List<Task> taskList = service.findALl();
        return ResponseEntity.ok(taskList);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@RequestBody @Validated Task task, @PathVariable("id") Long id) {
        service.update(task, id);
        return ResponseEntity.ok().build();
    }

}
