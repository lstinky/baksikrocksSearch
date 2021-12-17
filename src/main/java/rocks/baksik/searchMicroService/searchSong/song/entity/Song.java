package rocks.baksik.searchMicroService.searchSong.song.entity;

import rocks.baksik.searchMicroService.searchSong.guitarTuning.entity.GuitarTuning;
import rocks.baksik.searchMicroService.searchSong.platform.entity.Platform;
import rocks.baksik.searchMicroService.searchSong.typesInstrument.entity.TypesInstruments;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

@Entity
public class Song {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="id_out")
    private int idOut;

    private String artist;

    private String title;

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_tuning")
    private GuitarTuning guitarTuning;

    private String member;

    private boolean official;

    private Date updated;

    private String albumArt;

    private String musicVideo;

    private String link;

    private boolean crash;

    @Column(name="bought_dlc")
    private boolean boughtDlc;

    @Column(name="in_blacklist")
    private boolean inBlacklist;

    @Column(name="custom_link")
    private boolean customLink;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "song_platform",
            joinColumns = @JoinColumn(name = "id_song"),
            inverseJoinColumns = @JoinColumn(name = "id_platform")
    )
    private Collection<Platform> platforms;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "song_types_instruments",
            joinColumns = @JoinColumn(name = "id_song"),
            inverseJoinColumns = @JoinColumn(name = "id_types_instruments")
    )
    private Collection<TypesInstruments> typesInstruments;

    public Song() {
    }

    public int getId() {
        return id;
    }

    public int getIdOut() {
        return idOut;
    }

    public String getArtist() {
        return artist;
    }

    public String getTitle() {
        return title;
    }

    public GuitarTuning getGuitarTuning() {
        return guitarTuning;
    }

    public String getMember() {
        return member;
    }

    public boolean isOfficial() {
        return official;
    }

    public Date getUpdated() {
        return updated;
    }

    public String getAlbumArt() {
        return albumArt;
    }

    public String getMusicVideo() {
        return musicVideo;
    }

    public String getLink() {
        return link;
    }

    public boolean isCrash() {
        return crash;
    }

    public boolean isBoughtDlc() {
        return boughtDlc;
    }

    public boolean isInBlacklist() {
        return inBlacklist;
    }

    public boolean isCustomLink() {
        return customLink;
    }

    public Collection<Platform> getPlatforms() {
        return platforms;
    }

    public Collection<TypesInstruments> getTypesInstruments() {
        return typesInstruments;
    }
}
