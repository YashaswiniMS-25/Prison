package com.wolken.wolkenapp.service;

public class prisonServiceImpl implements prisonService {

	@Override
	public boolean check(int no_of_inmates,int no_of_years) {
		// TODO Auto-generated method stub
		
		if(no_of_inmates>12 && no_of_years<1)
			
		      return false;
		else 
			return true;
	}

	@Override
	public boolean checkupdate(int no_of_years) {
		// TODO Auto-generated method stub
		if(no_of_years>50)
		  return false;
		else
			return true;
	}

	@Override
	public boolean valiadte(int prisonid) {
		// TODO Auto-generated method stub
		if(prisonid<1)
		return false;
		else
			return true;
	}

}
