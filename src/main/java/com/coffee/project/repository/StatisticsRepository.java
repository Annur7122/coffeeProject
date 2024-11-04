package com.coffee.project.repository;

import com.coffee.project.model.Statistics;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;  import java.util.Optional;

public interface StatisticsRepository extends JpaRepository<Statistics, Long> {
    Statistics findByDrinkId(Long drinkId);

    @Query("SELECT s FROM Statistics s where s.timesOrdered = (SELECT MAX(s2.timesOrdered) FROM Statistics s2)")
    Optional<Statistics> findMax();
}
