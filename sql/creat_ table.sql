-- Create table: SaveFile
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product`
(
    id           BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    product_name NVARCHAR(100) NOT NULL,
    banner_img   TEXT          NOT NULL,
    cover_img    TEXT          NOT NULL,
    price        BIGINT        NOT NULL,
    sale         BIGINT,
    description  NVARCHAR(500),
    availability INT,
    unit         NVARCHAR(500),
    view         BIGINT,
    revenue      BIGINT,
    returned     BIGINT,
    status       INT,
    seller_id    Bigint,
    category_id  BIGINT,
    creat_at     DATETIME DEFAULT NOW(),
    update_at    DATETIME DEFAULT NOW()
);


