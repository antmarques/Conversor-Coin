package conversor;

public class RealPesoArg {
    private double txConversao = 38.92;
    
    public double getRealPesoArg(double valorInserido) {
        return valorInserido * txConversao;
    }
}
