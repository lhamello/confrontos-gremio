package br.com.lham.confrontosgremio.dominio;

import java.util.List;

import br.com.lham.confrontosgremio.infraestrutura.DominioException;
import br.com.lham.confrontosgremio.infraestrutura.validacao.ErroValidacaoException;

public class PaisInvalidoException extends DominioException {

  private static final long serialVersionUID = 1L;
  
  public PaisInvalidoException(final List<ErroValidacaoException> errosValidacao) {
    super(errosValidacao);
  }
}
