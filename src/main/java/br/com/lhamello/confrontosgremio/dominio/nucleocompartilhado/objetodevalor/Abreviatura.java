package br.com.lhamello.confrontosgremio.dominio.nucleocompartilhado.objetodevalor;

import java.util.List;
import java.util.Optional;

import br.com.lhamello.confrontosgremio.dominio.nucleocompartilhado.AbstractObjetoDeValor;
import br.com.lhamello.confrontosgremio.dominio.nucleocompartilhado.objetodevalor.tipo.ValorString;
import br.com.lhamello.confrontosgremio.dominio.nucleocompartilhado.validacao.notificacao.Notificacao;

public class Abreviatura extends AbstractObjetoDeValor<ValorString> {

  private static final long serialVersionUID = 7216159243115405707L;
  private static final int TAMANHO_EXATO = 3;
  
  private Abreviatura(final ValorString valor) {
    super(valor);
    this.validar();
  }

  public static Abreviatura criar(final String valor) {
    final ValorString valorString = ValorString.criar(valor);
    return new Abreviatura(valorString);
  }

  @Override
  protected void validar() {
    final List<Optional<Notificacao>> notificacoesValidacao = List.of(
        super.valor.notificarSeNuloOuBranco(),
        super.valor.notificarSeTamanhoDiferenteDe(TAMANHO_EXATO));
    
    super.adicionarNotificacoesPresentes(notificacoesValidacao);
  }
}
