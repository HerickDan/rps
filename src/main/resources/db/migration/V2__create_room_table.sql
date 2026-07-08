CREATE TABLE room(
     id SERIAL PRIMARY KEY,
     api_id VARCHAR(255) NOT NULL UNIQUE,
     room_number INTEGER UNIQUE,
     created_by INTEGER,
     CONSTRAINT created_by_id FOREIGN KEY (created_by) REFERENCES player(id)
);