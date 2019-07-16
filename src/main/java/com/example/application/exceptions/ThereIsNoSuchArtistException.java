package com.example.application.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "ARTIST_DOES_NOT_EXIST")
public class ThereIsNoSuchArtistException extends RuntimeException {
}
