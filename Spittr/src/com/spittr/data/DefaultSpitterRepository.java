//package com.spittr.data;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.util.HashMap;
//import java.util.Map;
//
//import javax.sql.DataSource;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import com.spittr.Spitter;
//
//@Component
//public class DefaultSpitterRepository implements SpitterRepository {
//
//
//
//	@Autowired
//	DataSource dataSource;
//
//	private static final String SAVE_SPITTER = "INSERT INTO spitter(firstname, lastname, username,password)values(?,?,?,?)";
//	private static final String GET_SPITTER_BY_USERNAME = "SELECT id,firstname, lastname, username, password from spitter where username=?";
//
//	@Override
//	public Spitter save(Spitter spitter) {
//		PreparedStatement statement = null;
//		Connection connection = null;
//		try {
//			connection = dataSource.getConnection();
//			statement = connection.prepareStatement(SAVE_SPITTER);
//			statement.setString(1, spitter.getFirstName());
//			statement.setString(2, spitter.getLastName());
//			statement.setString(3, spitter.getUserName());
//			statement.setString(4, spitter.getPassword());
//			statement.execute();
//
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				if (connection != null) {
//					connection.close();
//				}
//				if (statement != null) {
//					statement.close();
//				}
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}
//		return spitter;
//	}
//
//	@Override
//	public Spitter get(String username) {
//		PreparedStatement statement = null;
//		Connection connection = null;
//		try {
//			connection = dataSource.getConnection();
//			statement = connection.prepareStatement(GET_SPITTER_BY_USERNAME);
//			statement.setString(1, username);
//			ResultSet rs = statement.executeQuery();
//
//			Spitter spitter = null;
//			if (rs.next()) {
//				spitter = new Spitter();
//				spitter.setId(rs.getLong(1));
//				spitter.setFirstName(rs.getString(2));
//				spitter.setLastName(rs.getString(3));
//				spitter.setUserName(rs.getString(4));
//				spitter.setPassword(rs.getString(5));
//			}
//			return spitter;
//
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				if (connection != null) {
//					connection.close();
//				}
//				if (statement != null) {
//					statement.close();
//				}
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}
//		return null;
//	}
//}
