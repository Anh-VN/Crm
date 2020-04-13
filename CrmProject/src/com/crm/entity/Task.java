package com.crm.entity;

public class Task {
	private int id; 
	private String name;
	private String startDate;
	private String endDate;
    private int userId;
    private int generalTaskId;
    private int statusId;
    
    public Task()
    {
    	
    }
    
    
	public Task(int id, String name, String startDate, String endDate, int userId, int generalTaskId,
			int statusId) {
		super();
		this.id = id;
		this.name = name;
		this.startDate = startDate;
		this.endDate = endDate;
		this.userId = userId;
		this.generalTaskId = generalTaskId;
		this.statusId = statusId;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getGeneralTaskId() {
		return generalTaskId;
	}
	public void setgGeneralTaskId(int generalTaskId) {
		this.generalTaskId = generalTaskId;
	}
	public int getStatusId() {
		return statusId;
	}
	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}
    
    
}
