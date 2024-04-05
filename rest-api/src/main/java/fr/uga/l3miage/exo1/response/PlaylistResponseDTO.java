package fr.uga.l3miage.exo1.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.Duration;
import java.util.Set;

@Data
@Builder
@Getter
@Setter
@Schema(description = "Représente une playlist")
public class PlaylistResponseDTO {
    @Schema(description = "nom de la playlist")
    private String name;
    @Schema(description = "description de la playlist")
    private String description;
    @Schema(description = "le temps complet de la playlist")
    private Duration totalDuration;
    @Schema(description = "La liste des sons dans la playlist")
    private Set<SongResponseDTO> songEntities;
}
