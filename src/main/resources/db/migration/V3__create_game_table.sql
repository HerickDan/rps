CREATE TABLE game(
    id SERIAL PRIMARY KEY,
    player_one INTEGER NOT NULL,
    player_two INTEGER,
    winner VARCHAR NOT NULL,
    CONSTRAINT player_one_id_fk FOREIGN KEY (player_one) REFERENCES player(id),
    CONSTRAINT player_two_id_fk FOREIGN KEY (player_to) REFERENCES player(id),
    CONSTRAINT player_winner_id_fk FOREIGN KEY (winner) REFERENCES player(id),
);