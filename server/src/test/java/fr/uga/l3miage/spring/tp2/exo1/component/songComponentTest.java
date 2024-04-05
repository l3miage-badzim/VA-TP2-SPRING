package fr.uga.l3miage.spring.tp2.exo1.component;

import fr.uga.l3miage.spring.tp2.exo1.components.SongComponent;
import fr.uga.l3miage.spring.tp2.exo1.exceptions.technical.NotFoundSongEntityException;
import fr.uga.l3miage.spring.tp2.exo1.models.SongEntity;
import fr.uga.l3miage.spring.tp2.exo1.repositories.SongRepository;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

@AutoConfigureTestDatabase
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
public class songComponentTest {
    @Autowired
    private SongComponent songComponent;

    @MockBean
    private SongRepository songRepository;

    @Test
    void getSongEntityByIdNotFound() {
        //Given
        when(songRepository.findById(anyString())).thenReturn(Optional.empty());

        assertThrows(NotFoundSongEntityException.class, () -> songComponent.getSongEntityById("test"));
    }

    @Test
    void getSongEntityFound() {
        //Given
        SongEntity songEntity = SongEntity
                .builder()
                .title("test")
                .build();

        //When
        when(songRepository.findById(anyString())).thenReturn(Optional.of(songEntity));

        //Then
        assertDoesNotThrow(() -> songComponent.getSongEntityById("test"));
    }
}
