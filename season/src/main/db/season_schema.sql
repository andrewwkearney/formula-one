-- ----------------------------------------------
-- Chassis table
-- ----------------------------------------------
CREATE TABLE IF NOT EXISTS chassis (
  id   INTEGER PRIMARY KEY AUTOINCREMENT,
  name TEXT NOT NULL

);

INSERT INTO chassis (name) VALUES ('C38');
INSERT INTO chassis (name) VALUES ('F1 W10 EQ Power+');
INSERT INTO chassis (name) VALUES ('FW42');
INSERT INTO chassis (name) VALUES ('MCL34');
INSERT INTO chassis (name) VALUES ('RP19');
INSERT INTO chassis (name) VALUES ('RB15');
INSERT INTO chassis (name) VALUES ('R.S. 19');
INSERT INTO chassis (name) VALUES ('SF90');
INSERT INTO chassis (name) VALUES ('STR14');
INSERT INTO chassis (name) VALUES ('VF-19');


-- ----------------------------------------------
-- Engine table
-- ----------------------------------------------
CREATE TABLE IF NOT EXISTS engine (
  id           INTEGER PRIMARY KEY AUTOINCREMENT,
  name         TEXT NOT NULL,
  manufacturer TEXT NOT NULL
);

INSERT INTO engine (name, manufacturer) VALUES ('Ferrari 064', 'Ferrari');
INSERT INTO engine (name, manufacturer) VALUES ('Honda RA619H', 'Honda');
INSERT INTO engine (name, manufacturer) VALUES ('Mercedes M10 EQ Power+', 'Mercedes');
INSERT INTO engine (name, manufacturer) VALUES ('Renault E-Tech 19', 'Renault');


-- ----------------------------------------------
-- Entrant table
-- ----------------------------------------------
CREATE TABLE IF NOT EXISTS entrant (
  id         INTEGER PRIMARY KEY AUTOINCREMENT,
  full_name  TEXT    NOT NULL,
  short_name TEXT    NOT NULL,
  chassis    INTEGER NOT NULL,
  engine     INTEGER NOT NULL,

  CONSTRAINT entrant_chassis_id_fk
    FOREIGN KEY (chassis) REFERENCES chassis (id),
  CONSTRAINT entrant_engine_id_fk
    FOREIGN KEY (engine) REFERENCES engine (id)
);

INSERT INTO entrant (full_name, short_name, chassis, engine) VALUES ('Mercedes AMG Petronas Motorsport', 'Mercedes', 2, 3);
INSERT INTO entrant (full_name, short_name, chassis, engine) VALUES ('Scuderia Ferrari Mission Winnow', 'Ferrari', 8, 1);
INSERT INTO entrant (full_name, short_name, chassis, engine) VALUES ('Aston Martin Red Bull Racing', 'Red Bull Racing', 6, 2);
INSERT INTO entrant (full_name, short_name, chassis, engine) VALUES ('Renault F1 Team', 'Renault', 7, 4);
INSERT INTO entrant (full_name, short_name, chassis, engine) VALUES ('Rich Energy Hass F1 Team', 'Haas', 10, 1);
INSERT INTO entrant (full_name, short_name, chassis, engine) VALUES ('Racing Point F1 Team', 'Racing Point', 5, 3);
INSERT INTO entrant (full_name, short_name, chassis, engine) VALUES ('Alfa Romeo Racing', 'Alfa Romeo', 1, 1);
INSERT INTO entrant (full_name, short_name, chassis, engine) VALUES ('Red Bull Toro Rosso Honda', 'Toro Rosso', 9, 2);
INSERT INTO entrant (full_name, short_name, chassis, engine) VALUES ('McLaren F1 Team', 'McLaren', 4, 4);
INSERT INTO entrant (full_name, short_name, chassis, engine) VALUES ('Williams Racing', 'Williams', 3, 3);


-- ----------------------------------------------
-- Event table
-- ----------------------------------------------
CREATE TABLE IF NOT EXISTS event (
  id           INTEGER PRIMARY KEY AUTOINCREMENT,
  full_name    TEXT NOT NULL,
  short_name   TEXT NOT NULL,
  sponsor_name TEXT,
  timezone     TEXT NOT NULL,
  event_type   TEXT NOT NULL
);

INSERT INTO event (full_name, short_name, timezone, event_type) VALUES ('Formula 1™ 2019 Pre-season Test One', 'Pre-season Test One', 'Europe/Madrid', 'TEST');
INSERT INTO event (full_name, short_name, timezone, event_type) VALUES ('Formula 1™ 2019 Pre-season Test Two', 'Pre-season Test Two', 'Europe/Madrid', 'TEST');
INSERT INTO event (full_name, short_name, sponsor_name, timezone, event_type) VALUES ('Formula 1™ Rolex Australian Grand Prix 2019', 'Australian Grand Prix', 'Rolex', 'Australia/Melbourne', 'RACE');
INSERT INTO event (full_name, short_name, sponsor_name, timezone, event_type) VALUES ('Formula 1™ Gulf Air Bahrain Grand Prix 2019', 'Bahrain Grand Prix', 'Gulf Air', 'Asia/Bahrain', 'RACE');
INSERT INTO event (full_name, short_name, sponsor_name, timezone, event_type) VALUES ('Formula 1™ Heineken Chinese Grand Prix 2019', 'Chinese Grand Prix', 'Heineken', 'CST', 'RACE');
INSERT INTO event (full_name, short_name, timezone, event_type) VALUES ('Formula 1™ Azerbaijan Grand Prix 2019', 'Azerbaijan Grand Prix', 'Asia/Baku', 'RACE');
INSERT INTO event (full_name, short_name, sponsor_name, timezone, event_type) VALUES ('Formula 1™ Emirates Gran Premio de España 2019', 'Spanish Grand Prix', 'Emirates', 'Europe/Madrid', 'RACE');
INSERT INTO event (full_name, short_name, timezone, event_type) VALUES ('Formula 1™ Grand Prix de Monaco 2019', 'Monaco Grand Prix', 'Europe/Monaco', 'RACE');
INSERT INTO event (full_name, short_name, sponsor_name, timezone, event_type) VALUES ('Formula 1™ Pirelli Grand Prix du Canada 2019', 'Canadian Grand Prix', 'Pirelli', 'America/Montreal', 'RACE');
INSERT INTO event (full_name, short_name, timezone, event_type) VALUES ('Formula 1™ Grand Prix de France 2019', 'French Grand Prix', 'Europe/Paris', 'RACE');
INSERT INTO event (full_name, short_name, sponsor_name, timezone, event_type) VALUES ('Formula 1™ MyWorld Grosser Preis von Osterreich 2019', 'Austrian Grand Prix', 'MyWorld', 'Europe/Vienna', 'RACE');
INSERT INTO event (full_name, short_name, sponsor_name, timezone, event_type) VALUES ('Formula 1™ Rolex British Grand Prix 2019', 'British Grand Prix', 'Rolex', 'Europe/London', 'RACE');
INSERT INTO event (full_name, short_name, sponsor_name, timezone, event_type) VALUES ('Formula 1™ Mercedes Benz Grosser Preis von Deutschland 2019', 'German Grand Prix', 'Mercedes Benz', 'Europe/Berlin', 'RACE');
INSERT INTO event (full_name, short_name, timezone, event_type) VALUES ('Formula 1™ Magyar Nagydij 2019', 'Hungarian Grand Prix', 'Europe/Budapest', 'RACE');
INSERT INTO event (full_name, short_name, sponsor_name, timezone, event_type) VALUES ('Formula 1™ Johnnie Walker Belgian Grand Prix 2019', 'Belgian Grand Prix', 'Johnnie Walker', 'Europe/Brussels', 'RACE');
INSERT INTO event (full_name, short_name, sponsor_name, timezone, event_type) VALUES ('Formula 1™ Gran Premio Heineken d''Italia 2019', 'Italian Grand Prix', 'Heineken', 'Europe/Rome', 'RACE');
INSERT INTO event (full_name, short_name, sponsor_name, timezone, event_type) VALUES ('Formula 1™ Singapore Airlines Singapore Grand Prix 2019', 'Singapore Grand Prix', 'Singapore Airlines', 'Asia/Singapore', 'RACE');
INSERT INTO event (full_name, short_name, sponsor_name, timezone, event_type) VALUES ('Formula 1™ VTB Russian Grand Prix 2019', 'Russian Grand Prix', 'VTB', 'Europe/Moscow', 'RACE');
INSERT INTO event (full_name, short_name, timezone, event_type) VALUES ('Formula 1™ Japanese Grand Prix 2019', 'Japanese Grand Prix', 'Asia/Tokyo', 'RACE');
INSERT INTO event (full_name, short_name, timezone, event_type) VALUES ('Formula 1™ Gran Premio de Mexico 2019', 'Mexican Grand Prix', 'America/Mexico_City', 'RACE');
INSERT INTO event (full_name, short_name, timezone, event_type) VALUES ('Formula 1™ United States Grand Prix 2019', 'US Grand Prix', 'US/Central', 'RACE');
INSERT INTO event (full_name, short_name, timezone, event_type) VALUES ('Formula 1™ Grande Premio do Brasil 2019', 'Brazilian Grand Prix', 'America/Sao_Paulo', 'RACE');
INSERT INTO event (full_name, short_name, sponsor_name, timezone, event_type) VALUES ('Formula 1™ Etihad Airways Abu Dhabi Grand Prix 2019', 'Abu Dhabi Grand Prix', 'Etihad Airways', '', 'RACE');


-- ----------------------------------------------
-- Pilot table
-- ----------------------------------------------
CREATE TABLE IF NOT EXISTS pilot (
  id          TEXT PRIMARY KEY,
  first_name  TEXT    NOT NULL,
  last_name   TEXT    NOT NULL,
  tla         TEXT    NOT NULL,
  number      INTEGER NOT NULL,
  nationality TEXT    NOT NULL,
  team        INTEGER NOT NULL,

  CONSTRAINT pilot_team_id_fk
    FOREIGN KEY (team) REFERENCES entrant (id)
) WITHOUT ROWID;

INSERT INTO pilot (id, first_name, last_name, tla, number, nationality, team) VALUES ('2001_RAI', 'Kimi', 'Räikkonen', 'RAI', 7, 'FIN', 1);
INSERT INTO pilot (id, first_name, last_name, tla, number, nationality, team) VALUES ('2006_KUB', 'Robert', 'Kubica', 'KUB', 88, 'POL', 7);
INSERT INTO pilot (id, first_name, last_name, tla, number, nationality, team) VALUES ('2007_HAM', 'Lewis', 'Hamilton', 'HAM', 44, 'GBR', 6);
INSERT INTO pilot (id, first_name, last_name, tla, number, nationality, team) VALUES ('2007_VET', 'Sebastian', 'Vettel', 'VET', 5, 'DEU', 3);
INSERT INTO pilot (id, first_name, last_name, tla, number, nationality, team) VALUES ('2009_GRO', 'Romain', 'Grosjean', 'GRO', 8, 'FRA', 2);
INSERT INTO pilot (id, first_name, last_name, tla, number, nationality, team) VALUES ('2010_HUL', 'Nico', 'Hulkenberg', 'HUL', 27, 'DEU', 10);
INSERT INTO pilot (id, first_name, last_name, tla, number, nationality, team) VALUES ('2011_PER', 'Segio', 'Pérez', 'PER', 11, 'MEX', 8);
INSERT INTO pilot (id, first_name, last_name, tla, number, nationality, team) VALUES ('2011_RIC', 'Daniel', 'Ricciardo', 'RIC', 3, 'AUS', 10);
INSERT INTO pilot (id, first_name, last_name, tla, number, nationality, team) VALUES ('2013_BOT', 'Valtteri', 'Bottas', 'BOT', 77, 'FIN', 6);
INSERT INTO pilot (id, first_name, last_name, tla, number, nationality, team) VALUES ('2014_KVY', 'Daniil', 'Kvyat', 'KVY', 26, 'RUS', 5);
INSERT INTO pilot (id, first_name, last_name, tla, number, nationality, team) VALUES ('2014_MAG', 'Kevin', 'Magnussen', 'MAG', 20, 'DEN', 2);
INSERT INTO pilot (id, first_name, last_name, tla, number, nationality, team) VALUES ('2015_SAI', 'Carlos', 'Sainz', 'SAI', 55, 'ESP', 9);
INSERT INTO pilot (id, first_name, last_name, tla, number, nationality, team) VALUES ('2015_VER', 'Max', 'Verstappen', 'VER', 33, 'NLD', 4);
INSERT INTO pilot (id, first_name, last_name, tla, number, nationality, team) VALUES ('2017_GAS', 'Pierre', 'Gasly', 'GAS', 10, 'FRA', 4);
INSERT INTO pilot (id, first_name, last_name, tla, number, nationality, team) VALUES ('2017_GIO', 'Antonio', 'Giovinazzi', 'GIO', 99, 'ITA', 1);
INSERT INTO pilot (id, first_name, last_name, tla, number, nationality, team) VALUES ('2017_STR', 'Lance', 'Stroll', 'STR', 18, 'CAN', 8);
INSERT INTO pilot (id, first_name, last_name, tla, number, nationality, team) VALUES ('2018_LEC', 'Charles', 'Leclerc', 'LEC', 16, 'MON', 3);
INSERT INTO pilot (id, first_name, last_name, tla, number, nationality, team) VALUES ('2019_ALB', 'Alex', 'Albon', 'ALB', 23, 'THA', 5);
INSERT INTO pilot (id, first_name, last_name, tla, number, nationality, team) VALUES ('2019_NOR', 'Lando', 'Norris', 'NOR', 4, 'GBR', 9);
INSERT INTO pilot (id, first_name, last_name, tla, number, nationality, team) VALUES ('2019_RUS', 'George', 'Russell', 'RUS', 63, 'GBR', 7);

CREATE TABLE IF NOT EXISTS event_session (
  id           INTEGER NOT NULL,
  event_id     INTEGER NOT NULL,
  session_id   INTEGER NOT NULL,
  session_name TEXT    NOT NULL,
  session_type TEXT    NOT NULL,

  CONSTRAINT event_session_pk
    PRIMARY KEY (id),
  CONSTRAINT event_session_event_id_fk
    FOREIGN KEY (event_id) REFERENCES event (id),
  CONSTRAINT event_session_id_event_session_uindex
    UNIQUE (id, event_id, session_id)

) WITHOUT ROWID;

INSERT INTO event_session (id, event_id, session_id, session_name, session_type) VALUES (1, 1, 1, 'Morning Session', 'TEST');
INSERT INTO event_session (id, event_id, session_id, session_name, session_type) VALUES (2, 1, 2, 'Afternoon Session', 'TEST');
INSERT INTO event_session (id, event_id, session_id, session_name, session_type) VALUES (3, 1, 3, 'Morning Session', 'TEST');
INSERT INTO event_session (id, event_id, session_id, session_name, session_type) VALUES (4, 1, 4, 'Afternoon Session', 'TEST');
INSERT INTO event_session (id, event_id, session_id, session_name, session_type) VALUES (5, 1, 5, 'Morning Session', 'TEST');
INSERT INTO event_session (id, event_id, session_id, session_name, session_type) VALUES (6, 1, 6, 'Afternoon Session', 'TEST');
INSERT INTO event_session (id, event_id, session_id, session_name, session_type) VALUES (7, 1, 7, 'Morning Session', 'TEST');
INSERT INTO event_session (id, event_id, session_id, session_name, session_type) VALUES (8, 1, 8, 'Afternoon Session', 'TEST');
INSERT INTO event_session (id, event_id, session_id, session_name, session_type) VALUES (9, 2, 1, 'Morning Session', 'TEST');
INSERT INTO event_session (id, event_id, session_id, session_name, session_type) VALUES (10, 2, 2, 'Afternoon Session', 'TEST');
INSERT INTO event_session (id, event_id, session_id, session_name, session_type) VALUES (11, 2, 3, 'Morning Session', 'TEST');
INSERT INTO event_session (id, event_id, session_id, session_name, session_type) VALUES (12, 2, 4, 'Afternoon Session', 'TEST');
INSERT INTO event_session (id, event_id, session_id, session_name, session_type) VALUES (13, 2, 5, 'Morning Session', 'TEST');
INSERT INTO event_session (id, event_id, session_id, session_name, session_type) VALUES (14, 2, 6, 'Afternoon Session', 'TEST');
INSERT INTO event_session (id, event_id, session_id, session_name, session_type) VALUES (15, 2, 7, 'Morning Session', 'TEST');
INSERT INTO event_session (id, event_id, session_id, session_name, session_type) VALUES (16, 2, 8, 'Afternoon Session', 'TEST');
INSERT INTO event_session (id, event_id, session_id, session_name, session_type) VALUES (17, 3, 1, 'Practice One', 'PRACTICE');
INSERT INTO event_session (id, event_id, session_id, session_name, session_type) VALUES (18, 3, 2, 'Practice Two', 'PRACTICE');
INSERT INTO event_session (id, event_id, session_id, session_name, session_type) VALUES (19, 3, 3, 'Practice Three', 'PRACTICE');
INSERT INTO event_session (id, event_id, session_id, session_name, session_type) VALUES (20, 3, 4, 'Qualifying', 'QUALIFYING');
INSERT INTO event_session (id, event_id, session_id, session_name, session_type) VALUES (21, 3, 5, 'Race', 'RACE');
INSERT INTO event_session (id, event_id, session_id, session_name, session_type) VALUES (22, 4, 1, 'Practice One', 'PRACTICE');
INSERT INTO event_session (id, event_id, session_id, session_name, session_type) VALUES (23, 4, 2, 'Practice Two', 'PRACTICE');
INSERT INTO event_session (id, event_id, session_id, session_name, session_type) VALUES (24, 4, 3, 'Practice Three', 'PRACTICE');
INSERT INTO event_session (id, event_id, session_id, session_name, session_type) VALUES (25, 4, 4, 'Qualifying', 'QUALIFYING');
INSERT INTO event_session (id, event_id, session_id, session_name, session_type) VALUES (26, 4, 5, 'Race', 'RACE');
INSERT INTO event_session (id, event_id, session_id, session_name, session_type) VALUES (27, 5, 1, 'Practice One', 'PRACTICE');
INSERT INTO event_session (id, event_id, session_id, session_name, session_type) VALUES (28, 5, 2, 'Practice Two', 'PRACTICE');
INSERT INTO event_session (id, event_id, session_id, session_name, session_type) VALUES (29, 5, 3, 'Practice Three', 'PRACTICE');
INSERT INTO event_session (id, event_id, session_id, session_name, session_type) VALUES (30, 5, 4, 'Qualifying', 'QUALIFYING');
INSERT INTO event_session (id, event_id, session_id, session_name, session_type) VALUES (31, 5, 5, 'Race', 'RACE');
INSERT INTO event_session (id, event_id, session_id, session_name, session_type) VALUES (32, 6, 1, 'Practice One', 'PRACTICE');
INSERT INTO event_session (id, event_id, session_id, session_name, session_type) VALUES (33, 6, 2, 'Practice Two', 'PRACTICE');
INSERT INTO event_session (id, event_id, session_id, session_name, session_type) VALUES (34, 6, 3, 'Practice Three', 'PRACTICE');
INSERT INTO event_session (id, event_id, session_id, session_name, session_type) VALUES (35, 6, 4, 'Qualifying', 'QUALIFYING');
INSERT INTO event_session (id, event_id, session_id, session_name, session_type) VALUES (36, 6, 5, 'Race', 'RACE');
INSERT INTO event_session (id, event_id, session_id, session_name, session_type) VALUES (37, 7, 1, 'Practice One', 'PRACTICE');
INSERT INTO event_session (id, event_id, session_id, session_name, session_type) VALUES (38, 7, 2, 'Practice Two', 'PRACTICE');
INSERT INTO event_session (id, event_id, session_id, session_name, session_type) VALUES (39, 7, 3, 'Practice Three', 'PRACTICE');
INSERT INTO event_session (id, event_id, session_id, session_name, session_type) VALUES (40, 7, 4, 'Qualifying', 'QUALIFYING');
INSERT INTO event_session (id, event_id, session_id, session_name, session_type) VALUES (41, 7, 5, 'Race', 'RACE');
INSERT INTO event_session (id, event_id, session_id, session_name, session_type) VALUES (42, 8, 1, 'Practice One', 'PRACTICE');
INSERT INTO event_session (id, event_id, session_id, session_name, session_type) VALUES (43, 8, 2, 'Practice Two', 'PRACTICE');
INSERT INTO event_session (id, event_id, session_id, session_name, session_type) VALUES (44, 8, 3, 'Practice Three', 'PRACTICE');
INSERT INTO event_session (id, event_id, session_id, session_name, session_type) VALUES (45, 8, 4, 'Qualifying', 'QUALIFYING');
INSERT INTO event_session (id, event_id, session_id, session_name, session_type) VALUES (46, 8, 5, 'Race', 'RACE');
INSERT INTO event_session (id, event_id, session_id, session_name, session_type) VALUES (47, 9, 1, 'Practice One', 'PRACTICE');
INSERT INTO event_session (id, event_id, session_id, session_name, session_type) VALUES (48, 9, 2, 'Practice Two', 'PRACTICE');
INSERT INTO event_session (id, event_id, session_id, session_name, session_type) VALUES (49, 9, 3, 'Practice Three', 'PRACTICE');
INSERT INTO event_session (id, event_id, session_id, session_name, session_type) VALUES (50, 9, 4, 'Qualifying', 'QUALIFYING');
INSERT INTO event_session (id, event_id, session_id, session_name, session_type) VALUES (51, 9, 5, 'Race', 'RACE');

CREATE TABLE IF NOT EXISTS event_session_time (
  id              INTEGER  NOT NULL,
  start_timestamp TEXT NOT NULL,
  end_timestamp   TEXT NOT NULL,

  CONSTRAINT event_session_time_pk
    PRIMARY KEY (id),
  CONSTRAINT event_session_time_start_uindex
    UNIQUE (start_timestamp),
  CONSTRAINT event_session_time_end_uindex
    UNIQUE (end_timestamp)
) WITHOUT ROWID;

INSERT INTO event_session_time (id, start_timestamp, end_timestamp) VALUES (1 , '2019-02-18 09:00:00.000', '2019-02-18 13:00:00.000');
INSERT INTO event_session_time (id, start_timestamp, end_timestamp) VALUES (2 , '2019-02-18 14:00:00.000', '2019-02-18 18:00:00.000');
INSERT INTO event_session_time (id, start_timestamp, end_timestamp) VALUES (3 , '2019-02-19 09:00:00.000', '2019-02-19 13:00:00.000');
INSERT INTO event_session_time (id, start_timestamp, end_timestamp) VALUES (4 , '2019-02-19 14:00:00.000', '2019-02-19 18:00:00.000');
INSERT INTO event_session_time (id, start_timestamp, end_timestamp) VALUES (5 , '2019-02-20 09:00:00.000', '2019-02-20 13:00:00.000');
INSERT INTO event_session_time (id, start_timestamp, end_timestamp) VALUES (6 , '2019-02-20 14:00:00.000', '2019-02-20 18:00:00.000');
INSERT INTO event_session_time (id, start_timestamp, end_timestamp) VALUES (7 , '2019-02-21 09:00:00.000', '2019-02-21 13:00:00.000');
INSERT INTO event_session_time (id, start_timestamp, end_timestamp) VALUES (8 , '2019-02-21 14:00:00.000', '2019-02-21 18:00:00.000');
INSERT INTO event_session_time (id, start_timestamp, end_timestamp) VALUES (9 , '2019-02-26 09:00:00.000', '2019-02-26 13:00:00.000');
INSERT INTO event_session_time (id, start_timestamp, end_timestamp) VALUES (10 , '2019-02-26 14:00:00.000', '2019-02-26 18:00:00.000');
INSERT INTO event_session_time (id, start_timestamp, end_timestamp) VALUES (11 , '2019-02-27 09:00:00.000', '2019-02-27 13:00:00.000');
INSERT INTO event_session_time (id, start_timestamp, end_timestamp) VALUES (12 , '2019-02-27 14:00:00.000', '2019-02-27 18:00:00.000');
INSERT INTO event_session_time (id, start_timestamp, end_timestamp) VALUES (13 , '2019-02-28 09:00:00.000', '2019-02-28 13:00:00.000');
INSERT INTO event_session_time (id, start_timestamp, end_timestamp) VALUES (14 , '2019-02-28 14:00:00.000', '2019-02-28 18:00:00.000');
INSERT INTO event_session_time (id, start_timestamp, end_timestamp) VALUES (15 , '2019-02-29 09:00:00.000', '2019-02-29 13:00:00.000');
INSERT INTO event_session_time (id, start_timestamp, end_timestamp) VALUES (16 , '2019-02-29 14:00:00.000', '2019-02-29 18:00:00.000');


CREATE TABLE session_lap_time (
  event_session_id INTEGER NOT NULL,
  pilot_id         TEXT    NOT NULL,
  lap_time         INTEGER NOT NULL,

  CONSTRAINT session_lap_time_event_session_id_fk
    FOREIGN KEY (event_session_id) REFERENCES event_session (id),
  CONSTRAINT session_lap_time_pilot_id_fx
    FOREIGN KEY (pilot_id) REFERENCES pilot (id)

) WITHOUT ROWID;