package com.crm.dto;

public class StatusDto {

	private int id;
	private String name;
	private int numberOfTask;
	private int percent;
	
	
	
	public int getNumberOfTask() {
		return numberOfTask;
	}


	public void setNumberOfTask(int numberOfTask) {
		this.numberOfTask = numberOfTask;
	}


	public void setName(String name) {
		this.name = name;
	}





	public StatusDto(int id, String name, int numberOfTask, int percent) {
		super();
		this.id = id;
		this.name = name;
		this.numberOfTask = numberOfTask;
		this.percent = percent;
	}


	public String getName() {
		return name;
	}



	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPercent() {
		return percent;
	}
	public void setPercent(int percent) {
		this.percent = percent;
	}
	
	
}
