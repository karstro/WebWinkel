create table "ORDER" (
    order_id int not null,
    customer_id int not null REFERENCES CUSTOMER (customer_id),
    order_date date not null,
    order_shipped boolean not null,
    primary key(order_id)
);