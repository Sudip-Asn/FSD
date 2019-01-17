package com.sudip.springboot.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author 470009
 *
 */
@Entity
@Table(name = "parent_tasks")
public class ParentTask {

	@Id
	@Column(name = "parent_task_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long parentTaskId;

	@Column(name = "parent_task_name")
	private String parentTaskName;

	@Column(name = "project_id")
	private String projectId;

	public ParentTask() {

	}

	/**
	 * @return the parentTaskId
	 */
	public Long getParentTaskId() {
		return parentTaskId;
	}

	/**
	 * @param parentTaskId the parentTaskId to set
	 */
	public void setParentTaskId(Long parentTaskId) {
		this.parentTaskId = parentTaskId;
	}

	/**
	 * @return the parentTaskName
	 */
	public String getParentTaskName() {
		return parentTaskName;
	}

	/**
	 * @param parentTaskName the parentTaskName to set
	 */
	public void setParentTaskName(String parentTaskName) {
		this.parentTaskName = parentTaskName;
	}

	/**
	 * @return the projectId
	 */
	public String getProjectId() {
		return projectId;
	}

	/**
	 * @param projectId the projectId to set
	 */
	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	
}
