-- ====================================
--         [TasteMember]
-- ====================================   
CREATE TABLE TasteMember(
	id				BIGINT			PRIMARY KEY AUTO_INCREMENT,
	email			VARCHAR(30)		NOT NULL,
	passwd			VARCHAR(20)		NOT NULL,
	guide			BOOLEAN			NOT NULL default FALSE,
   
	firstName		VARCHAR(30)		NOT NULL,
	lastName		VARCHAR(30)      NOT NULL,
	region			VARCHAR(30)      NOT NULL,
	sex           CHAR(1)        NOT NULL,
   
	phone         VARCHAR(20),
	ssn            VARCHAR(6),
 	profileImage   VARCHAR(120),
	introduction   VARCHAR(100),
     
    regDate         TIMESTAMP      NOT NULL   DEFAULT CURRENT_TIMESTAMP,
   updateDate      TIMESTAMP      NOT NULL   DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
)AUTO_INCREMENT = 15000001;



-- ====================================
--         [ForeignLanguage]
-- ====================================   
CREATE TABLE ForeignLanguage (
   id           BIGINT         PRIMARY KEY AUTO_INCREMENT,
   
   kor          VARCHAR(50)    NOT NULL   DEFAULT '영어',
   eng          VARCHAR(50)   NOT NULL   DEFAULT 'English',
   
   regDate      TIMESTAMP      NOT NULL   DEFAULT CURRENT_TIMESTAMP,
   updateDate   TIMESTAMP      NOT NULL   DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
)AUTO_INCREMENT = 10000001;



-- insert lang data --
INSERT INTO ForeignLanguage(kor, eng) VALUES('영어', 'English');
INSERT INTO ForeignLanguage(kor, eng) VALUES('스페인어', 'Spanish');
INSERT INTO ForeignLanguage(kor, eng) VALUES('포르투갈어', 'Portuguese');
INSERT INTO ForeignLanguage(kor, eng) VALUES('프랑스어', 'French');
INSERT INTO ForeignLanguage(kor, eng) VALUES('독일어', 'Deutsch');
INSERT INTO ForeignLanguage(kor, eng) VALUES('이탈리아어', 'Italian');
INSERT INTO ForeignLanguage(kor, eng) VALUES('일본어', 'Japanese');
INSERT INTO ForeignLanguage(kor, eng) VALUES('중국어', 'Chinese');