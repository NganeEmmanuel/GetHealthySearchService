package com.gethealthy.searchservice.service;

import com.gethealthy.searchservice.feign.EventInterface;
import com.gethealthy.searchservice.feign.IllnessRecordInterface;
import com.gethealthy.searchservice.model.EventDTO;
import com.gethealthy.searchservice.model.IllnessRecordDTO;
import com.gethealthy.searchservice.model.SearchResult;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SearchServiceImpl implements SearchService {
    private final EventInterface eventInterface;
    private final IllnessRecordInterface illnessRecordInterface;
    private final ResultMapperService<EventDTO> eventResultMapperService;
    private final ResultMapperService<IllnessRecordDTO> illnessRecordResultMapperService;

    @Override
    public List<SearchResult> search(String term, String authorizationHeader) {
        var searchResults = new ArrayList<SearchResult>();
        var events = eventInterface.searchEvents(term, authorizationHeader).getBody();
        var illnessRecords = illnessRecordInterface.SearchRecords(term, authorizationHeader).getBody();

        assert events != null;
        if(!events.isEmpty()) {
            eventResultMapperService.addAll(events, searchResults);
        }

        assert illnessRecords != null;
        if(!illnessRecords.isEmpty()) {
            illnessRecordResultMapperService.addAll(illnessRecords, searchResults);
        }

        return searchResults.stream().sorted().toList(); //todo check for returning a shuffled list
    }

    @Override
    public List<SearchResult> searchEvent(String term, String authorizationHeader) {
        var searchResults = new ArrayList<SearchResult>();
        var events = eventInterface.searchEvents(term, authorizationHeader).getBody();

        assert events != null;
        if(!events.isEmpty()) {
            eventResultMapperService.addAll(events, searchResults);
        }

        return searchResults.stream().sorted().toList();
    }

    @Override
    public List<SearchResult> searchIllnessRecord(String term, String authorizationHeader) {
        var searchResults = new ArrayList<SearchResult>();
        var illnessRecords = illnessRecordInterface.SearchRecords(term, authorizationHeader).getBody();

        assert illnessRecords != null;
        if(!illnessRecords.isEmpty()) {
            illnessRecordResultMapperService.addAll(illnessRecords, searchResults);
        }

        return searchResults.stream().sorted().toList();
    }
}
