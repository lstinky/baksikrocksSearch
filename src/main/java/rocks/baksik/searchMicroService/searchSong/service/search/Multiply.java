package rocks.baksik.searchMicroService.searchSong.service.search;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rocks.baksik.searchMicroService.searchSong.model.Cdlc;
import rocks.baksik.searchMicroService.searchSong.repository.CdlcRepository;

import java.util.List;

@Slf4j
@Service
@Transactional
@Order(value = 4)
@RequiredArgsConstructor
public class Multiply implements SearchMethod  {

    private final CdlcRepository songRepository;


    /**
     * Смешанный поиск который пытается найти совпадения с введенным значением
     *
     * @param value значение для поиска
     * @return найденных CDLC
     */
    @Override
    public List<Cdlc> search(String value) {
        final var pairTextForSearch = getPairTextForSearch(value);
        final var finedSongList = songRepository.findAllHalf(pairTextForSearch.getFirst(), pairTextForSearch.getSecond());

        if (!finedSongList.isEmpty()) {
            return finedSongList;
        }

        final var pairTextForSearchPlus = getPairWithNotEqualsPath(value, true);
        return songRepository.findAllHalf(pairTextForSearchPlus.getFirst(), pairTextForSearchPlus.getSecond());
    }


    /**
     *  Деление строки на 2 равные части
     *
     * @param textForSearch изначальная строка с запросом
     * @return строка состоящая из двух половин
     */
    private Pair<String, String> getPairTextForSearch(String textForSearch) {
        int lengthtextForSearch = textForSearch.length();

        if (0 == lengthtextForSearch % 2) {
            return Pair.of(textForSearch.substring(0, lengthtextForSearch / 2), textForSearch.substring(lengthtextForSearch / 2, lengthtextForSearch));
        }

        return getPairWithNotEqualsPath(textForSearch, false);
    }

    /**
     * Деление строки на 2 не равыне части
     *
     * @param textForSearch изначальная строка с запросом
     * @param isUseOffset признак сдвига
     * @return строка состоящая из двух половин
     */
    private Pair<String, String> getPairWithNotEqualsPath(String textForSearch, Boolean isUseOffset) {
        int lengthtextForSearch = textForSearch.length();

        int halfLengthTextForFearch = (int) Math.floor(lengthtextForSearch / 2.0);

        if (isUseOffset) {
            halfLengthTextForFearch++;
        }

        return Pair.of(textForSearch.substring(0, halfLengthTextForFearch), textForSearch.substring(halfLengthTextForFearch, lengthtextForSearch));
    }
}
