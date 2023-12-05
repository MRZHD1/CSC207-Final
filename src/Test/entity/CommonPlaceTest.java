package entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import org.junit.jupiter.api.Assertions;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;

public class CommonPlaceTest {

    private CommonPlace commonPlace;
    private String validAddress = "New York";

    @TempDir
    Path tempDir;

    @BeforeEach
    public void setUp() throws IOException, InterruptedException {
        File keyFile = tempDir.resolve("key.txt").toFile();
        try (FileWriter writer = new FileWriter(keyFile)) {
            writer.write("dummyApiKey");
        }
        // Set the system property to use the temporary key file
        System.setProperty("user.dir", tempDir.toString());
        commonPlace = new CommonPlace(validAddress);
    }


    @Test
    public void testGetCoordinates() {
        // Act
        String coordinates = commonPlace.getCoordinates();
        // Assert
        Assertions.assertNotNull(coordinates, "Coordinates should not be null after object creation");
    }

    @Test
    public void testSomething(){}


}