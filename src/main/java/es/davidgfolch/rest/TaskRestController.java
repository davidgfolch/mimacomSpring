package es.davidgfolch.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import es.davidgfolch.model.Task;
import es.davidgfolch.service.TaskService;

@CrossOrigin(origins = "http://localhost:5555")
@RestController()
public class TaskRestController {

	@Autowired
	private TaskService service;
    
    @RequestMapping("/list")
    public List<Task> list(@RequestParam(required=false) String name) {
    	return service.list(name);
    }
    
    @RequestMapping(path="/create", method= RequestMethod.POST)
    public void create(@RequestParam String task) {
    	service.create(task, false);
    }
    
    @RequestMapping("/edit")
    public void edit(@RequestParam Long id, @RequestParam String task) {
    	service.edit(id,task);
    }

    @RequestMapping("/done")
    public void done(@RequestParam Long id, @RequestParam Boolean done) {
    	service.done(id,done);
    }

}
