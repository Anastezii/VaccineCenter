package sit.tuvarna.bg.vaccine.presentation.controllers;

import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import sit.tuvarna.bg.vaccine.business.services.UserService;
import sit.tuvarna.bg.vaccine.data.entities.User;
import sit.tuvarna.bg.vaccine.presentation.models.HelloModel;

import java.io.IOException;
import java.net.URL;

public class HelloController implements EventHandler<MouseEvent> {

    private final UserService service = UserService.getInstance();

    @FXML
    public Button loginButton;
    @FXML
    public Button ExitButton;

    @FXML
    private TextField textLogin;

    @FXML
    private PasswordField passwordField;
/*

    @FXML
    private Label welcomeText;*/



    //private final HelloModel model;

 /*   public HelloController() {
        this.model = new HelloModel();
    }

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }*/

    @FXML
    private void initialize(){
        loginButton.setOnMouseClicked(this::handle);
        ExitButton.setOnMouseClicked(this::handle2);

    }

    private void handle2(MouseEvent mouseEvent) {
       Stage stage=(Stage) ExitButton.getScene().getWindow();
       stage.close();
    }

    @Override
    public void handle(MouseEvent mouseEvent) {
        String login = textLogin.getText().trim();
        String pass = passwordField.getText().trim();
        User user=new User(login,pass);
        ObservableList<User> allTask = service.getAllTask(login,pass);

        boolean Login=false;

        for (User usersLog:allTask) {
            if(user.getLogin().equals(login) && user.getPassword().equals(pass)){
                Login=true;
                System.out.println("True");
                extracted();
            }
            else{
                System.out.println("error in adm");
                Login=false;
            }
        }
    }

    private void extracted() {
        Parent root;
        try{
            URL pathAdminWindow = getClass().getResource("/sit/tuvarna/bg/vaccine/presentation.view/ProfileCl.fxml");
            root= FXMLLoader.load(pathAdminWindow);
            Stage stage=new Stage();
            stage.setTitle("Client Window");
            stage.setScene(new Scene(root));
            stage.show();
            //((Node)(event.getSource())).getScene().getWindow().hide();
        }catch(IOException e){
            e.getCause();
        }
    }


    }
