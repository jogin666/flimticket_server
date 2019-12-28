package com.zy.flimticketserver.mapper;

import com.zy.flimticketserver.entity.CinemaEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CinemaMapper {

    //根据 city name 获取电影院信息
    List<CinemaEntity> findCinemaByCityName(String cityName);

    //根据 cinema name 获取电影院信息
    List<CinemaEntity> findCinemaByName(String cinemaName);

    //根据 city name 获取电影院的 id
    List<String> getCinemaIds(String cityName);

    //根据 cinema ids 获取电影院的信息
    List<CinemaEntity> findCinemaByIds(String[] cinemaIds);
}
