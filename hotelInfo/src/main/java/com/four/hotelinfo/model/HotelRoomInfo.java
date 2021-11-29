package com.four.hotelinfo.model;

public class HotelRoomInfo {
    private int seq; //엑셀상에서 룸정보 인덱스 넘버
    private int hotelId; //룸정보가 소속되는 호텔넘버. 한 호텔이 여러 객실을 가짐
    private String roomName;
    private String Info;

    public int getSeq() {
        return seq;
    }

    public void setSeq(int seq) {
        this.seq = seq;
    }

    public int getHotelId() {
        return hotelId;
    }

    public void setHotelId(int hotelId) {
        this.hotelId = hotelId;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public String getInfo() {
        return Info;
    }

    public void setInfo(String info) {
        Info = info;
    }

    @Override
    public String toString() {
        return "HotelRoomInfo{" +
                "seq=" + seq +
                ", hotelId=" + hotelId +
                ", roomName='" + roomName + '\'' +
                ", Info='" + Info + '\'' +
                '}';
    }
}