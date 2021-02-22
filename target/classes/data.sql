DROP TABLE IF EXISTS offer;

CREATE TABLE offer (
   OFFER_ID  INT AUTO_INCREMENT  PRIMARY KEY,
  OFFER_LOCATION  VARCHAR(250) NOT NULL,
  OFFER_NAME  VARCHAR(250) NOT NULL,
  OFFER_VALID_FROM TIMESTAMP DEFAULT NULL,
  OFFER_VALID_TILL TIMESTAMP  DEFAULT NULL,
  IMAGES  VARCHAR(250) null
);

INSERT INTO offer ( OFFER_LOCATION,OFFER_NAME, OFFER_VALID_FROM,OFFER_VALID_TILL,IMAGES) VALUES
('Palakkad', 'Big','2021-02-22 17:40:08.762','2021-02-22 17:40:08.762','https://via.placeholder.com/600/92c952'),
('Nemmmara', 'small', '2021-02-22 17:40:08.762','2021-02-22 17:40:08.762','https://via.placeholder.com/600/92c952'),
('Folrunsho', 'Alakija', '2021-02-22 17:40:08.762','2021-02-22 17:40:08.762','https://via.placeholder.com/600/92c952'),
('Palakkad', 'Big','2021-02-22 17:40:08.762','2021-02-22 17:40:08.762','https://via.placeholder.com/600/92c952'),
('Nemmmara', 'small', '2021-02-22 17:40:08.762','2021-02-22 17:40:08.762','https://via.placeholder.com/600/92c952'),
('Folrunsho', 'Alakija', '2021-02-22 17:40:08.762','2021-02-22 17:40:08.762','https://via.placeholder.com/600/92c952'),
('Palakkad', 'Big','2021-02-22 17:40:08.762','2021-02-22 17:40:08.762','https://via.placeholder.com/600/92c952'),
('Nemmmara', 'small', '2021-02-22 17:40:08.762','2021-02-22 17:40:08.762','https://via.placeholder.com/600/92c952'),
('Folrunsho', 'Alakija', '2021-02-22 17:40:08.762','2021-02-22 17:40:08.762','https://via.placeholder.com/600/92c952'),
('Palakkad', 'Big','2021-02-22 17:40:08.762','2021-02-22 17:40:08.762','https://via.placeholder.com/600/92c952'),
('Nemmmara', 'small', '2021-02-22 17:40:08.762','2021-02-22 17:40:08.762','https://via.placeholder.com/600/92c952'),
('Folrunsho', 'Alakija', '2021-02-22 17:40:08.762','2021-02-22 17:40:08.762','https://via.placeholder.com/600/92c952'),
('Palakkad', 'Big','2021-02-22 17:40:08.762','2021-02-22 17:40:08.762','https://via.placeholder.com/600/92c952'),
('Nemmmara', 'small', '2021-02-22 17:40:08.762','2021-02-22 17:40:08.762','https://via.placeholder.com/600/92c952'),
('Folrunsho', 'Alakija', '2021-02-22 17:40:08.762','2021-02-22 17:40:08.762','https://via.placeholder.com/600/92c952');
