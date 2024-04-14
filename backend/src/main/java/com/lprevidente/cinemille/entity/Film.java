package com.lprevidente.cinemille.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.proxy.HibernateProxy;

import java.time.LocalDate;
import java.util.Objects;

import static jakarta.persistence.GenerationType.IDENTITY;

@Getter
@Setter
@Entity
public class Film {

  @Id
  @GeneratedValue(strategy = IDENTITY)
  private Long id;

  @NotNull
  private String name;

  @Column(columnDefinition = "TEXT")
  private String description;

  @NotNull
  @ColumnDefault("(CURRENT_DATE)")
  private LocalDate releaseDate;

  @ColumnDefault("1")
  private int durationInMinutes;

  @Override
  public final boolean equals(Object o) {
    if (this == o) return true;
    if (o == null) return false;
    final var oEffectiveClass = o instanceof HibernateProxy hp ? hp.getHibernateLazyInitializer().getPersistentClass() : o.getClass();
    final var thisEffectiveClass = this instanceof HibernateProxy hp ? hp.getHibernateLazyInitializer().getPersistentClass() : this.getClass();
    if (thisEffectiveClass != oEffectiveClass) return false;
    final var film = (Film) o;
    return getId() != null && Objects.equals(getId(), film.getId());
  }

  @Override
  public final int hashCode() {
    return 2024;
  }

  @Override
  public String toString() {
    return STR."Film (id = \{id}, name = \{name}, description = \{description}, releaseDate = \{releaseDate}, durationInMinutes = \{durationInMinutes})";
  }
}
