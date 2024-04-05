package az.training.test.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseStatus {

private Integer code;
private String message;

private static final Integer SUCCESS_CODE = 1;
private static final String SUCCESS_MESSAGE = "succeess";
    public static ResponseStatus getSuccessMessage(){
        return new ResponseStatus(SUCCESS_CODE, SUCCESS_MESSAGE);
    }
}
