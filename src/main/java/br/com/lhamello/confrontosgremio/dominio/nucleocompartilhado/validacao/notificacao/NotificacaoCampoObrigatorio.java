package br.com.lhamello.confrontosgremio.dominio.nucleocompartilhado.validacao.notificacao;

import br.com.lhamello.confrontosgremio.dominio.nucleocompartilhado.util.ProvedorMensagem;

public final class NotificacaoCampoObrigatorio implements Notificacao {

  private NotificacaoCampoObrigatorio() {
    super();
  }

  public static NotificacaoCampoObrigatorio criar() {
    return new NotificacaoCampoObrigatorio();
  }

  public String getMensagem(final String nomeCampo) {
    return ProvedorMensagem.getMensagem("erro.validacao.campoObrigatorio", nomeCampo);
  }

  @Override
  public String toString() {
    return "Notificação de Campo Obrigatório";
  }
}
