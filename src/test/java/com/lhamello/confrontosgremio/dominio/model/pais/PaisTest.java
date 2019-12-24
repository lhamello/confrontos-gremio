package com.lhamello.confrontosgremio.dominio.model.pais;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import com.lhamello.confrontosgremio.dominio.nucleocompartilhado.excecao.CampoObrigatorioException;
import com.lhamello.confrontosgremio.dominio.nucleocompartilhado.excecao.TextoTamanhoExatoException;
import com.lhamello.confrontosgremio.dominio.nucleocompartilhado.excecao.TextoTamanhoMaximoException;

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
  @ValueSource(strings = { "A", "AB", "ABCD" })
  public void naoDeveCriarPaisComAbreviaturaComTamanhoDiferenteDe3(final String abreviatura) {
    assertThrows(TextoTamanhoExatoException.class, () -> new Pais(abreviatura, "México", Continente.AMERICA_DO_NORTE));
  }

  @ParameterizedTest
  @NullAndEmptySource
  @ValueSource(strings = { " ", "  ", "   " })
  public void naoDeveCriarPaisSemNome(final String nome) {
    assertThrows(CampoObrigatorioException.class, () -> new Pais("ING", nome, Continente.EUROPA));
  }

  @Test
  public void naoDeveCriarPaisComNomeComMaisDeCinquentaCaracateres() {
    assertThrows(TextoTamanhoMaximoException.class, () -> new Pais("RAS", "TESTEDENOMEDEPAISCOMMAISDECINQUENTACARACTERESSSSS51", Continente.AFRICA));
  }
  
  @Test
  public void naoDeveCriarPaisSemContinente() {
    assertThrows(CampoObrigatorioException.class, () -> new Pais("JAP", null, Continente.ASIA));
  }
}
