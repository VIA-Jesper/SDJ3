package main.java.requiredsource;

import java.io.Serializable;

public class Task implements Serializable
{
	private static final long serialVersionUID = 1L;
	private String text;
	private long estimatedTime;

	public Task(String text, long estimatedTime)
	{
		this.text = text;
		this.estimatedTime = estimatedTime;
	}

	public String getText()
	{
		return text;
	}

	public long getEstimatedTime()
	{
		return estimatedTime;
	}

	public void setEstimatedTime(long estimatedTime)
	{
		this.estimatedTime = estimatedTime;
	}

	public String toString()
	{
		return "Task: " + text + " EstimatedTime: " + estimatedTime;
	}
}
