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
            JOptionPane.showMessageDialog(null, "Muito Obrigado, Volte Sempre!");
            System.exit(0);
        }

        String entrada = JOptionPane.showInputDialog("Informe um valor monetário:");

        while (!valida.validaEntrada(entrada)) {
            entrada = JOptionPane.showInputDialog("Informe um valor "
                    + "monetário valido:");
            if (entrada == null) {
                int request = JOptionPane.showConfirmDialog(null, "Deseja tentar novamente?");
                if (request == JOptionPane.YES_OPTION) {
                    main(options);
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

        switch (escolha) {
            case "Dollar para Real":
                Moedas dollarreal = new ClientEconomic().getMoedas(escolha);
                System.out.println("Opção 1: " + valorInserido);
                valorConverter = valorInserido * dollarreal.getDolarParaReal().getBid();
                msgFinal = "Valor Convertido: R$" + valorFormatado.format(valorConverter);
                break;
            case "Euro para Real":
                Moedas euroreal = new ClientEconomic().getMoedas(escolha);
                System.out.println("Opção 2: " + valorInserido);
                valorConverter = valorInserido * euroreal.getEuroParaReal().getBid();
                msgFinal = "Valor Convertido: R$" + valorFormatado.format(valorConverter);
                break;
            case "Libras Esterlinas para Real":
                Moedas librareal = new ClientEconomic().getMoedas(escolha);
                System.out.println("Opção 3: " + valorInserido);
                valorConverter = valorInserido * librareal.getLibraParaReal().getBid();
                msgFinal = "Valor Convertido: R$" + valorFormatado.format(valorConverter);
                break;
            case "Peso Argentino para Real":
                Moedas pesoargreal = new ClientEconomic().getMoedas(escolha);
                System.out.println("Opção 4: " + valorInserido);
                valorConverter = valorInserido * pesoargreal.getPesoArgParaReal().getBid();
                msgFinal = "Valor Convertido: R$" + valorFormatado.format(valorConverter);
                break;
            case "Peso Chileno para Real":
                Moedas pesochireal = new ClientEconomic().getMoedas(escolha);
                System.out.println("Opção 5: " + valorInserido);
                valorConverter = valorInserido * pesochireal.getPesoChiParaReal().getBid();
                msgFinal = "Valor Convertido: R$" + valorFormatado.format(valorConverter);
                break;
            case "Real para Dollar":
                Moedas realdollar = new ClientEconomic().getMoedas(escolha);
                System.out.println("Opção 6: " + valorInserido);
                valorConverter = valorInserido * realdollar.getRealParaDolar().getBid();
                msgFinal = "Valor Convertido: US$" + valorFormatado.format(valorConverter);
                break;
            case "Real para Euro":
                Moedas realeuro = new ClientEconomic().getMoedas(escolha);
                System.out.println("Opção 7: " + valorInserido);
                valorConverter = valorInserido * realeuro.getRealParaEuro().getBid();
                msgFinal = "Valor Convertido: €" + valorFormatado.format(valorConverter);
                break;
            case "Real para Libras Esterlinas":
                Moedas reallibra = new ClientEconomic().getMoedas(escolha);
                System.out.println("Opção 8: " + valorInserido);
                valorConverter = valorInserido * reallibra.getRealParaLibra().getBid();
                msgFinal = "Valor Convertido: $" + valorFormatado.format(valorConverter);
                break;
            case "Real para Peso Argentino":
                Moedas realpesoarg = new ClientEconomic().getMoedas(escolha);
                System.out.println("Opção 9: " + valorInserido);
                valorConverter = valorInserido * realpesoarg.getRealParaPesoArg().getBid();
                msgFinal = "Valor Convertido: $" + valorFormatado.format(valorConverter);
                break;
            case "Real para Peso Chileno":
                Moedas realpesochi = new ClientEconomic().getMoedas(escolha);
                System.out.println("Opção 10: " + valorInserido);
                valorConverter = valorInserido * realpesochi.getRealParaPesoChi().getBid();
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
            main(options);
        } else {
            JOptionPane.showMessageDialog(null, "Muito Obrigado, Volte Sempre!");
            System.exit(0);
        }
    }
}
