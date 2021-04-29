INSERT INTO customers (name, age) VALUES ('Василье Василий', 21)
INSERT INTO customers (name, age) VALUES ('Ардаков Игорь', 27)
INSERT INTO customers (name, age) VALUES ('Донченко Иван', 23)
INSERT INTO customers (name, age) VALUES ('Кулагина Юлия', 22)
INSERT INTO customers (name, age) VALUES ('Бирюков Евгений', 37)
INSERT INTO customers (name, age) VALUES ('Васильев Валера', 18)
INSERT INTO customers (name, age) VALUES ('Дылдин Алексей', 54)
INSERT INTO customers (name, age) VALUES ('Девин Игорь', 56)
INSERT INTO customers (name) VALUES ('Угаров Виктор')
INSERT INTO customers (name, age) VALUES ('Демчук Алексей', 81)
INSERT INTO customers (name, age) VALUES ('Зюлькин Григорий', 98)
INSERT INTO customers (name, age) VALUES ('Гришина Ольга', 21)
INSERT INTO customers (name) VALUES ('Карсева Полина')
INSERT INTO goods (name) VALUES ('хлеб')
INSERT INTO goods (name) VALUES ('компьютер')
INSERT INTO goods (name) VALUES ('сметана')
INSERT INTO goods (name) VALUES ('лук')
INSERT INTO goods (name) VALUES ('удочка')
INSERT INTO goods (name) VALUES ('пакет')
INSERT INTO goods (name) VALUES ('велосипед')
INSERT INTO goods (name) VALUES ('колесо')
INSERT INTO goods (name) VALUES ('сыр')
INSERT INTO goods (name) VALUES ('фарш')
INSERT INTO goods (name) VALUES ('чеснок')
INSERT INTO trade_types (name) VALUES ('гипермаркет')
INSERT INTO trade_types (name) VALUES ('супермаркет')
INSERT INTO trade_types (name) VALUES ('ларек')
INSERT INTO trade_types (name) VALUES ('магазин у дома')
INSERT INTO trade_types (name) VALUES ('универсам')
INSERT INTO trade_points (type, name, point_size, rent_price, communal_payments, number_of_counters) VALUES (1, 'лента', 100, 10000, 77777, 4)
INSERT INTO trade_points (type, name, point_size, rent_price, communal_payments, number_of_counters) VALUES (4, 'продукты', 70, 1000, 9872, 4)
INSERT INTO trade_points (type, name, point_size, rent_price, communal_payments, number_of_counters) VALUES (5, 'горожанка', 260, 6000, 24332, 2)
INSERT INTO providers (name) VALUES ('ооо поставка')
INSERT INTO providers (name) VALUES ('доставим быстро')
INSERT INTO providers (name) VALUES ('тяк')
INSERT INTO providers (name) VALUES ('тяк спб')
INSERT INTO providers (name) VALUES ('быстровкусно')
INSERT INTO trade_room (trade_points_id) VALUES (1)
INSERT INTO trade_room (trade_points_id) VALUES (2)
INSERT INTO trade_room (trade_points_id) VALUES (2)
INSERT INTO trade_room (trade_points_id) VALUES (3)
INSERT INTO trade_room (trade_points_id) VALUES (1)
INSERT INTO trade_section_point (trade_point, floor, managers_name) VALUES (1, 1 ,'Виталя')
INSERT INTO trade_section_point (trade_point, floor, managers_name) VALUES (1, 2 ,'Олег')
INSERT INTO trade_section_point (trade_point, floor, managers_name) VALUES (2, 1 ,'Серафим')
INSERT INTO trade_section_point (trade_point, floor, managers_name) VALUES (1, 2 ,'Евдокия')
INSERT INTO trade_section_point (trade_point, floor, managers_name) VALUES (3, 1 ,'Агафья')
INSERT INTO trade_section_point (trade_point, floor, managers_name) VALUES (3, 1 ,'Льюис')
INSERT INTO DELIVERIES (PROVIDER_ID, TRADE_POINT_ID, COUNT, DELIVER_DATE) VALUES (1, 2, 11, TO_DATE('11/03/2020', 'MM/DD/YYYY'))
INSERT INTO DELIVERIES (PROVIDER_ID, TRADE_POINT_ID, COUNT, DELIVER_DATE) VALUES (3, 2, 1, TO_DATE('11/04/2020', 'MM/DD/YYYY'))
INSERT INTO DELIVERIES (PROVIDER_ID, TRADE_POINT_ID, COUNT, DELIVER_DATE) VALUES (3, 1, 32, TO_DATE('12/12/2020', 'MM/DD/YYYY'))
INSERT INTO DELIVERIES (PROVIDER_ID, TRADE_POINT_ID, COUNT, DELIVER_DATE) VALUES (4, 3, 983, TO_DATE('10/11/2020', 'MM/DD/YYYY'))
INSERT INTO DELIVERIES (PROVIDER_ID, TRADE_POINT_ID, COUNT, DELIVER_DATE) VALUES (5, 3, 777, TO_DATE('09/09/2019', 'MM/DD/YYYY'))
INSERT INTO DELIVERIES_GOODS (PROVIDER_ID, GOOD_ID, DELIVERY_ID, PRICE) VALUES (1, 6, 1, 2222)
INSERT INTO DELIVERIES_GOODS (PROVIDER_ID, GOOD_ID, DELIVERY_ID, PRICE) VALUES (2, 5, 1, 7812)
INSERT INTO DELIVERIES_GOODS (PROVIDER_ID, GOOD_ID, DELIVERY_ID, PRICE) VALUES (3, 4, 2, 562)
INSERT INTO DELIVERIES_GOODS (PROVIDER_ID, GOOD_ID, DELIVERY_ID, PRICE) VALUES (3, 3, 3, 289)
INSERT INTO DELIVERIES_GOODS (PROVIDER_ID, GOOD_ID, DELIVERY_ID, PRICE) VALUES (4, 2, 3, 1000)
INSERT INTO PURCHASE_COMPOSITIONS (GOOD, COUNT, RESULT_PRICE, PURCHASE_DATE) VALUES (1, 10, 2399, TO_DATE('11/12/2020', 'MM/DD/YYYY'))
INSERT INTO PURCHASE_COMPOSITIONS (GOOD, COUNT, RESULT_PRICE, PURCHASE_DATE) VALUES (2, 12, 822, TO_DATE('01/10/2019', 'MM/DD/YYYY'))
INSERT INTO PURCHASE_COMPOSITIONS (GOOD, COUNT, RESULT_PRICE, PURCHASE_DATE) VALUES (3, 11, 8982, TO_DATE('03/11/2020', 'MM/DD/YYYY'))
INSERT INTO PURCHASE_COMPOSITIONS (GOOD, COUNT, RESULT_PRICE, PURCHASE_DATE) VALUES (4, 7, 49090, TO_DATE('04/03/2020', 'MM/DD/YYYY'))
INSERT INTO PURCHASE_COMPOSITIONS (GOOD, COUNT, RESULT_PRICE, PURCHASE_DATE) VALUES (5, 9, 8743, TO_DATE('12/04/2020', 'MM/DD/YYYY'))
INSERT INTO PURCHASE_COMPOSITIONS (GOOD, COUNT, RESULT_PRICE, PURCHASE_DATE) VALUES (4, 2, 3212, TO_DATE('09/05/2020', 'MM/DD/YYYY'))
INSERT INTO SELLERS (NAME, SALARY, TRADE_POINT, TRADE_ROOM) VALUES ('Иван', 20000, 1, 1)
INSERT INTO SELLERS (NAME, SALARY, TRADE_POINT, TRADE_ROOM) VALUES ('Петр', 20000, 2, 3)
INSERT INTO SELLERS (NAME, SALARY, TRADE_POINT, TRADE_ROOM) VALUES ('Ирина', 25000, 2, 3)
INSERT INTO SELLERS (NAME, SALARY, TRADE_POINT, TRADE_ROOM) VALUES ('Василий', 15000, 3, 2)
INSERT INTO SELLERS (NAME, SALARY, TRADE_POINT, TRADE_ROOM) VALUES ('Олег', 10000, 3, 1)
INSERT INTO SALES (SELLER, CUSTOMER, PURCHASE_COMPOSITION) VALUES (1, 7, 4)
INSERT INTO SALES (SELLER, CUSTOMER, PURCHASE_COMPOSITION) VALUES (2, 6, 5)
INSERT INTO SALES (SELLER, CUSTOMER, PURCHASE_COMPOSITION) VALUES (3, 5, 3)
INSERT INTO SALES (SELLER, CUSTOMER, PURCHASE_COMPOSITION) VALUES (4, 4, 6)
INSERT INTO SALES (SELLER, CUSTOMER, PURCHASE_COMPOSITION) VALUES (5, 3, 2)