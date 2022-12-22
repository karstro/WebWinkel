create table CARTITEM (
    cart_item_id int not null,
    customer_id int not null REFERENCES CUSTOMER (customer_id),
    product_id int not null REFERENCES PRODUCT (product_id),
    cart_item_amount int not null,
    primary key(cart_item_id)
);