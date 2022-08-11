package com.example.tasktracker.controller;

import com.example.tasktracker.model.API;
import org.springframework.scheduling.config.Task;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class TrackerSystem {
    ArrayList<Task> task = new ArrayList();

   @GetMapping("/task")
    public ArrayList<Task> getTask() {
        return task;
    }

    @PostMapping("/task")
    public API addTask(@RequestBody Task t) {
        task.add(t);
        return new API("Add message");
    }

    @PutMapping("/task/{index}")
    public API updateTask(@RequestBody Task t, @PathVariable int index) {
        task.set(index, t);
        return new API("Update message");
    }

    @DeleteMapping("/task/{index}")
    public API deleteTask(@PathVariable int index) {
        task.remove(index);
        return new API(" Delete message");
    }

    @PostMapping("/task/status")
    public API statusTask(@RequestParam int id, @RequestParam String status) {
        for (int i = 0; i < task.size(); i++) {
            if (task.get(i).equals(id)) {
                task.get(i).equals(status);
                return new API("done");
            }
            return new API("not done");
        }
        return new API("not found");
    }

    @GetMapping("/task/search")
    public API searchTask(@RequestParam String title) {
        for (int i = 0; i < task.size(); i++) {
            task.get(i).equals(title);
            return new API("given title");
        } return new API("not found");
    }
}

