package az.training.test.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Response<T> {
    @JsonProperty("response")
    private T t;

private ResponseStatus responseStatus;
}
