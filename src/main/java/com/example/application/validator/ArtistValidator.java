package com.example.application.validator;

import com.example.application.model.Artist;
import com.example.application.repository.ArtistRepository;
import com.example.application.utils.CurrentYear;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class ArtistValidator implements Validator {

    @Autowired
    private ArtistRepository artistRepository;

    private static final Logger logger = LoggerFactory.getLogger(Artist.class);

    @Override
    public boolean supports(Class<?> aClass) {
        return Artist.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Artist artist=(Artist)o;

        CurrentYear.validateYear(artist.getStartActivityYear());
        CurrentYear.validateYear(artist.getEndActivityYear());

    }
}
