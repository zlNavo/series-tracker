package de.seriestracker;

import de.seriestracker.involvee_entry.InvolveeEntryService;
import de.seriestracker.media.Genre;
import de.seriestracker.media.movie.MovieDTOSimple;
import de.seriestracker.media.movie.MovieService;
import de.seriestracker.media.series.SeriesDTOSimple;
import de.seriestracker.media.series.SeriesService;
import de.seriestracker.media.series.season.SeasonDTOSimple;
import de.seriestracker.media.series.season.episode.EpisodeDTOSimple;
import de.seriestracker.person.Gender;
import de.seriestracker.person.Person;
import de.seriestracker.person.PersonDTOSimple;
import de.seriestracker.person.PersonService;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Arrays;

@Service
public class TestingData {

    private final PersonService personService;
    private final InvolveeEntryService involveeEntryService;
    private final MovieService movieService;
    private final SeriesService seriesService;

    public TestingData(final PersonService personService, final InvolveeEntryService involveeEntryService, final MovieService movieService, final SeriesService seriesService) {
        this.personService = personService;
        this.involveeEntryService = involveeEntryService;
        this.movieService = movieService;
        this.seriesService = seriesService;
    }

    @PostConstruct
    public void init() {
        loadPersons();
        loadMovies();
        loadSeries();
    }

    private void loadPersons() {
        final String[] firstNames = {"John", "Jane", "Bob"};
        final String[] lastNames = {"Doe", "Smith", "Jones"};
        final Gender[] gender = {Gender.MALE, Gender.FEMALE, Gender.UNKNOWN};
        final String[] birthdates = {"1992-02-09", "1991-10-28", "2003-12-26"};
        final String[] birthplaces = {"Stuttgart, Germany", "Fellbach, Germany", "New York City, USA"};

        for (int i = 0; i < firstNames.length; i++) {
            final PersonDTOSimple person = new PersonDTOSimple(firstNames[i], lastNames[i], gender[i] , LocalDate.parse(birthdates[i]), birthplaces[i]);

            personService.registerPerson(person);
        }
    }

    private void loadMovies() {
        final String[] titles = {"Django Unchained", "Interstellar", "Hereditary"};
        final String[] descriptions = {
                "Django, a freed slave, teams up with a bounty hunter to rescue his wife from a brutal plantation owner.",
                "In a dystopian future, astronauts travel through a wormhole near Saturn to find a new home for humanity.",
                "A grieving family is haunted by sinister occurrences following the death of their secretive grandmother."
        };
        final String[] premiereDates = {"2012-12-11", "2014-10-26", "2018-01-21"};
        final Genre[] genres = {Genre.ACTION, Genre.SCI_FI, Genre.HORROR};

        for (int i = 0; i < titles.length; i++) {
            final MovieDTOSimple movie = new MovieDTOSimple(titles[i], descriptions[i], LocalDate.parse(premiereDates[i]), Arrays.asList(genres[i]));

            movieService.registerMovie(movie);
        }
    }

    private void loadSeries() {
        final String[] titles = {"Daredevil: Born Again", "Paradise", "Running Point"};
        final String[] descriptions = {
                "Matt Murdock, aka Daredevil, faces new challenges as Wilson Fisk rises to power as Mayor of New York, setting the stage for a gritty crime saga in the MCU.",
                "A Secret Service agent investigates a murder in a high-profile community, uncovering secrets and corruption that threaten to unravel everything.",
                "Isla Gordon, a reformed party girl, takes charge of her family's professional basketball team and navigates the challenges of leadership in a male-dominated industry."
        };
        final String[] premiereDates = {"2025-03-04", "2025-01-28", "2025-02-27"};
        final Genre[] genres = {Genre.ACTION, Genre.THRILLER, Genre.COMEDY};

        for (int i = 0; i < titles.length; i++) {
            final SeriesDTOSimple series = new SeriesDTOSimple(titles[i], descriptions[i], LocalDate.parse(premiereDates[i]), Arrays.asList(genres[i]));
            final SeasonDTOSimple season = new SeasonDTOSimple((long) i+1);

            seriesService.registerSeries(series);

            seriesService.registerSeason(season);
            seriesService.registerSeason(season);
        }

        final String[] episodeTitles = {
                "Heaven's Half Hour", "Optics", "The Hollow of His Hand", "Sic Semper Systema",
                "With Interest", "Excessive Force", "Art for Art's Sake", "Straight to Hell",
                "Isle of Joy", "The Devil's Bargain", "A New Dawn", "Shadows of the Past",
                "The Final Blow", "Muse's Masterpiece", "The Reckoning", "Endgame",
                "The Dark Passenger", "Born Again"
        };

        final String[] episodeDescriptions = {
                "Matt Murdock gives up the mask. Wilson Fisk has his sights set to new heights.",
                "Matt Murdock gets a new client who's more than he claims to be. Fisk learns the power of optics.",
                "The trial of Hector Ayala begins. Fisk's old business associates seek to claim his vacant mantle.",
                "Matt Murdock and Wilson Fisk's darker halves fight to be unleashed.",
                "A day in the life of Matt Murdock gets unexpectedly intense, forcing him to team up with a familiar face.",
                "When a serial killer terrorizes the streets of New York, the city needs a savior.",
                "Muse makes his presence known with grotesque street art, forcing Daredevil into action.",
                "Fisk consolidates power as Daredevil confronts his own limits in Hell's Kitchen.",
                "Matt faces an unexpected ally while Fisk's plans for New York take a sinister turn.",
                "Daredevil and Kingpin strike a dangerous deal that could change everything.",
                "Hell's Kitchen sees a glimmer of hope as Matt tries to rebuild trust with his allies.",
                "Old wounds resurface as Matt faces a ghost from his past while Muse escalates his attacks.",
                "A climactic showdown between Daredevil and Muse leaves Hell's Kitchen in turmoil.",
                "Muse unveils his ultimate creation, pushing Matt to his breaking point.",
                "Fisk and Daredevil face their darkest truths in a battle for control of the city.",
                "The final confrontation between Daredevil and Kingpin determines the fate of Hell's Kitchen.",
                "Matt and Fisk grapple with their inner demons as their destinies collide one last time.",
                "Daredevil rises once more, embracing his true identity to protect Hell's Kitchen."
        };

        final String[] episodePremiereDates = {
                "2025-03-04", "2025-03-04", "2025-03-11", "2025-03-18",
                "2025-03-25", "2025-03-25", "2025-04-01", "2025-04-08",
                "2025-04-15", "2025-04-22", "2025-04-29", "2025-05-06",
                "2025-05-13", "2025-05-20", "2025-05-27", "2025-06-03",
                "2025-06-10", "2025-06-17"
        };

        long season = 1;

        for (int i = 0; i < episodeTitles.length; i+=3) {
            final EpisodeDTOSimple episode1 = new EpisodeDTOSimple(episodeTitles[i], episodeDescriptions[i], LocalDate.parse(episodePremiereDates[i]), season);
            final EpisodeDTOSimple episode2 = new EpisodeDTOSimple(episodeTitles[i+1], episodeDescriptions[i+1], LocalDate.parse(episodePremiereDates[i+1]), season);
            final EpisodeDTOSimple episode3 = new EpisodeDTOSimple(episodeTitles[i+2], episodeDescriptions[i+2], LocalDate.parse(episodePremiereDates[i+2]), season);

            seriesService.registerEpisode(episode1);
            seriesService.registerEpisode(episode2);
            seriesService.registerEpisode(episode3);
            season++;
        }
    }

}
