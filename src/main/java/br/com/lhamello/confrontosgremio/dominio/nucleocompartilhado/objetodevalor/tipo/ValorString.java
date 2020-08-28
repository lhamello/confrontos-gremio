package br.com.lhamello.confrontosgremio.dominio.nucleocompartilhado.objetodevalor.tipo;

import java.util.Objects;
import java.util.Optional;

import br.com.lhamello.confrontosgremio.dominio.nucleocompartilhado.validacao.notificacao.Notificacao;
import br.com.lhamello.confrontosgremio.dominio.nucleocompartilhado.validacao.notificacao.NotificacaoCampoObrigatorio;
import br.com.lhamello.confrontosgremio.dominio.nucleocompartilhado.validacao.notificacao.NotificacaoTamanhoExato;

public class ValorString extends Tipo<String> {

  private final String valor;

  private ValorString(final String valor) {
    this.valor = valor;
  }

  public static ValorString criar(final String valor) {
    return new ValorString(valor);
  }

  @Override
  public String getValor() {
    return valor;
  }

  public Optional<Notificacao> notificarSeNuloOuBranco() {
    return this.isNuloOuBranco() ? Optional.of(NotificacaoCampoObrigatorio.criar()) : Optional.empty();
  }

  public Optional<Notificacao> notificarSeTamanhoDiferenteDe(final int tamanhoExato) {
    return this.isNuloOuBranco() || valor.length() != tamanhoExato ? Optional.of(NotificacaoTamanhoExato.criar()) : Optional.empty();
  }

  private boolean isNuloOuBranco() {
    return (Objects.isNull(valor) || valor.isBlank());
  }
}
