package conversor;

public class RealDollar {
    private double txConversao = 0.19;
    
    public double getRealDollar(double valorInserido) {
        return valorInserido * txConversao;
    }
}
