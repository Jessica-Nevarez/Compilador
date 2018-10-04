package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

public class Controller extends Application {
    private Stage stage;

    public void evtsalir (ActionEvent evt){
        System.exit(0);
    }
    public void evtabrir(ActionEvent event){
        FileChooser of=new FileChooser();
        of.setTitle("Abrir archivo");
        FileChooser.ExtensionFilter filtro= new FileChooser.ExtensionFilter("Archivos .abc", "*.abc");
        of.getExtensionFilters().add(filtro);
        File file=of.showOpenDialog(stage);
    }

    @Override
    public void start(Stage stage) throws Exception {
        this.stage=stage;

    }
}
