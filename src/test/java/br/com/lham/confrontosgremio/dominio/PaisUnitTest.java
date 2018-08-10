package br.com.lham.confrontosgremio.dominio;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import br.com.validadorfluente.novo2.DominioException;

public class PaisUnitTest {

  @Test
  public void deveCriarPaisComSucesso() {
    final String abreviatura = "BRA";
    final String nome = "Brasil";
    final Continente continente = Continente.AMERICA_DO_SUL;
    
    final Pais pais = new Pais(abreviatura, nome, continente);
    
    assertAll("Verificando a cria��o do objeto...",
              () -> assertThat("Verificando atribui��o da abreviatura.", pais.getAbreviatura(), equalTo(abreviatura)),
              () -> assertThat("Verificando atribui��o do nome.",        pais.getNome(),        equalTo(nome)),
              () -> assertThat("Verificando atribui��o do continente.",  pais.getContinente(),  equalTo(continente)));    
  }
  
  @Test
  public void naoDeveCriarPaisComTodosAtributosNulos() {
    final String abreviaturaNula = null;
    final String nomeNulo = null;
    final Continente continenteNulo = null;
    
    final DominioException excecao = assertThrows(DominioException.class, () -> new Pais(abreviaturaNula, nomeNulo, continenteNulo));
    assertThat("Erro de valida��o na contru��o do objeto Pa�s.", excecao.getMessage(), equalTo("Erro na constru��o do dom�nio: br.com.lham.confrontosgremio.dominio.Pais."));
    
    final int numeroErrosValidacao = 3;
    assertThat("Deve ter 3 erros de valida��o (todos campos nulos).", excecao.getErrosValidacao().size(), equalTo(numeroErrosValidacao));
    
    IllegalArgumentException erroValidacao = excecao.getErrosValidacao().get(0);
    assertThat("Mensagem de valida��o para abreviatura nula.", erroValidacao.getMessage(), equalTo("Campo Abreviatura � de preenchimento obrigat�rio."));    
    
    erroValidacao = excecao.getErrosValidacao().get(1);
    assertThat("Mensagem de valida��o para nome nulo.", erroValidacao.getMessage(), equalTo("Campo Nome � de preenchimento obrigat�rio."));
    
    erroValidacao = excecao.getErrosValidacao().get(2);
    assertThat("Mensagem de valida��o para continente nulo.", erroValidacao.getMessage(), equalTo("Campo Continente � de preenchimento obrigat�rio."));
  }
  
  /* ========== Valida��es do atributo ABREVIATURA ========== */
  
  @Test
  public void naoDeveCriarPaisComAbreviaturaNula() {
    final String abreviaturaNula = null;
    final String nome = "Brasil";
    final Continente continente = Continente.AMERICA_DO_SUL;
    
    final DominioException excecao = assertThrows(DominioException.class, () -> new Pais(abreviaturaNula, nome, continente));
    assertThat("Erro de valida��o para abreviatura nula.", excecao.getMessage(), equalTo("Erro na constru��o do dom�nio: br.com.lham.confrontosgremio.dominio.Pais."));
    
    final int numeroErrosValidacao = 1;
    assertThat("Deve ter somente 1 erro de valida��o (abreviatura nula).", excecao.getErrosValidacao().size(), equalTo(numeroErrosValidacao));
    
    final IllegalArgumentException erroValidacao = excecao.getErrosValidacao().get(0);
    assertThat("Mensagem de valida��o para abreviatura nula.", erroValidacao.getMessage(), equalTo("Campo Abreviatura � de preenchimento obrigat�rio."));
  }
  
  @Test
  public void naoDeveCriarPaisComAbreviaturaVazia() {
    final String abreviaturaVazia = "";
    final String nome = "Brasil";
    final Continente continente = Continente.AMERICA_DO_SUL;
    
    final DominioException excecao = assertThrows(DominioException.class, () -> new Pais(abreviaturaVazia, nome, continente));
    assertThat("Erro de valida��o para abreviatura vazia.", excecao.getMessage(), equalTo("Erro na constru��o do dom�nio: br.com.lham.confrontosgremio.dominio.Pais."));
    
    final int numeroErrosValidacao = 1;
    assertThat("Deve ter somente 1 erro de valida��o (abreviatura vazia).", excecao.getErrosValidacao().size(), equalTo(numeroErrosValidacao));
    
    final IllegalArgumentException erroValidacao = excecao.getErrosValidacao().get(0);
    assertThat("Mensagem de valida��o para abreviatura vazia.", erroValidacao.getMessage(), equalTo("Abreviatura n�o pode ficar em branco."));
  }
  
  @Test
  public void naoDeveCriarPaisComAbreviaturaEmBranco() {
    final String abreviaturaEmBranco = "   ";
    final String nome = "Brasil";
    final Continente continente = Continente.AMERICA_DO_SUL;
    
    final DominioException excecao = assertThrows(DominioException.class, () -> new Pais(abreviaturaEmBranco, nome, continente));
    assertThat("Erro de valida��o para abreviatura vazia.", excecao.getMessage(), equalTo("Erro na constru��o do dom�nio: br.com.lham.confrontosgremio.dominio.Pais."));
    
    final int numeroErrosValidacao = 1;
    assertThat("Deve ter somente 1 erro de valida��o (abreviatura vazia).", excecao.getErrosValidacao().size(), equalTo(numeroErrosValidacao));
    
    final IllegalArgumentException erroValidacao = excecao.getErrosValidacao().get(0);
    assertThat("Mensagem de valida��o para abreviatura vazia.", erroValidacao.getMessage(), equalTo("Abreviatura n�o pode ficar em branco."));
  }
  
  @Test
  public void naoDeveCriarPaisComAbreviaturaComTamanhoMenorQueTresLetras() {
    final String abreviaturaTamanho2 = "BR";
    final String nome = "Brasil";
    final Continente continente = Continente.AMERICA_DO_SUL;
    
    final DominioException excecao = assertThrows(DominioException.class, () -> new Pais(abreviaturaTamanho2, nome, continente));
    assertThat("Erro de valida��o para abreviatura vazia.", excecao.getMessage(), equalTo("Erro na constru��o do dom�nio: br.com.lham.confrontosgremio.dominio.Pais."));
    
    final int numeroErrosValidacao = 1;
    assertThat("Deve ter somente 1 erro de valida��o (abreviatura vazia).", excecao.getErrosValidacao().size(), equalTo(numeroErrosValidacao));
    
    final IllegalArgumentException erroValidacao = excecao.getErrosValidacao().get(0);
    assertThat("Mensagem de valida��o para abreviatura vazia.", erroValidacao.getMessage(), equalTo("Abreviatura deve ter 3 letra(s)."));
  }
  
  @Test
  public void naoDeveCriarPaisComAbreviaturaComTamanhoMaiorQueTresLetras() {
    final String abreviaturaTamanho4 = "BRAa";
    final String nome = "Brasil";
    final Continente continente = Continente.AMERICA_DO_SUL;
    
    final DominioException excecao = assertThrows(DominioException.class, () -> new Pais(abreviaturaTamanho4, nome, continente));
    assertThat("Erro de valida��o para abreviatura vazia.", excecao.getMessage(), equalTo("Erro na constru��o do dom�nio: br.com.lham.confrontosgremio.dominio.Pais."));
    
    final int numeroErrosValidacao = 1;
    assertThat("Deve ter somente 1 erro de valida��o (abreviatura vazia).", excecao.getErrosValidacao().size(), equalTo(numeroErrosValidacao));
    
    final IllegalArgumentException erroValidacao = excecao.getErrosValidacao().get(0);
    assertThat("Mensagem de valida��o para abreviatura vazia.", erroValidacao.getMessage(), equalTo("Abreviatura deve ter 3 letra(s)."));
  }
  
  /* ========== Valida��es do atributo NOME ========== */
  
  @Test
  public void naoDeveCriarPaisComNomeNulo() {
    final String abreviatura = "BRA";
    final String nomeNulo = null;
    final Continente continente = Continente.AMERICA_DO_SUL;
    
    final DominioException excecao = assertThrows(DominioException.class, () -> new Pais(abreviatura, nomeNulo, continente));
    assertThat("Erro de valida��o para nome nulo.", excecao.getMessage(), equalTo("Erro na constru��o do dom�nio: br.com.lham.confrontosgremio.dominio.Pais."));
    
    final int numeroErrosValidacao = 1;
    assertThat("Deve ter somente 1 erro de valida��o (nome nulo).", excecao.getErrosValidacao().size(), equalTo(numeroErrosValidacao));
    
    final IllegalArgumentException erroValidacao = excecao.getErrosValidacao().get(0);
    assertThat("Mensagem de valida��o para nome nulo.", erroValidacao.getMessage(), equalTo("Campo Nome � de preenchimento obrigat�rio."));
  }
  
  @Test
  public void naoDeveCriarPaisComNomeVazio() {
    final String abreviatura = "BRA";
    final String nomeVazio = "";
    final Continente continente = Continente.AMERICA_DO_SUL;
    
    final DominioException excecao = assertThrows(DominioException.class, () -> new Pais(abreviatura, nomeVazio, continente));
    assertThat("Erro de valida��o para abreviatura vazia.", excecao.getMessage(), equalTo("Erro na constru��o do dom�nio: br.com.lham.confrontosgremio.dominio.Pais."));
    
    final int numeroErrosValidacao = 1;
    assertThat("Deve ter somente 1 erro de valida��o (nome vazio).", excecao.getErrosValidacao().size(), equalTo(numeroErrosValidacao));
    
    final IllegalArgumentException erroValidacao = excecao.getErrosValidacao().get(0);
    assertThat("Mensagem de valida��o para nome vazio.", erroValidacao.getMessage(), equalTo("Nome n�o pode ficar em branco."));
  }
  
  @Test
  public void naoDeveCriarPaisComNomeEmBranco() {
    final String abreviatura = "BRA";
    final String nomeEmBranco = "   ";
    final Continente continente = Continente.AMERICA_DO_SUL;
    
    final DominioException excecao = assertThrows(DominioException.class, () -> new Pais(abreviatura, nomeEmBranco, continente));
    assertThat("Erro de valida��o para nome em branco.", excecao.getMessage(), equalTo("Erro na constru��o do dom�nio: br.com.lham.confrontosgremio.dominio.Pais."));
    
    final int numeroErrosValidacao = 1;
    assertThat("Deve ter somente 1 erro de valida��o (nome em branco).", excecao.getErrosValidacao().size(), equalTo(numeroErrosValidacao));
    
    final IllegalArgumentException erroValidacao = excecao.getErrosValidacao().get(0);
    assertThat("Mensagem de valida��o para nome em branco.", erroValidacao.getMessage(), equalTo("Nome n�o pode ficar em branco."));
  }
  
  @Test
  public void naoDeveCriarPaisComNomeComTamanhoMaiorQueSessentaLetras() {
    final String abreviatura = "BRA";
    final String nomeCom61Letras = "123456789012345678901234567890123456789012345678901234567890A";
    final Continente continente = Continente.AMERICA_DO_SUL;
    
    final DominioException excecao = assertThrows(DominioException.class, () -> new Pais(abreviatura, nomeCom61Letras, continente));
    assertThat("Erro de valida��o para nome maior que 60 letras.", excecao.getMessage(), equalTo("Erro na constru��o do dom�nio: br.com.lham.confrontosgremio.dominio.Pais."));
    
    final int numeroErrosValidacao = 1;
    assertThat("Deve ter somente 1 erro de valida��o (nome maior que 60 letras).", excecao.getErrosValidacao().size(), equalTo(numeroErrosValidacao));
    
    final IllegalArgumentException erroValidacao = excecao.getErrosValidacao().get(0);
    assertThat("Mensagem de valida��o para nome maior que 60 letras.", erroValidacao.getMessage(), equalTo("Nome deve ter no m�ximo 60 letra(s)."));
  }
  
/* ========== Valida��es do atributo CONTINENTE ========== */
  
  @Test
  public void naoDeveCriarPaisComAContinenteNulo() {
    final String abreviatura = "BRA";
    final String nome = "Brasil";
    final Continente continenteNulo = null;
    
    final DominioException excecao = assertThrows(DominioException.class, () -> new Pais(abreviatura, nome, continenteNulo));
    assertThat("Erro de valida��o para abreviatura nula.", excecao.getMessage(), equalTo("Erro na constru��o do dom�nio: br.com.lham.confrontosgremio.dominio.Pais."));
    
    final int numeroErrosValidacao = 1;
    assertThat("Deve ter somente 1 erro de valida��o (continente nulo).", excecao.getErrosValidacao().size(), equalTo(numeroErrosValidacao));
    
    final IllegalArgumentException erroValidacao = excecao.getErrosValidacao().get(0);
    assertThat("Mensagem de valida��o para continente nulo.", erroValidacao.getMessage(), equalTo("Campo Continente � de preenchimento obrigat�rio."));
  }
}