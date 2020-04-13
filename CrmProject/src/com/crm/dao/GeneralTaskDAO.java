package com.crm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.crm.connection.JDBCConnection;
import com.crm.entity.GeneralTask;
import com.crm.entity.User;

public class GeneralTaskDAO {

	public List<GeneralTask> findAll() {

		String query = "SELECT * FROM generaltasks";
		List<GeneralTask> generalTasks = new ArrayList<GeneralTask>();

		try (Connection conn = JDBCConnection.getConnection()) {

			PreparedStatement statement = conn.prepareStatement(query);

			ResultSet rs = statement.executeQuery();

			while (rs.next()) {

				GeneralTask generalTask = new GeneralTask();

				generalTask.setId(rs.getInt("id"));
				generalTask.setName(rs.getString("name"));
				generalTask.setStartDate(rs.getString("start_date"));
				generalTask.setEndDate(rs.getString("end_date"));

				generalTasks.add(generalTask);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return generalTasks;
	}

	public GeneralTask findById(int id) {

		String query = "SELECT * FROM generaltasks WHERE id = ?";
		GeneralTask generalTask = new GeneralTask();

		try (Connection conn = JDBCConnection.getConnection()) {

			PreparedStatement statement = conn.prepareStatement(query);
			statement.setInt(1, id);

			ResultSet rs = statement.executeQuery();

			while (rs.next()) {

				generalTask.setId(rs.getInt("id"));
				generalTask.setName(rs.getString("name"));
				generalTask.setStartDate(rs.getString("start_date"));
				generalTask.setEndDate(rs.getString("end_date"));

				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return generalTask;
	}

	public boolean insert(GeneralTask generalTask) {
		String query = "INSERT INTO generaltasks(name, start_date, end_date)" + " VALUES (?, ?, ?)";
		try (Connection conn = JDBCConnection.getConnection()) {

			PreparedStatement statement = conn.prepareStatement(query);

			statement.setString(1, generalTask.getName());
			statement.setString(2, generalTask.getStartDate());
			statement.setString(3, generalTask.getEndDate());

			statement.executeUpdate();
			return true;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean update(GeneralTask generalTask) {
		String query = "UPDATE generaltasks SET name = ?, start_date = ?, end_date = ?  WHERE id = ?";

		try (Connection conn = JDBCConnection.getConnection()) {

			PreparedStatement statement = conn.prepareStatement(query);
			
			statement.setString(1, generalTask.getName());
			statement.setString(2, generalTask.getStartDate());
			statement.setString(3, generalTask.getEndDate());
			statement.setInt(4, generalTask.getId());

			statement.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean deleteById(int id) {
		String query = "DELETE FROM generaltasks WHERE id = ?";

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
}
