package com.zy.flimticketserver.mapper;

import com.zy.flimticketserver.entity.FilmReleaseEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface FilmReleaseMapper {

    //by cinemaId 查询上映电影信息
    List<FilmReleaseEntity> findFilmReleaseEntityByCinemaId(String cinemaIds[]);

    //by cinemaId or filmName 获取上映电影的id
    List<String> findFilmIds(String cinemaIds[]);

    //by id 获取上映电影信息
    FilmReleaseEntity findFilmReleaseById(int id);

    //根据上映 film id 获取电影院的cinemaId
    List<String> findCinemaIdByFilmId(String filmId);

    //by filmName 获取上映的电影信息
    List<FilmReleaseEntity> findFilmReleaseByFilmName(String filmName);

    // 根据cinema id and film id 查询 上映电影信息
    List<FilmReleaseEntity> findReleaseFilmByCinemaIdAndFilmId(Map<String,String> map);

}
