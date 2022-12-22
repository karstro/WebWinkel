create table ORDERITEM (
    order_item_id int not null,
    order_id int not null REFERENCES "ORDER" (order_id),
    product_id int not null REFERENCES PRODUCT (product_id),
    order_item_amount int not null,
    primary key(order_item_amount)
);