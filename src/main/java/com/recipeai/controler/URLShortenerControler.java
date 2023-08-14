package com.recipeai.controler;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import com.recipeai.exception.ExpiredUrlException;
import com.recipeai.exception.URLNotFoundException;

import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("/api/url")
public class URLShortenerControler {
    private static final String HTTPPrefix = "http://";

   /*  
    @RequestMapping(value = "/shorten",
            method = RequestMethod.POST,
            produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public URLShortenerDTO saveURL(@RequestParam(value = "originalURL") String originalURL) {
        return urlService.saveUrl(originalURL);
    }
        
    @GetMapping(value = "/reverse")
    public RedirectView getURL(@RequestParam(value = "shortenedURL") String shortenedURL) throws URLNotFoundException, ExpiredUrlException {
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl(HTTPPrefix + urlService.getURL(shortenedURL).getOriginalURL());
  
        return redirectView;
    }*/
}
