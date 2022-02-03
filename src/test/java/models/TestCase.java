package models;



import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TestCase {

    private String title;
    private String description;
    private String pre_conditions;
    private String post_conditions;
    private String suite;
    private String severity;
    private String priority;
    private String type;
}
