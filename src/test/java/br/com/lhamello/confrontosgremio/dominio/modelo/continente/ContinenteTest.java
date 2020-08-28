package br.com.lhamello.confrontosgremio.dominio.modelo.continente;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import br.com.lhamello.confrontosgremio.domain.model.continent.Continent;

public class ContinenteTest {

  private final String ABREVIATURA = "AMS";
  private final String NOME = "América do Sul";
  private final String CAMINHO_IMAGEM = "http://www.lhamello.confrontosgremio.com.br/continentes/america-do-sul.png";

  @Test
  public void testDeveCriarContinente() {
    final Continent continente = new Continent(ABREVIATURA, NOME, CAMINHO_IMAGEM);
    final List<RuntimeException> errosValidacao = continente.getErrosValidacao();
    final boolean esperado = errosValidacao.isEmpty();
    
    assertAll(
        () -> assertTrue(esperado),
        () -> assertEquals(ABREVIATURA, continente.getAbreviatura()),
        () -> assertEquals(NOME, continente.getNome()),
        () -> assertEquals(CAMINHO_IMAGEM, continente.getCaminhoImagem()));
  }

  @Test
  public void testNaoDeveCriarContinenteComTodosCamposNulos() {
    final Continent continente = new Continent(null, null, null);
    final List<RuntimeException> errosValidacao = continente.getErrosValidacao();
    final int numeroErros = errosValidacao.size();

    assertAll(
        () -> assertEquals(3, numeroErros), 
        () -> assertEquals("Informe a abreviatura.", errosValidacao.get(0).getMessage()),
        () -> assertEquals("Informe o nome.", errosValidacao.get(1).getMessage()),
        () -> assertEquals("Informe a imagem.", errosValidacao.get(2).getMessage()));
  }
  
  @ParameterizedTest
  @NullAndEmptySource
  @ValueSource(strings = { " ", "  ", "   " })
  public void testNaoDeveCriarContinenteSemAbreviatura(final String abreviatura) {
    final Continent continente = new Continent(abreviatura, NOME, CAMINHO_IMAGEM);
    final List<RuntimeException> errosValidacao = continente.getErrosValidacao();
    final int numeroErros = errosValidacao.size();
   
    assertAll(
        () -> assertEquals(1, numeroErros), 
        () -> assertEquals("Informe a abreviatura.", errosValidacao.get(0).getMessage()));
  }
  
  @ParameterizedTest
  @ValueSource(strings = {"A", "AB", "ABCD"})
  public void testNaoDeveCriarContinenteComAbreviaturaComTamanhoDiferenteDe3Caracteres(final String abreviatura) {
    final Continent continente = new Continent(abreviatura, NOME, CAMINHO_IMAGEM);
    final List<RuntimeException> errosValidacao = continente.getErrosValidacao();
    final int numeroErros = errosValidacao.size();
   
    assertAll(
        () -> assertEquals(1, numeroErros), 
        () -> assertEquals("Abreviatura deve ter 3 caracteres.", errosValidacao.get(0).getMessage()));
  }
  
  @ParameterizedTest
  @NullAndEmptySource
  @ValueSource(strings = { " ", "  ", "   " })
  public void testNaoDeveCriarContinenteSemNome(final String nome) {
    final Continent continente = new Continent(ABREVIATURA, nome, CAMINHO_IMAGEM);
    final List<RuntimeException> errosValidacao = continente.getErrosValidacao();
    final int numeroErros = errosValidacao.size();
   
    assertAll(
        () -> assertEquals(1, numeroErros), 
        () -> assertEquals("Informe o nome.", errosValidacao.get(0).getMessage()));
  }
  
  @Test
  public void testNaoDeveCriarContinenteComNomeComTamanhoMaiorQue16Caracteres() {
    final Continent continente = new Continent(ABREVIATURA, "TESTE DE NOME MAIOR QUE 16 CARACTERES", CAMINHO_IMAGEM);
    final List<RuntimeException> errosValidacao = continente.getErrosValidacao();
    final int numeroErros = errosValidacao.size();
   
    assertAll(
        () -> assertEquals(1, numeroErros), 
        () -> assertEquals("Nome deve ter no máximo 16 caracteres.", errosValidacao.get(0).getMessage()));
  }
  
  @ParameterizedTest
  @NullAndEmptySource
  @ValueSource(strings = { " ", "  ", "   " })
  public void testNaoDeveCriarContinenteSemImagem(final String caminhoImagem) {
    final Continent continente = new Continent(ABREVIATURA, NOME, caminhoImagem);
    final List<RuntimeException> errosValidacao = continente.getErrosValidacao();
    final int numeroErros = errosValidacao.size();
   
    assertAll(
        () -> assertEquals(1, numeroErros), 
        () -> assertEquals("Informe a imagem.", errosValidacao.get(0).getMessage()));
  }
  
  @ParameterizedTest
  @ValueSource(strings = { "www.teste.com/image.gif", "www.teste.com/image.bmp", "www.teste.com/image.pdf" })
  public void testNaoDeveCriarContinenteComImagemComFormatoNaoSuportado(final String caminhoImagem) {
    final Continent continente = new Continent(ABREVIATURA, NOME, caminhoImagem);
    final List<RuntimeException> errosValidacao = continente.getErrosValidacao();
    final int numeroErros = errosValidacao.size();
   
    assertAll(
        () -> assertEquals(1, numeroErros), 
        () -> assertEquals("Imagem deve ser em formato jpg ou png.", errosValidacao.get(0).getMessage()));
  }
  
  @Test
  public void testToString() {
    final Continent continente = new Continent(ABREVIATURA, NOME, CAMINHO_IMAGEM);
    final String esperado = String.format("[%s=%s,%s=%s,%s=%s]", "abreviatura", ABREVIATURA, "nome", NOME, "caminhoImagem", CAMINHO_IMAGEM);
    
    assertEquals(esperado, continente.toString());
  }
}
