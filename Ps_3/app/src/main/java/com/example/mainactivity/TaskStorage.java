package com.example.mainactivity;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class TaskStorage {
    private static TaskStorage instance = new TaskStorage();

    private final List<Task> tasks;

    public static TaskStorage getInstance() {

        return instance;
    }
    private TaskStorage()
    {
        int tasksCount = 100;
        tasks = new ArrayList<Task>(tasksCount);
        for (int i=1; i <=tasksCount; i++)
        {
            Task task = new Task();
            task.setName("Zadanie numer " + i);
            task.setDone(i % 3 == 0);
            tasks.add(task);
        }
    }

    // metoda zwracająca całą listę
    public List<Task> getTasks()
    {
        return tasks;
    }

    // metoda zwracająca konkretne zadanie
    public Task getTask(UUID id) {
        for (Task task : tasks){
            if (task.getId().equals(id)){
                return task;
            }
        }
        return null;
    }

    public void addTask(Task task) {
        tasks.add(task);
    }

}
