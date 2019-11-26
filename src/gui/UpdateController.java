package gui;

import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.ResourceBundle;

import javax.swing.event.ChangeEvent;

import db.DbException;
import gui.util.CalculateTime;
import gui.util.ListTimes;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.entities.Week;
import model.services.WeekService;

public class UpdateController implements Initializable {
	
	private Week week;	
	private WeekService weekService;
	
	private CalculateTime calculate;
	private ListTimes list;
	
	private static SimpleDateFormat format = new SimpleDateFormat("HH:mm");
	
	String sunday = null, monday = null, tuesday = null, fourth = null, fifth = null, friday = null, saturday = null;
	String time = null, HHStart = null, MMStart = null, HHEnd = null, MMEnd = null, doisPntos1 = null, doisPntos2 = null;	
	String hourstart = null, hourend = null;
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
	private TextField textHourStartHH;
	
	@FXML
	private ComboBox<String> cbStartHH;
	
	@FXML
	private ComboBox<String> cbStartMM;
	
	@FXML
	private ComboBox<String> cbEndHH;
	
	@FXML
	private ComboBox<String> cbEndMM;
	
	@FXML
	private TextField textHourStartMM;
	
	@FXML
	private TextField textHourEnd;
	
	@FXML
	private TextField textHourEndHH;
	
	@FXML
	private TextField textHourEndMM;
	
	@FXML
	private Label labelDoisPontos1;
	
	@FXML
	private Label labelDoisPontos2;
		
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
	private Button btnAddStart;
	
	@FXML
	private Button btnAddEnd;
	
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
	private Button btnSave;
	
	@FXML
	private Label labelResult1;
	
	@FXML
	private Label labelResult2;
	
	ObservableList<String> obsHH;
	ObservableList<String> obsMM;
	ObservableList<Week> obsId;
		
	@FXML
	public void onBtnSave(ActionEvent event) throws ParseException {
		try {
			textSave();	
		}
		catch(DbException e) {
			e.printStackTrace();
		}
	}
	
	public void textSave() throws ParseException {
		InstantiateValues();	
		if(!time.isEmpty()) {
			
			if(!hourstart.isEmpty()) {
				
				if(!hourend.isEmpty()) {					
				
					if(!sunday.isEmpty()) {
						try {
							updateWeek();
						}
						catch(DbException e) {
							e.printStackTrace();
						}
					}
					else if(!monday.isEmpty()) {
						try {
							updateWeek();
						}
						catch(DbException e) {
							e.printStackTrace();
						}
					}
					else if(!tuesday.isEmpty()) {
						try {
							updateWeek();
						}
						catch(DbException e) {
							e.printStackTrace();
						}
					}
					else if(!fourth.isEmpty()) {
						try {
							updateWeek();
						}
						catch(DbException e) {
							e.printStackTrace();
						}
					}
					else if(!fifth.isEmpty()) {
						try {
							updateWeek();
						}
						catch(DbException e) {
							e.printStackTrace();
						}
					}
					else if(!friday.isEmpty()) {
						try {
							updateWeek();
						}
						catch(DbException e) {
							e.printStackTrace();
						}
					}
					else if(!saturday.isEmpty()) {
						try {
							updateWeek();
						}
						catch(DbException e) {
							e.printStackTrace();
						}
					}else {
						labelResult1.setText("Enter Matter");
						labelResult2.setText("Entre com a Matéria");
					}								
			}else {
						labelResult1.setText("Select Hour and Minute");
						labelResult2.setText("Selecione Hora e Minuto");
					}
				}else {
					labelResult1.setText("Select Hour and Minute");
					labelResult2.setText("Selecione Hora e Minuto");
			}
		}else {
			labelResult1.setText("Select Time");
			labelResult2.setText("Selecione Tempo");
		}
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
	
	public void updateWeek() throws ParseException {
		weekService = new WeekService();
		week = new Week();	
										
		if(weekService == null) {
			labelResult1.setText("Error saving data!");
			labelResult2.setText("Erro ao salvar dados!");
		}
		textValidation();		
	}
	
	public void comboBoxSelectId() {
		weekService = new WeekService();
		week = new Week();	
										
		if(weekService == null) {
			labelResult1.setText("Error update data!");
			labelResult2.setText("Erro ao atualizar dados!");
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
			}			
		});	
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
		weekService.update(week);
		labelResult1.setText("Update successfully!");	
		labelResult2.setText("Atualizado com Sucesso!");	
	}
	
	public void onBtnAddStartonEnd(ActionEvent event) throws ParseException {
		calculeTime();		
	}	
	
	public void calculeTime() {
		HHStart = textHourStartHH.getText().toString();
		MMStart = textHourStartMM.getText().toString();	
		doisPntos1 = labelDoisPontos1.getText().toString();
		textHourStart.setText(HHStart+doisPntos1+MMStart);
		
		HHEnd = textHourEndHH.getText().toString();
		MMEnd = textHourEndMM.getText().toString();		
		doisPntos2 = labelDoisPontos2.getText().toString();		
		textHourEnd.setText(HHEnd+doisPntos2+MMEnd);
		
		time = textHourTime.getText().toString();
		
		double hS = 0, mS = 0, hE = 0, mE = 0;
		
		hS = Double.parseDouble(textHourStartHH.getText().toString());
		mS = Double.parseDouble(textHourStartMM.getText().toString());
		
		hE = Double.parseDouble(textHourEndHH.getText().toString());
		mE = Double.parseDouble(textHourEndMM.getText().toString());
		
		calculate = new CalculateTime();
		String cal = calculate.calculateTime(hS, mS, hE, mE);
		textHourTime.setText(cal);
	}
		
	public void textSundayVisible() {
		textSunday.setVisible(true);
		textMonday.setVisible(false);
		textTuesday.setVisible(false);
		textFourth.setVisible(false);
		textFifth.setVisible(false);
		textFriday.setVisible(false);
		textSaturday.setVisible(false);
	}
	
	public void textMondayVisible() {
		textSunday.setVisible(false);
		textMonday.setVisible(true);
		textTuesday.setVisible(false);
		textFourth.setVisible(false);
		textFifth.setVisible(false);
		textFriday.setVisible(false);
		textSaturday.setVisible(false);
	}
	
	public void textTuesdayVisible() {
		textSunday.setVisible(false);
		textMonday.setVisible(false);
		textTuesday.setVisible(true);
		textFourth.setVisible(false);
		textFifth.setVisible(false);
		textFriday.setVisible(false);
		textSaturday.setVisible(false);
	}
	
	public void textFourthVisible() {
		textSunday.setVisible(false);
		textMonday.setVisible(false);
		textTuesday.setVisible(false);
		textFourth.setVisible(true);
		textFifth.setVisible(false);
		textFriday.setVisible(false);
		textSaturday.setVisible(false);
	}
	
	public void textFifthVisible() {
		textSunday.setVisible(false);
		textMonday.setVisible(false);
		textTuesday.setVisible(false);
		textFourth.setVisible(false);
		textFifth.setVisible(true);
		textFriday.setVisible(false);
		textSaturday.setVisible(false);
	}
	
	public void textFridayVisible() {
		textSunday.setVisible(false);
		textMonday.setVisible(false);
		textTuesday.setVisible(false);
		textFourth.setVisible(false);
		textFifth.setVisible(false);
		textFriday.setVisible(true);
		textSaturday.setVisible(false);
	}
	
	public void textSaturdayVisible() {
		textSunday.setVisible(false);
		textMonday.setVisible(false);
		textTuesday.setVisible(false);
		textFourth.setVisible(false);
		textFifth.setVisible(false);
		textFriday.setVisible(false);
		textSaturday.setVisible(true);
	}
	
	public void textFieldInVisible() {
		textSunday.setVisible(false);
		textMonday.setVisible(false);
		textTuesday.setVisible(false);
		textFourth.setVisible(false);
		textFifth.setVisible(false);
		textFriday.setVisible(false);
		textSaturday.setVisible(false);
	}
	
	public void textFieldVisible() {
		textSunday.setVisible(true);
		textMonday.setVisible(true);
		textTuesday.setVisible(true);
		textFourth.setVisible(true);
		textFifth.setVisible(true);
		textFriday.setVisible(true);
		textSaturday.setVisible(true);
	}
	
	public void initializeComboBox() {
		list = new ListTimes();
		List<String> hhList = list.listHour();
		List<String> mmList = list.listMinute();
		
		obsHH = FXCollections.observableArrayList(hhList);
		cbStartHH.setItems(obsHH);
		cbEndHH.setItems(obsHH);
		
		obsMM = FXCollections.observableArrayList(mmList);
		cbStartMM.setItems(obsMM);
		cbEndMM.setItems(obsMM);
		
		cbStartHH.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				
				for(int i=0 ; i<hhList.size(); i++) {
					String sh = cbStartHH.getSelectionModel().getSelectedItem();
					textHourStartHH.setText(sh);
				}			
			}
		});
		
		cbStartMM.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				
				for(int i=0 ; i<mmList.size(); i++) {
					String smin = cbStartMM.getSelectionModel().getSelectedItem();
					textHourStartMM.setText(smin);					
				}				
			}
		});
		
		cbEndHH.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				
				for(int i=0 ; i<hhList.size(); i++) {
					String endh = cbEndHH.getSelectionModel().getSelectedItem();
					textHourEndHH.setText(endh);
				}			
			}
		});
		
		cbEndMM.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
								
				for(int i=0 ; i<mmList.size(); i++) {
					String endmin = cbEndMM.getSelectionModel().getSelectedItem();
					textHourEndMM.setText(endmin);
				}				
			}
		});
	}
				
	public void onComboBoxHHStart(ChangeEvent e) {			
		textHourStartHH.getText().toString();
	}
		
	@Override
	public void initialize(URL url, ResourceBundle rb) {		
		textFieldVisible();
		initializeComboBox();
		comboBoxSelectId();
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
