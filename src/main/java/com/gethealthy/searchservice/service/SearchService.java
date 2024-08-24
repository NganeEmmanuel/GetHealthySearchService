package com.gethealthy.searchservice.service;

import com.gethealthy.searchservice.model.SearchResult;

import java.util.List;

public interface SearchService {
    /**
     *
     * @param term string to search against
     * @return a list of searchResult objects
     */
    public List<SearchResult> search(String term);
}
