package com.example.redditredirector.data.service;

import com.example.redditredirector.data.RequestRepository;
import com.example.redditredirector.models.RequestForRedirect;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


public interface MainRequestGotService {
    List<RequestForRedirect> getAllLinksForUser();
    RequestForRedirect getLinkForRedirectThruLinkGenerated(String linkGenerated);
    RequestForRedirect saveNewLinkEntered(RequestForRedirect request);
    RequestForRedirect disableLink(RequestForRedirect request);
    void deleteLink(Long id);
}
