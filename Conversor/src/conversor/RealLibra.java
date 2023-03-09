package conversor;

public class RealLibra {
    private double txConversao = 0.16;
    
    public double getRealLibra(double valorInserido) {
        return valorInserido * txConversao;
    }
}
