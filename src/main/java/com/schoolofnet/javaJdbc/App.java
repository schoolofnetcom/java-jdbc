package com.schoolofnet.javaJdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.jdbc.PreparedStatement;
import com.schoolofnet.javaJdbc.model.Users;
import com.schoolofnet.javaJdbc.model.UsersDAO;

public class App 
{
    public static void main( String[] args ) throws SQLException
    {
//    	new ConnectionFactoryOld().getConnection();
//    	ConnectionFactory.getConnection();
//    	 Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc?useLegacyDatatimeCode=false&serverTimezone=UTC", "root", "root");
    	System.out.print("Connected");
    	
    	UsersDAO usersDAO = new UsersDAO();
    	List<Users> users = usersDAO.findAll();
    	
    	for(int i = 0; i < users.size(); i++) {
    		Users user = users.get(i);
    		
    		System.out.println(user.getName());
    	}
    	
    	Users user = usersDAO.findById(7);
    	
    	System.out.println("Find by id => " + user.getName());
    	
    	usersDAO.insert(new Users("Leo Luppi"));
    	
    	usersDAO.remove(user);
    	
//    	String query = "SELECT * FROM users";

//    	PreparedStatement preparedStatement = (PreparedStatement) ConnectionFactory.getConnection().prepareStatement(query);
//    	preparedStatement.setInt(1, 5);
//    	preparedStatement.executeQuery();
    	
//    	ResultSet rs = preparedStatement.executeQuery();
//    	List<Users> users = new ArrayList<Users>();
//    	
//    	while(rs.next()) {
//    		Users user = new Users(rs.getInt("id"), rs.getString("name"));
//    		users.add(user);
//    		
//    		System.out.println(user.getName());
//    	}
    }
}
