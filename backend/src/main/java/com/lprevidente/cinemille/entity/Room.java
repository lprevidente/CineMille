package com.lprevidente.cinemille.entity;

import static jakarta.persistence.GenerationType.*;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import java.util.Objects;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.proxy.HibernateProxy;

@Getter
@Setter
@Entity
public class Room {

  @Id
  @GeneratedValue(strategy = IDENTITY)
  private Long id;

  @NotNull private String name;

  @ColumnDefault("1")
  private int capacity;

  @ColumnDefault("false")
  private boolean iMax;

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
    final var room = (Room) o;
    return getId() != null && Objects.equals(getId(), room.getId());
  }

  @Override
  public final int hashCode() {
    return 2024;
  }

  @Override
  public String toString() {
    return STR."\{getClass().getSimpleName()}(id = \{id}, name = \{name}, capacity = \{capacity}, iMax = \{iMax})";
  }
}
