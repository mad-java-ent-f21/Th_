create table if not exists color
(
    id int auto_increment,
    name varchar(20) not null,
    code int null,
    constraint color_id_uindex
    unique (id)
    );

alter table color
    add primary key (id);

create table if not exists country
(
    id int auto_increment,
    name varchar(40) not null,
    constraint country_id_uindex
    unique (id),
    constraint country_name_uindex
    unique (name)
    );

alter table country
    add primary key (id);

create table if not exists brand
(
    id int auto_increment,
    name varchar(40) not null,
    country_id int not null,
    constraint brand_id_uindex
    unique (id),
    constraint brand_name_uindex
    unique (name),
    constraint brand_country_id_fk
    foreign key (country_id) references country (id)
    );

alter table brand
    add primary key (id);

create table if not exists drive_train
(
    id int auto_increment,
    type varchar(3) not null,
    constraint drive_train_id_uindex
    unique (id)
    );

alter table drive_train
    add primary key (id);

create table if not exists engine
(
    id int auto_increment,
    type varchar(20) not null comment 'One of 3
Internal Combustion, Hybrid or Electric',
    displacement int null comment 'Volume in Liters',
    cylinder_count int not null,
    voltage int null comment 'Electric engine voltage',
    energy_consumption int null comment 'direct energy consumption of an electric motor. Measured in Wh/km (watt hours per kilometer or mile), lower is better.',
    description varchar(128) null,
    constraint engine_id_uindex
    unique (id)
    );

alter table engine
    add primary key (id);

create table if not exists model
(
    id int auto_increment,
    name varchar(20) not null,
    year year not null comment 'Numbers between 1 and 7',
    seats int not null comment 'Between 1 and 20',
    description varchar(128) null,
    brand_id int not null,
    constraint model_id_uindex
    unique (id),
    constraint model_brand_id_fk
    foreign key (brand_id) references brand (id)
    );

alter table model
    add primary key (id);

create table if not exists model_color
(
    color_id int not null,
    model_id int not null,
    primary key (color_id, model_id),
    constraint model_color_color_id_fk
    foreign key (color_id) references color (id),
    constraint model_color_model_id_fk
    foreign key (model_id) references model (id)
    );

create table if not exists transmission
(
    id int auto_increment,
    name varchar(20) not null,
    automatic tinyint(1) not null comment '1 indicates automatic, 0 indicates manual',
    gears int not null comment 'Number of gears. 0 gears indicates a CVT.',
    constraint transmission_id_uindex
    unique (id),
    constraint transmission_name_uindex
    unique (name)
    );

alter table transmission
    add primary key (id);

create table if not exists trim
(
    id int not null,
    name varchar(20) not null,
    description varchar(128) null,
    model_id int not null,
    engine_id int not null,
    drive_train_id int not null,
    transmission_id int not null comment 'using MPG',
    fuel_consumption int null,
    forced_induction varchar(20) null comment 'Supercharged or turbocharged',
    primary key (id),
    constraint trim_drive_train_id_fk
    foreign key (drive_train_id) references drive_train (id),
    constraint trim_engine_id_fk
    foreign key (engine_id) references engine (id),
    constraint trim_model_id_fk
    foreign key (model_id) references model (id),
    constraint trim_transmission_id_fk
    foreign key (transmission_id) references transmission (id)
    );

