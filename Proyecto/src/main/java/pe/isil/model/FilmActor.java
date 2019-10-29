package pe.isil.model;

public class FilmActor {
    private String filmid;
    private String actorid;

    public FilmActor() {
    }

    public FilmActor(String filmid, String actorid) {
        this.filmid = filmid;
        this.actorid = actorid;
    }

    public String getFilmid() {
        return filmid;
    }

    public void setFilmid(String filmid) {
        this.filmid = filmid;
    }

    public String getActorid() {
        return actorid;
    }

    public void setActorid(String actorid) {
        this.actorid = actorid;
    }
}
