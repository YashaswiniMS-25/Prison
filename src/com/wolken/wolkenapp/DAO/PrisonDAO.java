package com.wolken.wolkenapp.DAO;

import java.sql.Connection;

import com.wolken.wolkenapp.DTO.prisonDTO;

public interface PrisonDAO {
	public void add(PrisonDTO dto);
	public void get();
	public Connection connect();
	public void close();
	public void update(int year,int id);
	public void delete(int id);

}
