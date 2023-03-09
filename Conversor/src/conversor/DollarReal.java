package conversor;

public class DollarReal {
    private double txConversao = 5.14;
    
    public double getDollarReal(double valorInserido){
        return valorInserido * txConversao;
    }
}
