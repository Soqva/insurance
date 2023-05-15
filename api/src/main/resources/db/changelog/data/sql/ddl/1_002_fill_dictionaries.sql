--liquibase formatted sql
--changeSet s0qva:1

INSERT INTO subject_types_dictionary (code, description)
VALUES ('LEGAL-ENTITY', 'Юридическое лицо'),
       ('INDIVIDUAL', 'Физическое лицо');

INSERT INTO countries_dictionary (code, description)
VALUES ('RUSSIA', 'Российская федерация');

INSERT INTO address_types_dictionary (code, description)
VALUES ('FACT', 'Фактический адрес'),
       ('JURIDICAL', 'Юридический адрес');
