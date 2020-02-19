package luluzinha;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import java.net.URL;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;

/**
 * Classe Controladora do FXMLs
 * 
 *
 * @author Wesley Araujo
 */
public class InicioPaginaController implements Initializable {
    
    @FXML
    private Label clAno1;

    @FXML
    private Label clDiaSemana1;

    @FXML
    private Label clDia1;

    @FXML
    private Label clMes1;
    
    
    @FXML
    private Label clAno;

    @FXML
    private Label clDiaSemana;

    @FXML
    private Label clDia;

    @FXML
    private Label clMes;
    
    @FXML
    private JFXDatePicker Calendario;
    
    @FXML
    private JFXButton btnDemandas;

    @FXML
    private JFXButton btnAnotacoes;
    
    @FXML
    private JFXButton btnAgenda;
    
    @FXML
    private JFXButton btnSobre;

    @FXML
    private AnchorPane apDemandas;

    @FXML
    private AnchorPane apAnotacoes;
    @FXML
    private AnchorPane apAgenda;

    @FXML
    private AnchorPane apSobre;
    
    
    @FXML
    public void handleButtonAction(MouseEvent event) {
        if(event.getTarget() == btnDemandas){
            apDemandas.setVisible(true);
            apAnotacoes.setVisible(false);
            apAgenda.setVisible(false);
            apSobre.setVisible(false);
        } else if(event.getTarget()==btnAnotacoes){
            apDemandas.setVisible(false);
            apAnotacoes.setVisible(true);
            apAgenda.setVisible(false);
            apSobre.setVisible(false);
        } else if(event.getTarget()== btnAgenda){
            apDemandas.setVisible(false);
            apAnotacoes.setVisible(false);
            apAgenda.setVisible(true);
            apSobre.setVisible(false);
        } else if(event.getTarget()==btnSobre){
            apDemandas.setVisible(false);
            apAnotacoes.setVisible(false);
            apAgenda.setVisible(false);
            apSobre.setVisible(true);
        }
    }
    
    @FXML
    void showDate(ActionEvent event) {
        LocalDate ld = Calendario.getValue();
        clDiaSemana.setText(ld.getDayOfWeek().getDisplayName(TextStyle.FULL, new Locale("pt","BR")));
        clDia.setText(Integer.toString(ld.getDayOfMonth()));
        clAno.setText(Integer.toString(ld.getYear()));
        clMes.setText(ld.getMonth().getDisplayName(TextStyle.FULL, new Locale("pt","BR")));
        clDiaSemana.setVisible(true);
        clDia.setVisible(true);
        clAno.setVisible(true);
        clMes.setVisible(true);
        
        DayOfWeek teste = ld.getDayOfWeek().SUNDAY;
        
        clDiaSemana1.setText(ld.getDayOfWeek().getDisplayName(TextStyle.FULL, new Locale("pt","BR")));
        clDia1.setText(Integer.toString(ld.getDayOfMonth()));
        clAno1.setText(Integer.toString(ld.getYear()));
        clMes1.setText(ld.getMonth().getDisplayName(TextStyle.FULL, new Locale("pt","BR")));
        clDiaSemana1.setVisible(true);
        clDia1.setVisible(true);
        clAno1.setVisible(true);
        clMes1.setVisible(true);
        
//        if(clDiaSemana.setText(ld.getDayOfWeek().SATURDAY) || clDiaSemana.setText(ld.getDayOfWeek().SUNDAY)){
//            clDia.setTextFill(Color.RED);
//        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
}
