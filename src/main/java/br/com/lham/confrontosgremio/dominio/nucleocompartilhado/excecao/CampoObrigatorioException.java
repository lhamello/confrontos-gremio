package br.com.lham.confrontosgremio.dominio.nucleocompartilhado.excecao;

public class CampoObrigatorioException extends Exception {

  private static final long serialVersionUID = 1L;

  public CampoObrigatorioException(final String nomeCampo) {
    super(String.format("Informe o campo %s.", nomeCampo));
  }
}
