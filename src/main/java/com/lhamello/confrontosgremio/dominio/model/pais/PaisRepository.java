package com.lhamello.confrontosgremio.dominio.model.pais;

public interface PaisRepository {

  abstract Pais salvar(final Pais pais);

  abstract boolean isPaisJaCadastrado(String abreviaturaPais, String nomePais);
}
