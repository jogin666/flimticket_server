package com.zy.flimticketserver.service;

import com.zy.flimticketserver.entity.FilmEntity;

import java.util.List;

public interface FilmService {

    //查询所有的电影
    List<FilmEntity> findFilms();

    //查询电影byName
    List<FilmEntity> findFilmByName(String filmName);

    //查询电影byFilmId
    List<FilmEntity> findFilmById(String[] filmIds);
}
