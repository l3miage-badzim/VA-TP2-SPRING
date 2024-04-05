package fr.uga.l3miage.spring.tp2.exo1.repositories;


import fr.uga.l3miage.exo1.enums.GenreMusical;
import fr.uga.l3miage.spring.tp2.exo1.models.ArtistEntity;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

@AutoConfigureTestDatabase
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK, properties = "spring.jpa.database-platform=org.hibernate.dialect.H2Dialect")
public class ArtistRepositoryTest {
    @Autowired
    private ArtistRepository artistRepository;

    @Test
    void countByGenreMusicalEqualsTest() {
        //Given 2 artistes
        ArtistEntity artistEntity1 = ArtistEntity
                .builder()
                .name("test01")
                .genreMusical(GenreMusical.RAP)
                .build();

        ArtistEntity artistEntity2 = ArtistEntity
                .builder()
                .name("test02")
                .genreMusical(GenreMusical.SLAM)
                .build();

        artistRepository.save(artistEntity1);
        artistRepository.save(artistEntity2);

        //When
        int count = artistRepository.countByGenreMusicalEquals(GenreMusical.RANDB);

        //Then
        assertThat(count).isEqualTo(0);

    }

}
