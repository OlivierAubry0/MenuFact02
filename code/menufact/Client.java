package menufact;

/**
 * The `Client` class represents a customer of a restaurant with an ID, a name, and a credit card number.
 */
public class Client {
    private int idClient;
    private String nom;
    private String numeroCarteCredit;

    /**
     * Creates a new `Client` object with the given ID, name, and credit card number.
     * @param idClient the ID of the client
     * @param nom the name of the client
     * @param numeroCarteCredit the credit card number of the client
     */
    public Client(int idClient, String nom, String numeroCarteCredit) {
        this.idClient = idClient;
        this.nom = nom;
        this.numeroCarteCredit = numeroCarteCredit;
    }

    /**
     * Returns the ID of the client.
     * @return the ID of the client
     */
    public int getIdClient() {
        return idClient;
    }

    /**
     * Sets the ID of the client.
     * @param idClient the new ID of the client
     */
    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    /**
     * Returns the name of the client.
     * @return the name of the client
     */
    public String getNom() {
        return nom;
    }

    /**
     * Sets the name of the client.
     * @param nom the new name of the client
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Returns the credit card number of the client.
     * @return the credit card number of the client
     */
    public String getNumeroCarteCredit() {
        return numeroCarteCredit;
    }

    /**
     * Sets the credit card number of the client.
     * @param numeroCarteCredit the new credit card number of the client
     */
    public void setNumeroCarteCredit(String numeroCarteCredit) {
        this.numeroCarteCredit = numeroCarteCredit;
    }

    /**
     * Returns a string representation of the `Client` object.
     * @return a string representation of the `Client` object
     */
    @Override
    public String toString() {
        return "menufact.Client{" +
                "idClient=" + idClient +
                ", nom='" + nom + '\'' +
                ", numeroCarteCredit='" + numeroCarteCredit + '\'' +
                '}';
    }
}