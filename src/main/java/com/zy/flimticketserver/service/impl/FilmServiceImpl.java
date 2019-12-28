package com.zy.flimticketserver.service.impl;

import com.zy.flimticketserver.entity.FilmEntity;
import com.zy.flimticketserver.mapper.FilmMapper;
import com.zy.flimticketserver.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilmServiceImpl implements FilmService {

    @Autowired
    private FilmMapper filmMapper;

    @Override
    public List<FilmEntity> findFilms() {
        return filmMapper.findFilms();
    }

    @Override
    public List<FilmEntity> findFilmByName(String filmName) {
        return filmMapper.findFilmByName(filmName);
    }

    @Override
    public List<FilmEntity> findFilmById(String[] filmIds) {
        return filmMapper.findFilmById(filmIds);
    }
}
