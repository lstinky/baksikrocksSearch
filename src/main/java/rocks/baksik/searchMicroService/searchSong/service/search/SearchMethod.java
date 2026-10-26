package rocks.baksik.searchMicroService.searchSong.service.search;

import rocks.baksik.searchMicroService.searchSong.model.Cdlc;

import java.util.List;

public interface SearchMethod {

    List<Cdlc> search(String value);
}
