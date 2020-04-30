package via.sdj3.colotask.service;

import org.springframework.stereotype.Service;
import via.sdj3.colotask.ColotaskApp;
import via.sdj3.colotask.model.CoLoTask;
import via.sdj3.colotask.model.User;

import java.time.LocalDateTime;
import java.util.HashMap;



@Service
public class CoLoTaskServiceImpl implements CoLoTaskService {


    @Override
    public HashMap<String, CoLoTask> getAllTasks() {

        return ColotaskApp.taskHashMap;
    }

    @Override
    public CoLoTask addTask(CoLoTask task) {
        CoLoTask resultSet = ColotaskApp.taskHashMap.get(task.getId());
        if (resultSet != null) {
            resultSet.setDateModified(LocalDateTime.now());
            resultSet.setDescription(task.getDescription());
            resultSet.setCompleted(task.isCompleted());
            task = resultSet;
        }

        ColotaskApp.taskHashMap.put(task.getId(), task);
        return task;
    }

    @Override
    public User addUser(User user) {
        User resultSet = (ColotaskApp.userHashMap.get(user.getId()));
        if (resultSet != null) {
            resultSet.setId(user.getId());
            resultSet.setEmail(user.getEmail());
            resultSet.setPassword(user.getPassword());
            user = resultSet;
        }
        ColotaskApp.userHashMap.put(user.getId(), user);
        return resultSet;
    }

    @Override
    public HashMap<String, User> getAllUsers() {
        return ColotaskApp.userHashMap;
    }

    @Override
    public User getUser(String id) {
        HashMap<String, User> users = ColotaskApp.userHashMap;
        User user = users.values().stream()
                .filter(u -> u.getId() == id)
                .findFirst().get();
        return user;
    }

    @Override
    public User updateUser(User user) {
        User resultSet = (ColotaskApp.userHashMap.get(user.getId()));
        if (resultSet != null) {
            resultSet.setEmail(user.getEmail());
            resultSet.setPassword(user.getPassword());
            user = resultSet;
        }
        ColotaskApp.userHashMap.put(user.getId(), user);
        return resultSet;
    }

    @Override
    public User deleteUser(User user) {
        User resultSet = (ColotaskApp.userHashMap.get(user.getId()));
        if (resultSet != null) {
            ColotaskApp.userHashMap.remove(user.getId());
        }
        return user;
    }
}
