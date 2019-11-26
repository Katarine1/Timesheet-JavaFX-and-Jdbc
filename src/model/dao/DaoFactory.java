package model.dao;

import db.DB;
import model.dao.impl.WeekDaoJDBC;

public class DaoFactory {

	public static WeekDao createDaoWeek() {
		return new WeekDaoJDBC(DB.getConnection());
	}
}
