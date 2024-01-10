create table book (
 book_code varchar2(10) primary key,
 book_name varchar2(100) not null,
 book_author varchar2(100) not null,
 book_press varchar2(100) not null,
 book_price number not null
);