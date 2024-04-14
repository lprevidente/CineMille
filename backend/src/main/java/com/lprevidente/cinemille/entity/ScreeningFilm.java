package com.lprevidente.cinemille.entity;

import static jakarta.persistence.GenerationType.IDENTITY;
import static org.hibernate.annotations.OnDeleteAction.CASCADE;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.proxy.HibernateProxy;

@Entity
@Getter
@Setter
public class ScreeningFilm {
  @Id
  @GeneratedValue(strategy = IDENTITY)
  private Long id;

  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "film_id", foreignKey = @ForeignKey(name = "fk_screening_film_film"))
  @OnDelete(action = CASCADE)
  private Film film;

  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "room_id", foreignKey = @ForeignKey(name = "fk_screening_film_room"))
  @OnDelete(action = CASCADE)
  private Room room;

  @NotNull private LocalDate date;

  @NotNull private LocalTime startTime;

  @Override
  public final boolean equals(Object o) {
    if (this == o) return true;
    if (o == null) return false;
    final var oEffectiveClass =
        o instanceof HibernateProxy hp
            ? hp.getHibernateLazyInitializer().getPersistentClass()
            : o.getClass();
    final var thisEffectiveClass =
        this instanceof HibernateProxy hp
            ? hp.getHibernateLazyInitializer().getPersistentClass()
            : this.getClass();
    if (thisEffectiveClass != oEffectiveClass) return false;
    ScreeningFilm that = (ScreeningFilm) o;
    return getId() != null && Objects.equals(getId(), that.getId());
  }

  @Override
  public final int hashCode() {
    return 2024;
  }

  @Override
  public String toString() {
    return STR."Screening Film (id = \{id}, startTime = \{startTime}, date = \{date})";
  }
}
