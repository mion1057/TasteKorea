-- ====================================
--			[Region]
-- ====================================	
DROP TABLE Region;

CREATE TABLE Region (
	id			BIGINT			PRIMARY KEY		AUTO_INCREMENT,
	
	kor			VARCHAR(50) 	NOT NULL,
	eng			VARCHAR(50)		NOT NULL,
	guide		BOOLEAN			NOT NULL		DEFAULT FALSE,
	
	regDate		TIMESTAMP		NOT NULL		DEFAULT CURRENT_TIMESTAMP,
	updateDate	TIMESTAMP		NOT NULL		DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
)AUTO_INCREMENT = 10000001;

SELECT * FROM Region;



-- insert region data --
INSERT INTO Region(kor, eng, guide) VALUES('서울', 'Seoul', true);
INSERT INTO Region(kor, eng, guide) VALUES('부산', 'Busan', true);
INSERT INTO Region(kor, eng, guide) VALUES('대구', 'Daegu', true);
INSERT INTO Region(kor, eng, guide) VALUES('광주', 'Gwangju', true);
INSERT INTO Region(kor, eng, guide) VALUES('제주', 'Jeju', true);
INSERT INTO Region(kor, eng, guide) VALUES('인천', 'Incheon', true);
INSERT INTO Region(kor, eng, guide) VALUES('춘천', 'Chuncheon', true);
INSERT INTO Region(kor, eng, guide) VALUES('울릉도', 'Ulleungdo', true);
INSERT INTO Region(kor, eng, guide) VALUES('평양', 'Pyongyang', true);


INSERT INTO Region(kor, eng, guide) VALUES('중국', 'China', false);
INSERT INTO Region(kor, eng, guide) VALUES('일본', 'Japan', false);
INSERT INTO Region(kor, eng, guide) VALUES('대만', 'Taiwan', false);
INSERT INTO Region(kor, eng, guide) VALUES('미국', 'USA', false);
INSERT INTO Region(kor, eng, guide) VALUES('홍콩', 'HonKong', false);
INSERT INTO Region(kor, eng, guide) VALUES('태국', 'Thailand', false);
INSERT INTO Region(kor, eng, guide) VALUES('말레이시아', 'Malaysia', false);
INSERT INTO Region(kor, eng, guide) VALUES('베트남', 'Vietnam', false);
INSERT INTO Region(kor, eng, guide) VALUES('필리핀', 'Philippines', false);
INSERT INTO Region(kor, eng, guide) VALUES('러시아,', 'Russia,', false);
INSERT INTO Region(kor, eng, guide) VALUES('인도네시아', 'Indonesia', false);
INSERT INTO Region(kor, eng, guide) VALUES('싱가포르', 'Singapore', false);
INSERT INTO Region(kor, eng, guide) VALUES('캐나다', 'Canada', false);
INSERT INTO Region(kor, eng, guide) VALUES('호주', 'Austrailia', false);
INSERT INTO Region(kor, eng, guide) VALUES('영국', 'United Kingdom', false);
INSERT INTO Region(kor, eng, guide) VALUES('터키', 'Turkey', false);








-- ====================================
--			[ForeignLanguage]
-- ====================================	
DROP TABLE LanguageSkill;
DROP TABLE ForeignLanguage;

CREATE TABLE ForeignLanguage (
	id			BIGINT			PRIMARY KEY		AUTO_INCREMENT,
	kor			VARCHAR(50) 	NOT NULL		DEFAULT '영어',
	eng			VARCHAR(50)		NOT NULL		DEFAULT	'English',	
	
	regDate		TIMESTAMP		NOT NULL		DEFAULT CURRENT_TIMESTAMP,
	updateDate	TIMESTAMP		NOT NULL		DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
)AUTO_INCREMENT = 10000001;


INSERT INTO ForeignLanguage(kor, eng) VALUES('영어', 'English');
INSERT INTO ForeignLanguage(kor, eng) VALUES('중국어', 'Chinese');
INSERT INTO ForeignLanguage(kor, eng) VALUES('러시아어', 'Russian');
INSERT INTO ForeignLanguage(kor, eng) VALUES('일본어', 'Japanese');
INSERT INTO ForeignLanguage(kor, eng) VALUES('스페인어', 'Spanish');
INSERT INTO ForeignLanguage(kor, eng) VALUES('프랑스어', 'French');
INSERT INTO ForeignLanguage(kor, eng) VALUES('아랍어', 'Arabic');
INSERT INTO ForeignLanguage(kor, eng) VALUES('포르투갈어', 'Portuguese');
INSERT INTO ForeignLanguage(kor, eng) VALUES('독일어', 'Deutsch');
INSERT INTO ForeignLanguage(kor, eng) VALUES('이탈리아어', 'Italian');
INSERT INTO ForeignLanguage(kor, eng) VALUES('한국어', 'Korean');


SELECT * FROM ForeignLanguage;


-- ====================================
--			[TasteMember]
-- ====================================	
DROP TABLE LanguageSkill;
DROP TABLE AppReply;
DROP TABLE TasteMember ;

CREATE TABLE TasteMember(
	id				BIGINT			PRIMARY KEY AUTO_INCREMENT,
	regionId		BIGINT 			NOT NULL,
	
	email 			VARCHAR(30) 	NOT NULL,
	passwd 			VARCHAR(20) 	NOT NULL, 
	guide 			BOOLEAN 		NOT NULL	DEFAULT FALSE,
	firstName		VARCHAR(30)		NOT NULL,
	lastName		VARCHAR(30)		NOT NULL,
	phone			VARCHAR(20),
	ssn				VARCHAR(6),
	sex				CHAR(1)			NOT NULL,
	alias			VARCHAR(20),
	profileImage	VARCHAR(120),
	introduction 	VARCHAR(100),
	
	regDate 		TIMESTAMP		NOT NULL	DEFAULT CURRENT_TIMESTAMP,
	updateDate		TIMESTAMP		NOT NULL	DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
	
	CONSTRAINT 		TasteMember_regionId_FK FOREIGN KEY(regionId) REFERENCES Region(id)
)AUTO_INCREMENT = 15000001;

ALTER TABLE TasteMember MODIFY COLUMN sex CHAR(1) DEFAULT 'x' NOT NULL;
ALTER TABLE TasteMember MODIFY COLUMN sex CHAR(1);
ALTER TABLE TasteMember ADD region VARCHAR(20) NOT NULL DEFAULT '서울';
ALTER TABLE TasteMember ADD alias VARCHAR(20)

SELECT * FROM TasteMember c ;




-- ====================================
--			[LanguageSkill]
-- ====================================	
DROP TABLE LanguageSkill;

CREATE TABLE LanguageSkill(
	id				BIGINT         PRIMARY KEY AUTO_INCREMENT,
	memberId		BIGINT         NOT NULL,
	languageId		BIGINT         NOT NULL,
	
	skillLevel		DOUBLE         NOT NULL,
	
	regDate			TIMESTAMP      NOT NULL   DEFAULT CURRENT_TIMESTAMP,
	updateDate		TIMESTAMP      NOT NULL   DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
	
	CONSTRAINT LanguageSkill_memberId_FK FOREIGN KEY(memberId) REFERENCES TasteMember(id),
	CONSTRAINT LanguageSkill_languageId_FK FOREIGN KEY(languageId) REFERENCES ForeignLanguage(id)
)AUTO_INCREMENT = 2000001;


-- ====================================
--			[PinCategory]
-- ====================================	
DROP TABLE PinCategory;

CREATE TABLE PinCategory(
	id		BIGINT		PRIMARY KEY AUTO_INCREMENT,
	
	kor		VARCHAR(30)	NOT NULL,
	eng		VARCHAR(30)	NOT NULL,
	
	regDate 		TIMESTAMP		NOT NULL	DEFAULT CURRENT_TIMESTAMP,
	updateDate		TIMESTAMP		NOT NULL	DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP

)AUTO_INCREMENT = 1000001;

-- ====================================
--				[Pin]
-- ====================================	
DROP TABLE Pin;

CREATE TABLE Pin(
	id				BIGINT			PRIMARY KEY AUTO_INCREMENT,
	categoryId		BIGINT 			NOT NULL,
	memberId		BIGINT 			NOT NULL,
	regionId		BIGINT			NOT NULL,
	
	imagePath		VARCHAR(50)		NOT NULL,
	title			VARCHAR(50)		NOT NULL,
	description		VARCHAR(1000)	NOT NULL,
	mapData			VARCHAR(100)	NOT NULL,
	
	likeCount		BIGINT			NOT NULL,
	dislikeCount	BIGINT			NOT NULL,
	
	regDate         TIMESTAMP      NOT NULL   DEFAULT CURRENT_TIMESTAMP,
  	updateDate      TIMESTAMP      NOT NULL   DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  	
  	CONSTRAINT Pin_categoryId_FK	FOREIGN KEY(categoryId) REFERENCES PinCategory(id),
	CONSTRAINT Pin_memberId_FK	FOREIGN KEY(memberId) REFERENCES TasteMember(id),
	CONSTRAINT Pin_regionId_FK	FOREIGN KEY(regionId) REFERENCES Region(id)
)AUTO_INCREMENT = 30000001

SELECT * FROM Pin;


-- ====================================
--			[Article]
-- ====================================
DROP TABLE Article;

CREATE TABLE Article (
	id 				BIGINT			PRIMARY KEY AUTO_INCREMENT,			-- articleId
	memberId		BIGINT			NOT NULL,				-- 작성자 id
	
	title 			VARCHAR(80)		NOT NULL,
	content			LONG VARCHAR	NOT NULL,
	category		INTEGER			NOT NULL,
	
	pics			BOOLEAN			NOT NULL	DEFAULT false,	-- 이미지 존재 여부
	video			BOOLEAN			NOT NULL	DEFAULT false,	-- 영상 존재 여부
	pinned			BOOLEAN			NOT NULL	DEFAULT false,	-- 상단 고정 여부
	
	hits			INTEGER			NOT NULL	DEFAULT 0,
	likeCount		INTEGER			NOT NULL	DEFAULT 0,
	
	regDate 		TIMESTAMP		NOT NULL	DEFAULT CURRENT_TIMESTAMP,
	updateDate		TIMESTAMP		NOT NULL	DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
	
	CONSTRAINT Article_memberId_FK 
		FOREIGN KEY(memberId) REFERENCES TasteMember(id)
)AUTO_INCREMENT = 5000001;


SELECT * FROM Article ORDER BY regDate DESC;



-- ====================================
--			[AppReply]
-- ====================================
DROP TABLE AppReply;

CREATE TABLE AppReply (
	id				BIGINT			PRIMARY KEY AUTO_INCREMENT,
	masterId		BIGINT			NOT NULL,
	parentId		BIGINT			NULL,
	memberId		BIGINT			NOT NULL,
	
	appCode			INTEGER			NOT NULL,
	comment			VARCHAR(1000)	NOT NULL,
	recipient		VARCHAR(25),
	priority		INTEGER			NOT NULL	DEFAULT '100',
	
	likeCount		INTEGER			NOT NULL	DEFAULT '0',
	dislikeCount	INTEGER			NOT NULL	DEFAULT '0',
	
	CONSTRAINT AppReply_memberId_FK FOREIGN KEY (memberId) REFERENCES TasteMember(id)
)AUTO_INCREMENT = 7000001;


SELECT r.id, r.parentId, r.comment, r.recipient, r.priority, r.likeCount, 
	r.dislikeCount, r.regDate, r.updateDate, m.id, m.alias, m.profileImage 
	FROM AppReply r INNER JOIN TasteMember m ON r.memberId = m.id 
	WHERE r.appCode=?1 AND r.parentId IS NULL
	ORDER BY r.regDate DESC;
	
			+ " ,    "
			+ " r.regDate, r.updateDate,"
			+ " pv.pid, pv.alias, pv.memberType, pv.level, pv.iconPath ) "
			+ " "
			+ " INNER JOIN Personacon_VIEW pv ON r.personacon = pv.pid "
			+ " WHERE r.appCode=?1 AND r.replyType = ?2 AND r.parentId IS NULL "
			+ " AND r.rid > 0 "
			+ " ORDER BY r.regDate DESC




