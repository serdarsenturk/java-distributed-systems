START TRANSACTION;
INSERT INTO movie (id, originalTitle, title, genre, movieType) VALUES (1, 'A', 'B', 'C', 2);
INSERT INTO series_movie (id, seasons, episodes) VALUES (1,'Asd', 13);
COMMIT;
