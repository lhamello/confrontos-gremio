package br.com.lham.confrontosgremio.infraestrutura.validacao;

import java.util.List;

public class ValidadorString extends Validador {
  
  private String campoParaValidar;
  
  private ValidadorString(final String campoParaValidar, final String nomeDoCampoAValidar) {
    super(campoParaValidar, nomeDoCampoAValidar);
    this.campoParaValidar = campoParaValidar;
  }

  public static ValidadorString paraCampo(final String campoParaValidar, final String nomeDoCampoAValidar) {
    return new ValidadorString(campoParaValidar, nomeDoCampoAValidar);
  }

  public ValidadorString queNaoDeveSerNulo() {
    if (campo == null) {
      final String mensagemErro = String.format("Campo %s é de preenchimento obrigatório.", nomeDoCampo);
      this.errosDeValidacao.add(new ErroValidacaoException(mensagemErro));
    }

    return this;
  }
  
  public ValidadorString queNaoDeveSerVazio() {
    if (campo == null) {
      return this;
    }
    
    if (campoParaValidar.trim().isEmpty()) {
      final String mensagemErro = String.format("%s não pode ficar em branco.", nomeDoCampo);
      this.errosDeValidacao.add(new ErroValidacaoException(mensagemErro));
    }
    
    return this;
  }
  
  public ValidadorString queDeveTerTamanhoIgualA(final int tamanho) {
    if (campo == null || campoParaValidar.trim().isEmpty()) {
      return this;
    }
    
    if (campoParaValidar.length() != tamanho) {
      this.errosDeValidacao.add(new ErroValidacaoException(String.format("%s deve ter %s letra(s).", nomeDoCampo, tamanho)));
    }
    
    return this;
  }
  
  public ValidadorString queDeveTerTamanhoMenorOuIgualQue(final int tamanhoMaximo) {
    if (campo == null || campoParaValidar.trim().isEmpty()) {
      return this;
    }
    
    if (campoParaValidar.length() > tamanhoMaximo) {
      this.errosDeValidacao.add(new ErroValidacaoException(String.format("%s deve ter no máximo %s letra(s).", nomeDoCampo, tamanhoMaximo)));
    }
    
    return this; 
  }
  
  public List<ErroValidacaoException> validar() {
    return errosDeValidacao;
  }
}