package client;

import org.junit.jupiter.api.Test;

class ClientEconomicTest {

    @Test
    public void test() {
        ClientEconomic client = new ClientEconomic();
        try {
            client.atualizarCambio();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
