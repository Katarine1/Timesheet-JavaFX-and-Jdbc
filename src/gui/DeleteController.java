package gui;

import java.net.URL;
import java.text.ParseException;
import java.util.List;
import java.util.ResourceBundle;

import db.DbException;
import gui.util.Alerts;
import gui.util.CalculateTime;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.entities.Week;
import model.services.WeekService;

public class DeleteController implements Initializable {
	
	private Week week;	
	private WeekService weekService;
	
	private CalculateTime calculate;
		
	String sunday = null, monday = null, tuesday = null, fourth = null, fifth = null, friday = null, saturday = null;
	String time = null, HHStart = null, MMStart = null, HHEnd = null, MMEnd = null, doisPntos1 = null, doisPntos2 = null;	
	String hourstart= null, hourend = null;
	int id = 0;
	
	@FXML
	private ComboBox<Week> cbSelectId;
		
	@FXML
	private TextField textId;
	
	@FXML
	private TextField textHourTime;
	
	@FXML
	private TextField textHourStart;	
	
	@FXML
	private TextField textHourEnd;
	
	@FXML
	private TextField textSunday;
	
	@FXML
	private TextField textMonday;
	
	@FXML
	private TextField textTuesday;
	
	@FXML
	private TextField textFourth;
	
	@FXML
	private TextField textFifth;
	
	@FXML
	private TextField textFriday;
	
	@FXML
	private TextField textSaturday;
			
	@FXML
	private Button btnSunday;
	
	@FXML
	private Button btnMonday;
	
	@FXML
	private Button btnTuesday;
	
	@FXML
	private Button btnFourth;
	
	@FXML
	private Button btnFifth;
	
	@FXML
	private Button btnFriday;
	
	@FXML
	private Button btnSaturday;
		
	@FXML
	private Button btnDelete;
	
	@FXML
	private Button btnConfirme;
	
	@FXML
	private Label labelResult1;
	
	@FXML
	private Label labelResult2;
	
	@FXML
	private Label labelDELETE;
	
	@FXML
	private Label labelCONFIRM;
	
	ObservableList<Week> obsId;
	
	@FXML
	public void onBtnConfirm(ActionEvent event) {
		confirmDelete();
	}
		
	@FXML
	public void onBtnDelete(ActionEvent event) throws ParseException {
		try {
			deleteWeek();
			
		}catch(DbException e) {
			throw new DbException(e.getMessage());
		}		
	}
	
	public void deleteWeek() throws ParseException {
		weekService = new WeekService();
		week = new Week();	
										
		if(weekService == null) {
			labelResult1.setText("Error delete data!");
			labelResult2.setText("Erro ao excluir dados!");
		}
		
		textValidation();
	}
	
	public void comboBoxSelectId() {
		weekService = new WeekService();
		week = new Week();	
										
		if(weekService == null) {
			labelResult1.setText("Error delete data!");
			labelResult1.setText("Erro ao excluir dados!");
		}
		
		List<Week> list = weekService.findAll();
		obsId = FXCollections.observableArrayList(list);
		cbSelectId.getItems().addAll(obsId);
		
		cbSelectId.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				int i = cbSelectId.getSelectionModel().getSelectedItem().getId();
				String th = cbSelectId.getSelectionModel().getSelectedItem().getTimehour();
				String hs = cbSelectId.getSelectionModel().getSelectedItem().getHourstart();
				String he = cbSelectId.getSelectionModel().getSelectedItem().getHourend();
				String sunday = cbSelectId.getSelectionModel().getSelectedItem().getSunday();
				String monday = cbSelectId.getSelectionModel().getSelectedItem().getMonday();
				String tuesday = cbSelectId.getSelectionModel().getSelectedItem().getTuesday();
				String fourth = cbSelectId.getSelectionModel().getSelectedItem().getFourth();
				String fifth = cbSelectId.getSelectionModel().getSelectedItem().getFifth();
				String friday = cbSelectId.getSelectionModel().getSelectedItem().getFriday();
				String saturday = cbSelectId.getSelectionModel().getSelectedItem().getSaturday();
				String s = String.valueOf(i);
				textId.setText(s);
				textHourTime.setText(th);
				textHourStart.setText(hs);
				textHourEnd.setText(he);
				textSunday.setText(sunday);
				textMonday.setText(monday);
				textTuesday.setText(tuesday);
				textFourth.setText(fourth);
				textFifth.setText(fifth);
				textFriday.setText(friday);
				textSaturday.setText(saturday);
				btnConfirme.setVisible(true);
				labelCONFIRM.setVisible(true);
				btnDelete.setVisible(false);
				labelDELETE.setVisible(false);
			}			
		});	
	}
	
	public void InstantiateValues() {		
		time = textHourTime.getText().toString();		
		hourstart = textHourStart.getText().toString();		
		hourend = textHourEnd.getText().toString();
			
		sunday = textSunday.getText().toString();
		monday = textMonday.getText().toString();
		tuesday = textTuesday.getText().toString();
		fourth = textFourth.getText().toString();
		fifth = textFifth.getText().toString();
		friday = textFriday.getText().toString();
		saturday = textSaturday.getText().toString();	
	}
		
	public void textValidation() throws ParseException {
		week = new Week();
		InstantiateValues();
		
		id = Integer.parseInt(textId.getText().toString());
		
		if(!sunday.equals("")) {
			textSunday.getText().toString();
		}else {
			textMonday.setText("");
			textTuesday.setText("");
			textFourth.setText("");
			textFifth.setText("");
			textFriday.setText("");
			textSaturday.setText("");
		}
		
		if(!monday.equals("")) {
			textMonday.getText().toString();
		}else {
			textSunday.setText("");
			textTuesday.setText("");
			textFourth.setText("");
			textFifth.setText("");
			textFriday.setText("");
			textSaturday.setText("");
		}
		
		if(!tuesday.equals("")) {
			textTuesday.getText().toString();
		}else {
			textSunday.setText("");
			textMonday.setText("");
			textFourth.setText("");
			textFifth.setText("");
			textFriday.setText("");
			textSaturday.setText("");
		}
		
		if(!fourth.equals("")) {
			textFourth.getText().toString();
		}else {
			textSunday.setText("");
			textMonday.setText("");
			textTuesday.setText("");
			textFifth.setText("");
			textFriday.setText("");
			textSaturday.setText("");
		}
		
		if(!fifth.equals("")) {
			textFifth.getText().toString();
		}else {
			textSunday.setText("");
			textMonday.setText("");
			textTuesday.setText("");
			textFourth.setText("");
			textFriday.setText("");
			textSaturday.setText("");
		}
		
		if(!friday.equals("")) {
			textFriday.getText().toString();
		}else {
			textSunday.setText("");
			textMonday.setText("");
			textTuesday.setText("");
			textFourth.setText("");
			textFifth.setText("");
			textSaturday.setText("");
		}
		
		if(!saturday.equals("")) {
			textSaturday.getText().toString();
		}else {
			textSunday.setText("");
			textMonday.setText("");
			textTuesday.setText("");
			textFourth.setText("");
			textFifth.setText("");
			textFriday.setText("");
		}
		week = new Week(id, time ,hourstart, hourend, sunday, monday, tuesday, fourth, fifth, friday, saturday);
		weekService.remove(week);
		//Alerts.alertMsg("Delete", "Delete successfully!\n(Excluído com sucesso!)", AlertType.INFORMATION);
		labelResult1.setText("Delete successfully!");
		labelResult2.setText("Excluído com sucesso!");
		btnDelete.setVisible(false);
		labelDELETE.setVisible(false);
	}
		
	public void confirmDelete() {
		Alerts.alertMsg("Delete", "Do you want to delete this data?\n(Deseja excluir esse dado?)",AlertType.CONFIRMATION);
		btnDelete.setVisible(true);
		labelDELETE.setVisible(true);
		btnConfirme.setVisible(false);
		labelCONFIRM.setVisible(false);
	}
		
	@Override
	public void initialize(URL url, ResourceBundle rb) {		
		comboBoxSelectId();
		btnDelete.setVisible(false);
		labelDELETE.setVisible(false);
		btnConfirme.setVisible(true);
		labelCONFIRM.setVisible(true);
	}

	public Week getWeek() {
		return week;
	}

	public void setWeek(Week week) {
		this.week = week;
	}

	public WeekService getWeekService() {
		return weekService;
	}

	public void setWeekService(WeekService weekService) {
		this.weekService = weekService;
	}
}
