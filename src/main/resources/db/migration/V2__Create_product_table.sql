create table PRODUCT (
    product_id int not null,
    product_name varchar(50) not null,
    product_stock int not null,
    product_reserved int not null,
    primary key(product_id)
);