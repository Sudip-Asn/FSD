package com.sudip.springboot.service;

import java.util.List;

import com.sudip.springboot.bo.ParentTaskVO;
import com.sudip.springboot.bo.ProjectVO;
import com.sudip.springboot.bo.TaskVO;
import com.sudip.springboot.bo.UserVO;

/**
 * @author 470009
 *
 */
public interface ProjectManagerService {
	
	public List<TaskVO> retriveTasks();
	public void updateTask(TaskVO task);
	
	public List<ParentTaskVO> retriveParentTasks();
	public List<ParentTaskVO> retriveParentTasksForProjectId(String projectId);
	public void updateParentTask(ParentTaskVO parentTask);
	
	public List<ProjectVO> retriveProjects();
	public void updateProject(ProjectVO project);
	
	public List<UserVO> retriveUsers();
	public void updateUser(UserVO user);

}
