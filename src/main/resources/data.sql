
-- INPUT DUMMY DATA FOR DEVELOPMENT

-- TESTING INSERT POSITION
INSERT INTO phenomenon(id, description, physical_unit) VALUES (1, 'phenomenon.position.test', 'phenomenon.position.test');
INSERT INTO unit_group (id, description) VALUES (1, 'unit_group.position.test');
INSERT INTO unit (id, description, id_unit_group) VALUES (1, 'unit.position.test', 1);
-----------------------------------------------------------------------


-- TESTING INSERT OBSERVATION

INSERT INTO metadata(id, code, description, value) VALUES (2, 'metadata.observation.test', 'metadata.observation.test', 'metadata.observation.test');
INSERT INTO phenomenon(id, description, physical_unit) VALUES (2, 'phenomenon.observation.test', 'phenomenon.observation.test');

INSERT INTO unit_group (id, description) VALUES (2, 'unit_group.observation.test');
INSERT INTO unit (id, description, id_unit_group) VALUES (2, 'unit.observation.test', 2);

INSERT INTO sensor(id, description, id_metadata, id_phenomenon, id_unit) VALUES (1, 'sensor.observation.test', 2, 2, 2);
-----------------------------------------------------------------------

-- TESTING INSERT EVENT
INSERT INTO enum_item (id, code, description) VALUES (3, 'event.state.unprocessed', 'Unprocessed event');
INSERT INTO event_code(id, code, description) VALUES (3, 'event_code.event.test', 'event_code.event.test');
INSERT INTO unit_group (id, description) VALUES (3, 'unit_group.event.test');
INSERT INTO unit (id, description, id_unit_group) VALUES (3, 'unit.event.test', 3);
-----------------------------------------------------------------------


-- HIERARCHY
-----------------------------------------------------------------------
--INSERT INTO hierarchy(
--            id, name)
--    VALUES (1, 'first hierarchy');


-- UNIT
-----------------------------------------------------------------------
--INSERT INTO unit(
--            id, description, id_hierarchy)
--    VALUES ( 1, 'unit test', 1);

-- SENSOR
-----------------------------------------------------------------------
--INSERT INTO sensor(
--            id, id_phenomenon, id_unit)
--    VALUES (1, 1, 1);

-- EventCode
-----------------------------------------------------------------------
--INSERT INTO event_code(
--            id, code, description)
--    VALUES (1, 'RUNNING', 'heartbeat from unit');

-- USER
-----------------------------------------------------------------------
--INSERT INTO "user"(
--        id, name, email, password)
--    VALUES (1, 'admin', 'a@b.cz', 'admin');



--INSERT INTO unit_to_group(
--            id, unit_id, user_group_id)
--    VALUES (1, 1, 1);
--
--INSERT INTO unit_to_group(
--            id, unit_id, user_group_id)
--    VALUES (2, 2, 1);
--
--INSERT INTO unit_to_group(
--            id, unit_id, user_group_id)
--    VALUES (3, 3, 1);

-- POSITION
-----------------------------------------------------------------------

--INSERT INTO "position"(
--            id, altitude, dop, speed, time_received, time_stamp, unit_id)
--    VALUES (1, 1.1, 1.2, 1.3, '2017-09-14T03:34:13', '2017-09-14T03:34:13', 1);
--
--INSERT INTO "position"(
--            id, altitude, dop, speed, time_received, time_stamp, unit_id)
--    VALUES (2, 1.6, 1.7, 1.8, '2017-09-14T03:34:13', '2017-09-14T03:34:13', 1);
--
--INSERT INTO "position"(
--            id, altitude, dop, speed, time_received, time_stamp, unit_id)
--    VALUES (3, 999, 999, 999, '2018-03-30T03:33:33', '2018-03-30T03:33:33', 1);
--
--INSERT INTO "position"(
--            id, altitude, dop, speed, time_received, time_stamp, unit_id)
--    VALUES (4, 999, 999, 999, '2018-01-11T01:11:11', '2018-01-11T01:11:11', 1);
--
--INSERT INTO "position"(
--            id, altitude, dop, speed, time_received, time_stamp, unit_id)
--    VALUES (5, 999, 999, 999, '2018-02-22T02:22:22', '2018-02-22T02:22:22', 3);

-- PHENOMENON
-----------------------------------------------------------------------

--INSERT INTO phenomenon(id, name, unit_desc)
--    VALUES ( 1, 'first phenom', '1 m/s');
--
--INSERT INTO phenomenon(id, name, unit_desc)
--    VALUES ( 2, 'second phenom', '2 m/s');
--
--INSERT INTO phenomenon(id, name, unit_desc)
--    VALUES ( 3, 'third phenom', '3 m/s');
--
--INSERT INTO phenomenon(id, name, unit_desc)
--    VALUES ( 4, '4 phenom', '3 m/s');

-- SENSOR
-----------------------------------------------------------------------

--INSERT INTO sensor(id, name, type, phenomenon_id, unit_id)
--    VALUES ( 1, 'sensor1', 'test_sensor for 1 unit', 1, 1);
--
--INSERT INTO sensor(id, name, type, phenomenon_id, unit_id)
--    VALUES ( 2, 'sensor2', 'test_sensor for 2 unit', 2, 2);
--
--INSERT INTO sensor(id, name, type, phenomenon_id, unit_id)
--    VALUES ( 3, 'sensor3', 'test_sensor for 3 unit', 3, 3);
--
--INSERT INTO sensor(id, name, type, phenomenon_id, unit_id)
--    VALUES ( 4, 'sensor4', 'test_sensor for 3 unit', 4, 3);

-- OBSERVATION
-----------------------------------------------------------------------
--
--INSERT INTO observation(id, observed_value, time_received, time_stamp, sensor_id)
--    VALUES ( nextval('seq_observation'), 123, '2018-02-22T02:22:22', '2018-02-22T02:22:22', 1);
--
--INSERT INTO observation(id, observed_value, time_received, time_stamp, sensor_id)
--    VALUES ( nextval('seq_observation'), 145, '2018-03-03T03:33:33', '2018-03-03T03:33:33', 1);
--
--INSERT INTO observation(id, observed_value, time_received, time_stamp, sensor_id)
--    VALUES ( nextval('seq_observation'), 167, '2018-04-04T04:44:44', '2018-04-04T04:44:44', 1);
--
--INSERT INTO observation(id, observed_value, time_received, time_stamp, sensor_id)
--    VALUES ( nextval('seq_observation'), 189, '2018-05-05T05:55:55', '2018-05-05T05:55:55', 1);
--
--INSERT INTO observation(id, observed_value, time_received, time_stamp, sensor_id)
--    VALUES ( nextval('seq_observation'), 212, '2018-01-01T01:01:01', '2018-01-01T01:01:01', 2);
--
--INSERT INTO observation(id, observed_value, time_received, time_stamp, sensor_id)
--    VALUES ( nextval('seq_observation'), 213, '2018-02-02T02:02:02', '2018-02-02T02:02:02', 2);
--
--INSERT INTO observation(id, observed_value, time_received, time_stamp, sensor_id)
--    VALUES ( nextval('seq_observation'), 214, '2018-03-03T03:03:03', '2018-02-03T03:03:03', 2);

-- Alert
-----------------------------------------------------------------------
--INSERT INTO alert(id, description)
--    VALUES (1, '1 alert');
--
--INSERT INTO alert(id, description)
--    VALUES (2, '2 alert');
--
--INSERT INTO alert(id, description)
--    VALUES (3, '3 alert');

-- Enum item
-----------------------------------------------------------------------
--INSERT INTO enum_item(id, name)
--    VALUES (1, 'FIRST_ENUM');
--
--INSERT INTO enum_item(id, name)
--    VALUES (2, 'SECOND_ENUM');
--
--INSERT INTO enum_item(id, name)
--    VALUES (3, 'THIRD_ENUM');
