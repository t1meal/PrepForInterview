CREATE SCHEMA cinema;

CREATE TABLE cinema.films
(
    id       INT          NOT NULL AUTO_INCREMENT,
    title    VARCHAR(255) NOT NULL,
    duration INT          NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE cinema.sessions
(
    id        INT      NOT NULL AUTO_INCREMENT,
    film_id   INT      NOT NULL,
    beginning DATETIME NOT NULL,
    price     INT      NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT fk_films
        FOREIGN KEY (film_id)
            REFERENCES cinema.films (id)
);

CREATE TABLE cinema.tickets
(
    id         INT NOT NULL AUTO_INCREMENT,
    session_id INT NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT fk_session
        FOREIGN KEY (session_id)
            REFERENCES cinema.sessions (id)
);

INSERT INTO cinema.films (title, duration)
VALUES ('The Green Mile', '189'),
       ('Schindler''s List', '195'),
       ('The Shawshank Redemption', '142'),
       ('Forrest Gump', '152'),
       ('Coco', '105');

INSERT INTO cinema.sessions (film_id, beginning, price)
VALUES ('1', '2023-06-08 12:00', '220'),
       ('2', '2023-06-08 13:00', '240'),
       ('3', '2023-06-08 16:00', '240'),
       ('1', '2023-06-08 18:00', '300'),
       ('5', '2023-06-08 22:00', '150');

INSERT INTO cinema.tickets (session_id)
VALUES ('1'),       ('1'),       ('2'),       ('1'),       ('3'),       ('5'),       ('5'),       ('1'),
       ('4'),       ('5'),       ('2'),       ('4'),       ('1'),       ('5'),       ('4'),       ('2'),
       ('3'),       ('1'),       ('2'),       ('3'),       ('4'),       ('1'),       ('2'),       ('3'),
       ('4'),       ('5'),       ('1'),       ('2'),       ('3'),       ('4'),       ('5'),       ('2'),
       ('2'),       ('5'),       ('5'),       ('5'),       ('5'),       ('1'),       ('2'),       ('4'),
       ('4'),       ('2'),       ('2'),       ('1'),       ('2'),       ('4'),       ('2'),       ('1'),
       ('3'),       ('4'),       ('1'),       ('2'),       ('2'),       ('3');

# Запрос на наложение времени фильмов
SELECT t4.title,
       t3.beginning,
       t4.duration,
       t2.title,
       t1.beginning,
       t2.duration
FROM cinema.sessions AS t1
         LEFT JOIN cinema.films AS t2 ON t1.film_id = t2.id
         INNER JOIN cinema.sessions AS t3 ON t1.id <> t3.id
         LEFT JOIN cinema.films AS t4 ON t3.film_id = t4.id
WHERE t1.beginning < addtime(t3.beginning, SEC_TO_TIME(t4.duration * 60))
  AND t1.beginning > t3.beginning
ORDER BY (addtime(t3.beginning, SEC_TO_TIME(t4.duration * 60)) - t1.beginning);

# Запрос на перерывы
SELECT t2.title,
       t1.beginning,
       t2.duration,
       t3.beginning,
       TIMEDIFF(t3.beginning, addtime(t1.beginning, SEC_TO_TIME(t2.duration * 60))) AS pause
FROM cinema.sessions AS t1
         LEFT JOIN cinema.films AS t2 ON t1.film_id = t2.id
         INNER JOIN cinema.sessions AS t3 ON t1.id <> t3.id AND t1.beginning < t3.beginning
GROUP BY t1.id
HAVING pause > sec_to_time(30 * 60)
ORDER BY (pause) DESC;

# Запрос по статистике
SELECT films.title,
       COUNT(tickets.id)                               AS total_viewers,
       COUNT(tickets.id) / COUNT(DISTINCT sessions.id) AS average_viewers,
       SUM(sessions.price)                             AS total_profit
FROM cinema.films AS films
         LEFT JOIN cinema.sessions AS sessions ON films.id = sessions.film_id
         LEFT JOIN cinema.tickets AS tickets ON sessions.id = tickets.session_id
GROUP BY(films.id)
ORDER BY(total_profit) DESC;

