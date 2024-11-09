CREATE TABLE client (
                        id BIGSERIAL PRIMARY KEY,
                        first_name VARCHAR(255),
                        last_name VARCHAR(255),
                        email VARCHAR(255),
                        phone_number VARCHAR(20),
                        address VARCHAR(255),
                        is_admin BOOLEAN DEFAULT FALSE,
                        is_blacklisted BOOLEAN DEFAULT FALSE
);

CREATE TABLE product (
                         id BIGSERIAL PRIMARY KEY,
                         name VARCHAR(255),
                         description TEXT,
                         genre VARCHAR(100),
                         band VARCHAR(100),
                         image VARCHAR(255),
                         price DOUBLE PRECISION,
                         quantity_in_stock INT
);

CREATE TABLE "order" (
                         id BIGSERIAL PRIMARY KEY,
                         client_id BIGINT REFERENCES client(id),
                         order_date TIMESTAMP,
                         status VARCHAR(50),
                         comment TEXT,
                         delivery_address VARCHAR(255),
                         delivery_city VARCHAR(100),
                         delivery_country VARCHAR(100),
                         delivery_zip VARCHAR(20),
                         total_price DOUBLE PRECISION
);

ALTER TABLE product
    ADD COLUMN order_id BIGINT REFERENCES "order"(id);
