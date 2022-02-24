package com.errortime.todolist.api.user;

import com.errortime.todolist.api.task.TaskRepository;
import com.errortime.todolist.entity.Task;
import com.errortime.todolist.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@Transactional
public class UserService {

    @Autowired
    private UserRepository repository;

    public User save(User task) {
        return repository.save(task);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public User findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new ResponseStatusException(
                HttpStatus.NOT_FOUND, "entity not found"
        ));
    }
    public List<User> findALl() {
        return repository.findAll();
    }

    public User update(User task, Long id) {
        return save(task);
    }
}
