-- Create roles table
CREATE TABLE roles (
    id SERIAL PRIMARY KEY,
    name VARCHAR(20) UNIQUE NOT NULL
);

-- Create users table
CREATE TABLE users (
    id BIGSERIAL PRIMARY KEY,
    username VARCHAR(50) UNIQUE NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL,
    enabled BOOLEAN DEFAULT TRUE
);

-- Create user_roles join table
CREATE TABLE user_roles (
    user_id BIGINT NOT NULL,
    role_id INT NOT NULL,
    PRIMARY KEY (user_id, role_id),
    FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE,
    FOREIGN KEY (role_id) REFERENCES roles(id) ON DELETE CASCADE
);

-- Create refresh_tokens table
CREATE TABLE refresh_tokens (
    id BIGSERIAL PRIMARY KEY,
    token VARCHAR(255) UNIQUE NOT NULL,
    expiry_date TIMESTAMP NOT NULL,
    user_id BIGINT UNIQUE NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE
);

-- Insert Roles
INSERT INTO roles(name) VALUES('ROLE_USER');
INSERT INTO roles(name) VALUES('ROLE_ADMIN');

-- Insert default users with BCrypt password "password123"
-- Hashes generated via BCrypt: $2a$10$wzC7UjZ3b8J/CmsGgI6sN.tK.tL1n2bF0GqK4Ld6Z2mO4JpC7Qf4e
INSERT INTO users(username, email, password, enabled) 
VALUES ('admin', 'admin@hackathon.com', '$2a$10$wzC7UjZ3b8J/CmsGgI6sN.tK.tL1n2bF0GqK4Ld6Z2mO4JpC7Qf4e', true);

INSERT INTO users(username, email, password, enabled) 
VALUES ('user', 'user@hackathon.com', '$2a$10$wzC7UjZ3b8J/CmsGgI6sN.tK.tL1n2bF0GqK4Ld6Z2mO4JpC7Qf4e', true);

-- Map Users to Roles
-- admin is both USER and ADMIN
INSERT INTO user_roles(user_id, role_id) VALUES (1, 1);
INSERT INTO user_roles(user_id, role_id) VALUES (1, 2);

-- user is USER
INSERT INTO user_roles(user_id, role_id) VALUES (2, 1);
