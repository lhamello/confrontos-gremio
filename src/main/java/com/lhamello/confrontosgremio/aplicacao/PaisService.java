package com.lhamello.confrontosgremio.aplicacao;

import com.lhamello.confrontosgremio.dominio.model.pais.Pais;

public interface PaisService {

  abstract Pais cadastrarPais(final String abreviaturaPais, final String nomePais, final String abreviaturaContinente) throws AplicacaoException;
}
