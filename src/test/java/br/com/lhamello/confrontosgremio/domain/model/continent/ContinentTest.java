package br.com.lhamello.confrontosgremio.domain.model.continent;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;

class ContinentTest {

  private final Long id = null;
  private final String name = null;// "América do Sul";
  private final String maleGentile = null;// "Sul-americano";
  private final String femaleGentile = null;// "Sul-americana";
  private final String profileImagePath = null;// "http://www.lhamello.confrontosgremio.com.br/continentes/america-do-sul.png";

  @Test
  void shouldCreateContinent() {
    assertDoesNotThrow(() -> Continent.of(name, maleGentile, femaleGentile, profileImagePath));
  }

//  @Test
//  void shouldReturnAttributesCorrectly() {
//    final Continent continent = Continent.of(name, maleGentile, femaleGentile, profileImagePath);
//    assertAll(
//        () -> assertEquals(id, continent.getId()), 
//        () -> assertEquals(Name.of(name), continent.getName()),
//        () -> assertEquals(maleGentile, continent.getMaleGentile()), 
//        () -> assertEquals(femaleGentile, continent.getFemaleGentile()), 
//        () -> assertEquals(profileImagePath, continent.getProfileImagePath())
//    );
//  }
  
//  @Test
//  void shouldHaveSameHashcode() {
//    final Continent continent = Continent.of(abbreviation, name, maleGentile, femaleGentile, profileImagePath);
//    final Continent otherContinent = Continent.of(abbreviation, name, maleGentile, femaleGentile, profileImagePath);
//    assertEquals(continent.hashCode(), otherContinent.hashCode());
//  }
//  
//  @Test
//  void doesNotShouldHaveSameHashcode() {
//    final Continent continent = Continent.of(abbreviation, name, maleGentile, femaleGentile, profileImagePath);
//    final Continent otherContinent = Continent.of("AA", name, maleGentile, femaleGentile, profileImagePath);
//    assertNotEquals(continent.hashCode(), otherContinent.hashCode());
//  }
}
