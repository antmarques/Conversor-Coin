package conversor;

public class LibraReal {
    private double txConversao = 6.09;
    
    public double getLibraReal(double valorInserido) {
        return valorInserido * txConversao;
    }
}
