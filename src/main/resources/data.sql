-- this script will be run every time the server is started

CREATE TABLE IF NOT EXISTS players (
                                       name varchar(20) primary key,
                                       isMaster boolean default false
);