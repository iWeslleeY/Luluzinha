/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package luluzinha;

import java.sql.Time;
import java.util.Date;

/**
 *
 * @author F0127063
 */
public class ListaEvento {
    String nome, vagas, justificativa,prioridade, status, responsavel;
    String endereco, gerente, coordenador;
    Date dt_inicio;
    Date dt_fim;
    Time hora_inicio, hora_fim;

    public ListaEvento(String nome, String vagas, String justificativa,String prioridade, String status, String responsavel, String endereco, String gerente, String coordenador, Date dt_inicio, Date dt_fim, Time hora_inicio, Time hora_fim) {
        this.nome = nome;
        this.vagas = vagas;
        this.justificativa = justificativa;
        this.prioridade = prioridade;
        this.status = status;
        this.responsavel = responsavel;
        this.endereco = endereco;
        this.gerente = gerente;
        this.coordenador = coordenador;
        this.dt_inicio = dt_inicio;
        this.dt_fim = dt_fim;
        this.hora_inicio = hora_inicio;
        this.hora_fim = hora_fim;
    }
    
    
    public String getJustificativa() {
        return justificativa;
    }

    public void setJustificativa(String justificativa) {
        this.justificativa = justificativa;
    }
//
    public String getVagas() {
        return vagas;
    }

    public void setVagas(String vagas) {
        this.vagas = vagas;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getGerente() {
        return gerente;
    }

    public void setGerente(String gerente) {
        this.gerente = gerente;
    }

    public String getCoordenador() {
        return coordenador;
    }

    public void setCoordenador(String coordenador) {
        this.coordenador = coordenador;
    }

    public String getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(String prioridade) {
        this.prioridade = prioridade;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }
//
    public Time getHora_inicio() {
        return hora_inicio;
    }

    public void setHora_inicio(Time hora_inicio) {
        this.hora_inicio = hora_inicio;
    }

    public Time getHora_fim() {
        return hora_fim;
    }

    public void setHora_termino(Time hora_fim) {
        this.hora_fim = hora_fim;
    }

    public Date getDt_inicio() {
        return dt_inicio;
    }

    public void setDt_inicio(Date dt_inicio) {
        this.dt_inicio = dt_inicio;
    }

    public Date getDt_fim() {
        return dt_fim;
    }

    public void setDt_fim(Date dt_fim) {
        this.dt_fim = dt_fim;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
}
