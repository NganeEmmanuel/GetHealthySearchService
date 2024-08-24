package com.gethealthy.searchservice.service;

import com.gethealthy.searchservice.model.SearchResult;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchServiceImpl implements SearchService {
    @Override
    public List<SearchResult> search(String term) {
        //Todo -- send the term to the SicknessCycle service to be queried
        //Todo -- send the term to the event service to be queried
        //Todo -- merge each result into a list of SearchResult objects
        return List.of(); //todo return list of SearchResult
    }

    @Override
    public List<SearchResult> searchEvent(String term) {
        //Todo -- send the term to the event service to be queried
        //Todo -- merge each result into a list of SearchResult objects
        return List.of(); //todo return list of SearchResult
    }

    @Override
    public List<SearchResult> searchIllnessCycle(String term) {
        //Todo -- send the term to the SicknessCycle service to be queried
        //Todo -- merge each result into a list of SearchResult objects
        return List.of(); //todo return list of SearchResult
    }
}
