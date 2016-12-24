package edu.ustc.debunker.service;

import edu.ustc.debunker.dao.AnalystDao;
import edu.ustc.debunker.model.Analyst;

public class LoginService {

	public boolean loginCheck(Analyst analyst) {
		// TODO Auto-generated method stub
		AnalystDao ad = new AnalystDao();
		Analyst dban = ad.getAnalystByAccount(analyst.getAccount());
		if(analyst.getPassword().equals(dban.getPassword()))
			return true;
		return false;
	}
	
}
