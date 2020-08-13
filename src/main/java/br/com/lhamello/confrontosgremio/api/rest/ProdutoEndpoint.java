package br.com.lhamello.confrontosgremio.api.rest;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/api/v1/produtos")
@Api(value = "Teste")
@CrossOrigin(origins = "*")
public class ProdutoEndpoint {

  @PostMapping
  public Produto incluir(@RequestBody Produto produto) {
    return new Produto();
  }

  @PutMapping("/{id}")
  public Produto editar(@PathVariable(value = "id") Long id, @RequestBody Produto produto) {
    return new Produto();
  }

  @DeleteMapping("/{id}")
  public void deletar(@PathVariable(value = "id") Long id) {
  }

  @GetMapping("/{id}")
  public Produto obter(@PathVariable(value = "id") Long id) {
    return new Produto();
  }

  @GetMapping
  public List<Produto> listar() {
    return new ArrayList<Produto>();
  }

  class Produto {
    private Long id;
    private String nome;
    private BigDecimal valor;

    public Long getId() {
      return id;
    }

    public void setId(Long id) {
      this.id = id;
    }

    public String getNome() {
      return nome;
    }

    public void setNome(String nome) {
      this.nome = nome;
    }

    public BigDecimal getValor() {
      return valor;
    }

    public void setValor(BigDecimal valor) {
      this.valor = valor;
    }
  }
}
