package adsmanagement.domain.ads;

import adsmanagement.domain.exeptions.TitleAndBodyEquality;
import adsmanagement.domain.exeptions.TooManyCharacters;
import adsmanagement.services.Id;

import java.util.Date;
import java.util.Objects;

public class Ad{
    private Title title;
    private Body body;
    private Date date;
    private Id id;
    private Integer views;

    public Ad(Title title, Body body, Date date, Id id) {
        this.title = title;
        this.body = body;
        this.date = date;
        this.id = id;
        this.views = 0;
    }

    public Ad add(Ad ad) throws TooManyCharacters, TitleAndBodyEquality {
        if(title.toString().length() > 50) throw new TooManyCharacters();
        if(title.toString().equals(body.toString())) throw new TitleAndBodyEquality();
        return ad;
    }
    public Id getId(){
       return this.id;
    }
    public Date getDate() {
        return  this.date;
    }

    public Integer getViews() {
        return  this.views++;
    }

    public Integer views() {
        return  this.views;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ad ad = (Ad) o;
        return Objects.equals(title, ad.title) &&
                Objects.equals(body, ad.body) &&
                Objects.equals(date, ad.date) &&
                Objects.equals(id, ad.id) &&
                Objects.equals(views, ad.views);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, body, date, id, views);
    }

    @Override
    public String toString() {
        return "Ad{" +
                "title=" + title +
                ", body=" + body +
                ", date=" + date +
                ", id=" + id +
                ", views=" + views +
                '}';
    }
}



