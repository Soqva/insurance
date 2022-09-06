--liquibase formatted sql

--changeset s0qva:1
--comment This table is mapped to InsuranceCompany entity
CREATE TABLE insurance_company
(
    id                                BIGSERIAL PRIMARY KEY,
    taxpayer_identification_number    VARCHAR(10)   NOT NULL UNIQUE,
    primary_state_registration_number VARCHAR(13)   NOT NULL UNIQUE,
    full_name                         VARCHAR(1024) NOT NULL,
    address                           VARCHAR(1024) NOT NULL
)
