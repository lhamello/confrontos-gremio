package com.lhamello.confrontosgremio.infraestrutura.persistencia;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.lhamello.confrontosgremio.dominio.model.pais.Pais;
import com.lhamello.confrontosgremio.dominio.model.pais.PaisRepository;
import com.lhamello.confrontosgremio.dominio.model.pais.QPais;
import com.querydsl.jpa.impl.JPAQueryFactory;

// TODO: implementar teste com arquillian
@ApplicationScoped
public class PaisRepositoryImplPadrao implements PaisRepository {

  @PersistenceContext
  private EntityManager entityManager;
  @Inject
  private JPAQueryFactory queryFactory;

  public PaisRepositoryImplPadrao() {
  }

  @Override
  public Pais salvar(final Pais pais) {
    return entityManager.merge(pais);
  }

  @Override
  public boolean isPaisJaCadastrado(final String abreviaturaPais, final String nomePais) {
    QPais qPais = QPais.pais;

    List<Pais> paises = queryFactory.selectFrom(qPais)
        .where(qPais.abreviatura.eq(abreviaturaPais), 
               qPais.nome.eq(nomePais))
        .fetch();

    return !paises.isEmpty();
  }
}
