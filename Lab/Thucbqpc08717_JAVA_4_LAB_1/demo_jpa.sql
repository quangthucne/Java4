CREATE DATABASE demo_jpa
use demo_jpa

CREATE TABLE users (
    user_id INT IDENTITY PRIMARY KEY NOT NULL,
    username VARCHAR(100) NOT NULL,
    password varchar(100) NOT NULL,
    name text NOT NULL,
    email text NOT NULL,
    address text NOT NULL,
    role int CONSTRAINT [DEFAULT_users_role] DEFAULT (1) NOT NULL
)

INSERT INTO users (username, [password], name, email, address)
VALUES ('abc', 'abc', 'abc', 'abc', 'abc')