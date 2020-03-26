package main.java.exercises_messages;

import main.java.requiredsource.Task;

public class TaskListProxy implements ITaskList {

    private ClientComm clientComm;

    public TaskListProxy(ClientComm clientComm){
        this.clientComm = clientComm;
    }


    @Override
    public void addTask(Task task) {
        clientComm.doOperation(task);
    }



}
