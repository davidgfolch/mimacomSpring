package es.davidgfolch.service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import es.davidgfolch.model.Task;

@Service
public class TaskService {

	private static final List<Task> tasks = new ArrayList<>();
	private AtomicLong ids = new AtomicLong();

	public TaskService() {
		super();
		tasks.add(new Task(ids.incrementAndGet(), "A task already done!!", true));
		tasks.add(new Task(ids.incrementAndGet(), "A task not done yet!!", false));
	}

	public List<Task> list(String name) {
        return tasks.stream() //
        		.filter(task->StringUtils.isEmpty(name) || (!StringUtils.isEmpty(task.getTask()) && task.getTask().contains(name))) //
        		.collect(Collectors.toList());
	}

	public void create(String task, boolean done) {
		tasks.add(new Task(ids.incrementAndGet(),task,done));
	}

	public void done(Long id, Boolean done) {
		Task item=getById(id);
    	item.setDone(done);
	}

	public void edit(Long id, String task) {
		Task item=getById(id);
		item.setTask(task);
	}
	
	private Task getById(Long id) {
		List<Task> res=tasks.stream() //
			.filter(task->task.getId().longValue()==id.longValue()) //
			.collect(Collectors.toList());
    	if (res.size()==0) 
    		throw new NoSuchElementException();
    	if (res.size()>1) 
    		throw new IllegalStateException("Same id found more than once");
    	return res.get(0);
	}
	
}
