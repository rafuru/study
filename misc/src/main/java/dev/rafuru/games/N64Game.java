package dev.rafuru.games;


public class N64Game extends Game{

    public boolean expansionPackRequired;

    public N64Game(String title, boolean owned, int players, boolean expansionPackRequired) {
        super(title, owned, players,"Nintendo 64");
        this.expansionPackRequired = expansionPackRequired;
    }

    public boolean isExpansionPackRequired() {
        return expansionPackRequired;
    }

    public void setExpansionPackRequired(boolean expansionPackRequired) {
        this.expansionPackRequired = expansionPackRequired;
    }
}
