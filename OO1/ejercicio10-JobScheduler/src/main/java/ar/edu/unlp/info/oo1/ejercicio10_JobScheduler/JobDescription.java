package ar.edu.unlp.info.oo1.ejercicio10_JobScheduler;

public class JobDescription {
	private double effort;
	private int priority;
	private String description;
	
	public JobDescription(double effort, int priority, String description) {
		this.effort = effort;
		this.priority = priority;
		this.description = description;
	}
	
	public int getPriority() {
		return priority;
	}

	public double getEffort() {
		return effort;
	}
	
	
}
