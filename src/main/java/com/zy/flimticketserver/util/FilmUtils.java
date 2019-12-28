package com.zy.flimticketserver.util;


import com.zy.flimticketserver.entity.Actor;
import com.zy.flimticketserver.entity.Director;
import com.zy.flimticketserver.entity.FilmEntity;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.*;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class FilmUtils {

    private static String readAll(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
            sb.append((char) cp);
        }
        return sb.toString();
    }

    public static JSONObject readJsonFromUrl(String url) throws IOException, JSONException {
        InputStream instream = new URL(url).openStream();
        try {
            BufferedReader rd = new BufferedReader(new InputStreamReader(instream, Charset.forName("UTF-8")));
            String jsonText = readAll(rd);
            JSONObject json = new JSONObject(jsonText);
            return json;
        }catch (Exception e){
            e.printStackTrace();
        } finally{
            instream.close();
        }
        return null;
    }

    public static void main(String[] args) throws IOException, JSONException {

        List<FilmEntity> filmList=new ArrayList<>();
        String url = "http://api01.idataapi.cn:8000/video/taopiaopiao?cityid=440300&apikey=ZMwoX5DKtFz93TWPfr9Eh5Bubs6I1eWBmOYVJa0cGiLTXc2siGKThgW0tDcnRkUa";
        JSONObject json = readJsonFromUrl(url);
        Object retcode = json.get("retcode");
        if (retcode != null) {
            if (retcode.equals("000000")) { //返回状态码"000000"表示正常

                String jsonStr=json.toString();//转化字符串
                String jsonStrs=jsonStr.substring(jsonStr.indexOf("["),jsonStr.lastIndexOf("]")+1);//提纯字符
                System.out.println("jsonStr->"+jsonStrs);
                JSONArray array=new JSONArray(jsonStrs); //数组
                System.out.println("object->"+array.get(0));

                for (int i=0;i<array.length();i++){
                    JSONObject filmInfo=array.getJSONObject(i);
                    //导演
                    JSONArray directors=filmInfo.getJSONArray("directors");
                    List<Director> directorList=new ArrayList<>();
                    for (int t=0;t<directors.length();t++) {
                        JSONObject object = directors.getJSONObject(t);
                        Director director = new Director(object.getString("id"),
                                object.getString("nameEng"), object.getString("name"));
                        directorList.add(director);
                    }
                    //演员
                    JSONArray jsonArray=filmInfo.getJSONArray("actors");
                    List<Actor> actorsList=new ArrayList<>();
                    for (int j=0;j<jsonArray.length();j++){
                        JSONObject actors=jsonArray.getJSONObject(j);
                        Actor actor=new Actor(actors.getString("id"),
                                actors.getString("nameEng"),actors.getString("name"));
                        actorsList.add(actor);
                    }
                    //电影
                    FilmEntity film=new FilmEntity();
                    film.setActorsList(actorsList); //演员
                    film.setDirectorList(directorList); //导演
                    Object d=filmInfo.get("rating");
                    if (!"null".equals(d) && !(d==null)) {
                        film.setRating(0); //评分
                    }else{
                        film.setRating((Double)d);
                    }
                    film.setDescription(filmInfo.getString("description")); //描述
                    film.setFilmName(filmInfo.getString("title")); //名称
                    //类型

                    String genres=filmInfo.getJSONArray("genres").toString();
                    genres=genres.replace("[","");
                    film.setGenres(genres);
                    //时长
                    film.setDurationMin(filmInfo.getInt("durationMin"));
                    //语言
                    String languages=filmInfo.getJSONArray("languages").toString();
                    languages=languages.replace("[","");
                    film.setLanguage(languages);
                    //国家
                    String countries=filmInfo.getJSONArray("countries").toString();
                    countries=countries.replace("[","");
                    film.setCountries(countries);
                    //上映时间
                    String releaseDates=filmInfo.getJSONArray("releaseDates").toString();
                    releaseDates=releaseDates.replace("[","");
                    film.setReleaseDates(releaseDates);
                    //图片
                    film.setCoverUrl(filmInfo.getString("coverUrl"));
                    //荧幕类型
                    String screenTypes=filmInfo.optString("screenTypes").toString();
                    screenTypes=screenTypes.replace("[","");
                    film.setScreenTypes(screenTypes);

                    String id=UUID.randomUUID().toString();
                    film.setFilmId(id);
                    String kk="12";
                    filmList.add(film);
                }
            }
        }
    }

//    Object retcode = json.get("retcode");
//        if (retcode != null) {
//        if (retcode.equals("000000")) { //返回状态码"000000"表示正常
//            String str=json.toString();
//            String []strs=str.split("\"directors\"");
//            for (int i=0;i<strs.length;i++){
//                String s=strs[i];
//                String daoyuan=s.substring(s.indexOf(":[{")+1,s.indexOf("\"}],"));
//                System.out.println("daoyuan->"+daoyuan);
//
//                System.out.println(i+"->"+strs[i]);
//            }
//
//            String film="";
//            //System.out.println(json.toString()); //接口返回正常 打印数据内容
//        } else { // 其它返回状态码,表示无法继续
//            System.out.println(json.getString("message")); //打印状态信息
//        }
//    }
}
