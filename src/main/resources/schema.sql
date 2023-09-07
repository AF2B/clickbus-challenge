CREATE TABLE IF NOT EXISTS place (
    id bigint AUTO_INCREMENT primary key,
    name varchar(255) not null,
    state varchar(255) not null,
    city varchar(255),
    slug varchar(255),
    created_at timestamp not null,
    updated_at timestamp not null
);
