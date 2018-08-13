package br.com.lham.confrontosgremio.dominio;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import br.com.validadorfluente.novo3.DominioException;
import br.com.validadorfluente.novo3.ErroValidacaoException;

public class PaisUnitTest {

  @Test
  public void deveCriarPaisComSucesso() {
    final String abreviatura = "BRA";
    final String nome = "Brasil";
    final Continente continente = Continente.AMERICA_DO_SUL;
    
    final Pais pais = new Pais(abreviatura, nome, continente);
    
    assertAll("Verificando a criação do objeto...",
              () -> assertThat("Verificando atribuição da abreviatura.", pais.getAbreviatura(), equalTo(abreviatura)),
              () -> assertThat("Verificando atribuição do nome.",        pais.getNome(),        equalTo(nome)),
              () -> assertThat("Verificando atribuição do continente.",  pais.getContinente(),  equalTo(continente)));    
  }
  
  @Test
  public void naoDeveCriarPaisComTodosAtributosNulos() {
    final String abreviaturaNula = null;
    final String nomeNulo = null;
    final Continente continenteNulo = null;
    
    final DominioException excecao = assertThrows(DominioException.class, () -> new Pais(abreviaturaNula, nomeNulo, continenteNulo));
    assertThat("Erro de validação na construção do domínio País.", excecao.getMessage(), equalTo("Erro na construção do domínio: br.com.lham.confrontosgremio.dominio.Pais."));
    
    final int numeroErrosValidacao = 3;
    assertThat("Deve ter 3 erros de validação (todos campos nulos).", excecao.getErrosValidacao().size(), equalTo(numeroErrosValidacao));
    
    ErroValidacaoException erroValidacao = excecao.getErrosValidacao().get(0);
    assertThat("Mensagem de validação para abreviatura nula.", erroValidacao.getMessage(), equalTo("Abreviatura é de preenchimento obrigatório."));    
    
    erroValidacao = excecao.getErrosValidacao().get(1);
    assertThat("Mensagem de validação para nome nulo.", erroValidacao.getMessage(), equalTo("Nome é de preenchimento obrigatório."));
    
    erroValidacao = excecao.getErrosValidacao().get(2);
    assertThat("Mensagem de validação para continente nulo.", erroValidacao.getMessage(), equalTo("Continente é de preenchimento obrigatório."));
  }
  
  /* ========== Validações do atributo ABREVIATURA ========== */
  
  @Test
  public void naoDeveCriarPaisComAbreviaturaNula() {
    final String abreviaturaNula = null;
    final String nome = "Brasil";
    final Continente continente = Continente.AMERICA_DO_SUL;
    
    final DominioException excecao = assertThrows(DominioException.class, () -> new Pais(abreviaturaNula, nome, continente));
    assertThat("Erro de validação para abreviatura nula.", excecao.getMessage(), equalTo("Erro na construção do domínio: br.com.lham.confrontosgremio.dominio.Pais."));
    
    final int numeroErrosValidacao = 1;
    assertThat("Deve ter somente 1 erro de validação (abreviatura nula).", excecao.getErrosValidacao().size(), equalTo(numeroErrosValidacao));
    
    final ErroValidacaoException erroValidacao = excecao.getErrosValidacao().get(0);
    assertThat("Mensagem de validação para abreviatura nula.", erroValidacao.getMessage(), equalTo("Abreviatura é de preenchimento obrigatório."));
  }
  
  @Test
  public void naoDeveCriarPaisComAbreviaturaVazia() {
    final String abreviaturaVazia = "";
    final String nome = "Brasil";
    final Continente continente = Continente.AMERICA_DO_SUL;
    
    final DominioException excecao = assertThrows(DominioException.class, () -> new Pais(abreviaturaVazia, nome, continente));
    assertThat("Erro de validação para abreviatura vazia.", excecao.getMessage(), equalTo("Erro na construção do domínio: br.com.lham.confrontosgremio.dominio.Pais."));
    
    final int numeroErrosValidacao = 1;
    assertThat("Deve ter somente 1 erro de validação (abreviatura vazia).", excecao.getErrosValidacao().size(), equalTo(numeroErrosValidacao));
    
    final ErroValidacaoException erroValidacao = excecao.getErrosValidacao().get(0);
    assertThat("Mensagem de validação para abreviatura vazia.", erroValidacao.getMessage(), equalTo("Abreviatura não pode ficar em branco."));
  }
  
  @Test
  public void naoDeveCriarPaisComAbreviaturaEmBranco() {
    final String abreviaturaEmBranco = "   ";
    final String nome = "Brasil";
    final Continente continente = Continente.AMERICA_DO_SUL;
    
    final DominioException excecao = assertThrows(DominioException.class, () -> new Pais(abreviaturaEmBranco, nome, continente));
    assertThat("Erro de validação para abreviatura vazia.", excecao.getMessage(), equalTo("Erro na construção do domínio: br.com.lham.confrontosgremio.dominio.Pais."));
    
    final int numeroErrosValidacao = 1;
    assertThat("Deve ter somente 1 erro de validação (abreviatura vazia).", excecao.getErrosValidacao().size(), equalTo(numeroErrosValidacao));
    
    final ErroValidacaoException erroValidacao = excecao.getErrosValidacao().get(0);
    assertThat("Mensagem de validação para abreviatura vazia.", erroValidacao.getMessage(), equalTo("Abreviatura não pode ficar em branco."));
  }
  
  @Test
  public void naoDeveCriarPaisComAbreviaturaComTamanhoMenorQueTresLetras() {
    final String abreviaturaTamanho2 = "BR";
    final String nome = "Brasil";
    final Continente continente = Continente.AMERICA_DO_SUL;
    
    final DominioException excecao = assertThrows(DominioException.class, () -> new Pais(abreviaturaTamanho2, nome, continente));
    assertThat("Erro de validação para abreviatura vazia.", excecao.getMessage(), equalTo("Erro na construção do domínio: br.com.lham.confrontosgremio.dominio.Pais."));
    
    final int numeroErrosValidacao = 1;
    assertThat("Deve ter somente 1 erro de validação (abreviatura vazia).", excecao.getErrosValidacao().size(), equalTo(numeroErrosValidacao));
    
    final ErroValidacaoException erroValidacao = excecao.getErrosValidacao().get(0);
    assertThat("Mensagem de validação para abreviatura vazia.", erroValidacao.getMessage(), equalTo("Abreviatura deve ter 3 caracter(es)."));
  }
  
  @Test
  public void naoDeveCriarPaisComAbreviaturaComTamanhoMaiorQueTresLetras() {
    final String abreviaturaTamanho4 = "BRAa";
    final String nome = "Brasil";
    final Continente continente = Continente.AMERICA_DO_SUL;
    
    final DominioException excecao = assertThrows(DominioException.class, () -> new Pais(abreviaturaTamanho4, nome, continente));
    assertThat("Erro de validação para abreviatura vazia.", excecao.getMessage(), equalTo("Erro na construção do domínio: br.com.lham.confrontosgremio.dominio.Pais."));
    
    final int numeroErrosValidacao = 1;
    assertThat("Deve ter somente 1 erro de validação (abreviatura vazia).", excecao.getErrosValidacao().size(), equalTo(numeroErrosValidacao));
    
    final ErroValidacaoException erroValidacao = excecao.getErrosValidacao().get(0);
    assertThat("Mensagem de validação para abreviatura vazia.", erroValidacao.getMessage(), equalTo("Abreviatura deve ter 3 caracter(es)."));
  }
  
  /* ========== Validações do atributo NOME ========== */
  
  @Test
  public void naoDeveCriarPaisComNomeNulo() {
    final String abreviatura = "BRA";
    final String nomeNulo = null;
    final Continente continente = Continente.AMERICA_DO_SUL;
    
    final DominioException excecao = assertThrows(DominioException.class, () -> new Pais(abreviatura, nomeNulo, continente));
    assertThat("Erro de validação para nome nulo.", excecao.getMessage(), equalTo("Erro na construção do domínio: br.com.lham.confrontosgremio.dominio.Pais."));
    
    final int numeroErrosValidacao = 1;
    assertThat("Deve ter somente 1 erro de validação (nome nulo).", excecao.getErrosValidacao().size(), equalTo(numeroErrosValidacao));
    
    final ErroValidacaoException erroValidacao = excecao.getErrosValidacao().get(0);
    assertThat("Mensagem de validação para nome nulo.", erroValidacao.getMessage(), equalTo("Nome é de preenchimento obrigatório."));
  }
  
  @Test
  public void naoDeveCriarPaisComNomeVazio() {
    final String abreviatura = "BRA";
    final String nomeVazio = "";
    final Continente continente = Continente.AMERICA_DO_SUL;
    
    final DominioException excecao = assertThrows(DominioException.class, () -> new Pais(abreviatura, nomeVazio, continente));
    assertThat("Erro de validação para abreviatura vazia.", excecao.getMessage(), equalTo("Erro na construção do domínio: br.com.lham.confrontosgremio.dominio.Pais."));
    
    final int numeroErrosValidacao = 1;
    assertThat("Deve ter somente 1 erro de validação (nome vazio).", excecao.getErrosValidacao().size(), equalTo(numeroErrosValidacao));
    
    final ErroValidacaoException erroValidacao = excecao.getErrosValidacao().get(0);
    assertThat("Mensagem de validação para nome vazio.", erroValidacao.getMessage(), equalTo("Nome não pode ficar em branco."));
  }
  
  @Test
  public void naoDeveCriarPaisComNomeEmBranco() {
    final String abreviatura = "BRA";
    final String nomeEmBranco = "   ";
    final Continente continente = Continente.AMERICA_DO_SUL;
    
    final DominioException excecao = assertThrows(DominioException.class, () -> new Pais(abreviatura, nomeEmBranco, continente));
    assertThat("Erro de validação para nome em branco.", excecao.getMessage(), equalTo("Erro na construção do domínio: br.com.lham.confrontosgremio.dominio.Pais."));
    
    final int numeroErrosValidacao = 1;
    assertThat("Deve ter somente 1 erro de validação (nome em branco).", excecao.getErrosValidacao().size(), equalTo(numeroErrosValidacao));
    
    final ErroValidacaoException erroValidacao = excecao.getErrosValidacao().get(0);
    assertThat("Mensagem de validação para nome em branco.", erroValidacao.getMessage(), equalTo("Nome não pode ficar em branco."));
  }
  
  @Test
  public void naoDeveCriarPaisComNomeComTamanhoMaiorQueSessentaLetras() {
    final String abreviatura = "BRA";
    final String nomeCom61Letras = "123456789012345678901234567890123456789012345678901234567890A";
    final Continente continente = Continente.AMERICA_DO_SUL;
    
    final DominioException excecao = assertThrows(DominioException.class, () -> new Pais(abreviatura, nomeCom61Letras, continente));
    assertThat("Erro de validação para nome maior que 60 letras.", excecao.getMessage(), equalTo("Erro na construção do domínio: br.com.lham.confrontosgremio.dominio.Pais."));
    
    final int numeroErrosValidacao = 1;
    assertThat("Deve ter somente 1 erro de validação (nome maior que 60 letras).", excecao.getErrosValidacao().size(), equalTo(numeroErrosValidacao));
    
    final ErroValidacaoException erroValidacao = excecao.getErrosValidacao().get(0);
    assertThat("Mensagem de validação para nome maior que 60 letras.", erroValidacao.getMessage(), equalTo("Nome deve ter no máximo 60 caracter(es)."));
  }
  
///* ========== Validações do atributo CONTINENTE ========== */
  
  @Test
  public void naoDeveCriarPaisComAContinenteNulo() {
    final String abreviatura = "BRA";
    final String nome = "Brasil";
    final Continente continenteNulo = null;
    
    final DominioException excecao = assertThrows(DominioException.class, () -> new Pais(abreviatura, nome, continenteNulo));
    assertThat("Erro de validação para abreviatura nula.", excecao.getMessage(), equalTo("Erro na construção do domínio: br.com.lham.confrontosgremio.dominio.Pais."));
    
    final int numeroErrosValidacao = 1;
    assertThat("Deve ter somente 1 erro de validação (continente nulo).", excecao.getErrosValidacao().size(), equalTo(numeroErrosValidacao));
    
    final ErroValidacaoException erroValidacao = excecao.getErrosValidacao().get(0);
    assertThat("Mensagem de validação para continente nulo.", erroValidacao.getMessage(), equalTo("Continente é de preenchimento obrigatório."));
  }
}