CREATE DATABASE PolyOE
use PolyOE

create table Users (
    id NVARCHAR(20) NOT NULL PRIMARY KEY,
    PASSWORD NVARCHAR(50) NOT NULL,
    fullname NVARCHAR(50) NOT NULL,
    email NVARCHAR(50) NOT NULL,
    admin BIT NOT NULL
)


-- Insert 15 records into the Users table
INSERT INTO Users (id, PASSWORD, fullname, email, admin) VALUES
('U01', 'password123', 'John Doe', 'user1@gmail.com', 0),
('U02', 'password123', 'Jane Smith', 'user2@fpt.edu.vn', 1),
('U03', 'password123', 'Alice Johnson', 'user3@ctu.edu.vn', 0),
('U04', 'password123', 'Robert Brown', 'user4@gmail.com', 1),
('U05', 'password123', 'Emily Davis', 'user5@fpt.edu.vn', 0),
('U06', 'password123', 'Michael Wilson', 'user6@ctu.edu.vn', 1),
('U07', 'password123', 'Jessica Taylor', 'user7@gmail.com', 0),
('U08', 'password123', 'Daniel Thomas', 'user8@fpt.edu.vn', 1),
('U09', 'password123', 'Laura White', 'user9@ctu.edu.vn', 0),
('U10', 'password123', 'Kevin Moore', 'user10@gmail.com', 1),
('U11', 'password123', 'Sarah Green', 'user11@fpt.edu.vn', 0),
('U12', 'password123', 'David Hall', 'user12@ctu.edu.vn', 1),
('U13', 'password123', 'Emma King', 'user13@gmail.com', 0),
('U14', 'password123', 'James Scott', 'user14@fpt.edu.vn', 1),
('U15', 'password123', 'Olivia Young', 'user15@ctu.edu.vn', 0);
