package com.home.shimmerrecyclerdemo.xmlparse;

import com.home.shimmerrecyclerdemo.xmlparse.entities.Result;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;

@Root(name = "PlaceSearchResponse", strict = false)
public class PlaceSearchResponse {

    @Element(name = "next_page_token")
    private String nextPageToken;

    @ElementList(inline = true)
    private List<Result> results = null;

    @Element(name = "status")
    private String status;

    public String getNextPageToken() {
        return nextPageToken;
    }

    public void setNextPageToken(String nextPageToken) {
        this.nextPageToken = nextPageToken;
    }

    public List<Result> getResults() {
        return results;
    }

    public void setResults(List<Result> results) {
        this.results = results;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
