package adapters;

import com.google.gson.reflect.TypeToken;
import models.AllCases;
import models.Cases;
import models.CasesResponseBody;
import models.CasesResultCode;

public class CaseAdapter extends BaseAdapter {

    final String CASES_URI = "case/";

    public CasesResponseBody getAllTestCases(String casesCode, int expectedStatusCode) {
        return gson.fromJson(get(CASES_URI + casesCode, expectedStatusCode),
                new TypeToken<CasesResponseBody<AllCases>>() {
                }.getType());
    }

    public CasesResponseBody getSpecificCase(String casesCode, int casesId, int expectedStatusCode) {
        return gson.fromJson(get(CASES_URI + casesCode + casesId, expectedStatusCode),
                new TypeToken<CasesResponseBody<AllCases>>() {
                }.getType());
    }

    public CasesResponseBody createCase(Cases cases) {
        return gson.fromJson(post(CASES_URI, gson.toJson(cases), 200),
                new TypeToken<CasesResponseBody<CasesResultCode>>() {
                }.getType());
    }

    public CasesResponseBody deleteCase(String casesCode, Cases cases) {
        return gson.fromJson(delete(CASES_URI, gson.toJson(cases), 200),
                new TypeToken<CasesResponseBody<CasesResultCode>>() {
                }.getType());
    }

    public CasesResponseBody updateCase(String casesCode, Cases cases) {
        return gson.fromJson(patch(CASES_URI,gson.toJson(cases),200),
                new TypeToken<CasesResponseBody<CasesResultCode>>() {
                }.getType());
    }
}
