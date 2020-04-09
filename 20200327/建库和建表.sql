CREATE DATABASE IF NOT EXISTS java20_0329 CHARSET utf8mb4;
use java20_0329;

CREATE TABLE vocabulary(
  en VARCHAR(20) NOT NULL UNIQUE ,
  ch VARCHAR(100) NOT NULL
);

INSERT INTO vocabulary(en,ch) VALUES
  ("dog","狗"),
  ("bee","蜜蜂");