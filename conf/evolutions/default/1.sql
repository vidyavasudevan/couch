# --- !Ups

CREATE TABLE USER (
    id VARCHAR(40) NOT NULL,
    username VARCHAR(225) NOT NULL,
    email varchar(255) NOT NULL,
    password varchar(255) NOT NULL,
    fullname varchar(255) NOT NULL,
    location varchar(255),
    PRIMARY KEY (id)
);

CREATE TABLE STORY(
  id VARCHAR(40) NOT NULL,
  user_id VARCHAR(40),
  problem LONGTEXT NOT NULL,
  problemTags VARCHAR(200),
  solution LONGTEXT NOT NULL,
  solutionTags VARCHAR(200),
  PRIMARY KEY (id)
);

# --- !Downs

DROP TABLE USER;
DROP TABLE STORY;