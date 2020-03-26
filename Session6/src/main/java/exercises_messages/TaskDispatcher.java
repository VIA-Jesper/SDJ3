package main.java.exercises_messages;

import main.java.requiredsource.ByteConverter;
import main.java.requiredsource.Task;
import main.java.requiredsource.TaskList;

import java.io.IOException;

public class TaskDispatcher implements Recipient {


    private ITaskList taskList;

    public TaskDispatcher(ITaskList taskList) {
        this.taskList = taskList;
    }


    @Override
    public byte[] getMessage(Task message) {
        return ByteConverter.toByteArray(message);
    }


    public void addMessage(Task message) {
        taskList.addTask(message);
    }
}
