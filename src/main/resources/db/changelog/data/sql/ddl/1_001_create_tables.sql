--liquibase formatted sql
--changeSet s0qva:1

CREATE TABLE subject_types_dictionary
(
    code        VARCHAR(64) PRIMARY KEY,
    description VARCHAR(256)
);

CREATE TABLE subjects
(
    id                BIGSERIAL PRIMARY KEY,
    subject_type_code VARCHAR(64)
        REFERENCES subject_types_dictionary (code)
            ON DELETE CASCADE
            ON UPDATE CASCADE
);

CREATE TABLE individual_data
(
    subject_id     BIGINT REFERENCES subjects (id),
    attribute_id   BIGSERIAL,
    last_name      VARCHAR(128),
    first_name     VARCHAR(128),
    middle_name    VARCHAR(128),
    snils          VARCHAR(11) UNIQUE,
    inn            VARCHAR(12) UNIQUE,
    ogrn           VARCHAR(13) UNIQUE,
    effective_date DATE,
    entry_date     TIMESTAMP WITHOUT TIME ZONE,
    version        INT,
    PRIMARY KEY (attribute_id, version)
);

CREATE TABLE legal_entity_data
(
    subject_id     BIGINT REFERENCES subjects (id),
    attribute_id   BIGSERIAL,
    full_name      VARCHAR(128),
    short_name     VARCHAR(128),
    inn            VARCHAR(10) UNIQUE,
    ogrn           VARCHAR(13) UNIQUE,
    effective_date DATE,
    entry_date     TIMESTAMP WITHOUT TIME ZONE,
    version        INT,
    PRIMARY KEY (attribute_id, version)
);

CREATE TABLE countries_dictionary
(
    code        VARCHAR(64) PRIMARY KEY,
    description VARCHAR(256)
);

CREATE TABLE address_types_dictionary
(
    code        VARCHAR(64) PRIMARY KEY,
    description VARCHAR(256)
);

CREATE TABLE addresses
(
    subject_id        BIGINT REFERENCES subjects (id),
    attribute_id      BIGSERIAL,
    address_type_code VARCHAR(64)
        REFERENCES subject_types_dictionary (code)
            ON DELETE CASCADE
            ON UPDATE CASCADE,
    country_code      VARCHAR(64)
        REFERENCES subject_types_dictionary (code)
            ON DELETE CASCADE
            ON UPDATE CASCADE,
    town              VARCHAR(128),
    street            VARCHAR(128),
    house             VARCHAR(16),
    effective_date    DATE,
    entry_date        TIMESTAMP WITHOUT TIME ZONE,
    version           INT,
    PRIMARY KEY (attribute_id, version)
);
