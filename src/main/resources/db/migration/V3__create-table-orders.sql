
CREATE TABLE orders(

    id_order BIGINT NOT NULL AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    description VARCHAR(200) NOT NULL,

    id_car BIGINT,

    PRIMARY KEY (id_order),

    FOREIGN KEY (id_car) REFERENCES cars (id_car)

);