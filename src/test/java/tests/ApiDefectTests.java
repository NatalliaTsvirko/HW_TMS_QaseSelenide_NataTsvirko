package tests;

import adapters.DefectAdapter;
import models.AllDefects;
import models.Defects;
import models.DefectsResponseBody;
import models.DefectsResultCode;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.junit.Assert.assertEquals;

public class ApiDefectTests {

    DefectAdapter defectAdapter;

    @BeforeClass
    public void setUp() {
        defectAdapter = new DefectAdapter();

    }

    @Test
    public void getAllDefectsTest() {
        DefectsResponseBody<AllDefects> actualResponse = defectAdapter.getAllDefect(200);
        System.out.println(actualResponse);
        System.out.println(actualResponse.getResult().getEntities()[5].getCode());
    }

    @Test
    public void getSpecificDefectTest() {
        String code = "TD";
        int id = 0;
        Defects expectedDefects = Defects.builder().
                title("TestDemo").
                code(code).
                build();
        DefectsResponseBody<Object> expectedResponseResult = DefectsResponseBody.builder().
                status(true).result(expectedDefects).build();

        DefectsResponseBody<Defects> actualResponseBody = defectAdapter.getSpecificDefect(code, id, 200);

        assertEquals(actualResponseBody, expectedResponseResult);
    }

    @Test
    public void createDefectTest() {
        String defectCode = "TD";

        DefectsResponseBody expectedResponse = DefectsResponseBody.builder().
                status(true).
                result(DefectsResultCode.builder().
                        id(0).
                        build()).
                build();

        Defects defect = Defects.builder().
                title("POIOP").
                code(defectCode).
                actualResult("Hello").
                severity(2).
                build();

        DefectsResponseBody actualResponse = defectAdapter.createDefect(defect);
        assertEquals(actualResponse, expectedResponse);
    }

    @Test
    public void deleteDefectTest() {
        String defectCode = "FGTGGFR";
        int id = 4;
        DefectsResponseBody actualResponse = defectAdapter.deleteDefect(defectCode, id);
        System.out.println(actualResponse);

    }

    @Test
    public void updateDefectTest() {
        String defectCode = "TD";

        Defects defect = Defects.builder().
                actualResult("Hi").
                severity(2).
                build();

        DefectsResponseBody actualResponse = defectAdapter.updateDefect(defectCode, defect);
        System.out.println(actualResponse);
    }

}
