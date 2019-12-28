package com.zy.flimticketserver.controller;

import com.zy.flimticketserver.entity.FilmEntity;
import com.zy.flimticketserver.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
public class FilmController {

    @Autowired
    private FilmService filmService;

    @RequestMapping("/findFilms")
    public String findFilms(){
        List<FilmEntity> filmEntityList=filmService.findFilms();
        return jsonStr(filmEntityList);
    }

    @RequestMapping("/findFilmByName")
    public String findFilmByName(HttpServletRequest request) {
        String filmName=request.getParameter("filmName");
        List<FilmEntity> filmEntityList=filmService.findFilmByName(filmName);
        return jsonStr(filmEntityList);
    }

    @RequestMapping("/findFilmById")
    public String findFilmById(String filmIdStr){
        String []filmIds;
        if (filmIdStr.contains(",")){
            filmIds=filmIdStr.split(",");
        }else{
            filmIds=new String[]{filmIdStr};
        }
        List<FilmEntity> filmEntityList=filmService.findFilmById(filmIds);
        return jsonStr(filmEntityList);
    }

    //将list<FilmEntity>转化为json格式
    private String jsonStr(List<FilmEntity> filmEntityList){
        if (filmEntityList!=null && filmEntityList.size()>0) {
            StringBuffer strFilms = new StringBuffer();
            strFilms.append('[');
            for (FilmEntity entity : filmEntityList) {
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
