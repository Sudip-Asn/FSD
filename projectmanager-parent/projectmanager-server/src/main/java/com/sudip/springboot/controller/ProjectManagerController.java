package com.sudip.springboot.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sudip.springboot.Application;
import com.sudip.springboot.bo.ParentTaskVO;
import com.sudip.springboot.bo.ProjectVO;
import com.sudip.springboot.bo.TaskVO;
import com.sudip.springboot.bo.UserVO;
import com.sudip.springboot.service.ProjectManagerService;

/**
 * @author 470009
 *
 */
@RestController
public class ProjectManagerController {
	
	private static final Logger LOGGER = LogManager.getLogger(ProjectManagerController.class);
	private ProjectManagerService projectManagerService;

	@Autowired
	public ProjectManagerController(ProjectManagerService projectManagerService) {
		this.projectManagerService = projectManagerService;
	}

	@GetMapping("/home")
	public String home() {
		LOGGER.info("In Home");
		return "forward:/index.html";
	}
	
	@GetMapping("/test")
	public String testhome() {
		LOGGER.info("In Test Method");
		return "Project Manager App - Creator: Chatterjee, Sudip";
	}
	
	
	@GetMapping("/api/tasks")
	public List<TaskVO> getTasks() {
		LOGGER.info("In getTask method");
		List<TaskVO> tasks = null;
		try{
			tasks = projectManagerService.retriveTasks();
		}catch(Exception e){
			LOGGER.error("Exception Occured in Get Tasks");
		}
		
		return tasks;
	}
	
	@PostMapping(path = "/api/tasks", consumes = "application/json", produces = "application/json")
	public boolean updateTask(@RequestBody TaskVO task) {
		LOGGER.info("In updateTask Method");
		try {
			projectManagerService.updateTask(task); 
		}catch(Exception e)
		{
			LOGGER.error("Exception Occured in Update Task");
			return false;
		}
		return true;
	}
	
	
	@GetMapping("/api/parenttasks")
	public List<ParentTaskVO> getAllParentTasks() {
		LOGGER.info("In getAllParentTasks Method");
		List<ParentTaskVO> tasks = projectManagerService.retriveParentTasks();
		return tasks;
	}
	
	@GetMapping("/api/parenttasks/projects/{projectId}")
	public List<ParentTaskVO> getParentTasksForProjectId(@PathVariable(name="projectId") String projectId) {
		LOGGER.info("In getParentTasksForProjectId Method");
		List<ParentTaskVO> tasks = null;
		try{
			tasks = projectManagerService.retriveParentTasksForProjectId(projectId); 
		}catch(Exception e){
			LOGGER.error("Exception Occured in Get Parent Task");
		}
		
		return tasks;
	}
	
	@PostMapping(path = "/api/parenttasks", consumes = "application/json", produces = "application/json")
	public boolean updateParentTask(@RequestBody ParentTaskVO parentTask) {
		LOGGER.info("In updateParentTask Method");
		try {
			projectManagerService.updateParentTask(parentTask);
		}catch(Exception e)
		{
			LOGGER.error("Exception Occured in Update Parent Task");
			return false;
		}
		return true;
	}
	
	
	@GetMapping("/api/projects")
	public List<ProjectVO> getProjects() {
		LOGGER.info("In getProjects Method");
		List<ProjectVO> projects = projectManagerService.retriveProjects();
		return projects;
	}
	
	@PostMapping(path = "/api/projects", consumes = "application/json", produces = "application/json")
	public boolean updateProject(@RequestBody ProjectVO project) {
		LOGGER.info("In updateProject Method");
		try {
			projectManagerService.updateProject(project);
		}catch(Exception e)
		{
			LOGGER.error("Exception Occured in Update Project");
			return false;
		}
		return true;
	}
	
	
	@GetMapping("/api/users")
	public List<UserVO> getUsers() {
		LOGGER.info("In getUsers Method");
		List<UserVO> users = null;
		try{
			users = projectManagerService.retriveUsers();
		}catch(Exception e){
			LOGGER.error("Exception Occured in Get Users");
		}
		
		return users;
	}
	
	@PostMapping(path = "/api/users", consumes = "application/json", produces = "application/json")
	public boolean updateUsers(@RequestBody UserVO user) {
		LOGGER.info("In updateUsers Method");
		try {
			projectManagerService.updateUser(user);
		}catch(Exception e)
		{
			LOGGER.error("Exception Occured in Update User");
			return false;
		}
		return true;
	}
	
	
}
