package com.zy.flimticketserver.service.impl;

import com.zy.flimticketserver.entity.FilmReleaseEntity;
import com.zy.flimticketserver.mapper.FilmReleaseMapper;
import com.zy.flimticketserver.service.FilmReleaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class FilmReleaseServiceImpl implements FilmReleaseService {

    @Autowired
    private FilmReleaseMapper filmReleaseMapper;

    @Override
    public List<FilmReleaseEntity> findFilmReleaseEntityByCinemaId(String[] cinemaIds) {
        return filmReleaseMapper.findFilmReleaseEntityByCinemaId(cinemaIds);
    }

    @Override
    public List<String> findFilmIds(String[] cinemaIds) {
        return filmReleaseMapper.findFilmIds(cinemaIds);
    }

    @Override
    public FilmReleaseEntity findFilmReleaseById(int id) {
        return filmReleaseMapper.findFilmReleaseById(id);
    }

    @Override
    public List<String> findCinemaIdByFilmId(String filmId) {
        return filmReleaseMapper.findCinemaIdByFilmId(filmId);
    }

    @Override
    public List<FilmReleaseEntity> findFilmReleaseByFilmName(String filmName) {
        return filmReleaseMapper.findFilmReleaseByFilmName(filmName);
    }

    @Override
    public List<FilmReleaseEntity> findReleaseFilmByCinemaIdAndFilmId(Map<String, String> map) {
        return filmReleaseMapper.findReleaseFilmByCinemaIdAndFilmId(map);
    }
}
