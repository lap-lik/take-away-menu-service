CREATE TABLE menu_items
(
    id                    BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    name                  TEXT UNIQUE NOT NULL,
    description           TEXT        NOT NULL,
    price                 NUMERIC(6, 2),
    category              TEXT        NOT NULL,
    time_to_cook          BIGINT      NOT NULL,
    weight                FLOAT       NOT NULL,
    image_url             TEXT        NOT NULL,
    ingredient_collection JSONB       NOT NULL,
    created_at            TIMESTAMP   NOT NULL,
    updated_at            TIMESTAMP   NOT NULL DEFAULT CURRENT_TIMESTAMP
);