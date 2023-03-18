package conversor;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.sql.Timestamp;

@Data
public class Moeda {
    private String code;
    private String codein;
    private String name;
    private Double high;
    private Double low;
    private Double varBid;
    private Double bid;
    private Double pctChange;
    private Double ask;
    private Timestamp timestamp;

    @JsonProperty("create_date")
    private String createDate;
}
