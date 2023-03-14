package conversor;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import javax.swing.JOptionPane;

public class Conversor {

    public static void main(String[] args) {
        ValidacaoEntrada valida = new ValidacaoEntrada();

        String[] options = {"Dollar para Real", "Euro para Real", "Libras "
        + "Esterlinas para Real", "Peso Argentino para Real", 
        "Peso Chileno para Real", "Real para Dollar", "Real para Euro", 
        "Real para Libras Esterlinas", "Real para Peso Argentino", 
        "Real para Peso Chileno"};
        String escolha = (String) JOptionPane.showInputDialog(null, 
                "Escolha a moeda para a qual você deseja converter:", 
                "Moedas", -1, null, options, args);
        if (escolha == null) {
            while (escolha == null) {
                escolha = (String) JOptionPane.showInputDialog(null, 
                        "Escolha uma moeda válida para a qual você deseja "
                        + "converter:", "Moedas", -1, null, options, args);
                if (escolha == null) {
                    System.exit(0);
                }
            }
        }

        String entrada = JOptionPane.showInputDialog("Informe um valor monetário:");
        
        while (!valida.validaEntrada(entrada) && entrada != null) { //Valida a entrada do valor.
            entrada = JOptionPane.showInputDialog("Informe um valor "
                    + "monetário valido:");
            if (entrada == null) {
                int request = JOptionPane.showConfirmDialog(null, "Deseja tentar novamente?");
                if (request == JOptionPane.YES_OPTION) {
                    main(args);
                } else {
                    JOptionPane.showMessageDialog(null, "Muito Obrigado, Volte Sempre!");
                    System.exit(0);
                }
            }
        }

        double valorInserido = Double.parseDouble(entrada);
        double valorConverter = 0;
        
        NumberFormat valorFormatado = new DecimalFormat("#0.00");
        String msgFinal = "";
        
        switch (escolha) {
            case "Dollar para Real":
                System.out.println("Opção 1: " + valorInserido);
                DollarReal valorDollarReal = new DollarReal();
                valorConverter = valorDollarReal.getDollarReal(valorInserido);
                msgFinal = "Valor Convertido: R$" + valorFormatado.format
                (valorConverter);
                break;
            case "Euro para Real":
                System.out.println("Opção 2: " + valorInserido);
                EuroReal valorEuroReal = new EuroReal();
                valorConverter = valorEuroReal.getEuroReal(valorInserido);
                msgFinal = "Valor Convertido: R$" + valorFormatado.format
                (valorConverter);
                break;
            case "Libras Esterlinas para Real":
                System.out.println("Opção 3: " + valorInserido);
                LibraReal valorLibraReal = new LibraReal();
                valorConverter = valorLibraReal.getLibraReal(valorInserido);
                msgFinal = "Valor Convertido: R$" + valorFormatado.format
                (valorConverter);
                break;
            case "Peso Argentino para Real":
                System.out.println("Opção 4: " + valorInserido);
                PesoArgReal valorPesoArgReal = new PesoArgReal();
                valorConverter = valorPesoArgReal.getPesoArgReal(valorInserido);
                msgFinal = "Valor Convertido: R$" + valorFormatado.format
                (valorConverter);
                break;
            case "Peso Chileno para Real":
                System.out.println("Opção 5: " + valorInserido);
                PesoChiReal valorPesoChiReal = new PesoChiReal();
                valorConverter = valorPesoChiReal.getPesoChiReal(valorInserido);
                msgFinal = "Valor Convertido: R$" + valorFormatado.format
                (valorConverter);
                break;
            case "Real para Dollar":
                System.out.println("Opção 6: " + valorInserido);
                RealDollar valorRealDollar = new RealDollar(); 
                valorConverter = valorRealDollar.getRealDollar(valorInserido);
                msgFinal = "Valor Convertido: US$" + valorFormatado.format
                (valorConverter);
                break;
            case "Real para Euro":
                System.out.println("Opção 7: " + valorInserido);
                RealEuro valorRealEuro = new RealEuro();
                valorConverter = valorRealEuro.getRealEuro(valorInserido);
                msgFinal = "Valor Convertido: €" + valorFormatado.format
                (valorConverter);
                break;
            case "Real para Libras Esterlinas":
                System.out.println("Opção 8: " + valorInserido);
                RealLibra valorRealLibra = new RealLibra();
                valorConverter = valorRealLibra.getRealLibra(valorInserido);
                msgFinal = "Valor Convertido: $" + valorFormatado.format
                (valorConverter);
                break;
            case "Real para Peso Argentino":
                System.out.println("Opção 9: " + valorInserido);
                RealPesoArg valorRealPesoArg = new RealPesoArg();
                valorConverter = valorRealPesoArg.getRealPesoArg(valorInserido);
                msgFinal = "Valor Convertido: $" + valorFormatado.format
                (valorConverter); 
                break;
            case "Real para Peso Chileno":
                System.out.println("Opção 10: " + valorInserido);
                RealPesoChi valorRealPesoChi = new RealPesoChi();
                valorConverter = valorRealPesoChi.getRealPesoChi(valorInserido);
                msgFinal = "Valor Convertido: CLP" + valorFormatado.format
                (valorConverter);
                break;
            default:
                msgFinal = "Opção inválida!";
                break;
        }
        
        JOptionPane.showMessageDialog(null, msgFinal);
        int pergunta = JOptionPane.showConfirmDialog(null, 
                "Deseja Informar outro valor?");
        if (pergunta == JOptionPane.YES_OPTION) {
            main(args);
        } else {
            JOptionPane.showMessageDialog(null, "Muito Obrigado, Volte Sempre!");
            System.exit(0);
        }
    }
}
