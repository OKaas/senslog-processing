INSERT INTO enum_item (id, code, description) VALUES (1, 'unit.type.gateway', 'Unit representing gateway of sensor network');
INSERT INTO enum_item (id, code, description) VALUES (2, 'unit.type.machine', 'Mobile unit deployed on agriculture machinery');
INSERT INTO enum_item (id, code, description) VALUES (3, 'unit.type.node', 'Static measure node deployed in field');
INSERT INTO enum_item (id, code, description) VALUES (4, 'unit.type.smartphone', 'Mobile smartphone');
INSERT INTO enum_item (id, code, description) VALUES (5, 'unit.type.testing', 'Unit for testing purposes');
INSERT INTO enum_item (id, code, description) VALUES (6, 'unit.type.virtual', 'Virtual unit with sensors from different real units');
INSERT INTO enum_item (id, code, description) VALUES (7, 'unit.type.undefined', 'Undefined unit');

-- INSERT unit_group
INSERT INTO unit_group (id, description) VALUES (1, 'admin');
INSERT INTO unit_group (id, description) VALUES (2, 'kojcice');
INSERT INTO unit_group (id, description) VALUES (3, 'chabicovice');
INSERT INTO unit_group (id, description) VALUES (4, 'ground_water');
INSERT INTO unit_group (id, description) VALUES (5, 'lipo_crisis_mngmt');
INSERT INTO unit_group (id, description) VALUES (6, 'chabi_virt');
INSERT INTO unit_group (id, description) VALUES (7, 'sigfox_test');

-- INSER unit
INSERT INTO unit (id, description, is_mobile, uuid, unit_group_id, unit_type_id) VALUES (1, 'automaticaly added unit', true, '0', 7, 7);