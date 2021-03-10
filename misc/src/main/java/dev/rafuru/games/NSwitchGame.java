package dev.rafuru.games;

public class NSwitchGame extends Game{

    private boolean onlineCompatible;

    public NSwitchGame(String title, boolean owned, int players, boolean onlineCompatible) {
        super(title, owned, players, "Nintendo Switch");
        this.onlineCompatible = onlineCompatible;
    }

    public boolean isOnlineCompatible() {
        return onlineCompatible;
    }

    public void setOnlineCompatible(boolean onlineCompatible) {
        this.onlineCompatible = onlineCompatible;
    }
}
