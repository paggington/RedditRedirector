package com.example.redditredirector.resource;

import com.example.redditredirector.data.service.RedirectServiceImpl;
import com.example.redditredirector.models.RequestForRedirect;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/redirect")
@AllArgsConstructor
@CrossOrigin(origins = {"http://localhost:4200"},methods = {
        RequestMethod.DELETE,
        RequestMethod.POST,
        RequestMethod.GET,
        RequestMethod.PUT,
        RequestMethod.PATCH,
        RequestMethod.OPTIONS
})
public class MainRedirectResource {
    private final RedirectServiceImpl redirectService;
    @GetMapping("/all")
    public ResponseEntity<List<RequestForRedirect>> allLinksForUser(){
        return ResponseEntity.ok().body(redirectService.getAllLinksForUser());
    }
    @PostMapping("/save")
    public ResponseEntity<RequestForRedirect> saveNewLinkForRedirecting(@RequestBody RequestForRedirect request){
        request.setLinkGenerated(UUID.randomUUID().toString());
        DateTimeFormatter dateTimeFormatter=DateTimeFormatter.ofPattern("dd MM yyyy HH:mm");
        Date date=new Date();
        request.setDateOfGenerating(dateTimeFormatter.format(date.toInstant()));
        return ResponseEntity.ok().body(redirectService.saveNewLinkEntered(request));
    }
    @GetMapping("/get-link/{link}")
    public ResponseEntity<RequestForRedirect> getLinkThruLinkGenerated(@PathVariable("link")String link){
        return ResponseEntity.ok().body(redirectService.getLinkForRedirectThruLinkGenerated(link));
    }
    @DeleteMapping("/delete-link/{id}")
    public ResponseEntity<Boolean> deleteRequestLink(@PathVariable("id")Long id){
        redirectService.deleteLink(id);
        return ResponseEntity.ok().body(true);
    }
}
