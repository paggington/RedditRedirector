package com.example.redditredirector.data;

import com.example.redditredirector.models.RequestForRedirect;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RequestRepository extends JpaRepository<RequestForRedirect,Long> {
    RequestForRedirect getByLinkGenerated(String link);
}
