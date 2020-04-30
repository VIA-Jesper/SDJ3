package via.sdj3.colotask.service;

import via.sdj3.colotask.model.CoLoTask;
import via.sdj3.colotask.model.User;

import java.util.HashMap;

public interface CoLoTaskService {

    // HTTP GET --> Read
    HashMap<String, CoLoTask> getAllTasks();

    // HTTP POST --> Create
    CoLoTask addTask(CoLoTask task);


    User addUser(User user);
    HashMap<String, User> getAllUsers();
    User getUser(String id);
    User updateUser(User user);
    User deleteUser(User user);


}
