drop table HOTEL_DETAIL_TBL;
drop table HOTEL_ROOM_INFO_TBL;
drop table review_tbl;

SELECT * 
FROM hotel_main_tbl
ORDER BY hotelid ASC
OFFSET 0 ROWS;

create table testUser(
    userid number primary key
);

create table testReview(
    id number primary key,
    userid number,
    score number,
    FOREIGN KEY(userid) REFERENCES testUser(userid)    
);

insert into testUser values (1);
insert into testUser values (2);
insert into testUser values (3);
insert into testUser values (4);
insert into testUser values (5);

insert into testReview values (1, 1, 3);
insert into testReview values (2, 2, 4);
insert into testReview values (3, 1, 3);
insert into testReview values (4, 1, 5);
insert into testReview values (5, 2, 1);

select u.*, avg(r.score) 
from testUser u, testReview r 
where u.userid = r.userid 
group by u.userid;



insert into review_tbl values (1, 'good', 3, 'test', 2);
select * from review_tbl;

SELECT h.hotelid, h.hotelimage, h.address, h.hotelname, avg(r.reviewScore)
from HOTEL_MAIN_TBL h, Review_TBL r
where h.hotelid = r.hotelId(+)
group by h.hotelid;

select * from hotel_main_tbl;

select * from HOTEL_DETAIL_TBL;

select * from hotel_room_info_tbl;

SELECT h.hotelid, h.hotelimage, h.address,h.hotelname, avg(r.review_score) as score from HOTEL_MAIN_TBL h, review_tbl r where h.hotelid = r.hotelid(+) group by h.hotelid, h.hotelimage, h.address,h.hotelname order by h.hotelid;

select review_tbl.hotelid from review_tbl;


select * from hotel_main_tbl;

MERGE INTO hotel_main_tbl H USING (SELECT h.hotelid hotelid, round(avg(r.review_score),1) score from HOTEL_MAIN_TBL h, review_tbl r where h.hotelid = r.hotelid(+) group by h.hotelid order by h.hotelid) S 
          ON (H.hotelid = S.hotelid) 
          WHEN MATCHED THEN
          UPDATE SET H.SCORE =nvl(S.SCORE,0);
          
    
          
          
          
   void hotelSetScore();






