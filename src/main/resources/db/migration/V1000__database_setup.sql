CREATE TABLE user (
  id BIGINT NOT NULL AUTO_INCREMENT,
  password VARCHAR(60) NOT NULL,
  email VARCHAR(60) NOT NULL,
  name VARCHAR(60) NOT NULL,
  enabled boolean NOT NULL default true,
  role varchar(16) NOT NULL default 'USER',
  PRIMARY KEY (`id`),
  UNIQUE INDEX `email_unique` (`email` ASC)
);

CREATE TABLE task (
  id BIGINT NOT NULL AUTO_INCREMENT,
  title VARCHAR(60) NOT NULL,
  description VARCHAR(60) NOT NULL,
  date_time timestamp NOT NULL,
  state ENUM('NOT_COMPLETED', 'COMPLETED') NOT NULL,
  user_id BIGINT NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
);