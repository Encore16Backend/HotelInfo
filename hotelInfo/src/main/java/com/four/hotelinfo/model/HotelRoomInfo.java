package com.four.hotelinfo.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="HOTEL_ROOM_INFO_TBL")
public class HotelRoomInfo implements Serializable {
    @Id
    @Column(updatable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long seq; //엑셀상에서 룸정보 인덱스 넘버
    @Column(updatable = false)
    private Long hotelid; //룸정보가 소속되는 호텔넘버. 한 호텔이 여러 객실을 가짐
    private String roomname;
    private String info;

    public Long getSeq() {
        return seq;
    }

    public void setSeq(Long seq) {
        this.seq = seq;
    }

    public Long getHotelid() {
        return hotelid;
    }

    public void setHotelid(Long hotelid) {
        this.hotelid = hotelid;
    }

    public String getRoomname() {
        return roomname;
    }

    public void setRoomname(String roomname) {
        this.roomname = roomname;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    @Override
    public String toString() {
        return "HotelRoomInfo{" +
                "seq=" + seq +
                ", hotelid=" + hotelid +
                ", roomname='" + roomname + '\'' +
                ", infoo='" + info + '\'' +
                '}';
    }
}
