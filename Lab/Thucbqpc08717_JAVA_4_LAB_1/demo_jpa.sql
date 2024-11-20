CREATE DATABASE demo_jpa
use demo_jpa

CREATE TABLE users (
    user_id INT IDENTITY PRIMARY KEY NOT NULL,
    username VARCHAR(100) NOT NULL,
    password varchar(100) NOT NULL,
    name text NOT NULL,
    email text NOT NULL,
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

CREATE TABLE categories (
    categories_id INT PRIMARY KEY NOT NULL,
    categories_name text NOT NULL
)

CREATE table images (
    images_id int PRIMARY KEY NOT NULL,
    images_name text NOT NULL,
    product_id INT FOREIGN KEY NOT NULL;
)

CREATE TABLE products (
    product_id int PRIMARY KEY NOT NULL,
    product_name text NOT NULL,
    product_price INT NOT NULL,
    product_quantity INT NOT NULL,
    categories_id int NOT NULL,
    REFERENCES categories_id FOREIGN KEY categories(categories_id)
)

INSERT INTO users (username, [password], name, email, address)
VALUES ('abc', 'abc', 'abc', 'abc', 'abc')


select * from address