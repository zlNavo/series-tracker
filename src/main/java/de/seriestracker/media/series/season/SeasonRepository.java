package de.seriestracker.media.series.season;

import de.seriestracker.media.series.Series;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SeasonRepository extends CrudRepository<Season, Long> {
    List<Season> findSeasonsBySeries(Series series);
}
