--liquibase formatted sql

--changeset s0qva:1
--comment Renaming the name of the table according to the conventions of the company
ALTER TABLE insurance_company
    RENAME TO "INSURANCE_COMPANY";

--changeset s0qva:2
--comment Renaming table's id according to the conventions of the company
ALTER TABLE "INSURANCE_COMPANY"
    RENAME COLUMN id TO "ID";

--changeset s0qva:3
--comment Renaming table's TIN according to the conventions of the company
ALTER TABLE "INSURANCE_COMPANY"
    RENAME COLUMN taxpayer_identification_number TO "TAXPAYER_IDENTIFICATION_NUMBER";

--changeset s0qva:4
--comment Renaming table's PSRN according to the conventions of the company
ALTER TABLE "INSURANCE_COMPANY"
    RENAME COLUMN primary_state_registration_number TO "PRIMARY_STATE_REGISTRATION_NUMBER";

--changeset s0qva:5
--comment Renaming table's full_name according to the conventions of the company
ALTER TABLE "INSURANCE_COMPANY"
    RENAME COLUMN full_name TO "FULL_NAME";

--changeset s0qva:6
--comment Renaming table's address according to the conventions of the company
ALTER TABLE "INSURANCE_COMPANY"
    RENAME COLUMN address TO "ADDRESS";
