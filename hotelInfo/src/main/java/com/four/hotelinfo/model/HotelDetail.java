package com.four.hotelinfo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name="HOTEL_DETAIL_TBL")
public class HotelDetail implements Serializable {
    @Id
    @Column(updatable = false)
    private int hotelid; //호텔 넘버
    private String reservationpage; //예약URL
    private String phone; //전화번호
    private String summary;
    private String checkin; //체크인,아웃 - 예시: 15:00, 월~목 18:00
    private String checkout;
    private String hotelimages; //이미지URL
    private String seminar; //이하 FALSE or TRUE
    private String sports;
    private String sauna;
    private String beauty;
    private String karaoke;
    private String BBQ;
    private String bicycle;
    private String fitness;
    private String publicpc;
    private String publicshower;

    public int getHotelid() {
        return hotelid;
    }

    public void setHotelid(int hotelid) {
        this.hotelid = hotelid;
    }

    public String getReservationpage() {
        return reservationpage;
    }

    public void setReservationpage(String reservationpage) {
        this.reservationpage = reservationpage;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getCheckin() {
        return checkin;
    }

    public void setCheckin(String checkin) {
        this.checkin = checkin;
    }

    public String getCheckout() {
        return checkout;
    }

    public void setCheckout(String checkout) {
        this.checkout = checkout;
    }

    public String getHotelimages() {
        return hotelimages;
    }

    public void setHotelimages(String hotelimages) {
        this.hotelimages = hotelimages;
    }

    public String getSeminar() {
        return seminar;
    }

    public void setSeminar(String seminar) {
        this.seminar = seminar;
    }

    public String getSports() {
        return sports;
    }

    public void setSports(String sports) {
        this.sports = sports;
    }

    public String getSauna() {
        return sauna;
    }

    public void setSauna(String sauna) {
        this.sauna = sauna;
    }

    public String getBeauty() {
        return beauty;
    }

    public void setBeauty(String beauty) {
        this.beauty = beauty;
    }

    public String getKaraoke() {
        return karaoke;
    }

    public void setKaraoke(String karaoke) {
        this.karaoke = karaoke;
    }

    public String getBBQ() {
        return BBQ;
    }

    public void setBBQ(String BBQ) {
        this.BBQ = BBQ;
    }

    public String getBicycle() {
        return bicycle;
    }

    public void setBicycle(String bicycle) {
        this.bicycle = bicycle;
    }

    public String getFitness() {
        return fitness;
    }

    public void setFitness(String fitness) {
        this.fitness = fitness;
    }

    public String getPublicpc() {
        return publicpc;
    }

    public void setPublicpc(String publicpc) {
        this.publicpc = publicpc;
    }

    public String getPublicshower() {
        return publicshower;
    }

    public void setPublicshower(String publicshower) {
        this.publicshower = publicshower;
    }

    @Override
    public String toString() {
        return "HotelDetail{" +
                "hotelId=" + hotelid +
                ", reservationpage='" + reservationpage + '\'' +
                ", phone='" + phone + '\'' +
                ", summary='" + summary + '\'' +
                ", checkin='" + checkin + '\'' +
                ", checkout='" + checkout + '\'' +
                ", hotelimages='" + hotelimages + '\'' +
                ", seminar='" + seminar + '\'' +
                ", sports='" + sports + '\'' +
                ", sauna='" + sauna + '\'' +
                ", beauty='" + beauty + '\'' +
                ", karaoke='" + karaoke + '\'' +
                ", BBQ='" + BBQ + '\'' +
                ", bicycle='" + bicycle + '\'' +
                ", fitness='" + fitness + '\'' +
                ", publicpc='" + publicpc + '\'' +
                ", publicshower='" + publicshower + '\'' +
                '}';
    }
}
