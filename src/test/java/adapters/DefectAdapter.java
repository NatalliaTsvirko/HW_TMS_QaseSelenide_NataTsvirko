package adapters;

import com.google.gson.reflect.TypeToken;
import models.*;

public class DefectAdapter extends BaseAdapter {

    final String DEFECTS_URI = "defect/";

    public DefectsResponseBody getAllDefect(int expectedStatusCode) {
        return gson.fromJson(get(DEFECTS_URI, expectedStatusCode),
                new TypeToken<DefectsResponseBody<AllDefects>>() {
                }.getType());
    }

    public DefectsResponseBody getSpecificDefect(String defectsCode, int defectId, int expectedStatusCode) {
        return gson.fromJson(get(DEFECTS_URI + defectsCode + defectId, expectedStatusCode),
                new TypeToken<DefectsResponseBody<Defects>>() {
                }.getType());
    }

    public DefectsResponseBody createDefect(Defects defects) {
        return gson.fromJson(post(DEFECTS_URI, gson.toJson(defects), 200),
                new TypeToken<DefectsResponseBody<DefectsResultCode>>() {
                }.getType());
    }

    public DefectsResponseBody deleteDefect(String defectCode, int id) {
        return gson.fromJson(delete(DEFECTS_URI, gson.toJson(id), 200),
                new TypeToken<DefectsResponseBody<DefectsResultCode>>() {
                }.getType());
    }

    public DefectsResponseBody updateDefect(String defectCode, Defects defects) {
        return gson.fromJson(patch(DEFECTS_URI, gson.toJson(defects), 200),
                new TypeToken<DefectsResponseBody<DefectsResultCode>>() {
                }.getType());
    }

    public DefectsResponseBody resolveSpecificDefect(String defectCode, Defects defects) {
        return gson.fromJson(patch(DEFECTS_URI, gson.toJson(defects), 200),
                new TypeToken<DefectsResponseBody<DefectsResultCode>>() {
                }.getType());
    }

    public DefectsResponseBody updateSpecificDefect(String defectCode, Defects defects) {
        return gson.fromJson(patch(DEFECTS_URI, gson.toJson(defects), 200),
                new TypeToken<DefectsResponseBody<DefectsResultCode>>() {
                }.getType());
    }
}
