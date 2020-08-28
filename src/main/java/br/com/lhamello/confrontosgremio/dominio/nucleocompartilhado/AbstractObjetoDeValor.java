package br.com.lhamello.confrontosgremio.dominio.nucleocompartilhado;

import java.io.Serializable;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import br.com.lhamello.confrontosgremio.dominio.nucleocompartilhado.objetodevalor.tipo.Tipo;
import br.com.lhamello.confrontosgremio.dominio.nucleocompartilhado.validacao.notificacao.Notificacao;

public abstract class AbstractObjetoDeValor<T extends Tipo<?>> implements Serializable {

  private static final long serialVersionUID = 5851025724438644999L;
  private final List<Notificacao> notificacoes;
  protected final T valor;

  public AbstractObjetoDeValor(final T valor) {
    this.valor = valor;
    this.notificacoes = new LinkedList<>();
  }

  protected abstract void validar();

  protected void adicionarNotificacoesPresentes(final List<Optional<Notificacao>> notificacoes) {
    notificacoes.forEach(notificacao -> {

      if (notificacao.isPresent()) {
        this.notificacoes.add(notificacao.get());
      }
    });
  }

  public List<Notificacao> getNotificacoes() {
    return Collections.unmodifiableList(notificacoes);
  }
}
