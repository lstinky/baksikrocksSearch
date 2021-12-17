package rocks.baksik.searchMicroService.searchSong.song.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rocks.baksik.searchMicroService.searchSong.song.dao.SongRepository;
import rocks.baksik.searchMicroService.searchSong.song.entity.Song;

import java.util.ArrayList;
import java.util.List;

@Service
public class SongService {

    private static Logger logger = LoggerFactory.getLogger(SongService.class);

    @Autowired
    private SongRepository songRepository;

    /**
     * Метод который выполняет поиск песен, преобразовывая различными спобосами исходную строку для поиска
     *
     * @param textForSearch исходная строка для поиска
     * @return список песен либо пустой список если ничего не нашлось
     */
    public List<Song> customSearch(String textForSearch) {
        //попытаемся подчистить строку поиска от ненужных символов, несмотря даже на то что мы повесили на них валидацию
        String clearTextForSearch = textForSearch.replaceAll("[\\\\#$:;'\"]", "").trim();

        //начнем формировать список возможных результатов
        List<Song> songs = new ArrayList<>();
        songs.addAll(songRepository.findOnArtistAndTitle(clearTextForSearch));

        //Это пока просто скопировал со старого решения скорее всего потребуется оптимизация
        if (songs.isEmpty()) {
            //если базовый запрос ничего не нашел, делим строку для поиска на 2 части
            String leftPart;
            String rightPart;
            int lengthtextForSearch = clearTextForSearch.length();
            //сперва определяем делится ли строка ровно по полам
            if (0 == lengthtextForSearch % 2) {
                //если делится, то разбиваем и пытаемся искать отдельно по левой или правой части
                leftPart = clearTextForSearch.substring(0, lengthtextForSearch / 2);
                rightPart = clearTextForSearch.substring(lengthtextForSearch / 2, lengthtextForSearch);
                songs.addAll(songRepository.findOnArtistAndTitleByPart(leftPart, rightPart));
            } else {
                //Если не делится, то разбиваем как можем
                int halfLengthTextForFearch = lengthtextForSearch / 2;
                leftPart = clearTextForSearch.substring(0, halfLengthTextForFearch);
                rightPart = clearTextForSearch.substring(halfLengthTextForFearch, lengthtextForSearch);
                //и опять же выполняем поиск по частям
                songs.addAll(songRepository.findOnArtistAndTitleByPart(leftPart, rightPart));
                if (songs.isEmpty()) {
                    //Если и это не дало результата, то пробуем сместить точку деления
                    halfLengthTextForFearch++;
                    leftPart = clearTextForSearch.substring(0, lengthtextForSearch / 2);
                    rightPart = clearTextForSearch.substring(halfLengthTextForFearch, lengthtextForSearch);
                    //и снова выполнять поиск по частям
                    songs.addAll(songRepository.findOnArtistAndTitleByPart(leftPart, rightPart));
                }
            }

        }
        //После завершения поиска, особенно если много данных приходится ждать кучу времени пока подтянутся дочерние элементы song это плохо, нужно что-то придумать
        return songs;
    }
}
