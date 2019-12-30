package com.lhamello.confrontosgremio.aplicacao.impl;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.lhamello.confrontosgremio.aplicacao.PaisService;
import com.lhamello.confrontosgremio.dominio.model.pais.Pais;
import com.lhamello.confrontosgremio.dominio.model.pais.PaisFactory;
import com.lhamello.confrontosgremio.dominio.model.pais.PaisRepository;

@Stateless
public class PaisServiceImplPadrao implements PaisService {

  @Inject
  private PaisFactory fabrica;
  @Inject
  private PaisRepository repositorio;

  private PaisServiceImplPadrao() {
  }

  @Override
  public Pais cadastrarPais(final String abreviaturaPais, final String nomePais, final String abreviaturaContinente) {
    Pais novoPais = fabrica.criarPais(abreviaturaPais, nomePais, abreviaturaContinente);
    return repositorio.salvar(novoPais);
  }
}
