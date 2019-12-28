package com.zy.flimticketserver.service.impl;

import com.zy.flimticketserver.mapper.CinemaMapper;
import com.zy.flimticketserver.entity.CinemaEntity;
import com.zy.flimticketserver.service.CinemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CinemaServiceImpl implements CinemaService {

    @Autowired
    private CinemaMapper cinemaMapper;

    @Override
    public List<CinemaEntity> findCinemaByCityName(String cityName){
        return cinemaMapper.findCinemaByCityName(cityName);
    }

    @Override
    public List<String> getCinemaIds(String cityName){
        return cinemaMapper.getCinemaIds(cityName);
    }

    @Override
    public List<CinemaEntity> findCinemaByName(String cinemaName){
        return cinemaMapper.findCinemaByCityName(cinemaName);
    }

    @Override
    public List<CinemaEntity> findCinemaByCinemaId(String[] cinemaIds){
        return cinemaMapper.findCinemaByIds(cinemaIds);
    }
}
