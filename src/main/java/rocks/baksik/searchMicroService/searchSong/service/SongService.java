package rocks.baksik.searchMicroService.searchSong.service;

import rocks.baksik.searchMicroService.searchSong.dto.CdlcSearch;
import rocks.baksik.searchMicroService.searchSong.model.Cdlc;

import java.util.List;

public interface SongService {

    /**
     * Метод который выполняет поиск песен, преобразовывая различными спобосами исходную строку для поиска
     *
     * @param cdlcSearch исходная строка для поиска
     * @return список песен либо пустой список если ничего не нашлось
     */
    List<Cdlc> customSearch(CdlcSearch cdlcSearch);
}
