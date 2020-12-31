CREATE TABLE one_to_one
(
    id    int NOT NULL AUTO_INCREMENT,
    min   int NOT NULL DEFAULT 0,
    PRIMARY KEY (id)
);


CREATE TABLE parent
(
    id         int NOT NULL AUTO_INCREMENT,
    count      int NOT NULL DEFAULT 0,
    one_to_one int,
    PRIMARY KEY (id)
);
alter table parent
    add constraint fk_parent_onetoone foreign key (one_to_one) references one_to_one (id);

CREATE TABLE day
(
    id     int NOT NULL AUTO_INCREMENT,
    name   varchar(16) DEFAULT NULL,
    parent int,
    PRIMARY KEY (id)
);
alter table day
    add constraint fk_day_parent foreign key (parent) references parent (id);

CREATE TABLE color
(
    id          int NOT NULL AUTO_INCREMENT,
    description varchar(16) DEFAULT NULL,
    hex_value   varchar(16) DEFAULT NULL,
    parent      int,
    parent_key  varchar(16),
    PRIMARY KEY (id)
);
alter table color
    add constraint fk_color_parent foreign key (parent) references parent (id);

CREATE TABLE car
(
    id          int NOT NULL AUTO_INCREMENT,
    name        varchar(16) DEFAULT NULL,
    parent      int,
    parent_key  varchar(16),
    PRIMARY KEY (id)
);
alter table car
    add constraint fk_car_parent foreign key (parent) references parent (id);

CREATE TABLE orderr
(
    id          int NOT NULL AUTO_INCREMENT,
    order_num   int NOT NULL,
    parent      int,
    parent_key  int,
    PRIMARY KEY (id)
);
alter table orderr
    add constraint fk_orderr_parent foreign key (parent) references parent (id);

CREATE TABLE item
(
    id          int NOT NULL AUTO_INCREMENT,
    name        varchar(16) DEFAULT NULL,
    orderr       int,
    orderr_key   varchar(16),
    PRIMARY KEY (id)
);
alter table item
    add constraint fk_item_orderr foreign key (orderr) references orderr (id);
