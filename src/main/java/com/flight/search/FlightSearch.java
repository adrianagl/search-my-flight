package com.flight.search;

import java.util.ArrayList;
import java.util.List;

public class FlightSearch {

    public List<SearchResult> run(SearchCriteria criteria) {
        criteria.validate();

        List<SearchResult> results = new ArrayList<>();

        return results;
    }
}
