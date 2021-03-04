DROP TABLE IF EXISTS author;
DROP TABLE IF EXISTS address;
DROP TABLE IF EXISTS book;
DROP TABLE IF EXISTS authorbook;

CREATE TABLE address(
    address_id INT NOT NULL AUTO_INCREMENT,
    address_name VARCHAR(30),
    address_number INT NOT NULL,
    CONSTRAINT address_pk PRIMARY KEY(address_id)
) ENGINE = INNODB;

CREATE TABLE author(
    author_id INT NOT NULL AUTO_INCREMENT,
    first_name VARCHAR(30),
    last_name VARCHAR(30),
    birth_date VARCHAR(30),
    address_id INT,
    CONSTRAINT author_pk PRIMARY KEY(author_id),
    CONSTRAINT author_fk FOREIGN KEY(address_id) REFERENCES address(address_id)
 )ENGINE = INNODB;

CREATE TABLE book(
    book_id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(30),
    pages INT,
    CONSTRAINT book_pk PRIMARY KEY(book_id)
) ENGINE = INNODB;

CREATE TABLE authorbook(
    author_id INT NOT NULL,
    book_id INT NOT NULL,
    CONSTRAINT authorbook_pk PRIMARY KEY(author_id, book_id),
    CONSTRAINT authorbook_fk1 FOREIGN KEY(author_id) REFERENCES author(author_id),
    CONSTRAINT authorbook_fk2 FOREIGN KEY(book_id) REFERENCES book(book_id)
) ENGINE = INNODB;

ALTER TABLE author MODIFY address_id INT NULL;

INSERT INTO address VALUES(1, "fjordgata", 29);
INSERT INTO author VALUES(1, "william", "forbrigd", "1999", 1);
