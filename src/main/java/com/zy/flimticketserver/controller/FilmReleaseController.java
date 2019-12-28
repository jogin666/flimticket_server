package com.zy.flimticketserver.controller;

import com.zy.flimticketserver.entity.FilmReleaseEntity;
import com.zy.flimticketserver.service.FilmReleaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/releaseFilm")
public class FilmReleaseController {

    @Autowired
    private FilmReleaseService service;

    @RequestMapping("/findFilmByCinemaId")
    public String findFilmReleaseEntityByCinemaId(String cinemaIdStr){
        String cinemaIds[];
        if (cinemaIdStr.contains(",")) {
            cinemaIds = cinemaIdStr.split(",");
        }else{
            cinemaIds=new String[]{cinemaIdStr};
        }
        List<FilmReleaseEntity> filmReleaseEntityList=service.findFilmReleaseEntityByCinemaId(cinemaIds);
        return strJson(filmReleaseEntityList);
    }

    @RequestMapping("/findReleaseFilmIds")
    public String findFilmIds(String cinemaIdStr){
        String cinemaIds[];
        if (cinemaIdStr.contains(",")){
            cinemaIds=cinemaIdStr.split(",");
        }else{
            cinemaIds=new String[]{cinemaIdStr};
        }
        List<String> list=service.findFilmIds(cinemaIds);
        if (list!=null && list.size()>0) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append('[');
            for (String releaseFilmId : list) {
                if (stringBuffer.toString().length() > 2) {
                    stringBuffer.append(",");
                }
                stringBuffer.append("{filmId:" + releaseFilmId+"}");
            }
            stringBuffer.append(']');
            System.out.println(stringBuffer.toString());
            return stringBuffer.toString();
        }
        return null;
    }

    @RequestMapping("/findReleaseFilmById")
    public String findFilmReleaseById(int id){
        FilmReleaseEntity entity=service.findFilmReleaseById(id);
        if (entity!=null) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer = stringBuffer.append('[');
            stringBuffer.append(entity.toString());
            stringBuffer = stringBuffer.append(']');
            return stringBuffer.toString();
        }
        return null;
    }

    @RequestMapping("/findReleaseByFilmName")
    public String findFilmReleaseEntityByFilmName(String filmName){
        List<FilmReleaseEntity> filmReleaseEntityList=service.findFilmReleaseByFilmName(filmName);
        return strJson(filmReleaseEntityList);
    }

    @RequestMapping("/findCinemaIdByFilmId")
    public String findCinemIdByFilmId(String filmId) {
        List<String> cinemIdList=service.findCinemaIdByFilmId(filmId);
        if (cinemIdList.size()>0){
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer = stringBuffer.append('[');
            for (String cinemaId:cinemIdList) {
                if (stringBuffer.length() > 2) {
                    stringBuffer.append(",");
                }
                stringBuffer.append("{cinemaId:" + cinemaId+"}");
            }
            stringBuffer = stringBuffer.append(']');
            return stringBuffer.toString();
        }
        return null;
    }

    @RequestMapping("/findReleaseFilmFyCinemaIdAndFilmId")
    public String findReleaseFilmFyCinemaIdAndFilmId(String cinemaId,String filmId){
        Map<String, String> map = new HashMap<>();
        map.put("cinemaId",cinemaId);
        map.put("filmId",filmId);
        List<FilmReleaseEntity> filmReleaseEntityList=service.findReleaseFilmByCinemaIdAndFilmId(map);
        return strJson(filmReleaseEntityList);
    }


    private String strJson(List<FilmReleaseEntity> releaseFilmEntityList){
        StringBuffer strFilms=new StringBuffer();
        strFilms.append('[');
        if (releaseFilmEntityList!=null && releaseFilmEntityList.size()>0) {
            for (FilmReleaseEntity entity : releaseFilmEntityList) {
                if (strFilms.toString().length() > 2) {
                    strFilms.append(',');
                }
                strFilms = strFilms.append(entity.toString());
            }
            strFilms.append(']');
            System.out.println(strFilms);
            return strFilms.toString();
        }
        return null;
    }
}
