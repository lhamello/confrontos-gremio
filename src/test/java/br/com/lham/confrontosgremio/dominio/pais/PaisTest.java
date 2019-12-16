package br.com.lham.confrontosgremio.dominio.pais;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import br.com.lham.confrontosgremio.dominio.continente.Continente;
import br.com.lham.confrontosgremio.nucleo.excecao.CampoObrigatorioException;

public class PaisTest {

  @Test
  public void deveCriarPais() {
    assertDoesNotThrow(() -> new Pais("BRA", "Brasil", Continente.AMERICA_DO_SUL));
  }

  @ParameterizedTest
  @NullAndEmptySource
  @ValueSource(strings = { " ", "  ", "   " })
  public void naoDeveCriarPaisSemAbreviatura(final String abreviatura) {
    assertThrows(CampoObrigatorioException.class, () -> new Pais(abreviatura, "Argentina", Continente.AMERICA_DO_SUL));
  }
  
  @ParameterizedTest
  @NullAndEmptySource
  @ValueSource(strings = { " ", "  ", "   " })
  public void naoDeveCriarPaisSemNome(final String nome) {
    assertThrows(CampoObrigatorioException.class, () -> new Pais("ING", nome, Continente.EUROPA));
  }
  
  @Test
  public void naoDeveCriarPaisSemContinente() {
    assertThrows(CampoObrigatorioException.class, () -> new Pais("JAP", null, Continente.ASIA));
  }
}
