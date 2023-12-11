CREATE TABLE UserInfo (
                          id BIGINT AUTO_INCREMENT PRIMARY KEY,
                          name VARCHAR(255),
                          email VARCHAR(255),
                          password VARCHAR(255)
);
CREATE TABLE Product (
                         id BIGINT AUTO_INCREMENT PRIMARY KEY,
                         productName VARCHAR(255),
                         description VARCHAR(255),
                         price INT,
                         quantity INT,
                         user_id BIGINT,
                         FOREIGN KEY (user_id) REFERENCES UserInfo(id) NOT NULL
);
