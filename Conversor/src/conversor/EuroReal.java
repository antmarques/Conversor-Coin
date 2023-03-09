package conversor;

public class EuroReal {
    private double txConversao = 5.42;
    
    public double getEuroReal(double valorInserido) {
        return valorInserido * txConversao;
    }
}
