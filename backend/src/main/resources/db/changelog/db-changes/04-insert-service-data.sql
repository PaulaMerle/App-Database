--liquibase formatted sql

--changeset VIDEVIK Paula::insert-services-data

INSERT INTO app_services (app_code, name, type, sub_type, description, last_modified)
values ((SELECT app_code FROM applications WHERE applications.name='Sisseastumise infosüsteem (SAIS)'),
        'HTTPS-teenus',
        'HTTPS',
        null,
        'Turvaline protokoll autenditud ja krüpteeritud informatsiooni edastamiseks arvutivõrkudes',
        now());

INSERT INTO app_services (app_code, name, type, sub_type, description, last_modified)
values ((SELECT app_code FROM applications WHERE applications.name='Täienduskoolituste infosüsteem Juhan'),
        'APACHE SOLR',
        'SOLR',
        null,
        'otsingu teenus',
        now());