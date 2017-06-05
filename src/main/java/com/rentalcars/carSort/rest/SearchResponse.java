package com.rentalcars.carSort.rest;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Nikolai on 3.06.2017.
 */
public class SearchResponse {

    public SearchResponse() {}

    public SearchResponse(Search search) {
        this.search = search;
    }

    @JsonProperty(value = "Search")
    private Search search;

//    public SearchResponse() {}

    public Search getSearch() {
        return search;
    }

    public void setSearch(Search search) {
        this.search = search;
    }
}
