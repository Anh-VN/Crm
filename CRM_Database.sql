CREATE SCHEMA `crm` DEFAULT CHARACTER SET utf8;
USE crm;

CREATE TABLE IF NOT EXISTS roles (
	id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(50) NOT NULL,
    description VARCHAR(100),
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS users (
	id INT NOT NULL AUTO_INCREMENT,
    email VARCHAR(100) NOT NULL,
    password VARCHAR(100) NOT NULL,
    fullname VARCHAR(100) NOT NULL,
    avatar VARCHAR(100),
    role_id INT NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS status (
	id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(50) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS generaltasks (
	id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(50) NOT NULL,
    start_date date,
    end_date date,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS tasks (
	id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(50) NOT NULL,
    start_date date,
    end_date date,
    user_id INT NOT NULL,
    general_task_id INT NOT NULL,
    status_id INT NOT NULL,
    PRIMARY KEY (id)
);

ALTER TABLE users ADD FOREIGN KEY (role_id) REFERENCES roles (id)  ON DELETE CASCADE;
ALTER TABLE tasks ADD FOREIGN KEY (user_id) REFERENCES users (id)  ON DELETE CASCADE;
ALTER TABLE tasks ADD FOREIGN KEY (general_task_id) REFERENCES generaltasks (id)  ON DELETE CASCADE;
ALTER TABLE tasks ADD FOREIGN KEY (status_id) REFERENCES status (id)  ON DELETE CASCADE;

INSERT INTO roles( name, description ) VALUES ("ADMIN", "Quản trị hệ thống");
INSERT INTO roles( name, description ) VALUES ("LEADER", "Quản lý");
INSERT INTO roles( name, description ) VALUES ("MEMBER", "Nhân viên");

INSERT INTO status( name ) VALUES ("Chưa thực hiện");
INSERT INTO status( name ) VALUES ("Đang thực hiện");
INSERT INTO status( name ) VALUES ("Đã hoàn thành");

/* admin account:  email: admin@gmail.com, password: 1 */

INSERT INTO users(id, email, password, fullname, avatar, role_id) VALUES ('1', 'admin@gmail.com', '$2a$12$lX8XYxXbuvnHOsuhD9BDbegtCvK9EKAOfF9NT4gYL3ib9XaF5HW8a', 'Lê Văn Admin', 'sonu', '1');