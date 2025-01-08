CREATE TABLE clients(

    id_client BIGINT NOT NULL AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    number VARCHAR(50) NOT NULL,
    email VARCHAR(50) NOT NULL UNIQUE,

    PRIMARY KEY (id_client)

);