package conversor;

public class PesoChiReal {
    private double txConversao = 0.0064;
    
    public double getPesoChiReal(double valorInserido) {
        return valorInserido * txConversao;
    }
}
