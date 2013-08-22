PRAGMA foreign_keys=OFF;
BEGIN TRANSACTION;
CREATE TABLE User (
id INTEGER PRIMARY KEY AUTOINCREMENT,
account_name varchar(255),
password varchar(255),
user_role int
);
INSERT INTO "User" VALUES(1,'gzmask','121212',1);
INSERT INTO "User" VALUES(2,'daisy','123456',2);
INSERT INTO "User" VALUES(3,'ricky','123456',2);
CREATE TABLE User_role (
id INTEGER PRIMARY KEY AUTOINCREMENT,
role_name varchar(255)
);
INSERT INTO "User_role" VALUES(1,'developer');
INSERT INTO "User_role" VALUES(2,'manager');
INSERT INTO "User_role" VALUES(3,'customer');
CREATE TABLE Item (
id INTEGER PRIMARY KEY AUTOINCREMENT,
item_name varchar(255),
item_type int,
plucode varchar(255),
price float,
cost float,
user_id int
);
CREATE TABLE Item_type (
id INTEGER PRIMARY KEY AUTOINCREMENT,
type_name varchar(255)
);
CREATE TABLE Invoice (
id INTEGER PRIMARY KEY AUTOINCREMENT,
total INTEGER,
timestamp INTEGER,
refund Boolean
);
CREATE TABLE Item_sold (
id INTEGER PRIMARY KEY AUTOINCREMENT,
item_name varchar(255),
item_type int,
plucode varchar(255),
price float,
cost float,
user_id int,
invoice_id int
, refund Boolean);
CREATE TABLE Version (
id INTEGER PRIMARY KEY AUTOINCREMENT,
timestamp varchar(255)
);
INSERT INTO "Version" VALUES(1,'201308031310');
DELETE FROM sqlite_sequence;
INSERT INTO "sqlite_sequence" VALUES('User_role',3);
INSERT INTO "sqlite_sequence" VALUES('User',3);
INSERT INTO "sqlite_sequence" VALUES('Version',1);
COMMIT;
