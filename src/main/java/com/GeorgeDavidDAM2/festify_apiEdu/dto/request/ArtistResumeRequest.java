package com.GeorgeDavidDAM2.festify_apiEdu.dto.request;

import java.util.List;

public record ArtistResumeRequest(String  id, String name, String country, List<String> genres, Integer listeners,String status) {

}
