CREATE TABLE IF NOT EXISTS "messages"
(
    "id"       SERIAL PRIMARY KEY NOT NULL,
    "username" VARCHAR(255)       NOT NULL,
    "context"  VARCHAR(255)       NOT NULL
);
