package client;

import conversor.Moedas;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

class ClientEconomicTest {

    @Test
    public void test() {
        ClientEconomic client = new ClientEconomic();
        try {
            Assertions.assertInstanceOf(Moedas.class, client.getMoedas(client.endpoint));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}