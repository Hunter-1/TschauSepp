package Model;

public class Tisch {
    private Karte card;
    private String output;

    public void setCard(Karte card) {
        this.card = card;
    }
    public Karte getCard() {
        return card;
    }
    public String getOutput() { return output; }
    public void setOutput(String output) { this.output = output; }
}
