package com.sudip.springboot.bo;

/**
 * @author 470009
 *
 */
public class ParentTaskVO {

	private Long parentTaskId;
	private String parentTaskName;
	private String projectId;
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
