package publishsubscriberbroker;


import java.util.List;

// observer
public class Subscriber implements Observer{


    private String name;
    public Subscriber(String name) {
        this.name = name;
    }
    @Override
    public void update(Event m) {
        System.out.println("Update has been received with event: " + m.getPayLoad());
    }

    @Override
    public void updateList(List<Event> list) {
        if (list != null && !list.isEmpty())
            System.out.println(name + " Received a list of size: " + list.size());
    }
}
