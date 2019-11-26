package model.services;

import java.util.List;

import model.dao.DaoFactory;
import model.dao.WeekDao;
import model.entities.Week;

public class WeekService {

	private WeekDao dao = DaoFactory.createDaoWeek();
	
	public List<Week> findAll(){
		return dao.findAll();
	}
	
	public void save(Week week) {
		if(week.getId() == null) {
			dao.insert(week);
		}
	}
	
	public void update(Week week) {
		if(week.getId() != null) {
			dao.update(week);
		}
	}
	
	public void remove(Week week) {
		dao.deleteById(week.getId());
	}
	
	public void findById(Week week) {
		dao.findById(week.getId());
	}	
}
