package com.zy.flimticketserver.entity;

import java.util.List;

public class FilmEntity {

    private double rating; //评分
    private String description; //描述
    private String filmName; //电影名
    private String genres; //类型
    private int durationMin;//时长
    private String language;//语言
    private String releaseDates;//上映时间
    private String countries; //国家
    private String coverUrl; //图片
    private String screenTypes;//影评类型
    private String filmId; //id

    private List<Actor> actorsList;
    private List<Director> directorList;

    public List<Actor> getActorsList() {
        return actorsList;
    }

    public void setActorsList(List<Actor> actorsList) {
        this.actorsList = actorsList;
    }

    public List<Director> getDirectorList() {
        return directorList;
    }

    public void setDirectorList(List<Director> directorList) {
        this.directorList = directorList;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFilmName() {
        return filmName;
    }

    public void setFilmName(String filmName) {
        this.filmName = filmName;
    }

    public String getGenres() {
        return genres;
    }

    public void setGenres(String genres) {
        this.genres = genres;
    }

    public int getDurationMin() {
        return durationMin;
    }

    public void setDurationMin(int durationMin) {
        this.durationMin = durationMin;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getReleaseDates() {
        return releaseDates;
    }

    public void setReleaseDates(String releaseDates) {
        this.releaseDates = releaseDates;
    }

    public String getCountries() {
        return countries;
    }

    public void setCountries(String countries) {
        this.countries = countries;
    }

    public String getCoverUrl() {
        return coverUrl;
    }

    public void setCoverUrl(String coverUrl) {
        this.coverUrl = coverUrl;
    }

    public String getScreenTypes() {
        return screenTypes;
    }

    public void setScreenTypes(String screenTypes) {
        this.screenTypes = screenTypes;
    }

    public String getFilmId() {
        return filmId;
    }

    public void setFilmId(String filmId) {
        this.filmId = filmId;
    }

    @Override
    public String toString() {
        return "{" +
                "rating:" + rating +
                ", description:'" + description + '\'' +
                ", filmName:'" + filmName + '\'' +
                ", genres:'" + genres + '\'' +
                ", durationMin:" + durationMin +
                ", language:'" + language + '\'' +
                ", releaseDates:'" + releaseDates + '\'' +
                ", countries:'" + countries + '\'' +
                ", coverUrl:'" + coverUrl + '\'' +
                ", screenTypes:'" + screenTypes + '\'' +
                ", filmId:'" + filmId + '\'' +
                ", actorsList:" + actorsList +
                ", directorList:" + directorList +
                '}';
    }
}
