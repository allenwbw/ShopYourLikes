CREATE TABLE users (
  user_id INT UNSIGNED NOT NULL,
  api_key VARCHAR(30) NOT NULL,
  instagram_id VARCHAR(30),
  instagram_name VARCHAR(30),
  PRIMARY KEY (user_id)
);

CREATE TABLE links (
  user_id INT UNSIGNED NOT NULL,
  hash CHAR(40) NOT NULL,
  creation_date DATETIME NOT NULL,
  redirects INT NOT NULL,
  earnings FLOAT UNSIGNED NOT NULL,
  epc FLOAT UNSIGNED NOT NULL,
  ig_image_url VARCHAR(30),
  original_url VARCHAR(30) NOT NULL,
  merchant_id INT UNSIGNED NOT NULL,
  name VARCHAR(30),
  PRIMARY KEY (user_id, hash)
);

CREATE TABLE merchants (
  merchant_id INT UNSIGNED NOT NULL,
  name VARCHAR(30),
  PRIMARY KEY (merchant_id)
);