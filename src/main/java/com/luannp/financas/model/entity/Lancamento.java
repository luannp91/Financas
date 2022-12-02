/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.luannp.financas.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;

/**
 *
 * @author estudo
 */
@Entity
@Table(name = "lancamento", schema = "financas")
public class Lancamento {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    
    @Column(name = "descricao")
    private String descricao;
    
    @Column(name = "mes")
    private Integer mes;
    
    @Column(name = "ano")
    private Integer ano;
    
    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;
    
    @Column(name = "valor")
    private BigDecimal valor;
    
    @Column(name = "data_cadastro")
    @Convert(converter = Jsr310JpaConverters.LocalDateConverter.class)
    private LocalDate dataCadastro;
    
    @Column(name = "tipo")
    @Enumerated(value = EnumType.STRING)
    private TipoLancamento tipo;
    
    @Column(name = "status")
    @Enumerated(value = EnumType.STRING)
    private StatusLancamento status; 

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getMes() {
        return mes;
    }

    public void setMes(Integer mes) {
        this.mes = mes;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public LocalDate getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDate dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public TipoLancamento getTipo() {
        return tipo;
    }

    public void setTipo(TipoLancamento tipo) {
        this.tipo = tipo;
    }

    public StatusLancamento getStatus() {
        return status;
    }

    public void setStatus(StatusLancamento status) {
        this.status = status;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + Objects.hashCode(this.id);
        hash = 37 * hash + Objects.hashCode(this.descricao);
        hash = 37 * hash + Objects.hashCode(this.mes);
        hash = 37 * hash + Objects.hashCode(this.ano);
        hash = 37 * hash + Objects.hashCode(this.usuario);
        hash = 37 * hash + Objects.hashCode(this.valor);
        hash = 37 * hash + Objects.hashCode(this.dataCadastro);
        hash = 37 * hash + Objects.hashCode(this.tipo);
        hash = 37 * hash + Objects.hashCode(this.status);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Lancamento other = (Lancamento) obj;
        if (!Objects.equals(this.descricao, other.descricao)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.mes, other.mes)) {
            return false;
        }
        if (!Objects.equals(this.ano, other.ano)) {
            return false;
        }
        if (!Objects.equals(this.usuario, other.usuario)) {
            return false;
        }
        if (!Objects.equals(this.valor, other.valor)) {
            return false;
        }
        if (!Objects.equals(this.dataCadastro, other.dataCadastro)) {
            return false;
        }
        if (this.tipo != other.tipo) {
            return false;
        }
        return this.status == other.status;
    }

    @Override
    public String toString() {
        return "Lancamento{" + "id=" + id + ", descricao=" + descricao + ", mes=" + mes + ", ano=" + ano + ", usuario=" + usuario + ", valor=" + valor + ", dataCadastro=" + dataCadastro + ", tipo=" + tipo + ", status=" + status + '}';
    }
}
