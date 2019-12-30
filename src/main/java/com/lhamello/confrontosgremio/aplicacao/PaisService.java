package com.lhamello.confrontosgremio.aplicacao;

import com.lhamello.confrontosgremio.dominio.model.pais.Continente;
import com.lhamello.confrontosgremio.dominio.model.pais.Pais;

public interface PaisService {

  Pais cadastrarPais(final String abreviatura, final String nome, final Continente continente);
}
