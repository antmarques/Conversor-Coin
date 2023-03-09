package conversor;

public class RealEuro {
    private double txConversao = 0.18;
    
    public double getRealEuro(double valorInserido) {
        return valorInserido * txConversao;
    }
}
