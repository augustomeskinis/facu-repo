package ar.edu.unlp.info.oo1.ejercicio10_JobScheduler;

import java.util.List;

public interface Strategy {
	public JobDescription next (List<JobDescription> jobs);
}
