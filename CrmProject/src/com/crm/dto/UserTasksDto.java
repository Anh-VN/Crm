package com.crm.dto;

import java.util.List;

public class UserTasksDto {
	private String userName;
	private String avatar;
	private List<TaskDto> tasks;	
	
	public UserTasksDto()
	{
		
	}
    
	public UserTasksDto(String userName, String avatar, List<TaskDto> tasks) {
		super();
		this.userName = userName;
		this.avatar = avatar;
		this.tasks = tasks;
	}


	public String getAvatar() {
		return avatar;
	}


	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public List<TaskDto> getTasks() {
		return tasks;
	}

	public void setTasks(List<TaskDto> tasks) {
		this.tasks = tasks;
	}
	
	public void insertNewTask(TaskDto task) {
		this.tasks.add(task);
	}
	
}
