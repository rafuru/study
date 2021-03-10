package dev.rafuru.games;

public abstract class Game {

    private String title;
    private boolean owned;
    private int players;
    private String platform;

    public Game(String title, boolean owned, int players, String platform) {
        this.title = title;
        this.owned = owned;
        this.players = players;
        this.platform = platform;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isOwned() {
        return owned;
    }

    public void setOwned(boolean owned) {
        this.owned = owned;
    }

    public int getPlayers() {
        return players;
    }

    public void setPlayers(int players) {
        this.players = players;
    }

    @Override
    public String toString() {
        return "Game{" +
                "title='" + title + '\'' +
                ", owned=" + owned +
                ", players=" + players +
                ", platform='" + platform + '\'' +
                '}';
    }
}
