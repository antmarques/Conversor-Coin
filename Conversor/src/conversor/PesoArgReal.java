package conversor;

public class PesoArgReal {
    private double txConversao = 0.026;
    
    public double getPesoArgReal(double valorInserido) {
        return valorInserido * txConversao;
    }
}
