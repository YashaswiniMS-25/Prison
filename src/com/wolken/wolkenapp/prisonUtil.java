package com.wolken.wolkenapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.wolken.wolkenapp.DAO.Prison;
import com.wolken.wolkenapp.DAO.PrisonDAO;
import com.wolken.wolkenapp.DAO.PrisonDAOImpl;
import com.wolken.wolkenapp.DAO.PrisonImpl;
import com.wolken.wolkenapp.DAO.prison;
import com.wolken.wolkenapp.DAO.prisonImpl;
import com.wolken.wolkenapp.DTO.prisonDTO;
import com.wolken.wolkenapp.service.prisonService;
import com.wolken.wolkenapp.service.prisonServiceImpl;

public class prisonUtil {

	public static void main(String[] args) {
		PrisonDAO p = new PrisonDAOImpl();
		Scanner scan = new Scanner(System.in);
		p.connect();
		prisonDTO pdto = new prisonDTO();
		prisonService ps = new prisonServiceImpl();
		// TODO Auto-generated method stub

		// Connection con=null;
		// Statement st=null;

		try {
			// Class.forName("com.mysql.cj.jdbc.Driver");
			// con=("jdbc:mysql://localhost:3306/wolken?user=root&password=Yashu@25101999");
			System.out.println("enter prison id");
			pdto.setPrisonid(scan.nextInt());
			System.out.println("enter prison name");
			pdto.setPrison_name(scan.next());
			System.out.println("enter no_of years");
			pdto.setNo_of_years(scan.nextInt());
			System.out.println("enter no of inmates");
			pdto.setNo_of_inmates(scan.nextInt());
			boolean c = ps.check(pdto.getNo_of_inmates(), pdto.getNo_of_years());
			if (c) {

				p.add(pdto);
				p.get();
				System.out.println("enter the year to be updated");
				pdto.setNo_of_years(scan.nextInt());
				

				System.out.println("enter the id ");
				pdto.setPrisonid(scan.nextInt());
				
				boolean upd=ps.checkupdate(pdto.getNo_of_years());
				if(upd) {
				p.update(pdto.getNo_of_years(), pdto.getPrisonid());
				}else {
					System.out.println("year is not valid");
				}
				System.out.println("enetr thr id to be deleted");
				pdto.setPrisonid(scan.nextInt());
				boolean val=ps.valiadte(pdto.getPrisonid());
				if(val) {
				
				p.delete(pdto.getPrisonid());}
				else {
					System.out.println("id is not valid");
				}
				p.get();

				p.close();
			} else {
				System.out.println("validation failed");
				p.close();
			}

		} catch (NullPointerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
