package conversor;

public class RealPesoChi {
    private double txConversao = 155.85;
    
    public double getRealPesoChi(double valorInserido) {
        return valorInserido * txConversao;
    }
}
