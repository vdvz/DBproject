CREATE TABLE Accounting (
id NUMBER(11) PRIMARY KEY,
trade_point REFERENCES Trade_Points(id) NOT NULL,
good REFERENCES Goods(id) NOT NULL,
count NUMBER(11) NOT NULL,
price NUMBER(11) NOT NULL
)
