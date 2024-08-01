CREATE TABLE IF NOT EXISTS location(

    id bigint AUTO_INCREMENT primary key,
    name varchar(255) not null,
    country varchar(255) not null,
    city varchar(255) not null,
    created_at timestamp not null,
    updated_at timestamp not null
);

CREATE TABLE IF NOT EXISTS water_distribution_per_country(

    id bigingt AUTO_INCREMENT primary key,
    country_name varchar(255) not null,
    country
)