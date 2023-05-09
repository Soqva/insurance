--liquibase formatted sql
--changeSet s0qva:1

CREATE TABLE revision_info_aud
(
    revision_number INT PRIMARY KEY,
    entering_date   TIMESTAMP WITHOUT TIME ZONE,
    username        VARCHAR(128)
);

CREATE TABLE subject_types_dictionary_aud
(
    code            VARCHAR(64) PRIMARY KEY,
    description     VARCHAR(256),
    revision_number BIGINT,
    revision_type   VARCHAR(32)
);

CREATE TABLE subjects_aud
(
    id                BIGINT,
    subject_type_code VARCHAR(64),
    revision_number   BIGINT PRIMARY KEY,
    revision_type     VARCHAR(32)
);

CREATE TABLE individual_data_aud
(
    subject_id             BIGINT,
    attribute_id           BIGINT,
    last_name              VARCHAR(128),
    first_name             VARCHAR(128),
    middle_name            VARCHAR(128),
    snils                  VARCHAR(11) UNIQUE,
    inn                    VARCHAR(12) UNIQUE,
    ogrn                   VARCHAR(13) UNIQUE,
    effective_date         DATE,
    entry_date             TIMESTAMP WITHOUT TIME ZONE,
    version                INT,
    revision_number        BIGINT PRIMARY KEY,
    revision_type          VARCHAR(32),
    parent_revision_number BIGINT
);

CREATE TABLE legal_entity_data_aud
(
    subject_id             BIGINT,
    attribute_id           BIGINT,
    full_name              VARCHAR(128),
    short_name             VARCHAR(128),
    inn                    VARCHAR(10) UNIQUE,
    ogrn                   VARCHAR(13) UNIQUE,
    effective_date         DATE,
    entry_date             TIMESTAMP WITHOUT TIME ZONE,
    version                INT,
    revision_number        BIGINT PRIMARY KEY,
    revision_type          VARCHAR(32),
    parent_revision_number BIGINT
);

CREATE TABLE address_types_dictionary_aud
(
    code            VARCHAR(64) PRIMARY KEY,
    description     VARCHAR(256),
    revision_number BIGINT,
    revision_type   VARCHAR(32)
);

CREATE TABLE countries_dictionary_aud
(
    code            VARCHAR(64) PRIMARY KEY,
    description     VARCHAR(256),
    revision_number BIGINT,
    revision_type   VARCHAR(32)
);

CREATE TABLE addresses_aud
(
    subject_id             BIGINT,
    attribute_id           BIGINT,
    address_type_code      VARCHAR(64),
    country_code           VARCHAR(64),
    town                   VARCHAR(128),
    street                 VARCHAR(128),
    house                  VARCHAR(16),
    effective_date         DATE,
    entry_date             TIMESTAMP WITHOUT TIME ZONE,
    version                INT,
    revision_number        BIGINT PRIMARY KEY,
    revision_type          VARCHAR(32),
    parent_revision_number BIGINT
);
