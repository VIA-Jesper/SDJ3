package main.java.requiredsource;

import main.java.exercises_messages.ITaskList;

import java.io.Serializable;
import java.util.ArrayList;

//A suitable interface for the TaskList to implement. Use your RMI experience to design the interface. Let the TaskList implement the interface.

public class TaskList implements Serializable, ITaskList
{
	private static final long serialVersionUID = 1L;
	private ArrayList<Task> tasks;

	public TaskList()
	{
		tasks = new ArrayList<Task>();
	}

	public void addTask(Task task)
	{
		tasks.add(task);
	}

	public Task getAndRemoveNextTask()
	{
		if (tasks.size() > 0)
		{
			return tasks.remove(0);
		}

		return null;
	}

	public int size()
	{
		return tasks.size();
	}
}
