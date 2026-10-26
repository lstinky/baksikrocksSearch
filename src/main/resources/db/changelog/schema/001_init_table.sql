CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

create table if not exists cdlc
(
    id             uuid    default uuid_generate_v4() not null
        constraint pk_cdlc
            primary key,
    customforge_id bigint,
    artist         varchar(255),
    title          varchar(255),
    parts          varchar(50),
    tuning         varchar(50),
    platforms      varchar(50),
    member         varchar(255),
    official       boolean default false,
    updated        date,
    album_art      varchar,
    music_video    varchar,
    link           varchar,
    crash          boolean default false,
    boughtdlc      boolean default false,
    blacklist      boolean default false,
    custom_link    boolean default false
);

comment on column cdlc.id is 'Идентификатор записи';

comment on column cdlc.customforge_id is 'идентификатор от кастом форджа';

comment on column cdlc.artist is 'артист';

comment on column cdlc.title is 'название песни';

comment on column cdlc.parts is 'тип инструмента';

comment on column cdlc.tuning is 'строй инструмента';

comment on column cdlc.platforms is 'платформа cdlc';

comment on column cdlc.member is 'загрузивший cdlc';

comment on column cdlc.official is 'официальное длс';

comment on column cdlc.updated is 'дата обновления';

comment on column cdlc.album_art is 'ссылка на арт';

comment on column cdlc.music_video is 'ссылка на музыкальное видео';

comment on column cdlc.link is 'ссылка для скачивания';

comment on column cdlc.crash is 'сломанное cdlc';

comment on column cdlc.boughtdlc is 'купленное cdlc';

comment on column cdlc.blacklist is 'cdlc в черном списке';

comment on column cdlc.custom_link is 'признак наличия ссылки';

create index if not exists ifk_artist
    on cdlc (artist);

create index if not exists ifk_title
    on cdlc (title);