CREATE TABLE game_category (
    game_id BIGINT NOT NULL,
    category_id BIGINT NOT NULL,
    PRIMARY KEY (game_id, category_id),
    CONSTRAINT fk_game_category_game FOREIGN KEY (game_id) REFERENCES game(id) ON DELETE CASCADE,
    CONSTRAINT fk_game_category_category FOREIGN KEY (category_id) REFERENCES category(id) ON DELETE CASCADE
);