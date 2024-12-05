-- this script will be run every time the server is started

CREATE TABLE IF NOT EXISTS players
(
    name      varchar(20) primary key,
    is_master boolean default false
);

CREATE TABLE IF NOT EXISTS characters
(
    name                 varchar(20) primary key,
    class                varchar(20)                           not null,
    level                number                                not null,
    background           varchar(20)                           not null,
    race                 varchar(20)                           not null,
    alignment            varchar(20)                           not null,
    player_name          varchar(20)                           not null,
    experience_points    number                                not null default 0,
    inspiration_points   number                                not null default 0,
    personality_traits   varchar(255)                          not null,
    ideals               varchar(255)                          not null,
    bonds                varchar(255)                          not null,
    flaws                varchar(255)                          not null,
    maximum_hit_points   number                                not null default 0,
    current_hit_points   number                                not null default 0,
    temporary_hit_points number                                not null default 0,
    hit_dice             ENUM ('d4', 'd6', 'd8', 'd10', 'd12') not null,
    success_death_saves  ENUM ('0','1','2','3')                not null default '0',
    failure_death_saves  ENUM ('0','1','2','3')                not null default '0',
    languagese           varchar(255),
    proficiencies        varchar(255),
    features_and_traits  varchar(255)

);

CREATE TABLE IF NOT EXISTS character_modifiers
(
    character_name varchar(20) primary key,
    strength       number not null default 0,
    dexterity      number not null default 0,
    constitution   number not null default 0,
    intelligence   number not null default 0,
    wisdom         number not null default 0,
    charisma       number not null default 0
);


CREATE TABLE IF NOT EXISTS equipment
(
    id                 uuid primary key,
    character_name     varchar(20)                                                                                                                                      not null,
    name               varchar(20)                                                                                                                                      not null,
    description        varchar(255),
    modifier           ENUM ('STR','DEX', 'CON', 'INT', 'WIS', 'CHA')                                                                                                   not null,
    damage_dice        ENUM ('d2','d4','d6','d8','d10','d12','d20', 'custom')                                                                                           not null,
    damage_dice_number int                                                                                                                                              not null default 1,
    damage_type        ENUM ('BLUDGEONING','PIERCING', 'SLASHING', 'ACID', 'COLD', 'FIRE', 'FORCE', 'LIGHTNING', 'NECROTIC', 'POISON', 'PSYCHIC', 'RADIANT', 'THUNDER') not null
);

CREATE TABLE IF NOT EXISTS character_proficiencies
(
    id               uuid primary key,
    character_name   varchar(20) not null,
    proficiency_name varchar(20) not null
);


CREATE TABLE IF NOT EXISTS character_physical_characteristics
(
    character_name varchar(20) primary key,
    age            int default 0,
    height         int default 0,
    weight         int default 0,
    skin           varchar(10),
    hair           varchar(10),
    eyes           varchar(10)
);


CREATE TABLE IF NOT EXISTS character_additional_info
(
    character_name           varchar(20) primary key,
    backstory                varchar,
    appearance_image         blob,
    features_and_traits      varchar,
    allies_and_organizations varchar
);

CREATE TABLE IF NOT EXISTS character_treasures
(
    id             uuid primary key,
    character_name varchar(20),
    name           varchar(20),
    description    varchar,
    monetary_value varchar
);


CREATE TABLE IF NOT EXISTS character_spellslots
(
    character_name        varchar(20) primary key,
    slot_level            int,
    maximum_slots_number  int,
    avaiable_slots_number int
);

CREATE TABLE IF NOT EXISTS character_spells
(
    id             uuid primary key,
    character_name varchar(20),
    name           varchar(20),
    level          int
);

CREATE TABLE IF NOT EXISTS spells
(
    name        varchar(20),
    description varchar,
    level       int,
    school      varchar(20),
    casting     varchar(20),
    time        varchar(20),
    range       varchar(20),
    duration    varchar(20),
    components  varchar(20)
);






