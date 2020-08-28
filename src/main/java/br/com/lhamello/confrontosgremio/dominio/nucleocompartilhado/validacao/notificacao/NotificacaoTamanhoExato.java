package br.com.lhamello.confrontosgremio.dominio.nucleocompartilhado.validacao.notificacao;

import br.com.lhamello.confrontosgremio.dominio.nucleocompartilhado.util.ProvedorMensagem;

public class NotificacaoTamanhoExato implements Notificacao {

  private NotificacaoTamanhoExato() {
    super();
  }

  public static NotificacaoTamanhoExato criar() {
    return new NotificacaoTamanhoExato();
  }

  public String getMensagem(final String nomeCampo, final int tamanhoExato) {
    if (tamanhoExato < 1) {
      throw new IllegalArgumentException(ProvedorMensagem.getMensagem("erro.validacao.tamanhoExato.invalido"));
    }

    final String caracterOuCaracteres = (tamanhoExato == 1) ? "caracter" : "caracteres";
    return ProvedorMensagem.getMensagem("erro.validacao.tamanhoExato", nomeCampo, tamanhoExato, caracterOuCaracteres);
  }

  @Override
  public String toString() {
    return "Notificação de Tamanho Exato";
  }
}
