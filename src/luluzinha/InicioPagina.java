package luluzinha;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class InicioPagina extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("InicioPagina.fxml"));
        Scene scene = new Scene(root);
        
        Image iconePorto = new Image("luluzinha/Imagens/download.png");
        
        stage.getIcons().add(iconePorto);
        stage.setTitle("Demandas de Curso");
        stage.setScene(scene);
        stage.setResizable(false);
        scene.setFill(javafx.scene.paint.Color.TRANSPARENT);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
