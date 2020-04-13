package com.crm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.crm.connection.JDBCConnection;
import com.crm.dto.StatusDto;
import com.crm.dto.TaskDto;
import com.crm.dto.UserTasksDto;
import com.crm.entity.Status;
import com.crm.entity.Task;

public class TaskDAO {

	public List<Status> findAllStatus() {

		String query = "SELECT * FROM status";
		List<Status> listStatus = new LinkedList<Status>();

		try (Connection conn = JDBCConnection.getConnection()) {

			PreparedStatement statement = conn.prepareStatement(query);

			ResultSet rs = statement.executeQuery();

			while (rs.next()) {

				Status status = new Status(rs.getInt("id"), rs.getString("name"));

				listStatus.add(status);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listStatus;
	}

	public List<Task> findAll() {

		String query = "SELECT * FROM tasks";
		List<Task> tasks = new ArrayList<Task>();

		try (Connection conn = JDBCConnection.getConnection()) {

			PreparedStatement statement = conn.prepareStatement(query);

			ResultSet rs = statement.executeQuery();

			while (rs.next()) {

				Task task = new Task();

				task.setId(rs.getInt("id"));
				task.setName(rs.getString("name"));
				task.setStartDate(rs.getString("start_date"));
				task.setEndDate(rs.getString("end_date"));
				task.setUserId(rs.getInt("user_id"));
				task.setgGeneralTaskId(rs.getInt("general_task_id"));
				task.setStatusId(rs.getInt("status_id"));

				tasks.add(task);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tasks;
	}

	public Task findById(int id) {

		String query = "SELECT * FROM tasks WHERE id = ?";
		Task task = new Task();

		try (Connection conn = JDBCConnection.getConnection()) {

			PreparedStatement statement = conn.prepareStatement(query);
			statement.setInt(1, id);

			ResultSet rs = statement.executeQuery();

			while (rs.next()) {

				task.setId(rs.getInt("id"));
				task.setName(rs.getString("name"));
				task.setStartDate(rs.getString("start_date"));
				task.setEndDate(rs.getString("end_date"));
				task.setUserId(rs.getInt("user_id"));
				task.setgGeneralTaskId(rs.getInt("general_task_id"));
				task.setStatusId(rs.getInt("status_id"));

				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return task;
	}

	public boolean insert(Task task) {
		String query = "INSERT INTO tasks(name, start_date, end_date, user_id, general_task_id, status_id)"
				+ " VALUES (?, ?, ?, ?, ?, ?)";
		try (Connection conn = JDBCConnection.getConnection()) {

			PreparedStatement statement = conn.prepareStatement(query);

			statement.setString(1, task.getName());
			statement.setString(2, task.getStartDate());
			statement.setString(3, task.getEndDate());
			statement.setInt(4, task.getUserId());
			statement.setInt(5, task.getGeneralTaskId());
			statement.setInt(6, task.getStatusId());

			statement.executeUpdate();
			return true;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;

	}

	public boolean update(Task task) {
		String query = "UPDATE tasks SET name = ?, start_date = ?, end_date = ?, user_id = ?, general_task_id = ?, status_id = ?  WHERE id = ?";

		try (Connection conn = JDBCConnection.getConnection()) {

			PreparedStatement statement = conn.prepareStatement(query);

			statement.setString(1, task.getName());
			statement.setString(2, task.getStartDate());
			statement.setString(3, task.getEndDate());
			statement.setInt(4, task.getUserId());
			statement.setInt(5, task.getGeneralTaskId());
			statement.setInt(6, task.getStatusId());

			statement.setInt(7, task.getId());

			statement.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean updateStatus(Task task) {
		String query = "UPDATE tasks SET status_id = ?  WHERE id = ?";

		try (Connection conn = JDBCConnection.getConnection()) {

			PreparedStatement statement = conn.prepareStatement(query);

			statement.setInt(1, task.getStatusId());

			statement.setInt(2, task.getId());

			statement.executeUpdate();
			
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean deleteById(int id) {
		String query = "DELETE FROM tasks WHERE id = ?";

		try (Connection conn = JDBCConnection.getConnection()) {

			PreparedStatement statement = conn.prepareStatement(query);
			statement.setInt(1, id);

			statement.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public List<StatusDto> listStatusDto(List<UserTasksDto> userTasksDto, List<Status> listStatus) {

		List<StatusDto> listStatusDto = new LinkedList<StatusDto>();

		for (Status status : listStatus) {
			int percent = 0;
			int count = 0;
			int totalTask = 0;

			for (UserTasksDto userTaks : userTasksDto) {
				for (TaskDto taskDto : userTaks.getTasks()) {
					if (taskDto.getStatusId() == status.getId()) {
						count++;
					}

					totalTask++;
				}
			}

			if (totalTask != 0) {
				percent = count * 100 / totalTask;
			}

			StatusDto statusDto = new StatusDto(status.getId(), status.getName(), count, percent);
			listStatusDto.add(statusDto);
		}

		return listStatusDto;
	}
}
