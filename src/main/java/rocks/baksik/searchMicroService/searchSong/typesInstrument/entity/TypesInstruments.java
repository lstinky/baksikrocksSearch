package rocks.baksik.searchMicroService.searchSong.typesInstrument.entity;

import javax.persistence.*;

@Entity
@Table(name = "types_instruments")
public class TypesInstruments {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String parts;

    private String description;
    /* Такие перекресные ссылки очень замедляют запросы
    @ManyToMany(mappedBy = "typesInstruments")
    private Collection<Song> songs;*/

    public TypesInstruments() {
    }

    public int getId() {
        return id;
    }

    public String getParts() {
        return parts;
    }

    public String getDescription() {
        return description;
    }
}
