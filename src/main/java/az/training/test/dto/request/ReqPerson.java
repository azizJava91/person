package az.training.test.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReqPerson {
    private Long id;
    private String name;
    private String surname;
    private Integer active;
}
