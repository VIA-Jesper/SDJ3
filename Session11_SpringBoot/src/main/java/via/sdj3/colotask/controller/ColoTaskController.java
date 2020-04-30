package via.sdj3.colotask.controller;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import via.sdj3.colotask.model.CoLoTask;
import via.sdj3.colotask.service.CoLoTaskService;

import java.util.HashMap;

@RestController
@RequestMapping("/colotask")
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ColoTaskController {

    @Autowired
    private CoLoTaskService coLoTask;


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public HashMap<String, CoLoTask> getAllTasks() {
        return coLoTask.getAllTasks();
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public CoLoTask postTask(@RequestParam(value = "description") String description) {
        CoLoTask task = new CoLoTask(description);
        coLoTask.addTask(task);
        return task;
    }

}
