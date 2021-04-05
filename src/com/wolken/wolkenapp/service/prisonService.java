package com.wolken.wolkenapp.service;

import com.wolken.wolkenapp.DTO.prisonDTO;

public interface prisonService {
	
public void add(prisonDTO dto);
public boolean check(int no_of_inmates,int no_of_years);

public boolean checkupdate(int no_of_years);

public boolean valiadte(int prisonid);
}
