package br.com.lhamello.confrontosgremio.domain.model.continent;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import br.com.lhamello.confrontosgremio.domain.shared.valueobject.Name;

@Entity
@Table(name = "CONTINENT", uniqueConstraints = { 
    @UniqueConstraint(columnNames = "NAME", name = "CONTINENT_NAME_UK"), 
    @UniqueConstraint(columnNames = "MALE_GENTILE", name = "CONTINENT_MALE_GENTILE_UK"),
    @UniqueConstraint(columnNames = "FEMALE_GENTILE", name = "CONTINENT_FEMALE_GENTILE_UK"), 
    @UniqueConstraint(columnNames = "PROFILE_IMAGE_PATH", name = "CONTINENT_PROFILE_IMAGE_PATH_UK") 
})
public class Continent implements Serializable {

  private static final long serialVersionUID = 4568676301068408576L;
  
  @Id
  @Column(name = "ID")
  @GeneratedValue(generator = "CONTINENT_SEQ", strategy = GenerationType.SEQUENCE)
  @SequenceGenerator(allocationSize = 1, initialValue = 1, name = "CONTINENT_SEQ", sequenceName = "CONTINENT_SEQ")
  private Long id;
  @Column(name = "NAME", length = 16, nullable = false)
  private ContinentName name;
  @Column(name = "MALE_GENTILE", length = 16, nullable = false)
  private String maleGentile;
  @Column(name = "FEMALE_GENTILE", length = 16, nullable = false)
  private String femaleGentile;
  @Column(name = "PROFILE_IMAGE_PATH", length = 255, nullable = false)
  private String profileImagePath;

  private Continent() {
    super();
  }
  
  private Continent(final ContinentName name, final String maleGentile, final String femaleGentile, final String profileImagePath) {
    this.name = name;
    this.maleGentile = maleGentile;
    this.femaleGentile = femaleGentile;
    this.profileImagePath = profileImagePath;
  }
  
  public static Continent of(final String name, final String maleGentile, final String femaleGentile, final String profileImagePath) {
    final ContinentName continentName = ContinentName.of(name);
    return new Continent(continentName, maleGentile, femaleGentile, profileImagePath);
  }

  public Long getId() {
    return id;
  }

  public Name getName() {
    return name;
  }

  public String getMaleGentile() {
    return maleGentile;
  }

  public String getFemaleGentile() {
    return femaleGentile;
  }

  public String getProfileImagePath() {
    return profileImagePath;
  }

  @Override
  public boolean equals(final Object object) {
    if (object == null) { return false; }
    if (object == this) { return true; }
    if (object.getClass() != this.getClass()) { return false; }

    final Continent other = (Continent) object;
    return new EqualsBuilder()
        .append(this.id, other.getId())
        .isEquals();
  }
  
  @Override
  public int hashCode() {
    return new HashCodeBuilder()
        .append(id)
        .toHashCode();
  }
  
  @Override
  public String toString() {
    return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
        .append("id", id)
        .append("name", name)
        .append("maleGentile", maleGentile)
        .append("femaleGentile", femaleGentile)
        .append("profileImagePath", profileImagePath)
        .toString();
  }
}
