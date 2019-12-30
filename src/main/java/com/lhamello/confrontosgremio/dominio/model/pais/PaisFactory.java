package com.lhamello.confrontosgremio.dominio.model.pais;

import java.util.List;
import java.util.Optional;

import javax.inject.Inject;

import com.lhamello.confrontosgremio.dominio.nucleocompartilhado.excecao.ErroDominioException;

public class PaisFactory {

  @Inject
  private List<Exception> errosValidacao;
  @Inject
  private PaisRepository repositorio;

  public Pais criarPais(final String abreviaturaPais, final String nomePais, final String abreviaturaContinente) {
    Continente continente = this.encontrarContinente(abreviaturaContinente);
    Pais novoPais = new Pais(abreviaturaPais, nomePais, continente);

    this.adicionarErrosValidacaoExistentes(novoPais);
    this.verificarSeNovoPaisJaExiste(abreviaturaPais, nomePais);

    if (!errosValidacao.isEmpty()) {
      throw new ErroDominioException(errosValidacao);
    }

    return novoPais;
  }

  private Continente encontrarContinente(final String abreviaturaContinente) {
    Optional<Continente> optional = Continente.getInstancia(abreviaturaContinente);

    if (optional.isEmpty()) {
      errosValidacao.add(new RuntimeException("Continente não encontrado.")); // TODO: trocar exceção
    }

    return optional.get();
  }

  private void adicionarErrosValidacaoExistentes(final Pais novoPais) {
    errosValidacao.addAll(novoPais.getErrosValidacao());
  }

  private void verificarSeNovoPaisJaExiste(final String abreviaturaPais, final String nomePais) {
    if (repositorio.isPaisJaCadastrado(abreviaturaPais, nomePais)) {
      errosValidacao.add(new RuntimeException("País já existente.")); // TODO: trocar exceção
    }
  }
}
