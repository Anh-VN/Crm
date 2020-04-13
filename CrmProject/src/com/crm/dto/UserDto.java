package com.crm.dto;

public class UserDto {
	
	private int id;
	private String email;
	private String fullname;
	private String avatar;
	private String roleName;
	
	public String getAvatar() {
		return avatar;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	
	public UserDto()
	{
		
	}
	
	public UserDto(int id, String email, String fullname, String roleName) {
		
		this.id = id;
		this.email = email;
		this.fullname = fullname;
		this.roleName = roleName;
	}
	
	

}
