package rocks.baksik.searchMicroService.searchSong.song.controllers;

import org.hibernate.validator.constraints.Length;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import rocks.baksik.searchMicroService.searchSong.song.entity.Song;
import rocks.baksik.searchMicroService.searchSong.song.services.SongService;

import javax.validation.ConstraintViolationException;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@RestController
@RequestMapping("search")
@Validated
public class SongController {

    private static Logger logger = LoggerFactory.getLogger(SongController.class);

    @Autowired
    private SongService songService;

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<String> handleConstraintViolationException(ConstraintViolationException e) {
        return new ResponseEntity<>("Invalid inpute data: " + e.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @GetMapping("findMusic")
    public List<Song> findMusic(
            @RequestParam("textForSearch")
            @NotBlank(message = "Not empty text")
            @NotEmpty(message = "text field is null")
            @Length(min = 3, max = 20, message = "Text is very short or long")
            //@Pattern(regexp="[\\^\\\\#$:;'\"]", message = "invalid search text") пока отключил потому, что неразобрался как оно работает
            String textForSearch) {

        return songService.customSearch(textForSearch);
    }
}
