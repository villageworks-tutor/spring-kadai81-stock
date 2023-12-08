-- テーブルを初期化
DELETE FROM stocks;
DELETE FROM items;
-- itemsテーブルのサンプルレコード
INSERT INTO items (name, price, quantity) VALUES ('ルームデニムジャケット', 4000, 3);
INSERT INTO items (name, price, quantity) VALUES ('ふんわりワンピース', 5000, 5);
INSERT INTO items (name, price, quantity) VALUES ('2wayトレンチコート', 30000, 4);
-- stocksテーブルのサンプルレコード
INSERT INTO stocks (item_id, quantity, checked_at) VALUES (1, 3, '2020/04/12 10:00:00');
INSERT INTO stocks (item_id, quantity, checked_at) VALUES (1, 1, '2020/04/13 11:00:00');
INSERT INTO stocks (item_id, quantity, checked_at) VALUES (1, -1, '2020/04/14 12:00:00');
