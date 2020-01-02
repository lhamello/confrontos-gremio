package com.lhamello.confrontosgremio.dominio.model.pais;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.lhamello.confrontosgremio.dominio.model.ObjetoDominio;
import com.lhamello.confrontosgremio.dominio.nucleocompartilhado.validacao.Objeto;
import com.lhamello.confrontosgremio.dominio.nucleocompartilhado.validacao.Textual;
import com.lhamello.confrontosgremio.dominio.nucleocompartilhado.validacao.Validador;

@Entity
@Table(name = "PAIS")
public final class Pais extends ObjetoDominio {

  private static final long serialVersionUID = -7854522165781724508L;
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

  Pais(final String abreviatura, final String nome, final Continente continente) {
    super();
    this.abreviatura = abreviatura;
    this.nome = nome;
    this.continente = continente;
    this.validar();
  }

  private void validar() {
    errosValidacao.addAll(
        Validador.paraObjetoDominio()
                 .comValidacoes(Textual.paraAtributo(abreviatura, "Abreviatura")
                                       .queDeveEstarPreenchido()
                                       .queDeveTerTamanhoExato(TAMANHO_ABREVIATURA))
                 .comValidacoes(Textual.paraAtributo(nome, "Nome")
                                       .queDeveEstarPreenchido()
                                       .queDeveTerTamanhoMaximo(TAMANHO_MAXIMO_NOME))
                 .comValidacoes(Objeto.paraAtributo(continente, "Continente")
                                       .queNaoDeveSerNulo())
                 .validar());
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

  @Override
  public String toString() {
    return String.format("%s (%s)", nome, abreviatura);
  }
}
