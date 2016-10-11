package com.schoolofnet.javaJdbc.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.jdbc.PreparedStatement;
import com.schoolofnet.javaJdbc.ConnectionFactory;

public class UsersDAO {
	private Connection con = null;
	private PreparedStatement statement = null;
	
	public UsersDAO() {
		con = ConnectionFactory.getConnection();
	}
	
	public List<Users> findAll() throws SQLException {
		String query = "SELECT * FROM users";
		List<Users> users = new ArrayList<Users>();
		
		statement = (PreparedStatement) con.prepareStatement(query);
		
		ResultSet rs = statement.executeQuery();
		
		while (rs.next()) {
			users.add(new Users(rs.getInt("id"), rs.getString("name")));
		}
		
		return users;
	}
	
	public Users findById(Integer id) throws SQLException {
		String query = "SELECT * FROM users WHERE id = ?";
		
		statement = (PreparedStatement) con.prepareStatement(query);
		statement.setInt(1, id);
		
		ResultSet rs = statement.executeQuery();
		Users user = null;
		
		while(rs.next()) {
			user = new Users();
			user.setId(rs.getInt("id"));
			user.setName(rs.getString("name"));
		}
		
		return user;
	}
	
	public void insert(Users user) throws SQLException {
		String query = "INSERT INTO users (name) VALUES (?)";
		
		statement = (PreparedStatement) con.prepareStatement(query);
//		statement.setInt(1, user.getId());
		statement.setString(1, user.getName());
		statement.execute();
	}
	
	public void remove(Users user) throws SQLException {
		String  query = "DELETE FROM users WHERE id = ?";
		
		statement = (PreparedStatement) con.prepareStatement(query);
		statement.setInt(1, user.getId());
		statement.execute();
	}
}
