package models;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AllDefects {
    int count;
    int filtered;
    int total;
    Defects [] entities;
    Defects [] customFields;
    Defects [] attachments;
    String created;
    String updated;
    String deleted;
    String resolved;
    int projectId;
    int memberId;
    String externalData;
    Defects [] tags;

}
