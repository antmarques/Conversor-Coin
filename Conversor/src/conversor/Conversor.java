package conversor;

import client.ClientEconomic;

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

        double valorInserido = Double.parseDouble(entrada.replaceAll(",","."));
        double valorConverter = 0;
        
        NumberFormat valorFormatado = new DecimalFormat("#0.00");
        String msgFinal = "";

        Moedas moedas = new ClientEconomic().getMoedas();
        
        switch (escolha) {
            case "Dollar para Real":
                System.out.println("Opção 1: " + valorInserido);
                valorConverter = valorInserido * moedas.getDolarParaReal().getBid();
                msgFinal = "Valor Convertido: R$" + valorFormatado.format(valorConverter);
                break;
            case "Euro para Real":
                System.out.println("Opção 2: " + valorInserido);
                valorConverter = valorInserido * moedas.getEuroParaReal().getBid();
                msgFinal = "Valor Convertido: R$" + valorFormatado.format(valorConverter);
                break;
            case "Libras Esterlinas para Real":
                System.out.println("Opção 3: " + valorInserido);
                valorConverter = valorInserido * moedas.getLibraParaReal().getBid();
                msgFinal = "Valor Convertido: R$" + valorFormatado.format(valorConverter);
                break;
            case "Peso Argentino para Real":
                System.out.println("Opção 4: " + valorInserido);
                valorConverter = valorInserido * moedas.getPesoArgParaReal().getBid();
                msgFinal = "Valor Convertido: R$" + valorFormatado.format(valorConverter);
                break;
            case "Peso Chileno para Real":
                System.out.println("Opção 5: " + valorInserido);
                valorConverter = valorInserido * moedas.getPesoChiParaReal().getBid();
                msgFinal = "Valor Convertido: R$" + valorFormatado.format(valorConverter);
                break;
            case "Real para Dollar":
                System.out.println("Opção 6: " + valorInserido);
                valorConverter = valorInserido * moedas.getRealParaDolar().getBid();
                msgFinal = "Valor Convertido: US$" + valorFormatado.format(valorConverter);
                break;
            case "Real para Euro":
                System.out.println("Opção 7: " + valorInserido);
                valorConverter = valorInserido * moedas.getRealParaEuro().getBid();
                msgFinal = "Valor Convertido: €" + valorFormatado.format(valorConverter);
                break;
            case "Real para Libras Esterlinas":
                System.out.println("Opção 8: " + valorInserido);
                valorConverter = valorInserido * moedas.getRealParaLibra().getBid();
                msgFinal = "Valor Convertido: $" + valorFormatado.format(valorConverter);
                break;
            case "Real para Peso Argentino":
                System.out.println("Opção 9: " + valorInserido);
                valorConverter = valorInserido * moedas.getRealParaPesoArg().getBid();
                msgFinal = "Valor Convertido: $" + valorFormatado.format(valorConverter);
                break;
            case "Real para Peso Chileno":
                System.out.println("Opção 10: " + valorInserido);
                valorConverter = valorInserido * moedas.getRealParaPesoChi().getBid();
                msgFinal = "Valor Convertido: CLP" + valorFormatado.format(valorConverter);
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
