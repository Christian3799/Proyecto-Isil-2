package pe.isil.model;

import java.sql.Timestamp;

public class Film {
    private Integer id;
    private String title;
    private String description;
    private Timestamp rentalDuration;
    private String release_year;
    private Double rentalRate;
    private Integer length;
    private Double replacementCost;
    private Integer rating;
    private String specialFeatures;

    public Film() {
    }

    public Film(Integer id, String title, String description, Timestamp rentalDuration, String release_year, Double rentalRate, Integer length, Double replacementCost, Integer rating, String specialFeatures) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.rentalDuration = rentalDuration;
        this.release_year = release_year;
        this.rentalRate = rentalRate;
        this.length = length;
        this.replacementCost = replacementCost;
        this.rating = rating;
        this.specialFeatures = specialFeatures;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Timestamp getRentalDuration() {
        return rentalDuration;
    }

    public void setRentalDuration(Timestamp rentalDuration) {
        this.rentalDuration = rentalDuration;
    }

    public String getRelease_year() {
        return release_year;
    }

    public void setRelease_year(String release_year) {
        this.release_year = release_year;
    }

    public Double getRentalRate() {
        return rentalRate;
    }

    public void setRentalRate(Double rentalRate) {
        this.rentalRate = rentalRate;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public Double getReplacementCost() {
        return replacementCost;
    }

    public void setReplacementCost(Double replacementCost) {
        this.replacementCost = replacementCost;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public String getSpecialFeatures() {
        return specialFeatures;
    }

    public void setSpecialFeatures(String specialFeatures) {
        this.specialFeatures = specialFeatures;
    }
}
