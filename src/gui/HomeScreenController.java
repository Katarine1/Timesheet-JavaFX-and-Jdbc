package gui;

import java.io.IOException;
import java.net.URL;
import java.sql.Time;
import java.util.ResourceBundle;
import java.util.function.Consumer;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import model.entities.Week;
import model.services.WeekService;

public class HomeScreenController implements Initializable {

	private Stage parentStage;
		
	private WeekService weekService;
	private Week week;
	
	@FXML
	private Button btnRegister;
	
	@FXML
	private Button btnUpdate;
	
	@FXML
	private Button btnDelete;
	
	@FXML
	private Button btnSchedules;
		
	//Action Buttons
	@FXML
	public void onBtnRegWeek(ActionEvent event) {
		loadDialog("/gui/RegisterForm.fxml", "Register", (RegisterController controller)->{
			controller.setWeekService(new WeekService());
		});
	}	
	@FXML
	public void onBtnUpdWeek(ActionEvent event) {
		loadDialog("/gui/UpdateForm.fxml", "Update", (UpdateController controller)->{
			controller.setWeekService(new WeekService());
		});
	}
	@FXML
	public void onBtnDelWeek(ActionEvent event) {
		loadDialog("/gui/DeleteForm.fxml", "Delete", (DeleteController controller)->{
			controller.setWeekService(new WeekService());
		});
	}
	@FXML
	public void onBtnSchedulesWeek(ActionEvent event) {
		loadDialog("/gui/Times.fxml", "Schedules", (TimesController controller)->{
			controller.setWeekService(new WeekService());
		});
	}
					
	private synchronized <T> void loadDialog(String file, String title, Consumer<T> initializeAction) {
		try {
			Parent parent = FXMLLoader.load(getClass().getResource(file));
			Scene scene = new Scene(parent);
			parentStage = new Stage();			
			parentStage.setTitle(title);
			//parentStage.getIcons().add(new Image("/img/img.jpg"));
			parentStage.setResizable(false);
			parentStage.setScene(scene);			
			parentStage.show();			
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		
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