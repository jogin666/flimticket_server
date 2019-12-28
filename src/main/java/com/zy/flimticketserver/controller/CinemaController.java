package com.zy.flimticketserver.controller;

import com.zy.flimticketserver.entity.CinemaEntity;
import com.zy.flimticketserver.service.CinemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CinemaController {

    @Autowired
    private CinemaService cinemaService;

    @RequestMapping("/findCinemaByCityName")
    public String findCinemaByCityName(String cityName){
        List<CinemaEntity> cinemaEntityList= cinemaService.findCinemaByCityName(cityName);
        return strJson(cinemaEntityList);
    }

    @RequestMapping("/getCinemaIdsByCityName")
    public String getCinemaIdsByCityName(String cityName){
        List<String> cinemaIdList=cinemaService.getCinemaIds(cityName);
        StringBuffer stringBuffer=new StringBuffer();
        stringBuffer.append("[");
        for (String releaseFilmId:cinemaIdList){
            if (stringBuffer.toString().length()>2){
                stringBuffer.append(",");
            }
            stringBuffer.append("{cinemaId:"+"\""+releaseFilmId+"\""+"}");
        }
        stringBuffer.append("]");
        System.out.println(stringBuffer.toString());
        return stringBuffer.toString();
    }

    @RequestMapping("/findCinemaByName")
    public String findCinemaByName(String cinemaName){
        List<CinemaEntity> cinemaEntityList= cinemaService.findCinemaByCityName(cinemaName);
        return strJson(cinemaEntityList);
    }

    @RequestMapping("/findCinemaByCinemaId")
    public String findCinemaByCinemaId(String cinemaIds){
        String cinemaIdStr[]=cinemaIds.split(",");
        List<CinemaEntity> cinemaEntityList=cinemaService.findCinemaByCinemaId(cinemaIdStr);
        return strJson(cinemaEntityList);
    }



    private String strJson(List<CinemaEntity> cinemaEntityList){
        if (cinemaEntityList!=null && cinemaEntityList.size()>0) {
            StringBuffer strFilms = new StringBuffer();
            strFilms.append('[');
            for (CinemaEntity entity : cinemaEntityList) {
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
