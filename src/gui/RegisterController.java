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

public class RegisterController implements Initializable {

	private Week week;
	private WeekService weekService;

	private CalculateTime calculate;
	private ListTimes list;

	private static SimpleDateFormat format = new SimpleDateFormat("HH:mm");

	String sunday = null, monday = null, tuesday = null, fourth = null, fifth = null, friday = null, saturday = null;
	String time = null, HHStart = "", MMStart = "", HHEnd = "", MMEnd = "", doisPontos1 = "", doisPontos2 = "";
	String hourstart = null, hourend = null;

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

	@FXML
	public void onBtnSunday(ActionEvent event) {
		textSundayVisible();
	}

	@FXML
	public void onBtnMonday(ActionEvent event) {
		textMondayVisible();
	}

	@FXML
	public void onBtnTuesday(ActionEvent event) {
		textTuesdayVisible();
	}

	@FXML
	public void onBtnFourth(ActionEvent event) {
		textFourthVisible();
	}

	@FXML
	public void onBtnFifth(ActionEvent event) {
		textFifthVisible();
	}

	@FXML
	public void onBtnFriday(ActionEvent event) {
		textFridayVisible();
	}

	@FXML
	public void onBtnSaturday(ActionEvent event) {
		textSaturdayVisible();
	}

	@FXML
	public void onBtnSave(ActionEvent event) throws ParseException {
		textSave();
	}

	public void textSave() throws ParseException {
		InstantiateValues();
		if (!time.isEmpty()) {

			if (!hourstart.isEmpty()) {

				if (!hourend.isEmpty()) {

					if (!sunday.isEmpty()) {
						try {
							saveWeek();
						} catch (DbException e) {
							e.printStackTrace();
						}
					} else if (!monday.isEmpty()) {
						try {
							saveWeek();
						} catch (DbException e) {
							e.printStackTrace();
						}
					} else if (!tuesday.isEmpty()) {
						try {
							saveWeek();
						} catch (DbException e) {
							e.printStackTrace();
						}
					} else if (!fourth.isEmpty()) {
						try {
							saveWeek();
						} catch (DbException e) {
							e.printStackTrace();
						}
					} else if (!fifth.isEmpty()) {
						try {
							saveWeek();
						} catch (DbException e) {
							e.printStackTrace();
						}
					} else if (!friday.isEmpty()) {
						try {
							saveWeek();
						} catch (DbException e) {
							e.printStackTrace();
						}
					} else if (!saturday.isEmpty()) {
						try {
							saveWeek();
						} catch (DbException e) {
							e.printStackTrace();
						}
					} else {
						labelResult1.setText("Enter Matter");
						labelResult2.setText("Entre com a Mat�ria");
					}
				} else {
					labelResult1.setText("Select Hour and Minute");
					labelResult2.setText("Selecione Hora e Minuto");
				}
			} else {
				labelResult1.setText("Select Hour and Minute");
				labelResult2.setText("Selecione Hora e Minuto");
			}
		} else {
			labelResult1.setText("Select Time");
			labelResult2.setText("Selecione Tempo");
		}

	}

	public void saveWeek() throws ParseException {
		weekService = new WeekService();
		week = new Week();

		if (weekService == null) {
			labelResult1.setText("Error saving data!");
			labelResult2.setText("Erro ao salvar dados!");
		}
		textValidation();
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

		if (!sunday.equals("")) {
			textSunday.getText().toString();
		} else {
			textMonday.setText("");
			textTuesday.setText("");
			textFourth.setText("");
			textFifth.setText("");
			textFriday.setText("");
			textSaturday.setText("");
		}

		if (!monday.equals("")) {
			textMonday.getText().toString();
		} else {
			textSunday.setText("");
			textTuesday.setText("");
			textFourth.setText("");
			textFifth.setText("");
			textFriday.setText("");
			textSaturday.setText("");
		}

		if (!tuesday.equals("")) {
			textTuesday.getText().toString();
		} else {
			textSunday.setText("");
			textMonday.setText("");
			textFourth.setText("");
			textFifth.setText("");
			textFriday.setText("");
			textSaturday.setText("");
		}

		if (!fourth.equals("")) {
			textFourth.getText().toString();
		} else {
			textSunday.setText("");
			textMonday.setText("");
			textTuesday.setText("");
			textFifth.setText("");
			textFriday.setText("");
			textSaturday.setText("");
		}

		if (!fifth.equals("")) {
			textFifth.getText().toString();
		} else {
			textSunday.setText("");
			textMonday.setText("");
			textTuesday.setText("");
			textFourth.setText("");
			textFriday.setText("");
			textSaturday.setText("");
		}

		if (!friday.equals("")) {
			textFriday.getText().toString();
		} else {
			textSunday.setText("");
			textMonday.setText("");
			textTuesday.setText("");
			textFourth.setText("");
			textFifth.setText("");
			textSaturday.setText("");
		}

		if (!saturday.equals("")) {
			textSaturday.getText().toString();
		} else {
			textSunday.setText("");
			textMonday.setText("");
			textTuesday.setText("");
			textFourth.setText("");
			textFifth.setText("");
			textFriday.setText("");
		}
		week = new Week(null, time, hourstart, hourend, sunday, monday, tuesday, fourth, fifth, friday, saturday);
		weekService.save(week);
		labelResult1.setText("Saved successfully!");
		labelResult2.setText("Salvo com sucesso!");
	}

	public void onBtnAddStartonEnd(ActionEvent event) throws ParseException {
		calculeTime();
	}

	public void calculeTime() {
		try {
			HHStart = textHourStartHH.getText().toString();
			MMStart = textHourStartMM.getText().toString();
			doisPontos1 = labelDoisPontos1.getText().toString();
			textHourStart.setText(HHStart + doisPontos1 + MMStart);
	
			HHEnd = textHourEndHH.getText().toString();
			MMEnd = textHourEndMM.getText().toString();
			doisPontos2 = labelDoisPontos2.getText().toString();
			textHourEnd.setText(HHEnd + doisPontos2 + MMEnd);
	
			time = textHourTime.getText().toString();
			hourstart = textHourStart.getText().toString();
			hourend = textHourEnd.getText().toString();
			
			if(!HHStart.equals("") && !HHEnd.equals("") && 
					!MMStart.equals("") && !MMEnd.equals("")) {
		
				if(!hourstart.equals("") && !hourend.equals("")) {
					
					int hS = 0, mS = 0, hE = 0, mE = 0;
					
					hS = Integer.parseInt(HHStart);
					mS = Integer.parseInt(MMStart);
			
					hE = Integer.parseInt(HHEnd);
					mE = Integer.parseInt(MMEnd);
					
					calculate = new CalculateTime();
					String cal = calculate.calculateTime(hS, mS, hE, mE);
					textHourTime.setText(cal);
					labelResult1.setText("");
					labelResult1.setText("");
				}else {
					labelResult1.setText("Select Hour and Minute");
					labelResult1.setText("Selecione Hora e Minuto");
				}
			}else {
				labelResult1.setText("Select Hour and Minute");
				labelResult1.setText("Selecione Hora e Minuto");
			}
		}catch(NumberFormatException e) {
			System.out.println(e.getMessage());
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
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

	public void textFieldVisible() {
		textSunday.setVisible(false);
		textMonday.setVisible(false);
		textTuesday.setVisible(false);
		textFourth.setVisible(false);
		textFifth.setVisible(false);
		textFriday.setVisible(false);
		textSaturday.setVisible(false);
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

				for (int i = 0; i < hhList.size(); i++) {
					String sh = cbStartHH.getSelectionModel().getSelectedItem();
					textHourStartHH.setText(sh);
				}
			}
		});

		cbStartMM.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {

				for (int i = 0; i < mmList.size(); i++) {
					String smin = cbStartMM.getSelectionModel().getSelectedItem();
					textHourStartMM.setText(smin);
				}
			}
		});

		cbEndHH.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {

				for (int i = 0; i < hhList.size(); i++) {
					String endh = cbEndHH.getSelectionModel().getSelectedItem();
					textHourEndHH.setText(endh);
				}
			}
		});

		cbEndMM.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {

				for (int i = 0; i < mmList.size(); i++) {
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
