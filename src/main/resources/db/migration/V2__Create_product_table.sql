create table PRODUCT (
    product_id int unique primary key not null,
    product_name varchar(50) not null,
    product_stock int not null,
    product_reserved int not null
);