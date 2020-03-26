package main.java.exercises_messages;

import main.java.requiredsource.Task;

public interface Recipient {

    byte[] getMessage(Task message);
}
