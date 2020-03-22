package de.donythepony.group.api.structure;

import org.bukkit.entity.Player;

public class GroupPlayer {
    private final Player player;
    private int collectedExp;
    private int kills;
    private int playerKills;
    private int deaths;

    public GroupPlayer(Player player) {
        this.player = player;
    }

    public Player getPlayer() {
        return player;
    }

    public int getCollectedExp() {
        return collectedExp;
    }

    protected void setCollectedExp(int collectedExp) {
        this.collectedExp = collectedExp;
    }

    protected void addCollectedExp(int collectedExp) {
        this.collectedExp += collectedExp;
    }

    public int getKills() {
        return kills;
    }

    public void addKills(int killCount) {
        this.kills += killCount;
    }

    public int getPlayerKills() {
        return playerKills;
    }

    public void addPlayerKills(int killCount) {
        this.playerKills += killCount;
    }

    public int getDeaths() {
        return deaths;
    }

    public void addDeath(int deathCount) {
        this.deaths += deathCount;
    }
}
