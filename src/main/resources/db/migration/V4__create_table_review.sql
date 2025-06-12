CREATE TABLE review (
    id BIGSERIAL PRIMARY KEY,
    title VARCHAR(255),
    content TEXT,
    rating DOUBLE PRECISION,
    date DATE,
    game_id BIGINT,
    CONSTRAINT fk_review_game FOREIGN KEY (game_id) REFERENCES game(id) ON DELETE CASCADE
);