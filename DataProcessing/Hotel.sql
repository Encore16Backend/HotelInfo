drop table HOTEL_TBL;

create table HOTEL_TBL(
    hotelId number primary key,
    hotelName varchar2(200),
    postalCode varchar2(20),
    phone varchar2(100),
    address varchar2(500),
    lat number,
    lng number,
    summary varchar2(3000),
    roomType varchar2(300),
    parking varchar2(150),
    cooking varchar2(200),
    checkIn varchar2(200),
    checkOut varchar2(200),
    reservationPage varchar2(300),
    hotelImage varchar2(300)
);

drop table HOTEL_DETAIL_TBL;

create table HOTEL_DETAIL_TBL(
    hotelId number primary key,
    hotelName varchar2(200),
    detail varchar2(3000),
    hotelImage varchar2(3000)
);

select * from hotel_category_tbl where fitness = 'true';

drop table USER_TBL;

create table USER_TBL(
    seq number primary key,
    userId varchar2(20),
    password varchar2(20),
    login_status number(2)
);

select * from USER_TBL;