package publishsubscriberbroker;

import java.util.List;

public interface Observer {
    public void update(Event m);

    public void updateList(List<Event> list);
}
