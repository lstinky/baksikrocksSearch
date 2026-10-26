package rocks.baksik.searchMicroService.searchSong.rest;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import rocks.baksik.searchMicroService.searchSong.dto.CdlcSearch;
import rocks.baksik.searchMicroService.searchSong.model.Cdlc;
import rocks.baksik.searchMicroService.searchSong.service.SongService;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@Tag(name = "dictionaries", description = "API по работе с песнями")
@RequestMapping(value = "/song/api/v2", produces = MediaType.APPLICATION_JSON_VALUE)
public class SongController {

    private final SongService songService;


    @Operation(summary = "Получение списка CDLC по указанных критериям", responses = {
            @ApiResponse(responseCode = "200", description = "Cписок CDLC")
    })
    @GetMapping("/find")
    public List<Cdlc> findMusic(@Parameter(description = "Значение справочника")
                                    @Validated CdlcSearch cdlcSearch) {

        return songService.customSearch(cdlcSearch);
    }
}