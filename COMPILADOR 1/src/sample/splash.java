package sample;

import com.sun.javafx.application.LauncherImpl;
import javafx.application.Platform;
import javafx.application.Preloader;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

/**
 * Created by D10101 on 06/09/2018.
 */
public class splash extends Preloader {
private Label lblprogress;
private ProgressBar barra;
private Stage stage;
private Scene scene;

    @Override
    public void handleStateChangeNotification(StateChangeNotification info) {
        StateChangeNotification.Type type=info.getType();
        switch (type){
            case BEFORE_START:{
                stage.hide();
                break;
            }
        }
    }

    @Override
    public void handleApplicationNotification(PreloaderNotification info) {
if(info instanceof  PreloaderNotification){
    lblprogress.setText(((ProgressNotification)info).getProgress()+"%");
    barra.setProgress(((ProgressNotification) info).getProgress()/100);

}
    }

    @Override
    public void init() throws Exception {
        Platform.runLater(new Runnable() {//hilo
            @Override
            public void run() {
                Parent root2;
                try{
                   root2= FXMLLoader.load(getClass().getResource("splash.fxml"));
                   scene= new Scene(root2,600,600);
                }
                catch (IOException e){
e.printStackTrace();
                }
            }
        });
    }

    @Override
    public void start(Stage stage) throws Exception {
this.stage=stage;
this.stage.initStyle(StageStyle.UNDECORATED);
this.stage.setScene(scene);
this.stage.show();
lblprogress=(Label) scene.lookup("#lblprog");
barra=(ProgressBar) scene.lookup("#prog");


    }
}
