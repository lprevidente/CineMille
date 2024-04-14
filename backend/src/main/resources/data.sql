/* @formatter:off */
delete from screening_film;
ALTER TABLE screening_film AUTO_INCREMENT = 1;

delete from film;
ALTER TABLE film AUTO_INCREMENT = 1;

delete from room;
ALTER TABLE room AUTO_INCREMENT = 1;
/* @formatter:on */

insert into room (name, capacity, i_max)
values ('Sala 1', 200, false),
       ('Sala 2', 128, false),
       ('Sala 3', 250, true),
       ('Sala 4', 54, false),
       ('Sala 5', 100, false),
       ('Sala 6', 300, true),
       ('Sala 7', 150, false),
       ('Sala 8', 147, false),
       ('Sala 9', 200, true),
       ('Sala 10', 69, false),
       ('Sala 11', 120, false),
       ('Sala 12', 100, false);

/* @formatter:off */
insert into film (name, description, release_date, duration_in_minutes)
values ('Le ali della libertà', 'Due uomini imprigionati si legano nel corso di molti anni, trovando consolazione e alla fine la redenzione attraverso atti di decenza comune.', '1994-09-22', 142),
       ('Il padrino', 'Il patriarca invecchiato di una dinastia del crimine organizzato trasferisce il controllo del suo impero clandestino al suo riluttante figlio.', '1972-03-24', 175),
       ('Il cavaliere oscuro', 'Quando la minaccia conosciuta come il Joker semina il caos e il disordine tra la gente di Gotham, Batman deve accettare una delle più grandi prove psicologiche e fisiche della sua capacità di combattere l\'ingiustizia.', '2008-07-18', 152),
       ('Pulp Fiction', 'Le vite di due sicari della mafia, un pugile, un gangster e sua moglie, e una coppia di banditi da diner si intrecciano in quattro storie di violenza e redenzione.', '1994-10-14', 154),
       ('Fight Club', 'Un impiegato insonne e un produttore di sapone spensierato formano un club di lotta sotterraneo che si evolve in qualcosa di molto più grande.', '1999-10-15', 139),
       ('Il buono, il brutto, il cattivo', 'Una storia del west durante la guerra civile americana che segue tre pistoleri che cercano un tesoro sepolto.', '1966-12-23', 178),
       ('Forrest Gump', 'La storia della vita di un uomo semplice con buone intenzioni, ma con un basso quoziente intellettivo.', '1994-07-06', 142),
       ('C\'era una volta in America', 'Un ex gangster torna nel vecchio quartiere, dove riflette sulla sua vita e sulle scelte che ha fatto.', '1984-05-23', 229),
       ('Via col vento', 'La figlia di un ricco proprietario di piantagioni deve usare ogni mezzo a sua disposizione per tornare a casa dopo la guerra civile americana.', '1939-12-15', 238),
       ('2001: Odissea nello spazio', 'Dopo la scoperta di un misterioso monolito sulla luna, una missione con equipaggio umano viene inviata a Giove.', '1968-04-02', 149),
       ('Il padrino - Parte II', 'La storia della famiglia Corleone continua con Michael al potere e suo padre Vito che cresce in Sicilia.', '1974-12-20', 202),
       ('Il silenzio degli innocenti', 'Un giovane agente dell\'FBI cerca l\'aiuto di un incarcerato e manipolatore cannibale per catturare un serial killer.', '1991-02-14', 118),
       ('Schindler\'s List', 'La storia vera di Oskar Schindler, un imprenditore tedesco che salva più di mille ebrei polacchi durante l\'Olocausto.', '1993-12-15', 195),
       ('Il Signore degli Anelli: Il ritorno del re', 'Gandalf e Aragorn guidano il Mondo degli Uomini contro l\'esercito di Sauron per distrarre il suo occhio dal portatore dell\'anello.', '2003-12-17', 201),
       ('Matrix', 'Un programmatore di computer scopre una realtà simulata e si unisce a una ribellione contro i suoi sovrani.', '1999-03-31', 136);
/* @formatter:on  */

insert into screening_film (id, film_id, room_id, date, start_time)
values (1, 1, 1, '2022-12-01', '18:00:00'),
       (2, 2, 2, '2022-12-02', '20:00:00'),
       (3, 3, 3, '2022-12-03', '16:00:00'),
       (4, 4, 4, '2022-12-04', '19:00:00'),
       (5, 5, 5, '2022-12-05', '21:00:00'),
       (6, 6, 6, '2022-12-06', '17:00:00'),
       (7, 7, 7, '2022-12-07', '15:00:00'),
       (8, 8, 8, '2022-12-08', '14:00:00'),
       (9, 9, 9, '2022-12-09', '16:00:00'),
       (10, 10, 10, '2022-12-10', '18:00:00'),
       (11, 11, 11, '2022-12-11', '20:00:00'),
       (12, 12, 12, '2022-12-12', '19:00:00'),
       (13, 13, 1, '2022-12-13', '21:00:00'),
       (14, 14, 2, '2022-12-14', '16:00:00'),
       (15, 15, 3, '2022-12-15', '18:00:00'),
       (16, 1, 1, CURDATE(), '18:00:00'),
       (17, 2, 2, DATE_ADD(CURDATE(), INTERVAL 1 DAY), '20:00:00'),
       (18, 3, 3, DATE_ADD(CURDATE(), INTERVAL 2 DAY), '16:00:00'),
       (19, 4, 4, DATE_ADD(CURDATE(), INTERVAL 3 DAY), '19:00:00'),
       (20, 5, 5, DATE_ADD(CURDATE(), INTERVAL 4 DAY), '21:00:00'),
       (21, 6, 6, DATE_ADD(CURDATE(), INTERVAL 5 DAY), '17:00:00'),
       (22, 7, 7, DATE_ADD(CURDATE(), INTERVAL 6 DAY), '15:00:00'),
       (23, 8, 8, DATE_ADD(CURDATE(), INTERVAL 7 DAY), '14:00:00'),
       (24, 9, 9, DATE_ADD(CURDATE(), INTERVAL 8 DAY), '16:00:00'),
       (25, 10, 10, DATE_ADD(CURDATE(), INTERVAL 9 DAY), '18:00:00'),
       (26, 1, 1, DATE_ADD(CURDATE(), INTERVAL 1 DAY), '10:00:00'),
       (27, 1, 1, DATE_ADD(CURDATE(), INTERVAL 1 DAY), '14:00:00'),
       (28, 1, 1, DATE_ADD(CURDATE(), INTERVAL 1 DAY), '18:00:00'),
       (29, 2, 2, DATE_ADD(CURDATE(), INTERVAL 2 DAY), '10:00:00'),
       (30, 2, 2, DATE_ADD(CURDATE(), INTERVAL 2 DAY), '14:00:00'),
       (31, 2, 2, DATE_ADD(CURDATE(), INTERVAL 2 DAY), '18:00:00'),
       (32, 3, 3, DATE_ADD(CURDATE(), INTERVAL 3 DAY), '10:00:00'),
       (33, 3, 3, DATE_ADD(CURDATE(), INTERVAL 3 DAY), '14:00:00'),
       (34, 3, 3, DATE_ADD(CURDATE(), INTERVAL 3 DAY), '18:00:00'),
       (35, 4, 4, DATE_ADD(CURDATE(), INTERVAL 4 DAY), '10:00:00'),
       (36, 4, 4, DATE_ADD(CURDATE(), INTERVAL 4 DAY), '14:00:00'),
       (37, 4, 4, DATE_ADD(CURDATE(), INTERVAL 4 DAY), '18:00:00'),
       (38, 5, 5, DATE_ADD(CURDATE(), INTERVAL 5 DAY), '10:00:00'),
       (39, 5, 5, DATE_ADD(CURDATE(), INTERVAL 5 DAY), '14:00:00'),
       (40, 5, 5, DATE_ADD(CURDATE(), INTERVAL 5 DAY), '18:00:00'),
       (41, 6, 6, DATE_ADD(CURDATE(), INTERVAL 6 DAY), '10:00:00'),
       (42, 6, 6, DATE_ADD(CURDATE(), INTERVAL 6 DAY), '14:00:00'),
       (43, 6, 6, DATE_ADD(CURDATE(), INTERVAL 6 DAY), '18:00:00'),
       (44, 7, 7, DATE_ADD(CURDATE(), INTERVAL 7 DAY), '10:00:00'),
       (45, 7, 7, DATE_ADD(CURDATE(), INTERVAL 7 DAY), '14:00:00'),
       (46, 7, 7, DATE_ADD(CURDATE(), INTERVAL 7 DAY), '18:00:00'),
       (47, 8, 8, DATE_ADD(CURDATE(), INTERVAL 8 DAY), '10:00:00'),
       (48, 8, 8, DATE_ADD(CURDATE(), INTERVAL 8 DAY), '14:00:00'),
       (49, 8, 8, DATE_ADD(CURDATE(), INTERVAL 8 DAY), '18:00:00');