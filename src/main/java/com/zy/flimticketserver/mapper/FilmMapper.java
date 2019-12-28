package com.zy.flimticketserver.mapper;

import com.zy.flimticketserver.entity.FilmEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FilmMapper {

    //查询所有的电影
    List<FilmEntity> findFilms();

    //查询电影byName
    List<FilmEntity> findFilmByName(String filmName);

    //查询电影byFilmId
    List<FilmEntity> findFilmById(String[] filmIds);
}
