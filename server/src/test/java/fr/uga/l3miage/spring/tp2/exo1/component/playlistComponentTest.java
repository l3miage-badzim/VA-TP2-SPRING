package fr.uga.l3miage.spring.tp2.exo1.component;

import fr.uga.l3miage.spring.tp2.exo1.components.PlaylistComponent;
import fr.uga.l3miage.spring.tp2.exo1.exceptions.technical.NotFoundPlaylistEntityException;
import fr.uga.l3miage.spring.tp2.exo1.models.PlaylistEntity;
import fr.uga.l3miage.spring.tp2.exo1.repositories.PlaylistRepository;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.Mockito.*;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;
import java.util.Set;

@AutoConfigureTestDatabase
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
public class playlistComponentTest {
    @Autowired
    private PlaylistComponent playlistComponent;
    @MockBean
    private PlaylistRepository playlistRepository;

    @Test
    void getPlaylistNotFound() {
        //Given
        when(playlistRepository.findById(anyString())).thenReturn(Optional.empty());

        //then - when

        assertThrows(NotFoundPlaylistEntityException.class, () -> playlistComponent.getPlaylist("test"));
    }

    @Test
    void getPlayListFound() {
        //Given
        PlaylistEntity playlistEntity = PlaylistEntity
                .builder()
                .songEntities(Set.of())
                .description("test")
                .build();
        when(playlistRepository.findById(anyString())).thenReturn(Optional.of(playlistEntity));

        //When-then
        assertDoesNotThrow(() -> playlistComponent.getPlaylist("vbdsvbdfbfdsbfd"));
    }


}
