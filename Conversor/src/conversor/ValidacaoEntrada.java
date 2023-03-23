package conversor;

public class ValidacaoEntrada {
    public boolean validaEntrada(String entrada) {
        try {
            if (entrada == null) {
                return false;
            }
            Double.parseDouble(entrada.replaceAll(",","."));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
