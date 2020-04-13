package com.crm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.crm.connection.JDBCConnection;
import com.crm.dto.LoginDto;
import com.crm.dto.TaskDto;
import com.crm.dto.UserDto;
import com.crm.dto.UserTasksDto;
import com.crm.entity.User;

public class UserDAO {

	public List<UserTasksDto> findAllUserTasks() {

		String query = "SELECT users.fullname, users.avatar, tasks.id as task_id, tasks.name as task_name ,tasks.start_date, tasks.end_date,tasks.status_id, status.name as status_name "
				+ "FROM tasks INNER JOIN users ON tasks.user_id = users.id "
				+ "INNER JOIN status ON tasks.status_id = status.id ";

		List<UserTasksDto> listUserTasksDto = new LinkedList<UserTasksDto>();

		try (Connection conn = JDBCConnection.getConnection()) {

			PreparedStatement statement = conn.prepareStatement(query);

			ResultSet rs = statement.executeQuery();

			while (rs.next()) {

				String userName = rs.getString("fullname");
				String avatar = rs.getString("avatar");
				int taskId = rs.getInt("task_id");
				String taskName = rs.getString("task_name");
				String startDate = rs.getString("start_date");
				String endDate = rs.getString("end_date");
				int statusId = rs.getInt("status_id");
				String statusName = rs.getString("status_name");

				TaskDto taskDto = new TaskDto(taskId, taskName, startDate, endDate, statusId, statusName);

				UserTasksDto userTasks = usernameExitsInList(listUserTasksDto, userName);

				if (userTasks == null) {
					UserTasksDto userTasksDto = new UserTasksDto(userName, avatar, new LinkedList<TaskDto>());

					userTasksDto.insertNewTask(taskDto);

					listUserTasksDto.add(userTasksDto);
				} else {
					userTasks.insertNewTask(taskDto);
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listUserTasksDto;
	}

	public List<UserTasksDto> findUserTasksByGeneralTaskId(int id) {

		String query = "SELECT users.fullname, users.avatar, tasks.id as task_id, tasks.name as task_name ,tasks.start_date, tasks.end_date,tasks.status_id, status.name as status_name "
				+ "FROM tasks INNER JOIN users ON tasks.user_id = users.id "
				+ "INNER JOIN status ON tasks.status_id = status.id " + "WHERE tasks.general_task_id=? ";

		List<UserTasksDto> listUserTasksDto = new LinkedList<UserTasksDto>();

		try (Connection conn = JDBCConnection.getConnection()) {

			PreparedStatement statement = conn.prepareStatement(query);

			statement.setInt(1, id);

			ResultSet rs = statement.executeQuery();

			while (rs.next()) {

				String userName = rs.getString("fullname");
				String avatar = rs.getString("avatar");
				int taskId = rs.getInt("task_id");
				String taskName = rs.getString("task_name");
				String startDate = rs.getString("start_date");
				String endDate = rs.getString("end_date");
				int statusId = rs.getInt("status_id");
				String statusName = rs.getString("status_name");

				TaskDto taskDto = new TaskDto(taskId, taskName, startDate, endDate, statusId, statusName);

				UserTasksDto userTasks = usernameExitsInList(listUserTasksDto, userName);

				if (userTasks == null) {
					UserTasksDto userTasksDto = new UserTasksDto(userName, avatar, new LinkedList<TaskDto>());

					userTasksDto.insertNewTask(taskDto);

					listUserTasksDto.add(userTasksDto);
				} else {
					userTasks.insertNewTask(taskDto);
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listUserTasksDto;
	}

	public UserTasksDto findUserTasksByUserId(int id) {

		String query = "SELECT users.fullname, users.avatar, tasks.id as task_id, tasks.name as task_name ,tasks.start_date, tasks.end_date,tasks.status_id, status.name as status_name "
				+ "FROM tasks INNER JOIN users ON tasks.user_id = users.id "
				+ "INNER JOIN status ON tasks.status_id = status.id " + "WHERE users.id=? ";

		UserTasksDto userTasksDto = new UserTasksDto("","", new LinkedList<TaskDto>());

		try (Connection conn = JDBCConnection.getConnection()) {

			PreparedStatement statement = conn.prepareStatement(query);

			statement.setInt(1, id);

			ResultSet rs = statement.executeQuery();

			boolean flag = false;

			while (rs.next()) {

				if (!flag) {
					
					String userName = rs.getString("fullname");
					String avatar = rs.getString("avatar");
					userTasksDto.setUserName(userName);
					userTasksDto.setAvatar(avatar);
					flag = true;
				}
				
				int taskId = rs.getInt("task_id");
				String taskName = rs.getString("task_name");
				String startDate = rs.getString("start_date");
				String endDate = rs.getString("end_date");
				int statusId = rs.getInt("status_id");
				String statusName = rs.getString("status_name");

			
				TaskDto taskDto = new TaskDto(taskId, taskName, startDate, endDate, statusId, statusName);
	
				userTasksDto.insertNewTask(taskDto);
				
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return userTasksDto;
	}

	private UserTasksDto usernameExitsInList(List<UserTasksDto> listUserTasksDto, String username) {

		for (UserTasksDto userTasksDto : listUserTasksDto) {
			if (username.equals(userTasksDto.getUserName())) {
				return userTasksDto;
			}
		}
		return null;
	}

	public List<UserDto> findAllDto() {

		String query = "SELECT users.id, users.email, users.fullname, roles.name FROM users INNER JOIN roles ON users.role_id = roles.id";

		List<UserDto> usersDto = new ArrayList<UserDto>();

		try (Connection conn = JDBCConnection.getConnection()) {
			// Bước 2: Gửi câu truy vấn
			// Tạo ra câu truy vấn sử dụng PreparedStatement
			PreparedStatement statement = conn.prepareStatement(query);
			// Thực thi truy vấn lấy dữu liệu
			ResultSet rs = statement.executeQuery();

			// Bước 3: Xử ký kết quả trả về
			while (rs.next()) {
				// Tạo entity User hứng dữ liệu mỗi dòng trả về từ database
				UserDto userDto = new UserDto();
				// Set thuộc tính cho User entity
				userDto.setId(rs.getInt("id"));
				userDto.setEmail(rs.getString("email"));
				userDto.setFullname(rs.getString("fullname"));
				userDto.setRoleName(rs.getString("roles.name"));
				// Add User vào danh sách để trả về cho jsp
				usersDto.add(userDto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return usersDto;
	}

	public UserDto findUserDto(int id) {

		String query = "SELECT users.id, users.email, users.fullname, users.avatar, roles.name FROM users INNER JOIN roles ON users.role_id = roles.id "
				+ "WHERE users.id = ?";

		UserDto userDto = new UserDto();

		try (Connection conn = JDBCConnection.getConnection()) {

			PreparedStatement statement = conn.prepareStatement(query);

			statement.setInt(1, id);
			ResultSet rs = statement.executeQuery();

			while (rs.next()) {

				userDto.setId(rs.getInt("id"));
				userDto.setEmail(rs.getString("email"));
				userDto.setFullname(rs.getString("fullname"));
				userDto.setRoleName(rs.getString("roles.name"));
				userDto.setAvatar(rs.getString("avatar"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return userDto;
	}

	public List<User> findAll() {

		String query = "SELECT * FROM users";
		List<User> users = new ArrayList<User>();

		try (Connection conn = JDBCConnection.getConnection()) {
			// Bước 2: Gửi câu truy vấn
			// Tạo ra câu truy vấn sử dụng PreparedStatement
			PreparedStatement statement = conn.prepareStatement(query);
			// Thực thi truy vấn lấy dữu liệu
			ResultSet rs = statement.executeQuery();

			// Bước 3: Xử ký kết quả trả về
			while (rs.next()) {
				// Tạo entity User hứng dữ liệu mỗi dòng trả về từ database
				User user = new User();
				// Set thuộc tính cho User entity
				user.setId(rs.getInt("id"));
				user.setEmail(rs.getString("email"));
				user.setFullname(rs.getString("fullname"));
				user.setAvatar(rs.getString("avatar"));
				user.setRoleId(rs.getInt("role_id"));
				// Add User vào danh sách để trả về cho jsp
				users.add(user);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return users;
	}

	public User findById(int id) {

		String query = "SELECT * FROM users WHERE id = ?";
		User user = new User();

		try (Connection conn = JDBCConnection.getConnection()) {
			// Bước 2: Gửi câu truy vấn
			// Tạo ra câu truy vấn phù hợp với hệ quản trị CSDL mysql
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setInt(1, id);

			// Thực thi truy vấn lấy dữu liệu
			ResultSet rs = statement.executeQuery();

			// Bước 3: Xử ký kết quả trả về
			while (rs.next()) {
				// Set thuộc tính cho User entity
				user.setId(rs.getInt("id"));
				user.setEmail(rs.getString("email"));
				user.setPassword(rs.getString("password"));
				user.setFullname(rs.getString("fullname"));
				user.setAvatar(rs.getString("avatar"));
				user.setRoleId(rs.getInt("role_id"));
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}

	public boolean insert(User user) {
		String query = "INSERT INTO Users(email, password, fullname, avatar, role_id)" + " VALUES (?, ?, ?, ?, ?)";
		try (Connection conn = JDBCConnection.getConnection()) {
			// Bước 2: Gửi câu truy vấn
			// Tạo ra câu truy vấn phù hợp với hệ quản trị CSDL mysql
			PreparedStatement statement = conn.prepareStatement(query);
			// Set dữ liệu cho câu truy vấn
			statement.setString(1, user.getEmail());
			statement.setString(2, user.getPassword());
			statement.setString(3, user.getFullname());
			statement.setString(4, user.getAvatar());
			statement.setInt(5, user.getRoleId());

			// Trả về kết quả truy vấn
			statement.executeUpdate();
			return true;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean update(User user) {
		String query = "UPDATE users SET email = ?, password = ?,"
				+ " fullname = ?, avatar = ?, role_id = ? WHERE id = ?";

		try (Connection conn = JDBCConnection.getConnection()) {

			PreparedStatement statement = conn.prepareStatement(query);
			statement.setString(1, user.getEmail());
			statement.setString(2, user.getPassword());
			statement.setString(3, user.getFullname());
			statement.setString(4, user.getAvatar());
			statement.setInt(5, user.getRoleId());
			statement.setInt(6, user.getId());

			// Thực thi truy vấn lấy dữu liệu
			statement.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean updateWithoutPassword(User user) {
		String query = "UPDATE users SET email = ?," + " fullname = ?, avatar = ?, role_id = ? WHERE id = ?";

		try (Connection conn = JDBCConnection.getConnection()) {

			PreparedStatement statement = conn.prepareStatement(query);
			statement.setString(1, user.getEmail());
			statement.setString(2, user.getFullname());
			statement.setString(3, user.getAvatar());
			statement.setInt(4, user.getRoleId());
			statement.setInt(5, user.getId());

			// Thực thi truy vấn lấy dữu liệu
			statement.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean deleteById(int id) {
		String query = "DELETE FROM users WHERE id = ?";

		try (Connection conn = JDBCConnection.getConnection()) {

			PreparedStatement statement = conn.prepareStatement(query);
			statement.setInt(1, id);

			// Thực thi truy vấn lấy dữu liệu
			statement.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public User findByEmail(String email) {

		String query = "SELECT * FROM users WHERE email  = ?";
		User user = new User();

		try (Connection conn = JDBCConnection.getConnection()) {
			// Bước 2: Gửi câu truy vấn
			// Tạo ra câu truy vấn phù hợp với hệ quản trị CSDL mysql
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setString(1, email);

			// Thực thi truy vấn lấy dữu liệu
			ResultSet rs = statement.executeQuery();

			// Bước 3: Xử ký kết quả trả về
			while (rs.next()) {
				// Set thuộc tính cho User entity
				user.setId(rs.getInt("id"));
				user.setEmail(rs.getString("email"));
				user.setPassword(rs.getString("password"));
				user.setFullname(rs.getString("fullname"));
				user.setAvatar(rs.getString("avatar"));
				user.setRoleId(rs.getInt("role_id"));
				return user;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public LoginDto getLoginInfor(String email) {

		String query = "SELECT users.id, users.email, users.password, users.fullname, users.avatar, roles.name as rolename FROM users INNER JOIN roles ON users.role_id = roles.id WHERE email  = ?";
		LoginDto login = new LoginDto();

		try (Connection conn = JDBCConnection.getConnection()) {
			// Bước 2: Gửi câu truy vấn
			// Tạo ra câu truy vấn phù hợp với hệ quản trị CSDL mysql
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setString(1, email);

			// Thực thi truy vấn lấy dữu liệu
			ResultSet rs = statement.executeQuery();

			// Bước 3: Xử ký kết quả trả về
			while (rs.next()) {
				// Set thuộc tính cho User entity
				login.setId(rs.getInt("id"));
				login.setEmail(rs.getString("email"));
				login.setPassword(rs.getString("password"));
				login.setFullname(rs.getString("fullname"));
				login.setRoleName(rs.getString("rolename"));
				login.setAvatar(rs.getString("avatar"));

				return login;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

}
