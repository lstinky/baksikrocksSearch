package rocks.baksik.searchMicroService.searchSong.platform.entity;

import javax.persistence.*;

@Entity
@Table(name = "platforms")
public class Platform {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String platform;

    private String description;
    /* Такие перекресные ссылки очень замедляют запросы
    @ManyToMany(mappedBy = "platforms")
    private Collection<Song> songs;*/

    public Platform() {
    }

    public int getId() {
        return id;
    }

    public String getPlatform() {
        return platform;
    }

    public String getDescription() {
        return description;
    }
}