INSERT INTO BUILDING(id, name) VALUES(1, 'MA GROSSE MAISON');

INSERT INTO ROOM(id, name, floor, current_temperature, target_temperature, building_id) VALUES(1, 'Room 1', 1, 22.3, 20.0, 1);
INSERT INTO ROOM(id, name, floor, building_id) VALUES(2, 'Room 2', 1, 1);
INSERT INTO ROOM(id, name, floor, building_id) VALUES(3, 'Room 3', 1, 1);
INSERT INTO ROOM(id, name, floor, building_id) VALUES(4, 'Room 4', 1, 1);
INSERT INTO ROOM(id, name, floor, building_id) VALUES(5, 'Room 5', 1, 1);
INSERT INTO ROOM(id, name, floor, building_id) VALUES(6, 'Room 6', 1, 1);
INSERT INTO ROOM(id, name, floor, building_id) VALUES(7, 'Room 7', 1, 1);
INSERT INTO ROOM(id, name, floor, building_id) VALUES(8, 'Room 8', 1, 1);
INSERT INTO ROOM(id, name, floor, building_id) VALUES(9, 'Room 9', 1, 1);
INSERT INTO ROOM(id, name, floor, building_id) VALUES(10, 'Room 10', 1, 1);
INSERT INTO ROOM(id, name, floor, building_id) VALUES(11, 'Room 11', 1, 1);
INSERT INTO ROOM(id, name, floor, building_id) VALUES(12, 'Room 12', 1, 1);
INSERT INTO ROOM(id, name, floor, building_id) VALUES(13, 'Room 13', 1, 1);
INSERT INTO ROOM(id, name, floor, building_id) VALUES(14, 'Room 14', 1, 1);
INSERT INTO ROOM(id, name, floor, building_id) VALUES(15, 'Room 15', 1, 1);
INSERT INTO ROOM(id, name, floor, building_id) VALUES(16, 'Room 16', 1, 1);
INSERT INTO ROOM(id, name, floor, building_id) VALUES(17, 'Room 17', 1, 1);
INSERT INTO ROOM(id, name, floor, building_id) VALUES(18, 'Room 18', 1, 1);


INSERT INTO HEATER(id, heater_status, name, power, room_id) VALUES(1, 'ON', 'Heater 1', 2000, 1);
INSERT INTO HEATER(id, heater_status, name, power, room_id) VALUES(2, 'OFF', 'Heater 2', null, 1);

INSERT INTO RWINDOW(id, window_status, name, room_id) VALUES(1, 'CLOSED', 'Window 1', 1);
INSERT INTO RWINDOW(id, window_status, name, room_id) VALUES(2, 'CLOSED', 'Window 2', 1);
INSERT INTO RWINDOW(id, window_status, name, room_id) VALUES(3, 'CLOSED', 'Window 1', 2);
INSERT INTO RWINDOW(id, window_status, name, room_id) VALUES(4, 'OPEN', 'Window 2', 2);