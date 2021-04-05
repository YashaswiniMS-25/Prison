package com.wolken.wolkenapp.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.wolken.wolkenapp.DTO.prisonDTO;

public class PrisonDAOImpl implements PrisonDAO {
	Connection con = null;
	Statement statement = null;

	@Override
	public Connection connect() {

		try {
			// System.out.println("1load the driver");
			// Class.forName("com.mysql.cj.jdbc.Driver");
			// System.out.println("2estsblish connection");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/wolken?user=root&password=Yashu@25101999");
			// System.out.println("3create a statement or platform");
			// statement=con.createStatement();
		} catch (Exception e) {
			e.printStackTrace();

		}
		return con;
	}

	@Override
	public void add(int id, String name, int y, int inmates) {
		// TODO Auto-generated method stub
		try {
			                
			PreparedStatement preparedStatement = connect().prepareStatement("insert into prison_table values(?,?,?,?)");

			preparedStatement.setInt(1, id);

			preparedStatement.setString(2, name);

			preparedStatement.setInt(3, inmates);

			preparedStatement.setInt(4, y);
			preparedStatement.executeUpdate();
			System.out.println("added");
close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}

	}

	public void get() {
		try {

			statement = connect().createStatement();

			ResultSet rs = statement.executeQuery("select * from prison_table");

			while (rs.next()) {

				int id = rs.getInt("prisonid");
				String name = rs.getString("prison_name");
				int yrs = rs.getInt("no_of_years");
				int inmates = rs.getInt("no_of_inmates");
				// preparedStatement.executeUpdate();
				System.out.println(id + "" + name + " " + yrs + " " + inmates);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void close() {
		try {
			System.out.println("closing the connection");
		} finally {
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

	@Override
	public void update(int year, int id) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement ps = con
					.prepareStatement("update prison_table set no_of_years=" + year + " where prisonid=" + id);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement ps = con.prepareStatement("delete from prison_table where prisonid=" + id);
			ps.executeUpdate();
			System.out.println("deleted");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
