package rocks.baksik.searchMicroService.searchSong.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import rocks.baksik.searchMicroService.searchSong.dto.CdlcSearch;
import rocks.baksik.searchMicroService.searchSong.exception.ValueException;
import rocks.baksik.searchMicroService.searchSong.model.Cdlc;
import rocks.baksik.searchMicroService.searchSong.service.search.SearchMethod;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class SongServiceImpl implements SongService {

    private final List<SearchMethod> searchMethods;

    @Override
    public List<Cdlc> customSearch(CdlcSearch cdlcSearch) throws ValueException.NotFound {
        final var textForSearch = cdlcSearch.value().replaceAll("[\\\\#$:;'\"]", "").trim();

        List<Cdlc> cdlcList = new ArrayList<>();

        for (final var searchMethod : searchMethods) {
            cdlcList.addAll(searchMethod.search(textForSearch));
        }

        if (cdlcList.isEmpty()) {
            throw  new ValueException.NotFound();
        }

        return cdlcList;
    }
}
