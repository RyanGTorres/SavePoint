CREATE TABLE game (
    id BIGSERIAL PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    description TEXT,
    release_date DATE NOT NULL,
    developer VARCHAR(255),
    platform VARCHAR(50),
    CONSTRAINT chk_platform CHECK (platform IN (
        'PLAYSTATION', 'NINTENDO', 'XBOX', 'STEAM', 'EPIC', 'MULTIPLATFORM'
    ))
);
