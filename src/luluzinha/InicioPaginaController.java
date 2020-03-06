package luluzinha;


import LuluzinhaDao.Dao;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTimePicker;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
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
    private DatePicker dtInicio;

    @FXML
    private DatePicker dtFim;

    @FXML
    private JFXTimePicker hrInicio;

    @FXML
    private JFXTimePicker hrFinal;

    @FXML
    private TextField txtNumVagas;

    @FXML
    private TextField txtCoordenador;

    @FXML
    private TextArea txtObservacao;
    
    @FXML
    private TextField txtDemanda;

    @FXML
    private TextField txtSolicitante;

    @FXML
    private TextField txtLocal;

    @FXML
    private TextField txtCentroCusto;

    @FXML
    private TextField txtGerente;

    @FXML
    private ComboBox<String> cbResponsavel;
    
    private final ObservableList<String> obResponsavel = FXCollections.observableArrayList("Ana","Luana");
    
    @FXML
    private JFXTimePicker tmHoraAnotacoes;

    @FXML
    private JFXDatePicker dtDataAnotacoes;
    
    @FXML
    private ComboBox<?> cbEvento;
    
    @FXML
    private TextArea txtAnotacoes;
    
    @FXML
    private AnchorPane apInicio;
    
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
    private Label lblConcluido;
    
    Connection con;
    PreparedStatement stmt;
    ResultSet rs;
    
    @FXML
    public void handleButtonAction(MouseEvent event) {
        if(event.getTarget() == btnDemandas){
            apInicio.setVisible(false);
            apDemandas.setVisible(true);
            apAnotacoes.setVisible(false);
            apAgenda.setVisible(false);
            apSobre.setVisible(false);
        } else if(event.getTarget()==btnAnotacoes){
            apInicio.setVisible(false);
            apDemandas.setVisible(false);
            apAnotacoes.setVisible(true);
            apAgenda.setVisible(false);
            apSobre.setVisible(false);
        } else if(event.getTarget()== btnAgenda){
            apInicio.setVisible(false);
            apDemandas.setVisible(false);
            apAnotacoes.setVisible(false);
            apAgenda.setVisible(true);
            apSobre.setVisible(false);
        } else if(event.getTarget()==btnSobre){
            apInicio.setVisible(false);
            apDemandas.setVisible(false);
            apAnotacoes.setVisible(false);
            apAgenda.setVisible(false);
            apSobre.setVisible(true);
        }
    }
    
    @FXML
    void retornarHome(MouseEvent event) {
        apInicio.setVisible(true);
            apDemandas.setVisible(false);
            apAnotacoes.setVisible(false);
            apAgenda.setVisible(false);
            apSobre.setVisible(false);
    }
      
    @FXML
    void limparAnotacoes(MouseEvent event) {
        txtAnotacoes.clear();
        cbEvento.setValue(null);
        dtDataAnotacoes.setValue(null);
        tmHoraAnotacoes.setValue(null);
        cbResponsavel.setValue(null);
    }
    
    @FXML
    void limparDemandas(ActionEvent event) {
        txtDemanda.clear();
        txtLocal.clear();
        txtCentroCusto.clear();
        txtGerente.clear();
        txtNumVagas.clear();
        txtCoordenador.clear();
        dtInicio.setValue(null);
        dtFim.setValue(null);
        hrInicio.setValue(null);
        hrFinal.setValue(null);
        txtObservacao.clear();
        txtSolicitante.clear();
        lblConcluido.setVisible(false);
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
        
        clDiaSemana1.setText(ld.getDayOfWeek().getDisplayName(TextStyle.FULL, new Locale("pt","BR")));
        clDia1.setText(Integer.toString(ld.getDayOfMonth()));
        clAno1.setText(Integer.toString(ld.getYear()));
        clMes1.setText(ld.getMonth().getDisplayName(TextStyle.FULL, new Locale("pt","BR")));
        clDiaSemana1.setVisible(true);
        clDia1.setVisible(true);
        clAno1.setVisible(true);
        clMes1.setVisible(true);
        
        if(ld.getDayOfWeek() == ld.getDayOfWeek().SUNDAY || ld.getDayOfWeek() == ld.getDayOfWeek().SATURDAY){
            clDia.setTextFill(Color.RED);
            clDia1.setTextFill(Color.RED);
        } else{
            clDia.setTextFill(Color.BLACK);
            clDia1.setTextFill(Color.BLACK);
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cbResponsavel.setItems(obResponsavel);
        Constraints.setTextFieldDouble(txtCentroCusto);
        Constraints.setTextFieldDouble(txtNumVagas);
        Constraints.setTextFieldMaxLength(txtNumVagas, 4);
        dtInicio.setValue(LocalDate.now());
        dtFim.setValue(LocalDate.now());
    }    
    
    public InicioPaginaController() {
        con = Dao.conDB();
    }
    
    @FXML
    void salvarAnotacoes(ActionEvent event) throws SQLException, ClassNotFoundException, NullPointerException {
        try{
        Dao dao = new Dao();
        Connection cn = Dao.conDB();
        

        String nome = txtDemanda.getText();
        String dataFim = String.valueOf(dtFim.getValue().toString());
        String vagas = txtNumVagas.getText();
        String justificativa =txtObservacao.getText();
        String local = txtLocal.getText();
        String gerente = txtGerente.getText();
        String coordenador = txtCoordenador.getText();
        String solicitante = txtSolicitante.getText();
        String dataInicio = String.valueOf(dtInicio.getValue().toString());
        
        stmt =cn.prepareStatement("INSERT INTO treinamento (nome,vagas, "
                + "justificativa, responsavel, endereco,dt_inicio,dt_fim,coordenador, gerente) "
                + "VALUES(?,?,?,?,?,?,?,?,?)");
        stmt.setString(1, nome);
        stmt.setString(2, vagas);
        stmt.setString(3, justificativa);
        stmt.setString(4, solicitante);
        stmt.setString(5, local);
        stmt.setString(6, dataInicio);
        stmt.setString(7, dataFim);
        stmt.setString(8, coordenador);
        stmt.setString(9, gerente);
        
        if(justificativa.equals("") || nome.equals("") || local.equals("") || solicitante.equals("")){
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("CAMPO NULO");
            alerta.setHeaderText("Campo não pode ser Nulo!");
            alerta.setContentText("Um ou mais campos obrigatório não foram preenchidos!");
            alerta.show();
            txtDemanda.requestFocus();
        } else{
           stmt.executeUpdate();
           lblConcluido.setVisible(true);
        }        
        
        } catch(SQLException e){
          throw e;
        }
    }
}
