CREATE TABLE t_user (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name varchar(20),
    age INT,
    address VARCHAR(20),
)

CREATE TABLE t_count (
    id INT PRIMARY KEY AUTO_INCREMENT,
    uid INT,
    money DECIMAL,
    CONSTRAINT fk_tb_probe_info_metrics FOREIGN KEY (uid) REFERENCES t_user(id)
)