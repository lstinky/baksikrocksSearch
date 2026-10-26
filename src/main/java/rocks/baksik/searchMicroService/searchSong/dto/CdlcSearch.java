package rocks.baksik.searchMicroService.searchSong.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Pattern;

@Schema(description = "Фильтры для поиска")
public record CdlcSearch (
        @Pattern(regexp = "^$|^[А-яЁёA-z' -]+$", message = "Введено недопустимое название")
        @Schema(description = "Имя или название композиции для поиска", example = "ZZ top", maxLength = 256)
        String value
) {
}
