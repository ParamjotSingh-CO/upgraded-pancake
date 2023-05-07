package com.paramjot.rest.upgradedpancake.filter;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonFilter("SeriesPropertyFilter")
public class Series {
    @JsonProperty("SeriesName")
    public String SeriesName;
    @JsonProperty("Protagonist")
    public String Protagonist;
    @JsonProperty("Antagonist")
    public String Antagonist;
    @JsonProperty("genre")
    public String genre;

    public Series(String seriesName, String protagonist, String Antagonist, String genre) {
        this.SeriesName = seriesName;
        this.Protagonist = protagonist;
        this.Antagonist = Antagonist;
        this.genre = genre;
    }
}
