package com.gethealthy.searchservice.service;

import com.gethealthy.searchservice.model.SearchResult;

import java.util.List;

public interface SearchService {
    /**
     *
     * @param term string to search against
     * @return a list of searchResult objects
     */
    List<SearchResult> search(String term);

    /**
     *
     * @param term string to search against
     * @return a list of searchResult objects
     */
    List<SearchResult> searchEvent(String term);

    /**
     *
     * @param term string to search against
     * @return a list of searchResult objects
     */
    List<SearchResult> searchIllnessCycle(String term);
}
