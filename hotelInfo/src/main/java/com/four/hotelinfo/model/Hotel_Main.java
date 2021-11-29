package com.four.hotelinfo.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="HOTEL_MAIN_TBL")
public class Hotel_Main implements Serializable {

    @Id
    @Column(nullable = false, updatable = false)
    private Long hotelid;
    @Column(nullable = false)
    private String hotelname;
    private String address;
    private String hotelimage;

    public Hotel_Main() {
    }

    public Long getHotelid() {
        return hotelid;
    }

    public void setHotelid(Long hotelid) {
        this.hotelid = hotelid;
    }

    public String getHotelname() {
        return hotelname;
    }

    public void setHotelname(String hotelname) {
        this.hotelname = hotelname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getHotelimage() {
        return hotelimage;
    }

    public void setHotelimage(String hotelimage) {
        this.hotelimage = hotelimage;
    }

    @Override
    public String toString() {
        return "Hotel_Main{" +
                "hotelid=" + hotelid +
                ", hotelname='" + hotelname + '\'' +
                ", address='" + address + '\'' +
                ", hotelimage='" + hotelimage + '\'' +
                '}';
    }
}
