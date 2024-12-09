CREATE TABLE IF NOT EXISTS players
(
    name varchar2(20) primary key,
    type ENUM ('PLAYER', 'MASTER') default 'PLAYER' not null
);

CREATE TABLE IF NOT EXISTS characters
(
    name                 varchar2(40) primary key,
    class                varchar2(20)                          not null,
    level                number                                not null,
    background           varchar2(20)                          not null,
    race                 varchar2(20)                          not null,
    alignment            varchar2(20)                          not null,
    player_name          varchar2(20)                          not null,
    experience_points    number                                not null default 0,
    inspiration_points   number                                not null default 0,
    personality_traits   varchar2(255)                         not null,
    ideals               varchar2(255)                         not null,
    bonds                varchar2(255)                         not null,
    flaws                varchar2(255)                         not null,
    maximum_hit_points   number                                not null default 0,
    current_hit_points   number                                not null default 0,
    temporary_hit_points number                                not null default 0,
    hit_dice             ENUM ('D4', 'D6', 'D8', 'D10', 'D12') not null,
    success_death_saves  int                                   not null default 0 check success_death_saves between 0 and 3,
    failure_death_saves  int                                   not null default 0 check failure_death_saves between 0 and 3,
    languagese           varchar2(255),
    proficiencies        varchar2(255),
    features_and_traits  varchar2(255)

);

CREATE TABLE IF NOT EXISTS character_modifiers
(
    character_name varchar(40) primary key,
    strength       int not null default 0,
    dexterity      int not null default 0,
    constitution   int not null default 0,
    intelligence   int not null default 0,
    wisdom         int not null default 0,
    charisma       int not null default 0
);


CREATE TABLE IF NOT EXISTS character_equipment
(
    id             uuid primary key,
    character_name varchar2(40)                                                                                                                                     not null,
    name           varchar2(50)                                                                                                                                     not null,
    description    varchar2(255),
    modifier       ENUM ('STR','DEX', 'CON', 'INT', 'WIS', 'CHA')                                                                                                   not null,
    damage_dice    ENUM ('D2','D4','D6','D8','D10','D12','D20') array                                                                                               not null default array [0],
    damage_type    ENUM ('BLUDGEONING','PIERCING', 'SLASHING', 'ACID', 'COLD', 'FIRE', 'FORCE', 'LIGHTNING', 'NECROTIC', 'POISON', 'PSYCHIC', 'RADIANT', 'THUNDER') not null
);

CREATE TABLE IF NOT EXISTS character_proficiencies
(
    id               uuid primary key,
    character_name   varchar2(40) not null,
    proficiency_name varchar2(20) not null
);


CREATE TABLE IF NOT EXISTS character_physical_characteristics
(
    character_name varchar(40) primary key,
    age            int default 0,
    height         int default 0,
    weight         int default 0,
    skin           varchar2(10),
    hair           varchar2(10),
    eyes           varchar2(10)
);


CREATE TABLE IF NOT EXISTS character_additional_info
(
    character_name           varchar2(40) primary key,
    backstory                varchar2,
    appearance_image         blob,
    features_and_traits      varchar2,
    allies_and_organizations varchar2
);

CREATE TABLE IF NOT EXISTS character_treasures
(
    id             uuid primary key,
    character_name varchar2(40),
    name           varchar2(50),
    description    varchar2,
    monetary_value varchar2
);


CREATE TABLE IF NOT EXISTS character_spellslots
(
    character_name        varchar2(40) primary key,
    slot_level            int,
    maximum_slots_number  int,
    avaiable_slots_number int
);

CREATE TABLE IF NOT EXISTS character_spells
(
    id             uuid primary key,
    character_name varchar2(40),
    spell_name     varchar2(35),
    level          int
);

CREATE TABLE IF NOT EXISTS spells
(
    NAME             varchar2(35) primary key,
    LEVEL            int          not null,
    SCHOOL           varchar2(20) not null,
    CASTING_TIME     varchar2(20) not null,
    DURATION         varchar2(30),
    RANGE            varchar2(20),
    AREA             varchar2(20),
    ATTACK           varchar2(20),
    SAVE             varchar2(20),
    DAMAGE_OR_EFFECT varchar2(20) not null,
    RITUAL           varchar2(1),
    CONCENTRATION    varchar2(1),
    COMPONENTS       varchar2(10),
    VERBAL           varchar2(1),
    SOMATIC          varchar2(1),
    MATERIAL         varchar2(1),
    MATERIALS        varchar2(max),
    SOURCE           varchar2(30),
    DESCRIPTION      varchar2(max),
    PLAYER_CREATOR   varchar2(20)
);


CREATE TABLE IF NOT EXISTS magic_items
(
    NAME           varchar2(50) primary key,
    DESCRIPTION    varchar2     not null,
    RARITY         varchar2     not null,
    ATTUNEMENT     varchar2(10) not null,
    TYPE           varchar2,
    PLAYER_CREATOR varchar2(20)
);






