package gui;

import java.net.URL;
import java.sql.Time;
import java.util.List;
import java.util.ResourceBundle;

import db.DbException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.entities.Week;
import model.services.WeekService;

public class TimesController implements Initializable {
		
	private WeekService weekService;
	private Week week;
	
	@FXML
	private TableView<Week> tableViewTime;
		
	@FXML
	private TableColumn<Week, String> tableColumnHour;
		
	@FXML
	private TableColumn<Week, Time> tableColumnHourStart;
	
	@FXML
	private TableColumn<Week, Time> tableColumnHourEnd;
	
	@FXML
	private TableColumn<Week, String> tableColumnSunday;
	
	@FXML
	private TableColumn<Week, String> tableColumnMonday;
	
	@FXML
	private TableColumn<Week, String> tableColumnTuesday;
	
	@FXML
	private TableColumn<Week, String> tableColumnFourth;
	
	@FXML
	private TableColumn<Week, String> tableColumnFifth;
	
	@FXML
	private TableColumn<Week, String> tableColumnFriday;
	
	@FXML
	private TableColumn<Week, String> tableColumnSaturday;
			
	ObservableList<Week> weekObs;
				
	private void initializeTable() {		
		tableColumnHour.setCellValueFactory(new PropertyValueFactory<>("timehour"));
		tableColumnHourStart.setCellValueFactory(new PropertyValueFactory<>("hourstart"));
		tableColumnHourEnd.setCellValueFactory(new PropertyValueFactory<>("hourend"));
		tableColumnSunday.setCellValueFactory(new PropertyValueFactory<>("sunday"));
		tableColumnMonday.setCellValueFactory(new PropertyValueFactory<>("monday"));
		tableColumnTuesday.setCellValueFactory(new PropertyValueFactory<>("tuesday"));
		tableColumnFourth.setCellValueFactory(new PropertyValueFactory<>("fourth"));
		tableColumnFifth.setCellValueFactory(new PropertyValueFactory<>("fifth"));
		tableColumnFriday.setCellValueFactory(new PropertyValueFactory<>("friday"));
		tableColumnSaturday.setCellValueFactory(new PropertyValueFactory<>("saturday"));
			
		updateTableView();
	}
	
	public void updateTableView() {
		week = new Week();
		weekService = new WeekService();
		if(weekService == null) {
			throw new DbException("Week service was null");
		}
				
		List<Week> list = weekService.findAll();		
		weekObs = FXCollections.observableArrayList(list);
		tableViewTime.setItems(weekObs);	
	}
	
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		initializeTable();
	}
	
	public WeekService getWeekService() {
		return weekService;
	}

	public void setWeekService(WeekService weekService) {
		this.weekService = weekService;
	}

	public Week getWeek() {
		return week;
	}

	public void setWeek(Week week) {
		this.week = week;
	}
}