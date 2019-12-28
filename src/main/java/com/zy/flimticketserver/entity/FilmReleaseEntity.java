package com.zy.flimticketserver.entity;

import java.sql.Date;

public class FilmReleaseEntity {

    private int id;
    private String filmId;
    private String cinemaId;
    private Date releaseDate;
    private int releasePosition;
    private String cinemaName;
    private String releaseTime;
    private String filmName;
    private int releaseNum;

    public int getReleaseNum() {
        return releaseNum;
    }

    public void setReleaseNum(int releaseNum) {
        this.releaseNum = releaseNum;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFilmId() {
        return filmId;
    }

    public void setFilmId(String filmId) {
        this.filmId = filmId;
    }

    public String getCinemaId() {
        return cinemaId;
    }

    public void setCinemaId(String cinemaId) {
        this.cinemaId = cinemaId;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public int getReleasePosition() {
        return releasePosition;
    }

    public void setReleasePosition(int releasePosition) {
        this.releasePosition = releasePosition;
    }

    public String getCinemaName() {
        return cinemaName;
    }

    public void setCinemaName(String cinemaName) {
        this.cinemaName = cinemaName;
    }

    public String getReleaseTime() {
        return releaseTime;
    }

    public void setReleaseTime(String releaseTime) {
        this.releaseTime = releaseTime;
    }

    public String getFilmName() {
        return filmName;
    }

    public void setFilmName(String filmName) {
        this.filmName = filmName;
    }

    @Override
    public String toString() {
        return "{" +
                "id:" + id +
                ", filmId:'" + filmId + '\'' +
                ", cinemaId:'" + cinemaId + '\'' +
                ", releaseDate:" + releaseDate +
                ", releasePosition:" + releasePosition +
                ", cinemaName:'" + cinemaName + '\'' +
                ", releaseTime:'" + releaseTime + '\'' +
                ", filmName:'" + filmName + '\'' +
                ",releaseNum:'" + releaseNum + '\'' +
                '}';
    }
}
