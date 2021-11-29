package com.four.hotelinfo.model;

public class HotelDetail {
    private int hotelId; //호텔 넘버
    private String reservationPage; //예약URL
    private String phone; //전화번호
    private String summary;
    private String checkIn; //체크인,아웃 - 예시: 15:00, 월~목 18:00
    private String checkOut;
    private String hotelImages; //이미지URL
    private String seminar; //이하 FALSE or TRUE
    private String sports;
    private String sauna;
    private String beauty;
    private String karaoke;
    private String BBQ;
    private String bicycle;
    private String fitness;
    private String publicPC;
    private String publicShower;

    public int getHotelId() {
        return hotelId;
    }

    public void setHotelId(int hotelId) {
        this.hotelId = hotelId;
    }

    public String getReservationPage() {
        return reservationPage;
    }

    public void setReservationPage(String reservationPage) {
        this.reservationPage = reservationPage;
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

    public String getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(String checkIn) {
        this.checkIn = checkIn;
    }

    public String getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(String checkOut) {
        this.checkOut = checkOut;
    }

    public String getHotelImages() {
        return hotelImages;
    }

    public void setHotelImages(String hotelImages) {
        this.hotelImages = hotelImages;
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

    public String getPublicPC() {
        return publicPC;
    }

    public void setPublicPC(String publicPC) {
        this.publicPC = publicPC;
    }

    public String getPublicShower() {
        return publicShower;
    }

    public void setPublicShower(String publicShower) {
        this.publicShower = publicShower;
    }

    @Override
    public String toString() {
        return "HotelDetail{" +
                "hotelId=" + hotelId +
                ", reservationPage='" + reservationPage + '\'' +
                ", phone='" + phone + '\'' +
                ", summary='" + summary + '\'' +
                ", checkIn='" + checkIn + '\'' +
                ", checkOut='" + checkOut + '\'' +
                ", hotelImages='" + hotelImages + '\'' +
                ", seminar='" + seminar + '\'' +
                ", sports='" + sports + '\'' +
                ", sauna='" + sauna + '\'' +
                ", beauty='" + beauty + '\'' +
                ", karaoke='" + karaoke + '\'' +
                ", BBQ='" + BBQ + '\'' +
                ", bicycle='" + bicycle + '\'' +
                ", fitness='" + fitness + '\'' +
                ", publicPC='" + publicPC + '\'' +
                ", publicShower='" + publicShower + '\'' +
                '}';
    }
}
