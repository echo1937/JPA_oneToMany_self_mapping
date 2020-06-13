INSERT INTO jpa_test.category (id, name, parent_id) VALUES (1, '家用电器', null);
INSERT INTO jpa_test.category (id, name, parent_id) VALUES (2, '电脑', 1);
INSERT INTO jpa_test.category (id, name, parent_id) VALUES (3, '笔记本电脑', 2);
INSERT INTO jpa_test.category (id, name, parent_id) VALUES (4, '手机', 1);
INSERT INTO jpa_test.category (id, name, parent_id) VALUES (5, '智能机', 4);
INSERT INTO jpa_test.category (id, name, parent_id) VALUES (6, '老人机', 4);

INSERT INTO jpa_test.area (id, name, parent_id) VALUES (1, '广东省', null);
INSERT INTO jpa_test.area (id, name, parent_id) VALUES (2, '广州市', 1);
INSERT INTO jpa_test.area (id, name, parent_id) VALUES (3, '天河区', 2);
INSERT INTO jpa_test.area (id, name, parent_id) VALUES (4, '湛江市', 1);
INSERT INTO jpa_test.area (id, name, parent_id) VALUES (5, '霞山区', 4);