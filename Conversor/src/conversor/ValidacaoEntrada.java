package conversor;

public class ValidacaoEntrada {
    public boolean validaEntrada(String entrada) {
        try {
            Double.parseDouble(entrada);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
