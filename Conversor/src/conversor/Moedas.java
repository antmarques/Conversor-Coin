package conversor;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Moedas {

    @JsonProperty("USDBRL")
    private Moeda dolarParaReal;

    @JsonProperty("BRLUSD")
    private Moeda realParaDolar;

    @JsonProperty("EURBRL")
    private Moeda euroParaReal;

    @JsonProperty("BRLEUR")
    private Moeda realParaEuro;

    @JsonProperty("GBPBRL")
    private Moeda libraParaReal;

    @JsonProperty("BRLGBP")
    private Moeda realParaLibra;

    @JsonProperty("ARSBRL")
    private Moeda pesoArgParaReal;

    @JsonProperty("BRLARS")
    private Moeda realParaPesoArg;

    @JsonProperty("CLPBRL")
    private Moeda pesoChiParaReal;

    @JsonProperty("BRLCLP")
    private Moeda realParaPesoChi;
}