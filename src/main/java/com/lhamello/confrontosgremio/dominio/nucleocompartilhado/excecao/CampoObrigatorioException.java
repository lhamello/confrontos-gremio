package com.lhamello.confrontosgremio.dominio.nucleocompartilhado.excecao;

@SuppressWarnings("serial")
public class CampoObrigatorioException extends RuntimeException {

  public CampoObrigatorioException(final String nomeCampo) {
    super(String.format("Informe o campo %s.", nomeCampo));
  }
}
