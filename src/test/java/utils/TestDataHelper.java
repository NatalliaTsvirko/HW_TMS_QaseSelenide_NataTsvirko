package utils;

import com.github.javafaker.Faker;
import models.TestCase;

public class TestDataHelper {

    public static TestCase getTestCaseData() {
        Faker faker = new Faker();
        TestCase dataTestCase = TestCase.builder()
                .title(faker.name().title())
                .description("Hello")
                .pre_conditions("set")
                .post_conditions("get")
                .priority("Medium")
                .severity("Major")
                .type("Usability")
                .suite("Test cases without suite")
                .build();
        return dataTestCase;
    }
}
