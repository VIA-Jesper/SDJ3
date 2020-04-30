package via.sdj3.colotask;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import via.sdj3.colotask.model.CoLoTask;
import via.sdj3.colotask.model.User;

import java.util.HashMap;

@SpringBootApplication
public class ColotaskApp {


    public static HashMap<String, CoLoTask> taskHashMap;
    public static HashMap<String, User> userHashMap;


    public static void main(String[] args) {

        taskHashMap = new HashMap<>();
        CoLoTask t1 = new CoLoTask("Get ready for next opening");
        taskHashMap.put(t1.getId(), t1);
        CoLoTask t2 = new CoLoTask("Buy coffee for the weekend");
        taskHashMap.put(t2.getId(), t2);



        SpringApplication.run(ColotaskApp.class, args);
    }

}
