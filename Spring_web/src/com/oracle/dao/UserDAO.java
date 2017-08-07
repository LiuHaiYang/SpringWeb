package com.oracle.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.jdbc.util.jdbc_util;
import com.oracle.domain.Infor;
import com.oracle.domain.Users;

public class UserDAO {
	
	public void save(Users users) throws Exception{
		String sql = "insert into users(user_name,user_pass,user_img) values(?,?,?)";
		Connection conn = jdbc_util.getconection();
	     PreparedStatement ps = conn.prepareStatement(sql);
	     ps.setString(1, users.getUserName());
	     ps.setString(2, users.getUserPass());
	     ps.setString(3, users.getUserImg());
	     ps.executeUpdate();
	     
	}
	 public Users findByUserName(String userName) throws Exception{
		 String sql = "select * from users where  user_name = ?";
	     Connection conn = jdbc_util.getconection();
	     PreparedStatement ps = conn.prepareStatement(sql);
	     ps.setString(1, userName);
	     ResultSet rs = ps.executeQuery();
	     if(rs.next()){
	    	 Users users = new Users();
	    	 users.setUserName(rs.getString("user_name"));
	    	 users.setUserPass(rs.getString("user_pass"));
	    	 users.setUserImg(rs.getString("USER_IMG"));
	    	 return users;
	     }else{
	    	 return  null;
	     }
	 }
}
