package service;

import java.io.IOException;

import dao.LunchDAO;
import domain.LunchDomain;

public class LunchService {

	public int getTotal() {
		int total = 0;
		
		LunchDAO l_dao = LunchDAO.getInstance();
		try {
			total = l_dao.selectTotal();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return total;
	}
	
	public LunchDomain selectLunchMenu(int idx) {
		LunchDomain ld = null;
		
		LunchDAO l_dao = LunchDAO.getInstance();
		try {
			ld = l_dao.selectLunchMenu(idx);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return ld;
	}
}
