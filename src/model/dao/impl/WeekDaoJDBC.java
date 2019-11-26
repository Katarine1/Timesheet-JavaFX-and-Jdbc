package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import db.DB;
import db.DbException;
import model.dao.WeekDao;
import model.entities.Week;

public class WeekDaoJDBC implements WeekDao {
	
	private Week week;
	
	private static Connection conn;
	
	private PreparedStatement st = null;
	private ResultSet rs = null;

	private String sql = null;
	
	public WeekDaoJDBC(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void insert(Week week) {
		try {
			sql = "INSERT INTO week (timehour, hourstart, hourend, sunday, monday, tuesday, fourth, fifth, friday, saturday) VALUE (?,?,?,?,?,?,?,?,?,?)";
			st = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			st.setString(1, week.getTimehour());
			st.setString(2, week.getHourstart());
			st.setString(3, week.getHourend());
			st.setString(4, week.getSunday());
			st.setString(5, week.getMonday());
			st.setString(6, week.getTuesday());
			st.setString(7, week.getFourth());
			st.setString(8, week.getFifth());
			st.setString(9, week.getFriday());
			st.setString(10, week.getSaturday());
			
			int rowsAffected = st.executeUpdate();

			if (rowsAffected > 0) {
				rs = st.getGeneratedKeys();
				if (rs.next()) {
					int id = rs.getInt(1);
					week.setId(id);
				}
				DB.closeResultSet(rs);
			} else {
				throw new DbException("Unexpected error! No rows affected!");
			}
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(st);
		}
	}

	@Override
	public void update(Week week) {
		try {
			sql = "UPDATE week SET timehour = ?, hourstart = ?, hourend = ?, sunday = ?, monday = ?, tuesday = ?, fourth = ?, fifth = ?, friday = ?, saturday = ?  WHERE id = ?";
			st = conn.prepareStatement(sql);
			st.setString(1, week.getTimehour());
			st.setString(2, week.getHourstart());
			st.setString(3, week.getHourend());
			st.setString(4, week.getSunday());
			st.setString(5, week.getMonday());
			st.setString(6, week.getTuesday());
			st.setString(7, week.getFourth());
			st.setString(8, week.getFifth());
			st.setString(9, week.getFriday());
			st.setString(10, week.getSaturday());
			st.setInt(11, week.getId());
			
			st.executeUpdate();
		}
		catch(SQLException e)	{
			throw new DbException(e.getMessage());
		}
		finally{
			DB.closeStatement(st);
		}
	}

	@Override
	public void deleteById(Integer id) {
		try {
			sql = "DELETE FROM week WHERE id = ?";
			st = conn.prepareStatement(sql);
			st.setInt(1, id);
			st.executeUpdate();
		}
		catch(SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
		}
	}

	@Override
	public Week findById(Integer id) {
		try {
			sql = "SELECT * FROM week WHERE id = ?";					
			st = conn.prepareStatement(sql);
			st.setInt(1, id);
			rs = st.executeQuery();

			if (rs.next()) {
				week = instantiateWeek();
				return week;
			}
			return null;
		} 
		catch (SQLException e) {
			throw new DbException(e.getMessage());
		} 
		finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
	}
		
	@Override
	public List<Week> findAll() {
		try {
			sql = "SELECT * FROM week ORDER BY hourstart";
			st = conn.prepareStatement(sql);
			rs = st.executeQuery();

			List<Week> list = new ArrayList<>();
									
			while (rs.next()) {
				week = instantiateWeek();
				list.add(week);
			}
			return list;
		} 
		catch (SQLException e) {
			throw new DbException(e.getMessage());
		} 
		finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
	}
	
	private Week instantiateWeek() throws SQLException {		
		week = new Week();		
		week.setId(rs.getInt("id"));
		week.setTimehour(rs.getString("timehour"));
		week.setHourstart(rs.getString("hourstart"));
		week.setHourend(rs.getString("hourend"));
		week.setSunday(rs.getString("sunday").toUpperCase());
		week.setMonday(rs.getString("monday").toUpperCase());
		week.setTuesday(rs.getString("tuesday").toUpperCase());
		week.setFourth(rs.getString("fourth").toUpperCase());
		week.setFifth(rs.getString("fifth").toUpperCase());
		week.setFriday(rs.getString("friday").toUpperCase());
		week.setSaturday(rs.getString("saturday").toUpperCase());		
		return week;
	}	
}
