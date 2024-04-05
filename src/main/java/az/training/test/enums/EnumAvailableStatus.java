package az.training.test.enums;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor

public enum EnumAvailableStatus {

    ACTIVE(1), DEACTIVE(0);

    public Integer value;
}
