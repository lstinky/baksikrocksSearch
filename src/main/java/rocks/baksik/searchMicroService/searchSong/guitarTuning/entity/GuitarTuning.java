package rocks.baksik.searchMicroService.searchSong.guitarTuning.entity;

import javax.persistence.*;

@Entity
@Table(name = "guitar_tuning")
public class GuitarTuning {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String tuning;

    private String description;

    /* Такие перекресные ссылки очень замедляют запросы
    @OneToMany(mappedBy = "guitarTuning", fetch = FetchType.EAGER)
    private Collection<Song> songs;*/

    public GuitarTuning() {

    }

    public int getId() {
        return id;
    }

    public String getTuning() {
        return tuning;
    }

    public String getDescription() {
        return description;
    }
}
