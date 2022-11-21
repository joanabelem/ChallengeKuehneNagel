package models;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class RatesOutput {

    private String max;
    private String min;

}
