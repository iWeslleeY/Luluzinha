package luluzinha;

import LuluzinhaDao.Dao;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTimePicker;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.net.URL;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.TextStyle;
import java.util.Locale;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
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
    
    @FXML private TextField txtSeteMeia;
    
    @FXML private TextField txtSeteMeia1;
    
    @FXML private TableView<ListaAnotacao> tlb_anotacao;

    @FXML private TableColumn<ListaAnotacao, String> cln_nome_demanda;

    @FXML private TableColumn<ListaAnotacao, Date> cln_dt_anotacao;

    @FXML private TableColumn<ListaAnotacao, String> cln_anotacao;

    @FXML private TableColumn<ListaAnotacao, String> cln_responsavel_demanda;

    @FXML private TableColumn<ListaAnotacao, String> cln_status_demanda;
    
    @FXML private TableView<ListaEvento> tbl_demanda;

    @FXML private TableColumn<ListaEvento, String> cln_nome;

    @FXML private TableColumn<ListaEvento, String> cln_vagas;

    @FXML private TableColumn<ListaEvento, Time> cln_horaInicio;

    @FXML private TableColumn<ListaEvento, Time> cln_horaTermino;

    @FXML private TableColumn<ListaEvento, String> cln_justificativa;

    @FXML private TableColumn<ListaEvento, String> cln_prioridade;

    @FXML private TableColumn<ListaEvento, String> cln_status;

    @FXML private TableColumn<ListaEvento, String> cln_responsavel;

    @FXML private TableColumn<ListaEvento, String> cln_endereco;

    @FXML private TableColumn<ListaEvento, Date> cln_dataInicio;

    @FXML private TableColumn<ListaEvento, Date> cln_dataFim;

    @FXML private TableColumn<ListaEvento, String> cln_coordenador;

    @FXML private TableColumn<ListaEvento, String> cln_gerente;
    
    @FXML private ComboBox<String> cbPrioridade;

    @FXML private DatePicker dtInicio;

    @FXML private DatePicker dtFim;

    @FXML private JFXTimePicker hrInicio;

    @FXML private JFXTimePicker hrFinal;

    @FXML private TextField txtNumVagas;

    @FXML private TextField txtCoordenador;

    @FXML private TextArea txtObservacao;

    @FXML private TextField txtDemanda;

    @FXML private TextField txtSolicitante;

    @FXML private TextField txtLocal;

    @FXML private TextField txtCentroCusto;

    @FXML private TextField txtGerente;

    @FXML private ComboBox<String> cbResponsavel;

    @FXML private ComboBox<String> cbSituacao;

    private final ObservableList<String> obEvento = FXCollections.observableArrayList();
    private final ObservableList<String> obResponsavel = FXCollections.observableArrayList("Ana", "Luana");
    private final ObservableList<String> obPrioridade = FXCollections.observableArrayList("Baixa", "Media", "Alta");
    private final ObservableList<String> obSituacao = FXCollections.observableArrayList("Para Fazer", "Feito", "Cancelado");
    private final ObservableList<ListaEvento> obListaEvento = FXCollections.observableArrayList();
    private final ObservableList<ListaAnotacao> obListaAnotacao = FXCollections.observableArrayList();
    
    @FXML private JFXDatePicker dtDataAnotacoes;

    @FXML private ComboBox<String> cbEvento;

    @FXML private TextArea txtAnotacoes;

    @FXML private AnchorPane apInicio;

    @FXML private Label clAno1;

    @FXML private Label clDiaSemana1;

    @FXML private Label clDia1;

    @FXML private Label clMes1;

    @FXML private Label clAno;

    @FXML private Label clDiaSemana;

    @FXML private Label clDia;

    @FXML private Label clMes;

    @FXML private JFXDatePicker Calendario;

    @FXML private JFXButton btnDemandas;

    @FXML private JFXButton btnAnotacoes;

    @FXML private JFXButton btnAgenda;

    @FXML private JFXButton btnBuscar;

    @FXML private AnchorPane apDemandas;

    @FXML private AnchorPane apAnotacoes;

    @FXML private AnchorPane apAgenda;

    @FXML private AnchorPane apBuscar;

    @FXML private Label lblConcluido;

    @FXML private Label lblConcluido1;
    @FXML private TextField txtBuscar;
    
    Connection con;
    PreparedStatement stmt;
    ResultSet rs;

    @FXML
    public void carregarDemandas() {
        try {
            String sql = "SELECT id,nome from demandas";
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            if (obEvento.isEmpty()) {
                while (rs.next()) {
                    obEvento.addAll(rs.getString("nome"));
                }
            }

        } catch (SQLException ex) {
        }
    }
    
    @FXML
    public void carregarAnotacao(){
        try {
            Connection cn = Dao.conDB();
            rs = cn.createStatement().executeQuery("select * from atividades");

            while (rs.next()) {
                obListaAnotacao.addAll(new ListaAnotacao(rs.getString("nm_demanda")
                        ,rs.getDate("dt_anotacao"), 
                     rs.getString("anotacao"), rs.getString("responsavel"), rs.getString("situacao")));
            }
            
        } catch (SQLException e) {

        }
        cln_nome_demanda.setCellValueFactory(new PropertyValueFactory<>("nm_demanda"));
        cln_dt_anotacao.setCellValueFactory(new PropertyValueFactory<>("dt_anotacao"));
        cln_anotacao.setCellValueFactory(new PropertyValueFactory<>("anotacao"));
        cln_responsavel_demanda.setCellValueFactory(new PropertyValueFactory<>("responsavel"));
        cln_status_demanda.setCellValueFactory(new PropertyValueFactory<>("situacao"));
        
        tlb_anotacao.setItems(obListaAnotacao);
        
        FilteredList<ListaAnotacao> filteredAnotacao = new FilteredList<>(obListaAnotacao, b -> true);
        
        txtBuscar.textProperty().addListener((observable, oldValue, newValue)->{
            filteredAnotacao.setPredicate(listaAnotacao -> {
								
				if (newValue == null || newValue.isEmpty()) {
					return true;
				}
				
				String lowerCaseFilter = newValue.toLowerCase();
				
				if (listaAnotacao.getNm_demanda().toLowerCase().indexOf(lowerCaseFilter) != -1 ) {
					return true; 
				} else if (listaAnotacao.getAnotacao().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true; 
				}  else if (listaAnotacao.getResponsavel().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true; 
				} 
				else if (String.valueOf(listaAnotacao.getDt_anotacao()).indexOf(lowerCaseFilter)!=-1)
				     return true;
				     else  
				    	 return false; 
			});
		});
		
		SortedList<ListaAnotacao> sortedData = new SortedList<>(filteredAnotacao);
		
		sortedData.comparatorProperty().bind(tlb_anotacao.comparatorProperty());
		
		tlb_anotacao.setItems(sortedData);
               }
    
    @FXML
    public void carregarDemanda() {
        try {
            Connection cn = Dao.conDB();
            rs = cn.createStatement().executeQuery("SELECT * FROM demandas");

            while (rs.next()) {
                obListaEvento.addAll(new ListaEvento(rs.getString("nome"), 
                        rs.getString("vagas"),
                        rs.getString("justificativa"),
                        rs.getString("prioridade"),
                        rs.getString("status"),
                        rs.getString("responsavel"),
                        rs.getString("endereco"),
                        rs.getString("gerente"),
                        rs.getString("coordenador"),
                        rs.getDate("dt_inicio"),                        
                        rs.getDate("dt_fim"),
                        rs.getTime("hora_inicio"),
                        rs.getTime("hora_fim"))); 
           }

        } catch (SQLException e) {

        }
        cln_nome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        cln_vagas.setCellValueFactory(new PropertyValueFactory<>("vagas"));
        cln_justificativa.setCellValueFactory(new PropertyValueFactory<>("justificativa"));
        cln_prioridade.setCellValueFactory(new PropertyValueFactory<>("prioridade"));;
        cln_status.setCellValueFactory(new PropertyValueFactory<>("status"));
        cln_responsavel.setCellValueFactory(new PropertyValueFactory<>("responsavel"));
        cln_endereco.setCellValueFactory(new PropertyValueFactory<>("endereco"));
        cln_dataInicio.setCellValueFactory(new PropertyValueFactory<>("dt_inicio"));
        cln_dataFim.setCellValueFactory(new PropertyValueFactory<>("dt_fim"));
        cln_horaInicio.setCellValueFactory(new PropertyValueFactory<>("hora_inicio"));
        cln_horaTermino.setCellValueFactory(new PropertyValueFactory<>("hora_fim"));
        cln_coordenador.setCellValueFactory(new PropertyValueFactory<>("coordenador"));
        cln_gerente.setCellValueFactory(new PropertyValueFactory<>("gerente"));
        
        tbl_demanda.setItems(obListaEvento);
    
        FilteredList<ListaEvento> filteredEvento = new FilteredList<>(obListaEvento, b -> true);
        
        txtBuscar.textProperty().addListener((observable, oldValue, newValue)->{
            filteredEvento.setPredicate(listaEvento -> {
								
				if (newValue == null || newValue.isEmpty()) {
					return true;
				}
				
				String lowerCaseFilter = newValue.toLowerCase();
				
				if (listaEvento.getNome().toLowerCase().indexOf(lowerCaseFilter) != -1 ) {
					return true; 
				} else if (listaEvento.getResponsavel().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true; 
				}  else if (listaEvento.getStatus().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true; 
				} else if (listaEvento.getPrioridade().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true; 
				} else if (listaEvento.getCoordenador().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true; 
				} else if (listaEvento.getGerente().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true; 
				} else if (listaEvento.getJustificativa().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true; 
				} else if (listaEvento.getEndereco().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true; 
				}
                                else if (String.valueOf(listaEvento.getVagas()).indexOf(lowerCaseFilter)!=-1)
				     return true;
				else if (String.valueOf(listaEvento.getDt_inicio()).indexOf(lowerCaseFilter)!=-1)
				     return true;
                               else if (String.valueOf(listaEvento.getDt_fim()).indexOf(lowerCaseFilter)!=-1)
				     return true;
                               else if (String.valueOf(listaEvento.getHora_fim()).indexOf(lowerCaseFilter)!=-1)
				     return true;
                               else if (String.valueOf(listaEvento.getHora_inicio()).indexOf(lowerCaseFilter)!=-1)
				     return true;
                               
				     else  
				    	 return false; 
			});
		});
		
		SortedList<ListaEvento> sortedEvento = new SortedList<>(filteredEvento);
		
		sortedEvento.comparatorProperty().bind(tbl_demanda.comparatorProperty());
		
		tbl_demanda.setItems(sortedEvento);
    }

    @FXML
    public void handleButtonAction(MouseEvent event) {
        if (event.getTarget() == btnDemandas) {
            apInicio.setVisible(false);
            apDemandas.setVisible(true);
            apAnotacoes.setVisible(false);
            apAgenda.setVisible(false);
            apBuscar.setVisible(false);
        } else if (event.getTarget() == btnAnotacoes) {
            apInicio.setVisible(false);
            apDemandas.setVisible(false);
            apAnotacoes.setVisible(true);
            apAgenda.setVisible(false);
            apBuscar.setVisible(false);
        } else if (event.getTarget() == btnAgenda) {
            apInicio.setVisible(false);
            apDemandas.setVisible(false);
            apAnotacoes.setVisible(false);
            apAgenda.setVisible(true);
            apBuscar.setVisible(false);
        } else if (event.getTarget() == btnBuscar) {
            apInicio.setVisible(false);
            apDemandas.setVisible(false);
            apAnotacoes.setVisible(false);
            apAgenda.setVisible(false);
            apBuscar.setVisible(true);
        }
    }

    @FXML
    void retornarHome(MouseEvent event) {
        apInicio.setVisible(true);
        apDemandas.setVisible(false);
        apAnotacoes.setVisible(false);
        apAgenda.setVisible(false);
        apBuscar.setVisible(false);
    }

    @FXML
    void limparAnotacoes(MouseEvent event) {
        txtAnotacoes.clear();
        cbEvento.setValue(null);
        dtDataAnotacoes.setValue(null);
        cbResponsavel.setValue(null);
        lblConcluido1.setVisible(false);
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
        lblConcluido1.setVisible(false);
    }

    @FXML
    void showDate(ActionEvent event) {
        LocalDate ld = Calendario.getValue();
        clDiaSemana.setText(ld.getDayOfWeek().getDisplayName(TextStyle.FULL, new Locale("pt", "BR")));
        clDia.setText(Integer.toString(ld.getDayOfMonth()));
        clAno.setText(Integer.toString(ld.getYear()));
        clMes.setText(ld.getMonth().getDisplayName(TextStyle.FULL, new Locale("pt", "BR")));
        clDiaSemana.setVisible(true);
        clDia.setVisible(true);
        clAno.setVisible(true);
        clMes.setVisible(true);

        clDiaSemana1.setText(ld.getDayOfWeek().getDisplayName(TextStyle.FULL, new Locale("pt", "BR")));
        clDia1.setText(Integer.toString(ld.getDayOfMonth()));
        clAno1.setText(Integer.toString(ld.getYear()));
        clMes1.setText(ld.getMonth().getDisplayName(TextStyle.FULL, new Locale("pt", "BR")));
        clDiaSemana1.setVisible(true);
        clDia1.setVisible(true);
        clAno1.setVisible(true);
        clMes1.setVisible(true);

        if (ld.getDayOfWeek() == ld.getDayOfWeek().SUNDAY || ld.getDayOfWeek() == ld.getDayOfWeek().SATURDAY) {
            clDia.setTextFill(Color.RED);
            clDia1.setTextFill(Color.RED);
        } else {
            clDia.setTextFill(Color.BLACK);
            clDia1.setTextFill(Color.BLACK);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        carregarAnotacao();
        carregarDemanda();
        carregarDemandas();
        cbSituacao.setItems(obSituacao);
        cbEvento.setItems(obEvento);
        cbResponsavel.setItems(obResponsavel);
        cbPrioridade.setItems(obPrioridade);
        cbSituacao.getSelectionModel().selectFirst();
        cbPrioridade.getSelectionModel().selectFirst();
        Constraints.setTextFieldDouble(txtCentroCusto);
        Constraints.setTextFieldDouble(txtNumVagas);
        Constraints.setTextFieldMaxLength(txtNumVagas, 4);
    }

    public InicioPaginaController() {
        con = Dao.conDB();
    }

    @FXML
    void salvarAnotacoes(ActionEvent event) throws SQLException {
        try {
            Connection cn = Dao.conDB();

            if (dtDataAnotacoes.getValue() == null) {
                dtDataAnotacoes.setValue(LocalDate.now());
            }
            Date data = Date.valueOf(dtDataAnotacoes.getValue());

            stmt = cn.prepareStatement("INSERT INTO atividades (nm_demanda,dt_anotacao,"
                    + "anotacao,responsavel, situacao) "
                    + "VALUES(?,?,?,?,?)");
            

            stmt.setString(1,cbEvento.getValue());
            stmt.setDate(2, data);
            stmt.setString(3, txtAnotacoes.getText());
            stmt.setString(4, cbResponsavel.getValue());
            stmt.setString(5, cbSituacao.getValue());
            
            if (cbEvento.getValue() == null || cbResponsavel.getValue() == null
                    || txtAnotacoes.getText() == null || data == null || cbSituacao.getValue() == null) {
                Alert anotacoes = new Alert(Alert.AlertType.ERROR);
                anotacoes.setTitle("Valores nulos");
                anotacoes.setContentText("Um ou mais valores estão nulos!");
                anotacoes.show();
                stmt.cancel();
            } else {
                stmt.executeUpdate();
                lblConcluido1.setVisible(true);
            }
        } catch (SQLException ex) {
            throw ex;
        }
    }

    @FXML
    void salvarDemandas(ActionEvent event) throws SQLException, ClassNotFoundException {
        try {
            Connection cn = Dao.conDB();

            String nome = txtDemanda.getText();
            if (txtNumVagas.getText().isEmpty()) {
                txtNumVagas.setText("0");
            }
            int vagas = Integer.valueOf(txtNumVagas.getText());
            String justificativa = txtObservacao.getText();
            String local = txtLocal.getText();
            String gerente = txtGerente.getText();
            String coordenador = txtCoordenador.getText();
            String solicitante = txtSolicitante.getText();
            if (dtInicio.getValue() == null) {
                dtInicio.setValue(LocalDate.now());
            }
            Date dataInicio = Date.valueOf(dtInicio.getValue());
            if (dtFim.getValue() == null) {
                dtFim.setValue(LocalDate.now());
            }
            Date dataFim = Date.valueOf(dtFim.getValue());
            if (hrInicio.getValue() == null) {
                hrInicio.setValue(LocalTime.now());
            }
            Time hora_inicio = Time.valueOf(hrInicio.getValue());
            if (hrFinal.getValue() == null) {
                hrFinal.setValue(LocalTime.now());
            }
            Time hora_fim = Time.valueOf(hrFinal.getValue());
            String status = "Em andamento";
            stmt = cn.prepareStatement("INSERT INTO demandas (nome,vagas, "
                    + "justificativa,prioridade, status, responsavel, endereco,dt_inicio,"
                    + "dt_fim,hora_inicio, hora_fim,coordenador, gerente) "
                    + "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)");
            stmt.setString(1, nome);
            stmt.setInt(2, vagas);
            stmt.setString(3, justificativa);
            stmt.setString(4, cbPrioridade.getSelectionModel().getSelectedItem());
            stmt.setString(5, status);
            stmt.setString(6, solicitante);
            stmt.setString(7, local);
            stmt.setDate(8, dataInicio);
            stmt.setDate(9, dataFim);
            stmt.setTime(10, hora_inicio);
            stmt.setTime(11, hora_fim);
            stmt.setString(12, coordenador);
            stmt.setString(13, gerente);

            if (dataFim.before(dataInicio)) {
                Alert data = new Alert(Alert.AlertType.ERROR);
                data.setTitle("Periodo menor");
                data.setHeaderText("Ajustar Data");
                data.setContentText("A data não pode ser negativa!");
                data.show();
                stmt.cancel();
            } else if (justificativa.equals("") || nome.equals("") || local.equals("") || solicitante.equals("")) {
                Alert alerta = new Alert(Alert.AlertType.ERROR);
                alerta.setTitle("CAMPO NULO");
                alerta.setHeaderText("Campo não pode ser Nulo!");
                alerta.setContentText("Um ou mais campos obrigatório não foram preenchidos!");
                alerta.show();
                stmt.cancel();
                if (nome.equals("")) {
                    txtDemanda.requestFocus();
                } else if (solicitante.equals("")) {
                    txtSolicitante.requestFocus();
                } else if (local.equals("")) {
                    txtLocal.requestFocus();
                } else if (justificativa.equals("")) {
                    txtObservacao.requestFocus();
                }
            } else {
                stmt.executeUpdate();
                lblConcluido.setVisible(true);
            }

        } catch (SQLException e) {
            throw e;
        }

    }
}