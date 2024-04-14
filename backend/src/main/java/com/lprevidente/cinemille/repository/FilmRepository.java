package com.lprevidente.cinemille.repository;

import com.lprevidente.cinemille.controller.FilmCriteria;
import com.lprevidente.cinemille.entity.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Repository
@Transactional(readOnly = true)
public interface FilmRepository extends JpaRepository<Film, Long> {


  @Query(nativeQuery = true,
      value = """
          select f.id, f.name, f.description,f.release_date, f.duration_in_minutes,
                 sf.date, sf.start_time,
                 r.id, r.name
          from film f
                left join screening_film sf on sf.film_id = f.id
                join room r on sf.room_id = r.id
          where date >= CURDATE()
            and start_time >= CURTIME()
          order by f.name""")
  List<Object[]> findAllOnShown();

  @Query(nativeQuery = true,
      value = """
          select f.id, f.name, f.description,f.release_date, f.duration_in_minutes,
                 sf.date, sf.start_time,
                 r.id, r.name
          from film f
                left join screening_film sf on sf.film_id = f.id
                join room r on sf.room_id = r.id
          where (sf.date < CURDATE() or (sf.date = CURDATE() and start_time < CURTIME()))
          and (:text is null or f.name like %:text% or f.description like %:text%)
          and (:start is null or sf.date between :start and :end)
          order by f.name""")
  List<Object[]> findHistory(String text, LocalDate start, LocalDate end);
}
