CREATE SCHEMA IF NOT EXISTS "recipes_ai";

CREATE TABLE IF NOT EXISTS users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(200) NOT NULL,
    last_name VARCHAR(200),
    first_name VARCHAR(200),
    email VARCHAR(100) UNIQUE,
    country VARCHAR(100),
    password VARCHAR(10) NOT NULL,
    user_role VARCHAR(100),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    last_login TIMESTAMP,
    is_active BOOLEAN DEFAULT TRUE,
    CONSTRAINT uc_username UNIQUE (username)
);

CREATE SEQUENCE IF NOT EXISTS seq_unique_user_id
INCREMENT 1
START WITH 10000000;
