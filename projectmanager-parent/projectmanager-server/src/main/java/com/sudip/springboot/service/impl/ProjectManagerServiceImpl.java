package com.sudip.springboot.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sudip.springboot.Application;
import com.sudip.springboot.bo.ParentTaskVO;
import com.sudip.springboot.bo.ProjectVO;
import com.sudip.springboot.bo.TaskVO;
import com.sudip.springboot.bo.UserVO;
import com.sudip.springboot.entity.ParentTask;
import com.sudip.springboot.entity.Project;
import com.sudip.springboot.entity.Task;
import com.sudip.springboot.entity.User;
import com.sudip.springboot.repository.ParentTaskManagerRepository;
import com.sudip.springboot.repository.ProjectManagerRepository;
import com.sudip.springboot.repository.TaskManagerRepository;
import com.sudip.springboot.repository.UserManagerRepository;
import com.sudip.springboot.service.ProjectManagerService;

/**
 * @author 470009
 *
 */
@Service
public class ProjectManagerServiceImpl implements ProjectManagerService{

	private static final Logger LOGGER = LogManager.getLogger(ProjectManagerServiceImpl.class);
	
	private ProjectManagerRepository projectManagerRepository;
	
	private TaskManagerRepository taskManagerRepository;
	
	private ParentTaskManagerRepository parentTaskManagerRepository;
	
	private UserManagerRepository userManagerRepository;
	
	private Mapper dozerMapper;
	
	@Autowired
	public ProjectManagerServiceImpl(ProjectManagerRepository projectManagerRepository,
			TaskManagerRepository taskManagerRepository, 
			ParentTaskManagerRepository parentTaskManagerRepository,
			UserManagerRepository userManagerRepository, Mapper dozerMapper) {
		this.projectManagerRepository = projectManagerRepository;
		this.taskManagerRepository = taskManagerRepository;
		this.parentTaskManagerRepository = parentTaskManagerRepository;
		this.userManagerRepository = userManagerRepository;
		this.dozerMapper = dozerMapper;
	}

	
	public List<TaskVO> retriveTasks(){
		LOGGER.info("In retriveTasks method");
		List<TaskVO> taskToBeReturned = new ArrayList<TaskVO>();
		List<Task> tasksRetrived = taskManagerRepository.findAll();
		for(Task task: tasksRetrived) {
			taskToBeReturned.add(dozerMapper.map(task, TaskVO.class));
		}
		return taskToBeReturned;
	}
	
	public void updateTask(TaskVO task) {
		LOGGER.info("In updateTask method");
		taskManagerRepository.save(dozerMapper.map(task, Task.class));
	}
	
	
	public List<ParentTaskVO> retriveParentTasks(){
		LOGGER.info("In retriveParentTasks method");
		List<ParentTaskVO> taskToBeReturned = new ArrayList<ParentTaskVO>();
		List<ParentTask> tasksRetrived = parentTaskManagerRepository.findAll();
		for(ParentTask task: tasksRetrived) {
			taskToBeReturned.add(dozerMapper.map(task, ParentTaskVO.class));
		}
		return taskToBeReturned;
	}
	
	public List<ParentTaskVO> retriveParentTasksForProjectId(String projectId){
		LOGGER.info("In retriveParentTasksForProjectId method");
		List<ParentTaskVO> taskToBeReturned = new ArrayList<ParentTaskVO>();
		List<ParentTask> tasksRetrived = parentTaskManagerRepository.findAllParentTaskByProjectId(projectId); 
		for(ParentTask task: tasksRetrived) {
			taskToBeReturned.add(dozerMapper.map(task, ParentTaskVO.class));
		}
		return taskToBeReturned;
	}
	
	public void updateParentTask(ParentTaskVO parentTask) {
		LOGGER.info("In updateParentTask method");
		parentTaskManagerRepository.save(dozerMapper.map(parentTask, ParentTask.class));
	}
	
	
	public List<ProjectVO> retriveProjects(){
		LOGGER.info("In retriveProjects method");
		List<ProjectVO> projectToBeReturned = new ArrayList<ProjectVO>();
		List<Project> projectsRetrived = projectManagerRepository.findAll();
		for(Project project: projectsRetrived) {
			ProjectVO projectVO = dozerMapper.map(project, ProjectVO.class);
			projectVO.setNoOfTasks(taskManagerRepository.getTotalTasksForProjectId(projectVO.getProjectId()));
			projectToBeReturned.add(projectVO);
		}
		return projectToBeReturned;
	}
	
	public void updateProject(ProjectVO project) {
		LOGGER.info("In updateProject method");
		projectManagerRepository.save(dozerMapper.map(project, Project.class));
	}
	
	
	public List<UserVO> retriveUsers(){
		LOGGER.info("In retriveUsers method");
		List<UserVO> userToBeReturned = new ArrayList<UserVO>();
		List<User> usersRetrived = userManagerRepository.findAll();
		for(User user: usersRetrived) {
			userToBeReturned.add(dozerMapper.map(user, UserVO.class));
		}
		return userToBeReturned;
	}
	
	public void updateUser(UserVO user) {
		LOGGER.info("In updateUser method");
		User userStore = dozerMapper.map(user, User.class);
		userManagerRepository.save(userStore);
	}
	
}
