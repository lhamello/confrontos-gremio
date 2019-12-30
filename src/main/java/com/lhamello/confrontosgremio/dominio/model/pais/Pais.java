package com.lhamello.confrontosgremio.dominio.model.pais;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.lhamello.confrontosgremio.dominio.nucleocompartilhado.util.Validacao;

@Entity
@Table(name = "PAIS")
public final class Pais implements Serializable {

  private static final long serialVersionUID = -6845251864563975124L;
  private static final int TAMANHO_ABREVIATURA = 3;
  private static final int TAMANHO_MAXIMO_NOME = 50;
  @Id
  @Column
  @GeneratedValue(generator = "Pais_SEQ", strategy = GenerationType.SEQUENCE)
  @SequenceGenerator(allocationSize = 1, name = "Pais_SEQ", sequenceName = "ID_PAIS_SEQ")
  private Short id;
  @Column
  private String abreviatura;
  @Column
  private String nome;
  @Column
  private Continente continente;
  @Transient
  private Validacao validacao;

  Pais(final String abreviatura, final String nome, final Continente continente) {
    this.validacao = new Validacao();
    this.abreviatura = validarAbreviatura(abreviatura, "Abreviatura", TAMANHO_ABREVIATURA);
    this.nome = validarNome(nome, "Nome", TAMANHO_MAXIMO_NOME);
    this.continente = validarContinente(continente, "Continente");
  }

  private String validarAbreviatura(final String abreviatura, final String nomeCampo, final int tamanhoExatoCampo) {
    validacao.campoObrigatorio(abreviatura, nomeCampo);
    validacao.campoComTamanhoExato(tamanhoExatoCampo, abreviatura, nomeCampo);
    return abreviatura;
  }

  private String validarNome(final String nome, final String nomeCampo, final int tamanhoMaximoCampo) {
    validacao.campoObrigatorio(nome, nomeCampo);
    validacao.campoComTamanhoMaximo(tamanhoMaximoCampo, nome, nomeCampo);
    return nome;
  }

  private Continente validarContinente(final Continente continente, final String nomeCampo) {
    validacao.campoObrigatorio(continente, nomeCampo);
    return continente;
  }

  public String getAbreviatura() {
    return abreviatura;
  }

  public String getNome() {
    return nome;
  }

  public Continente getContinente() {
    return continente;
  }

  List<Exception> getErrosValidacao() {
    return validacao.getErrosValidacao();
  }

  @Override
  public String toString() {
    return String.format("%s (%s)", nome, abreviatura);
  }
}
