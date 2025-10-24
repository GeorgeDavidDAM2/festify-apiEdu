package com.GeorgeDavidDAM2.festify_apiEdu.utils.exception;

public class ArtistNotFoundException extends RuntimeException { //interfaces se implementan con "implements" y las clases se extienden con "extends"
    public ArtistNotFoundException(String message) {
        super(message);
    }
    
}
