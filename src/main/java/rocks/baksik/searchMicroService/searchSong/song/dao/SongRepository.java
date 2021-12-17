package rocks.baksik.searchMicroService.searchSong.song.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import rocks.baksik.searchMicroService.searchSong.song.entity.Song;

import java.util.List;

public interface SongRepository extends CrudRepository<Song, Integer> {

    @Query("select s from Song s join s.typesInstruments t join s.platforms p where (concat(upper(s.artist), ' - ', upper(s.title)) like concat('%', upper(:title) ,'%')) and t.id = 2 and p.id = 1")
    List<Song> findOnArtistAndTitle(String title);

    @Query("select s from Song s join s.typesInstruments t join s.platforms p where (concat(upper(s.artist), ' ', upper(s.title)) like concat('%', upper(:leftPart) ,'%') or concat(upper(s.artist), ' ', upper(s.title)) like concat(upper(:leftPart) ,'%') or concat(upper(s.artist), ' ', upper(s.title)) like concat('%', upper(:rightpart))) and t.id = 2 and p.id = 1")
    List<Song> findOnArtistAndTitleByPart(String leftPart, String rightpart );
}
