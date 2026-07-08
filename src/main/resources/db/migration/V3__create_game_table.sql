CREATE TABLE game(
    id SERIAL PRIMARY KEY,
    player_one INTEGER NOT NULL,
    player_two INTEGER,
    winner INTEGER,
    game_room INTEGER UNIQUE,
    CONSTRAINT player_one_id_fk FOREIGN KEY (player_one) REFERENCES player(id),
    CONSTRAINT player_two_id_fk FOREIGN KEY (player_two) REFERENCES player(id),
    CONSTRAINT winner_id_fk FOREIGN KEY (winner) REFERENCES player(id),
    CONSTRAINT room_number_fk FOREIGN KEY (game_room) REFERENCES room(room_number)
);