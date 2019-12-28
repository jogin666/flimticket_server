package com.zy.flimticketserver.service;

import com.zy.flimticketserver.entity.CinemaEntity;

import java.util.List;

public interface CinemaService {

    List<CinemaEntity> findCinemaByCityName(String cityName);

    List<CinemaEntity> findCinemaByName(String cinemaName);

    List<String> getCinemaIds(String cityName);

    List<CinemaEntity> findCinemaByCinemaId(String[] cinemaIds);
}
