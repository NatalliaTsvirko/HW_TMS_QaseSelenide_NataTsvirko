package models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Defects {
    String title;
    String code;
    String actualResult;
    int severity;
    int milestoneId;
}
