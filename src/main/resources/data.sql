-- this script will be run every time the server is started

CREATE TABLE IF NOT EXISTS players (
                                       name varchar(20) primary key,
                                       is_master boolean default false
);