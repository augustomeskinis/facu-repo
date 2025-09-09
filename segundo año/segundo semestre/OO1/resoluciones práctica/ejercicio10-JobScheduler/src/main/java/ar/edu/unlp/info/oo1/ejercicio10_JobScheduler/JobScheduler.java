package ar.edu.unlp.info.oo1.ejercicio10_JobScheduler;

import java.util.ArrayList;
import java.util.List;

public class JobScheduler {
	protected List <JobDescription> jobs;
	protected Strategy strategy;
	
	public JobScheduler() {
		jobs = new ArrayList <>();
	}
	
	public void schedule (JobDescription Job) {
		this.jobs.add(Job);
	}
	
	public void unschedule (JobDescription Job) {
		this.jobs.remove(Job);
	}
	
	public void setStrategy(Strategy aStrategy) {
		this.strategy = aStrategy;
	}
	
	public JobDescription next() {
		JobDescription Job = this.strategy.next(jobs);
		this.unschedule(Job);
		return Job;
	}

	public List<JobDescription> getJobs() {
		return jobs;
	}
	
	
}
