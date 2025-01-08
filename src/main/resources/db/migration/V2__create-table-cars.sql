CREATE TABLE cars (

    id_car BIGINT NOT NULL AUTO_INCREMENT,
    brand VARCHAR(100) NOT NULL,
    model VARCHAR(100) NOT NULL,
    comments VARCHAR (200) NOT NULL,

    id_client BIGINT,

    PRIMARY KEY (id_car),

    FOREIGN KEY (id_client) REFERENCES clients (id_client)

);