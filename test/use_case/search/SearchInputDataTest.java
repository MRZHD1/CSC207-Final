package use_case.search;

import entity.CommonPlace;
import entity.Place;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

class SearchInputDataTest {

    @Test
    void testGetQuery() throws IOException, InterruptedException {

        String query = "coffee shop";
        String location = "New York";
        SearchInputData searchData = new SearchInputData(query, location);
        String expectedEncodedQuery = URLEncoder.encode(query, StandardCharsets.UTF_8);


        String actualEncodedQuery = searchData.getQuery();


        Assertions.assertEquals(expectedEncodedQuery, actualEncodedQuery, "Encoded query should match expected value");
    }

    @Test
    void testGetLocation() throws IOException, InterruptedException {

        String query = "coffee shop";
        String location = "Ney York";
        SearchInputData searchData = new SearchInputData(query, location);
        Place expectedLocation = new CommonPlace(location);


        Place actualLocation = searchData.getLocation();


        Assertions.assertEquals(expectedLocation.getAddress(), actualLocation.getAddress(), "Location address should match expected value");
    }

    @Test
    void testGetSubject() throws IOException, InterruptedException {

        String query = "coffee shop";
        String location = "Ney York";
        SearchInputData searchData = new SearchInputData(query, location);


        String actualQuery = searchData.getSubject();

        Assertions.assertEquals(query, actualQuery, "Subject should match the original query");
    }

    @Test
    void testGetPinpoint() throws IOException, InterruptedException {
        String query = "coffee shop";
        String location = "Ney York";
        SearchInputData searchData = new SearchInputData(query, location);
        Place expectedLocation = new CommonPlace(location);

        Place actualLocation = searchData.getPinpoint();

        Assertions.assertEquals(expectedLocation.getAddress(), actualLocation.getAddress(), "Pinpoint address should match expected value");
    }
}