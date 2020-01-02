package com.lhamello.confrontosgremio.aplicacao.impl;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.lhamello.confrontosgremio.aplicacao.AplicacaoException;
import com.lhamello.confrontosgremio.aplicacao.PaisService;
import com.lhamello.confrontosgremio.dominio.model.pais.Pais;
import com.lhamello.confrontosgremio.dominio.model.pais.PaisFactory;
import com.lhamello.confrontosgremio.dominio.model.pais.PaisRepository;
import com.lhamello.confrontosgremio.dominio.nucleocompartilhado.excecao.DominioException;

@Stateless
public class PaisServiceImplPadrao implements PaisService {

  @Inject
  private PaisFactory fabrica;
  @Inject
  private PaisRepository repositorio;

  private PaisServiceImplPadrao() {
  }

  @Override
  public Pais cadastrarPais(final String abreviaturaPais, final String nomePais, final String abreviaturaContinente) throws AplicacaoException {
    Pais novoPais;
    
    try {
      novoPais = fabrica.criarPais(abreviaturaPais, nomePais, abreviaturaContinente);
    } catch (DominioException excecao) {
      throw new AplicacaoException(excecao);
    }
    
    return repositorio.salvar(novoPais);
  }
}
