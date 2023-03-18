package client;

import conversor.Moedas;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ClientEconomicTest {

    @Test
    public void test() {
        ClientEconomic client = new ClientEconomic();
        try {
            Assertions.assertInstanceOf(Moedas.class, client.getMoedas());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
