package com.errortime.todolist;

import com.errortime.todolist.api.task.TaskRepository;
import com.errortime.todolist.api.user.UserRepository;
import com.errortime.todolist.entity.Task;
import com.errortime.todolist.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class ApplicationStartup implements ApplicationListener<ApplicationReadyEvent> {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public void onApplicationEvent(final ApplicationReadyEvent event) {

        userRepository.save(
                new User(
                        null,
                        "https://upload.wikimedia.org/wikipedia/commons/b/b1/VAN_CAT.png",
                        "Cat",
                        "Pet",
                        null
                )
        );

        taskRepository.save(
                new Task(
                        null,
                        "testTask",
                        "testDescription",
                        new Date(),
                        new User(
                                1L
                        )
                )
        );

    }
}