package testUnitaires;
import menufact.Client;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestClient {
    private Client client;

    @BeforeEach
    public void setup() {
        client = new Client(1, "Groot", "1234");
    }

    @Test
    void getIdClient() {
        assertEquals(1, client.getIdClient());
    }

    @Test
    void setIdClient() {
        client.setIdClient(2);
        assertEquals(2, client.getIdClient());
    }

    @Test
    void getNom() {
        assertEquals("Groot", client.getNom());
    }

    @Test
    void setNom() {
        client.setNom("Sasuke");
        assertEquals("Sasuke", client.getNom());
    }

    @Test
    void getNumeroCarteCredit() {
        assertEquals("1234", client.getNumeroCarteCredit());
    }

    @Test
    void setNumeroCarteCredit() {
        client.setNumeroCarteCredit("12345");
        assertEquals("12345", client.getNumeroCarteCredit());
    }
}