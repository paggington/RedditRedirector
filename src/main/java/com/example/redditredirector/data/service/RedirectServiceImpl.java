package com.example.redditredirector.data.service;

import com.example.redditredirector.data.RequestRepository;
import com.example.redditredirector.models.RequestForRedirect;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class RedirectServiceImpl implements MainRequestGotService{
    private final RequestRepository requestRepository;
    @Override
    public List<RequestForRedirect> getAllLinksForUser() {
        return requestRepository.findAll();
    }

    @Override
    public RequestForRedirect getLinkForRedirectThruLinkGenerated(String linkGenerated) {
        return requestRepository.getByLinkGenerated(linkGenerated);
    }

    @Override
    public RequestForRedirect saveNewLinkEntered(RequestForRedirect request) {
        return requestRepository.save(request);
    }

    @Override
    public RequestForRedirect disableLink(RequestForRedirect request) {
        request.setActive(!request.isActive());
        return requestRepository.save(request);
    }

    @Override
    public void deleteLink(Long id) {
        requestRepository.deleteById(id);
    }
}
