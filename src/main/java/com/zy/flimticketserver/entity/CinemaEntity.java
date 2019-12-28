package com.zy.flimticketserver.entity;

public class CinemaEntity {

    private String cinemaId;
    private String cinemaName;
    private String cinemaCity;
    private String cinemaAddress;

    public String getCinemaId() {
        return cinemaId;
    }

    public void setCinemaId(String cinemaId) {
        this.cinemaId = cinemaId;
    }

    public String getCinemaName() {
        return cinemaName;
    }

    public void setCinemaName(String cinemaName) {
        this.cinemaName = cinemaName;
    }

    public String getCinemaCity() {
        return cinemaCity;
    }

    public void setCinemaCity(String cinemaCity) {
        this.cinemaCity = cinemaCity;
    }

    public String getCinemaAddress() {
        return cinemaAddress;
    }

    public void setCinemaAddress(String cinemaAddress) {
        this.cinemaAddress = cinemaAddress;
    }

    @Override
    public String toString() {
        return "{" +
                "cinemaId:'" + cinemaId + '\'' +
                ", cinemaName:'" + cinemaName + '\'' +
                ", cinemaCity:'" + cinemaCity + '\'' +
                ", cinemaAddress:'" + cinemaAddress + '\'' +
                '}';
    }
}
