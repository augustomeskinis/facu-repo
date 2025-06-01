package ar.edu.unlp.info.oo1.ejercicio10_JobScheduler;

import java.util.List;

public class HighestEffort implements Strategy{
	public JobDescription next(List<JobDescription> jobs) {
		return jobs.stream().max ( (j1,j2) -> Double.compare(j1.getEffort(), j2.getEffort())).orElse(null);
	}
}
