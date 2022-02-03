package tests;

import adapters.ProjectAdapter;
import models.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertEquals;

public class ApiProjectTests {


    ProjectAdapter projectAdapter;


    @BeforeMethod
    public void setUp() {
        projectAdapter = new ProjectAdapter();

    }


    @Test
    public void positiveApiTest() {

        given().
                header("Token", "f63c6d812b840ce064c0d44e0d3da57af382ebdb").
                header("content-type", "application/json").
                body("{\"title\": \"qa_14\",\"code\": \"qwe\"}").
        when().
                post("https://api.qase.io/v1/project").
                then().log().all().statusCode(200)
        .body("status", equalTo(true));
    }

    @Test
    public void getProjectTest() {
        String code = "TD";
        Project expectedProject = Project.builder().
                title("Test_Demo").
                code(code).
                counts(Counts.builder().
                        suites(0).
                        cases(0).
                        milestones(0).
                        projectDefectsModel(ProjectDefectsModel.builder().
                                open(1).
                                total(1).
                                build()).
                        runs(Runs.builder().
                                total(0).
                                active(0).
                                build()).
                        build()).
                build();
        ProjectResponseBody<Object> expectedResponseResult = ProjectResponseBody.builder().
                status(true).result(expectedProject).build();

        ProjectResponseBody<Project> actualResponseBody = projectAdapter.getProjects(code, 200);

        assertEquals(actualResponseBody, expectedResponseResult);
    }

    @Test
    public void getProjectNegative() {

        String code = "5gsfhtth565ghsh";
        new ProjectAdapter().getProjects(code, 404);


    }

    @Test
    public void createProjectPositiveTest1() {
        String projectCode = "LGJGGDFHR";

        ProjectResponseBody expectedResponse = ProjectResponseBody.builder().
                status(true).
                result(ProjectsResultCode.builder().
                        code(projectCode).
                        build()).
                build();

        Project project = Project.builder().
                title("QA_14_5").
                code(projectCode).
                build();

        ProjectResponseBody actualResponse = projectAdapter.createProject(project);
        assertEquals(actualResponse, expectedResponse);
    }

    @Test
    public void getAllProjectsTest() {
        ProjectResponseBody<AllProjects> actualResponse = projectAdapter.getAllProjects(200);
        System.out.println(actualResponse);
        System.out.println(actualResponse.getResult().getEntities()[9].getCode());
    }

    @Test
    public void deleteProjectTest(){
        String projectCode = "LGJGGDFHR";
        ProjectResponseBody<AllProjects> actualResponse = projectAdapter.deleteProject(projectCode);
        System.out.println(actualResponse);

    }


}

