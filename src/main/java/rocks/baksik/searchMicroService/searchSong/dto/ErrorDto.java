package rocks.baksik.searchMicroService.searchSong.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Ошибка")
public record ErrorDto(@Schema(description = "Код ошибки") String code,
                       @Schema(description = "Сообщение") String message) {
}
