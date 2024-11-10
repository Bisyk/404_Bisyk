ALTER TABLE client
    ADD COLUMN username VARCHAR(255) UNIQUE,
    ADD COLUMN password VARCHAR(255) NOT NULL;

create table roles
(
    id bigint generated always as identity primary key not null,
    name varchar(100)
);

create table roles_has_users
(
    id bigint generated always as identity primary key not null,
    user_id bigint,
    role_id bigint
);

ALTER TABLE roles_has_users
    ADD CONSTRAINT fk_user_id
        FOREIGN KEY (user_id) REFERENCES client(id);

ALTER TABLE roles_has_users
    ADD CONSTRAINT fk_role_id
        FOREIGN KEY (role_id) REFERENCES roles(id);
