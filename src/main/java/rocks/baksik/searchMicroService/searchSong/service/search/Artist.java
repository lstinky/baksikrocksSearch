package rocks.baksik.searchMicroService.searchSong.service.search;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rocks.baksik.searchMicroService.searchSong.model.Cdlc;
import rocks.baksik.searchMicroService.searchSong.repository.CdlcRepository;

import java.util.List;

@Slf4j
@Service
@Transactional
@Order(value = 2)
@RequiredArgsConstructor
public class Artist implements SearchMethod {

    private final CdlcRepository songRepository;

    /**
     * Поиск по артисту
     *
     * @param value значение для поиска
     * @return найденных CDLC
     */
    @Override
    public List<Cdlc> search(String value) {
        return songRepository.findAllByArtist(value);
    }
}
