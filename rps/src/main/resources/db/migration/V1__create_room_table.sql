CREATE TABLE room(
     id SERIAL PRIMARY KEY,
     api_id VARCHAR(255) NOT NULL UNIQUE,
     room_number INTEGER
);