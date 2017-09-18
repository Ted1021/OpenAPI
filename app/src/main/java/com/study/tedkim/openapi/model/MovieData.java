package com.study.tedkim.openapi.model;

/**
 * Created by tedkim on 2017. 9. 18..
 */

public class MovieData {

    private String total;
    private Items[] items;
    private String start;
    private String lastBuildDate;
    private String display;

    public String getTotal ()
    {
        return total;
    }

    public void setTotal (String total)
    {
        this.total = total;
    }

    public Items[] getItems ()
    {
        return items;
    }

    public void setItems (Items[] items)
    {
        this.items = items;
    }

    public String getStart ()
    {
        return start;
    }

    public void setStart (String start)
    {
        this.start = start;
    }

    public String getLastBuildDate ()
    {
        return lastBuildDate;
    }

    public void setLastBuildDate (String lastBuildDate)
    {
        this.lastBuildDate = lastBuildDate;
    }

    public String getDisplay ()
    {
        return display;
    }

    public void setDisplay (String display)
    {
        this.display = display;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [total = "+total+", items = "+items+", start = "+start+", lastBuildDate = "+lastBuildDate+", display = "+display+"]";
    }

    public class Items
    {
        private String pubDate;
        private String title;
        private String userRating;
        private String link;
        private String subtitle;
        private String image;
        private String actor;
        private String director;

        public String getPubDate ()
        {
            return pubDate;
        }

        public void setPubDate (String pubDate)
        {
            this.pubDate = pubDate;
        }

        public String getTitle ()
        {
            return title;
        }

        public void setTitle (String title)
        {
            this.title = title;
        }

        public String getUserRating ()
        {
            return userRating;
        }

        public void setUserRating (String userRating)
        {
            this.userRating = userRating;
        }

        public String getLink ()
        {
            return link;
        }

        public void setLink (String link)
        {
            this.link = link;
        }

        public String getSubtitle ()
        {
            return subtitle;
        }

        public void setSubtitle (String subtitle)
        {
            this.subtitle = subtitle;
        }

        public String getImage ()
        {
            return image;
        }

        public void setImage (String image)
        {
            this.image = image;
        }

        public String getActor ()
        {
            return actor;
        }

        public void setActor (String actor)
        {
            this.actor = actor;
        }

        public String getDirector ()
        {
            return director;
        }

        public void setDirector (String director)
        {
            this.director = director;
        }

        @Override
        public String toString()
        {
            return "ClassPojo [pubDate = "+pubDate+", title = "+title+", userRating = "+userRating+", link = "+link+", subtitle = "+subtitle+", image = "+image+", actor = "+actor+", director = "+director+"]";
        }
    }
}
