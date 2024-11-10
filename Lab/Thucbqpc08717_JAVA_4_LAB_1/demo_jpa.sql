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

CREATE TABLE address (
    address_id int IDENTITY NOT NULL PRIMARY KEY,
    customer_name text NOT NULL, 
    phone_number VARCHAR(14) NOT NULL,
    address text not NULL,
    user_id int NOT NULL,
        FOREIGN KEY (user_id) REFERENCES users(user_id)

)

CREATE TABLE [order] (
    order_id int IDENTITY NOT NULL PRIMARY KEY,
    user_id int NOT NULL,
    address_id int NOT NULL,
    status int NOT NULL,
    FOREIGN key (user_id) REFERENCES users(user_id),
    FOREIGN KEY (address_id) REFERENCES address(address_id)
)

INSERT INTO users (username, [password], name, email, address)
VALUES ('abc', 'abc', 'abc', 'abc', 'abc')