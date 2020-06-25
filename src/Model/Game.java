package Model;

public class Game {
    int playercount;
    Stapel stack;
    Tisch table;
    Spieler[] players;
    int turns = 0;
    public Game(int playercount, Stapel s, Tisch t) {
        this.playercount = playercount;
        this.stack = s;
        this.table = t;
        this.players = new Spieler[playercount];
        for (int i = 0; i < playercount; i++) {
            players[i] = new Spieler(stack, table, this,i);
        }
        incrementPlayerTurns();
    }
    public void incrementPlayerTurns() {
        for (Spieler p:players
        ) {
            p.setActive(players[turns] == p);
        }
        turns++;
        if (turns == players.length){
            turns = 0;
        }
    }
    public int getTurns() { return turns; }
    public int getPlayercount() { return playercount; }
    public void setPlayercount(int playercount) { this.playercount = playercount; }
    public Stapel getStack() { return stack; }
    public void setStack(Stapel stack) { this.stack = stack; }
    public Tisch getTable() { return table; }
    public void setTable(Tisch table) { this.table = table; }
    public Spieler[] getPlayers() { return players; }
    public void setPlayers(Spieler[] players) { this.players = players; }
}