package br.com.lham.confrontosgremio.infraestrutura;

import java.util.List;

import br.com.lham.confrontosgremio.infraestrutura.validacao.ErroValidacaoException;

public class DominioException extends RuntimeException {

  private static final long serialVersionUID = 1L;
  private List<ErroValidacaoException> errosValidacao;

  public DominioException(final List<ErroValidacaoException> errosValidacao) {
    super("Erro na construção do domínio.");
    this.errosValidacao = errosValidacao;
  }

  public List<ErroValidacaoException> getErrosValidacao() {
    return errosValidacao;
  }
}
