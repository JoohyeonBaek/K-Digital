DROP DATABASE IF EXISTS tsunmoon;
CREATE DATABASE IF NOT EXISTS tsunmoon;
USE tsunmoon;

CREATE TABLE `pet` (
	`name` VARCHAR(10) NOT NULL COLLATE 'utf8_general_ci',
	`owner` VARCHAR(10) NOT NULL COLLATE 'utf8_general_ci',
	`species` VARCHAR(10) NOT NULL COLLATE 'utf8_general_ci',
	`sex` CHAR(1) NOT NULL COLLATE 'utf8_general_ci',
	`birth` DATE NOT NULL,
	`death` DATE NULL DEFAULT NULL
)
COLLATE='utf8_general_ci'
ENGINE=InnoDB
;

INSERT INTO pet(NAME, OWNER, species, sex, birth, death) values("유리", "종호", "고양이", "f", "2014-01-01", "2014-01-01");
INSERT INTO pet(NAME, OWNER, species, sex, birth, death) values("귀염", "종호", "강아지", "f", "2014-01-01", "2014-01-01");
INSERT INTO pet(NAME, OWNER, species, sex, birth, death) values("곰돌이", "종호", "곰", "f", "2014-01-01", "2014-01-01");
INSERT INTO pet(NAME, OWNER, species, sex, birth, death) values("인천시", "민주", "cat", "f", "2001-02-04", NULL);
INSERT INTO pet(NAME, OWNER, species, sex, birth, death) values("대구시", "자유", "cat", "f", "2010-03-17", NULL);
INSERT INTO pet(NAME, OWNER, species, sex, birth, death) values("대전시", "민주", "dog", "f", "2010-05-13", NULL);
INSERT INTO pet(NAME, OWNER, species, sex, birth, death) values("광주시", "민주", "dog", "m", "2015-08-27", NULL);
INSERT INTO pet(NAME, OWNER, species, sex, birth, death) values("부산시", "자유", "dog", "m", "2017-08-31", "2018-04-29");
INSERT INTO pet(NAME, OWNER, species, sex, birth, death) values("인천시", "민주", "cat", "f", "2001-02-04", NULL);
INSERT INTO pet(NAME, OWNER, species, sex, birth, death) values("대구시", "자유", "cat", "f", "2010-03-17", NULL);
INSERT INTO pet(NAME, OWNER, species, sex, birth, death) values("대전시", "민주", "dog", "f", "2010-05-13", NULL);
INSERT INTO pet(NAME, OWNER, species, sex, birth, death) values("광주시", "민주", "dog", "m", "2015-08-27", NULL);
INSERT INTO pet(NAME, OWNER, species, sex, birth, death) values("부산시", "자유", "dog", "m", "2017-08-31", "2018-04-29");

UPDATE pet SET NAME="두부" WHERE NAME="귀염";
DELETE from pet WHERE NAME="곰돌이";
SELECT * FROM pet;