



/* Drop Tables */

DROP TABLE item_inventory CASCADE CONSTRAINTS;
DROP TABLE item CASCADE CONSTRAINTS;
DROP TABLE category CASCADE CONSTRAINTS;
DROP TABLE image CASCADE CONSTRAINTS;



/* Drop Sequences */

DROP SEQUENCE SEQ_category_category_id;
DROP SEQUENCE SEQ_item_item_id;
DROP SEQUENCE SEQ_item_inventory_inv_id;
DROP SEQUENCE SEQ_image_image_id;




/* Create Sequences */

CREATE SEQUENCE SEQ_category_category_id INCREMENT BY 1 START WITH 1;
CREATE SEQUENCE SEQ_item_item_id INCREMENT BY 1 START WITH 1;
CREATE SEQUENCE SEQ_item_inventory_inv_id INCREMENT BY 1 START WITH 1;
CREATE SEQUENCE SEQ_image_image_id INCREMENT BY 1 START WITH 1;



/* Create Tables */

CREATE TABLE category
(
	category_id number(10,0) NOT NULL,
	category_name varchar2(30) NOT NULL,
	activity_status varchar2(5) DEFAULT 'A' NOT NULL,
	PRIMARY KEY (category_id)
);


CREATE TABLE item
(
	item_id number(10,0) NOT NULL,
	item_name varchar2(40) NOT NULL,
	item_description varchar2(100),
	activity_status varchar2(5) DEFAULT 'A' NOT NULL,
	category_id number(10,0) NOT NULL UNIQUE,
	PRIMARY KEY (item_id)
);


CREATE TABLE item_inventory
(
	item_inventory_id number(10,0) NOT NULL,
	quantity_available number(7,0) NOT NULL,
	unit_price number(19,4) NOT NULL,
	color varchar2(20),
	itm_size number(10,4),
	weight number(10,4),
	size_measurement_unit varchar2(10),
	weight_measurement_unit varchar2(10),
	start_date date NOT NULL,
	end_date date,
	activity_status varchar2(5) NOT NULL,
	item_id number(10,0) NOT NULL UNIQUE,
	image_id number(10,0) NOT NULL UNIQUE,
	PRIMARY KEY (item_inventory_id)
);


CREATE TABLE image
(
	image_id number(10,0) NOT NULL,
	image_file_name varchar2(40) NOT NULL,
	image_key varchar2(100) NOT NULL UNIQUE,
	PRIMARY KEY (image_id)
);



/* Create Foreign Keys */

ALTER TABLE item
	ADD FOREIGN KEY (category_id)
	REFERENCES category (category_id)
;


ALTER TABLE item_inventory
	ADD FOREIGN KEY (item_id)
	REFERENCES item (item_id)
;


ALTER TABLE item_inventory
	ADD FOREIGN KEY (image_id)
	REFERENCES image (image_id)
;
