package model.dao;

import java.util.List;

import model.entities.Week;

public interface WeekDao {

	void insert(Week week);
	void update(Week week);
	void deleteById(Integer id);
	Week findById(Integer id);
	List<Week> findAll();
}
