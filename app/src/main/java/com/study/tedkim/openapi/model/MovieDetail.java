package com.study.tedkim.openapi.model;

/**
 * Created by tedkim on 2017. 9. 18..
 */

public class MovieDetail {

    private MovieInfoResult movieInfoResult;

    public MovieInfoResult getMovieInfoResult ()
    {
        return movieInfoResult;
    }

    public void setMovieInfoResult (MovieInfoResult movieInfoResult)
    {
        this.movieInfoResult = movieInfoResult;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [movieInfoResult = "+movieInfoResult+"]";
    }

    public class MovieInfoResult
    {
        private String source;

        private MovieInfo movieInfo;

        public String getSource ()
        {
            return source;
        }

        public void setSource (String source)
        {
            this.source = source;
        }

        public MovieInfo getMovieInfo ()
        {
            return movieInfo;
        }

        public void setMovieInfo (MovieInfo movieInfo)
        {
            this.movieInfo = movieInfo;
        }

        @Override
        public String toString()
        {
            return "ClassPojo [source = "+source+", movieInfo = "+movieInfo+"]";
        }

        public class MovieInfo
        {
            private String typeNm;

            private Genres[] genres;

            private Companys[] companys;

            private String showTm;

            private ShowTypes[] showTypes;

            private String movieCd;

            private Staffs[] staffs;

            private String movieNm;

            private String movieNmOg;

            private String openDt;

            private Actors[] actors;

            private String movieNmEn;

            private String prdtYear;

            private Directors[] directors;

            private Nations[] nations;

            private String prdtStatNm;

            private Audits[] audits;

            public String getTypeNm ()
            {
                return typeNm;
            }

            public void setTypeNm (String typeNm)
            {
                this.typeNm = typeNm;
            }

            public Genres[] getGenres ()
            {
                return genres;
            }

            public void setGenres (Genres[] genres)
            {
                this.genres = genres;
            }

            public Companys[] getCompanys ()
            {
                return companys;
            }

            public void setCompanys (Companys[] companys)
            {
                this.companys = companys;
            }

            public String getShowTm ()
            {
                return showTm;
            }

            public void setShowTm (String showTm)
            {
                this.showTm = showTm;
            }

            public ShowTypes[] getShowTypes ()
            {
                return showTypes;
            }

            public void setShowTypes (ShowTypes[] showTypes)
            {
                this.showTypes = showTypes;
            }

            public String getMovieCd ()
            {
                return movieCd;
            }

            public void setMovieCd (String movieCd)
            {
                this.movieCd = movieCd;
            }

            public Staffs[] getStaffs ()
            {
                return staffs;
            }

            public void setStaffs (Staffs[] staffs)
            {
                this.staffs = staffs;
            }

            public String getMovieNm ()
            {
                return movieNm;
            }

            public void setMovieNm (String movieNm)
            {
                this.movieNm = movieNm;
            }

            public String getMovieNmOg ()
            {
                return movieNmOg;
            }

            public void setMovieNmOg (String movieNmOg)
            {
                this.movieNmOg = movieNmOg;
            }

            public String getOpenDt ()
            {
                return openDt;
            }

            public void setOpenDt (String openDt)
            {
                this.openDt = openDt;
            }

            public Actors[] getActors ()
            {
                return actors;
            }

            public void setActors (Actors[] actors)
            {
                this.actors = actors;
            }

            public String getMovieNmEn ()
            {
                return movieNmEn;
            }

            public void setMovieNmEn (String movieNmEn)
            {
                this.movieNmEn = movieNmEn;
            }

            public String getPrdtYear ()
            {
                return prdtYear;
            }

            public void setPrdtYear (String prdtYear)
            {
                this.prdtYear = prdtYear;
            }

            public Directors[] getDirectors ()
            {
                return directors;
            }

            public void setDirectors (Directors[] directors)
            {
                this.directors = directors;
            }

            public Nations[] getNations ()
            {
                return nations;
            }

            public void setNations (Nations[] nations)
            {
                this.nations = nations;
            }

            public String getPrdtStatNm ()
            {
                return prdtStatNm;
            }

            public void setPrdtStatNm (String prdtStatNm)
            {
                this.prdtStatNm = prdtStatNm;
            }

            public Audits[] getAudits ()
            {
                return audits;
            }

            public void setAudits (Audits[] audits)
            {
                this.audits = audits;
            }

            @Override
            public String toString()
            {
                return "ClassPojo [typeNm = "+typeNm+", genres = "+genres+", companys = "+companys+", showTm = "+showTm+", showTypes = "+showTypes+", movieCd = "+movieCd+", staffs = "+staffs+", movieNm = "+movieNm+", movieNmOg = "+movieNmOg+", openDt = "+openDt+", actors = "+actors+", movieNmEn = "+movieNmEn+", prdtYear = "+prdtYear+", directors = "+directors+", nations = "+nations+", prdtStatNm = "+prdtStatNm+", audits = "+audits+"]";
            }

            public class Staffs
            {
                private String staffRoleNm;

                private String peopleNm;

                private String peopleNmEn;

                public String getStaffRoleNm ()
                {
                    return staffRoleNm;
                }

                public void setStaffRoleNm (String staffRoleNm)
                {
                    this.staffRoleNm = staffRoleNm;
                }

                public String getPeopleNm ()
                {
                    return peopleNm;
                }

                public void setPeopleNm (String peopleNm)
                {
                    this.peopleNm = peopleNm;
                }

                public String getPeopleNmEn ()
                {
                    return peopleNmEn;
                }

                public void setPeopleNmEn (String peopleNmEn)
                {
                    this.peopleNmEn = peopleNmEn;
                }

                @Override
                public String toString()
                {
                    return "ClassPojo [staffRoleNm = "+staffRoleNm+", peopleNm = "+peopleNm+", peopleNmEn = "+peopleNmEn+"]";
                }
            }

            public class Audits
            {
                private String auditNo;

                private String watchGradeNm;

                public String getAuditNo ()
                {
                    return auditNo;
                }

                public void setAuditNo (String auditNo)
                {
                    this.auditNo = auditNo;
                }

                public String getWatchGradeNm ()
                {
                    return watchGradeNm;
                }

                public void setWatchGradeNm (String watchGradeNm)
                {
                    this.watchGradeNm = watchGradeNm;
                }

                @Override
                public String toString()
                {
                    return "ClassPojo [auditNo = "+auditNo+", watchGradeNm = "+watchGradeNm+"]";
                }
            }

            public class Companys
            {
                private String companyPartNm;

                private String companyNmEn;

                private String companyCd;

                private String companyNm;

                public String getCompanyPartNm ()
                {
                    return companyPartNm;
                }

                public void setCompanyPartNm (String companyPartNm)
                {
                    this.companyPartNm = companyPartNm;
                }

                public String getCompanyNmEn ()
                {
                    return companyNmEn;
                }

                public void setCompanyNmEn (String companyNmEn)
                {
                    this.companyNmEn = companyNmEn;
                }

                public String getCompanyCd ()
                {
                    return companyCd;
                }

                public void setCompanyCd (String companyCd)
                {
                    this.companyCd = companyCd;
                }

                public String getCompanyNm ()
                {
                    return companyNm;
                }

                public void setCompanyNm (String companyNm)
                {
                    this.companyNm = companyNm;
                }

                @Override
                public String toString()
                {
                    return "ClassPojo [companyPartNm = "+companyPartNm+", companyNmEn = "+companyNmEn+", companyCd = "+companyCd+", companyNm = "+companyNm+"]";
                }
            }

            public class ShowTypes
            {
                private String showTypeGroupNm;

                private String showTypeNm;

                public String getShowTypeGroupNm ()
                {
                    return showTypeGroupNm;
                }

                public void setShowTypeGroupNm (String showTypeGroupNm)
                {
                    this.showTypeGroupNm = showTypeGroupNm;
                }

                public String getShowTypeNm ()
                {
                    return showTypeNm;
                }

                public void setShowTypeNm (String showTypeNm)
                {
                    this.showTypeNm = showTypeNm;
                }

                @Override
                public String toString()
                {
                    return "ClassPojo [showTypeGroupNm = "+showTypeGroupNm+", showTypeNm = "+showTypeNm+"]";
                }
            }

            public class Actors
            {
                private String cast;

                private String castEn;

                private String peopleNm;

                private String peopleNmEn;

                public String getCast ()
                {
                    return cast;
                }

                public void setCast (String cast)
                {
                    this.cast = cast;
                }

                public String getCastEn ()
                {
                    return castEn;
                }

                public void setCastEn (String castEn)
                {
                    this.castEn = castEn;
                }

                public String getPeopleNm ()
                {
                    return peopleNm;
                }

                public void setPeopleNm (String peopleNm)
                {
                    this.peopleNm = peopleNm;
                }

                public String getPeopleNmEn ()
                {
                    return peopleNmEn;
                }

                public void setPeopleNmEn (String peopleNmEn)
                {
                    this.peopleNmEn = peopleNmEn;
                }

                @Override
                public String toString()
                {
                    return "ClassPojo [cast = "+cast+", castEn = "+castEn+", peopleNm = "+peopleNm+", peopleNmEn = "+peopleNmEn+"]";
                }
            }

            public class Directors
            {
                private String peopleNm;

                private String peopleNmEn;

                public String getPeopleNm ()
                {
                    return peopleNm;
                }

                public void setPeopleNm (String peopleNm)
                {
                    this.peopleNm = peopleNm;
                }

                public String getPeopleNmEn ()
                {
                    return peopleNmEn;
                }

                public void setPeopleNmEn (String peopleNmEn)
                {
                    this.peopleNmEn = peopleNmEn;
                }

                @Override
                public String toString()
                {
                    return "ClassPojo [peopleNm = "+peopleNm+", peopleNmEn = "+peopleNmEn+"]";
                }
            }

        }

        public class Genres
        {
            private String genreNm;

            public String getGenreNm ()
            {
                return genreNm;
            }

            public void setGenreNm (String genreNm)
            {
                this.genreNm = genreNm;
            }

            @Override
            public String toString()
            {
                return "ClassPojo [genreNm = "+genreNm+"]";
            }
        }

        public class Nations
        {
            private String nationNm;

            public String getNationNm ()
            {
                return nationNm;
            }

            public void setNationNm (String nationNm)
            {
                this.nationNm = nationNm;
            }

            @Override
            public String toString()
            {
                return "ClassPojo [nationNm = "+nationNm+"]";
            }
        }
    }

}
