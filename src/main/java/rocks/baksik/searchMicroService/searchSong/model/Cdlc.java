package rocks.baksik.searchMicroService.searchSong.model;

import java.time.LocalDate;
import java.util.UUID;

/**
 *
 * @param id                Идентификатор записи
 * @param customforge_id    идентификатор от кастом форджа
 * @param artist            артист
 * @param title             название песни
 * @param parts             тип инструмента
 * @param tuning            строй инструмента
 * @param platforms         платформа cdlc
 * @param member            загрузивший cdlc
 * @param official          официальное длс
 * @param updated           дата обновления
 * @param album_art         ссылка на арт
 * @param music_video       ссылка на музыкальное видео
 * @param link              ссылка для скачивания
 * @param crash             сломанное cdlc
 * @param boughtdlc         купленное cdlc
 * @param blacklist         cdlc в черном списке
 * @param custom_link       признак наличия ссылки
 */
public record Cdlc(
        UUID id,
        long customforge_id,
        String artist,
        String title,
        String parts,
        String tuning,
        String platforms,
        String member,
        Boolean official,
        LocalDate updated,
        String album_art,
        String music_video,
        String link,
        Boolean crash,
        Boolean boughtdlc,
        Boolean blacklist,
        Boolean custom_link
) {
}