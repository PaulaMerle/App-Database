--liquibase formatted sql

--changeset VIDEVIK Paula::insert-applications-data

INSERT INTO applications (name, app_group, app_type, description, app_cost, last_modified)
values ('Sisseastumise infosüsteem (SAIS)',
        'SAIS',
        'react/java',
        'Eesti tudengitele haridusasutustesse kandideerimis- ja vastuvõtusüsteem',
        350000,
        now());
INSERT INTO applications (name, app_group, app_type, description, app_cost, last_modified)
values ('Täienduskoolituste infosüsteem Juhan',
        'Juhan',
        'angular/java',
        'e-lahendus täiendusõppe sisu ja protsesside haldamiseks',
        70000,
        now());
INSERT INTO applications (name, app_group, app_type, description, app_cost, last_modified)
values ('Välismaalaste vastuvõtuinfosüsteem (VVIS)',
        'UI - VVIS',
        'react',
        'juhime konsortsiumi ja vahendame kõrgkoolidele Dream Apply teenust',
        420000,
        now());
INSERT INTO applications (name, app_group, app_type, description, app_cost, last_modified)
values ('Tahvel',
        '-',
        'vue, java',
        'õppeinfosüsteem',
        200000,
        now());