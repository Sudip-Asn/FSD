package com.sudip.springboot.bo;

/**
 * @author 470009
 *
 */
public class TaskVO {
	
	
	private Long taskId;
	private String taskName;
	private String startDate;
	private String endDate;
	private String priority;
	private String status;
	private ParentTaskVO parentTask;
	private UserVO employeeDetails;
	private ProjectVO projectDetails;
	
	
	/**
	 * @return the taskId
	 */
	public Long getTaskId() {
		return taskId;
	}
	/**
	 * @param taskId the taskId to set
	 */
	public void setTaskId(Long taskId) {
		this.taskId = taskId;
	}
	/**
	 * @return the taskName
	 */
	public String getTaskName() {
		return taskName;
	}
	/**
	 * @param taskName the taskName to set
	 */
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}
	/**
	 * @return the startDate
	 */
	public String getStartDate() {
		return startDate;
	}
	/**
	 * @param startDate the startDate to set
	 */
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	/**
	 * @return the endDate
	 */
	public String getEndDate() {
		return endDate;
	}
	/**
	 * @param endDate the endDate to set
	 */
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	/**
	 * @return the priority
	 */
	public String getPriority() {
		return priority;
	}
	/**
	 * @param priority the priority to set
	 */
	public void setPriority(String priority) {
		this.priority = priority;
	}
	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * @return the parentTask
	 */
	public ParentTaskVO getParentTask() {
		return parentTask;
	}
	/**
	 * @param parentTask the parentTask to set
	 */
	public void setParentTask(ParentTaskVO parentTask) {
		this.parentTask = parentTask;
	}
	/**
	 * @return the employeeDetails
	 */
	public UserVO getEmployeeDetails() {
		return employeeDetails;
	}
	/**
	 * @param employeeDetails the employeeDetails to set
	 */
	public void setEmployeeDetails(UserVO employeeDetails) {
		this.employeeDetails = employeeDetails;
	}
	/**
	 * @return the projectDetails
	 */
	public ProjectVO getProjectDetails() {
		return projectDetails;
	}
	/**
	 * @param projectDetails the projectDetails to set
	 */
	public void setProjectDetails(ProjectVO projectDetails) {
		this.projectDetails = projectDetails;
	}

	
}
