package de.seriestracker.media.series.season.episode;

import de.seriestracker.media.series.season.Season;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EpisodeRepository extends CrudRepository<Episode, Long> {
    List<Episode> findBySeason(Season season);
}
