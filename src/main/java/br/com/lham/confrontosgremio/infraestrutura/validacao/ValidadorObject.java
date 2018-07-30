package br.com.lham.confrontosgremio.infraestrutura.validacao;

import java.util.List;

public class ValidadorObject extends Validador {

  private ValidadorObject(final Object campoParaValidar, final String nomeDoCampoAValidar) {
    super(campoParaValidar, nomeDoCampoAValidar);
  }

  public static ValidadorObject paraCampo(final Object campoParaValidar, final String nomeDoCampoAValidar) {
    return new ValidadorObject(campoParaValidar, nomeDoCampoAValidar);
  }

  public ValidadorObject queNaoDeveSerNulo() {
    if (campo == null) {
      final String mensagemErro = String.format("Campo %s é de preenchimento obrigatório.", nomeDoCampo);
      this.errosDeValidacao.add(new ErroValidacaoException(mensagemErro));
    }

    return this;
  }

  public List<ErroValidacaoException> validar() {
    return errosDeValidacao;
  }
}
