/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package luluzinha;

import java.util.Date;

/**
 *
 * @author F0127063
 */
public class ListaAnotacao {
    String nm_demanda, anotacao, responsavel, situacao;
    Date dt_anotacao;

    @Override
    public String toString() {
        return "ListaAnotacao{" + "dt_anotacao=" + dt_anotacao + '}';
    }

    public ListaAnotacao(String nm_demanda, Date dt_anotacao, String anotacao, String responsavel, String situacao) {
        this.nm_demanda = nm_demanda;
        this.anotacao = anotacao;
        this.responsavel = responsavel;
       this.dt_anotacao = dt_anotacao;
       this.situacao = situacao;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public ListaAnotacao(String nm_demanda, Date dt_anotacao, String anotacao, String responsavel) {
        this.nm_demanda = nm_demanda;
        this.anotacao = anotacao;
        this.responsavel = responsavel;
        this.dt_anotacao = dt_anotacao;
    }

    public String getNm_demanda() {
        return nm_demanda;
    }

    public void setNm_demanda(String nm_demanda) {
        this.nm_demanda = nm_demanda;
    }

    public String getAnotacao() {
        return anotacao;
    }

    public void setAnotacao(String anotacao) {
        this.anotacao = anotacao;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }

    public Date getDt_anotacao() {
        return dt_anotacao;
    }

    public void setDt_anotacao(Date dt_anotacao) {
        this.dt_anotacao = dt_anotacao;
    }
    
}
