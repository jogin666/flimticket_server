package com.zy.flimticketserver.service;

import com.zy.flimticketserver.entity.FilmReleaseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

public interface FilmReleaseService {

    List<FilmReleaseEntity> findFilmReleaseEntityByCinemaId(String cinemaIds[]);

    List<String> findFilmIds(String cinemaIds[]);

    FilmReleaseEntity findFilmReleaseById(int id);

    List<String> findCinemaIdByFilmId(String filmId);

    List<FilmReleaseEntity> findFilmReleaseByFilmName(String filmName);

    List<FilmReleaseEntity> findReleaseFilmByCinemaIdAndFilmId(Map<String,String> map);
}
