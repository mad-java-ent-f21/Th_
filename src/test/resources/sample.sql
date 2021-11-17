delete from th_db.trim;
delete from transmission;
delete from model_color;
delete from model;
delete from engine;
delete from drive_train;
delete from brand;
delete from country;
delete from color;

ALTER TABLE brand auto_increment = 1;
alter table color auto_increment = 1;
alter table country auto_increment = 1;
alter table drive_train auto_increment = 1;
alter table engine auto_increment = 1;
alter table model auto_increment = 1;
alter table transmission auto_increment = 1;
alter table th_db.trim auto_increment = 1;

INSERT INTO th_db.color (id, name, code) VALUES (2, 'green', 456456345);
INSERT INTO th_db.color (id, name, code) VALUES (3, 'black', 342524525);
INSERT INTO th_db.color (id, name, code) VALUES (4, 'white', 232545234);
INSERT INTO th_db.color (id, name, code) VALUES (5, 'gray', 56744356);

INSERT INTO th_db.country (id, name) VALUES (13, 'Germany');
INSERT INTO th_db.country (id, name) VALUES (12, 'Japan');
INSERT INTO th_db.country (id, name) VALUES (14, 'Korea');
INSERT INTO th_db.country (id, name) VALUES (9, 'United States');

INSERT INTO th_db.brand (id, name, country_id) VALUES (1, 'Ford', 9);
INSERT INTO th_db.brand (id, name, country_id) VALUES (2, 'BMW', 13);

INSERT INTO th_db.drive_train (id, type) VALUES (3, 'new');

INSERT INTO th_db.engine (id, type, displacement, cylinder_count, voltage, energy_consumption, description) VALUES (2, '2', 35, 8, 300, 70, 'about ...');

INSERT INTO th_db.model (id, name, year, seats, description, brand_id) VALUES (1, 'b34', 2020, 4, '23423', 1);
INSERT INTO th_db.model (id, name, year, seats, description, brand_id) VALUES (2, 'new 3', 2020, 1, '100', 2);

INSERT INTO th_db.model_color (color_id, model_id) VALUES (2, 1);
INSERT INTO th_db.model_color (color_id, model_id) VALUES (4, 1);
INSERT INTO th_db.model_color (color_id, model_id) VALUES (4, 2);

INSERT INTO th_db.transmission (id, name, automatic, gears) VALUES (1, 'test', 0, 5);
INSERT INTO th_db.transmission (id, name, automatic, gears) VALUES (2, 'new transmission', 0, 23);

INSERT INTO th_db.trim (id, name, description, model_id, engine_id, drive_train_id, transmission_id, fuel_consumption, forced_induction) VALUES (1, 'sfgsdfg', 'iii', 2, 2, 3, 2, 345, 'sdfsdf');
