package rocks.baksik.searchMicroService.searchSong.repository;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.Repository;
import rocks.baksik.searchMicroService.searchSong.model.Cdlc;


import java.util.List;
import java.util.UUID;

public interface CdlcRepository extends Repository<Cdlc, UUID> {

    @Query
    List<Cdlc> findAllEasy(String value);

    @Query
    List<Cdlc> findAllHalf(String left_path, String right_path);

    @Query
    List<Cdlc> findAllByArtist(String artist);

    @Query
    List<Cdlc> findAllByTitle(String title);
}
