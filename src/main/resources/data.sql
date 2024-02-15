# init data for H2 DB. This file has to be on classpath for H2 to read and setup DB
insert into customer(id, name) values (1000, 'Alex');
insert into customer(id, name) values (1001, 'Ram');
insert into customer(id, name) values (1002, 'Rahim');

insert into my_transaction(id, description, total, save_date, customer_id) values (1001, 'Order 1', 100, '2022-10-17 10:20:10', 1000);
insert into my_transaction(id, description, total, save_date, customer_id) values (1002, 'Order 2', 50, '2022-10-01 10:20:10', 1000);
insert into my_transaction(id, description, total, save_date, customer_id) values (1003, 'Order 3', 120, '2022-10-10 10:20:10', 1000);
insert into my_transaction(id, description, total, save_date, customer_id) values (1004, 'Order 10', 175.32, '2021-10-07 10:20:10', 1000);
insert into my_transaction(id, description, total, save_date, customer_id) values (1005, 'Order 20', 65.75, '2020-10-05 10:20:10', 1000);
insert into my_transaction(id, description, total, save_date, customer_id) values (1006, 'Order 30', 210.50, '2019-10-03 10:20:10', 1000);
insert into my_transaction(id, description, total, save_date, customer_id) values (1009, 'Order 31', 42.80, '2018-10-18 17:10:10', 1000);
insert into my_transaction(id, description, total, save_date, customer_id) values (1200, 'Order 200', 25.60, '2020-10-01 12:20:10', 1002);
insert into my_transaction(id, description, total, save_date, customer_id) values (1201, 'Order 201', 80.50, '2023-10-05 15:00:10', 1002);
insert into my_transaction(id, description, total, save_date, customer_id) values (1202, 'Order 202', 116.14, '2021-10-10 11:30:10', 1002);
insert into my_transaction(id, description, total, save_date, customer_id) values (1008, 'Order 5', 200, '2017-10-17 10:20:10', 1001);
