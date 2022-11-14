CREATE TABLE employees
(
    id         BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    first_name VARCHAR(255),
    last_name  VARCHAR(255),
    job        VARCHAR(255),
    CONSTRAINT pk_employees PRIMARY KEY (id)
);
