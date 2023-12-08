-- テーブルの初期化
DROP TABLE IF EXISTS stocks CASCADE;
DROP TABLE IF EXISTS items CASCADE;

-- itemsテーブルの作成
CREATE TABLE items (
	id       SERIAL,
	name     VARCHAR(20) NOT NULL,
	price    INTEGER     NOT NULL,
	quantity INTEGER     NOT NULL
);
-- inventoriesテーブルの作成
CREATE TABLE stocks (
	id         SERIAL,
	item_id    INTEGER   NOT NULL,
	quantity   INTEGER   NOT NULL,
	checked_at TIMESTAMP NOT NULL DEFAULT current_timestamp
);

-- itemsテーブルの主キー設定
ALTER TABLE items ADD CONSTRAINT pk_items PRIMARY KEY (id);
-- inventoriesテーブルの主キー設定
ALTER TABLE stocks ADD CONSTRAINT pk_stocks PRIMARY KEY (id);
-- inventoriesテーブルの外部キー設定
ALTER TABLE stocks ADD CONSTRAINT fk_stocks FOREIGN KEY (item_id) REFERENCES items(id);
