package es.davidgfolch.model;

public class Task {

	private Long id;
	private String task;
	private boolean done;

	public Task(Long id, String task, boolean done) {
		super();
		this.id = id;
		this.task = task;
		this.done = done;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTask() {
		return task;
	}

	public boolean isDone() {
		return done;
	}

	public void setTask(String task) {
		this.task = task;
	}

	public void setDone(boolean done) {
		this.done = done;
	}

	@Override
	public String toString() {
		return super.toString()+"["+this.id+","+this.task+","+this.done+"]";
	}
	
}
