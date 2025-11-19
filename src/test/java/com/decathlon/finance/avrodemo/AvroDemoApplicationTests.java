package com.decathlon.finance.avrodemo;

import com.decathlon.finance.avrodemo.model.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

@SpringBootTest
class AvroDemoApplicationTests {

    @Test
    void generateUserAvsc() throws IOException {
        generateAvsc(User.SCHEMA$.toString(), "target/avsc/user.avsc");
    }


    private Path generateAvsc(String formatted, String path) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        ObjectWriter writer = objectMapper.writerWithDefaultPrettyPrinter();
        return Files.write(Paths.get(path), writer.writeValueAsString(objectMapper.readTree(formatted)).getBytes(), StandardOpenOption.CREATE);
    }



}
