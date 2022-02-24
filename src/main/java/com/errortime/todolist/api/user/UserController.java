package com.errortime.todolist.api.user;

import com.errortime.todolist.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/user")
@RestController
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody @Validated User task) {
        service.save(task);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable("id") Long id) {
        User user = service.findById(id);
        return ResponseEntity.ok(user);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        service.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<User>> findAll() {
        List<User> userList = service.findALl();
        return ResponseEntity.ok(userList);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@RequestBody @Validated User user, @PathVariable("id") Long id) {
        service.update(user, id);
        return ResponseEntity.ok().build();
    }
}
