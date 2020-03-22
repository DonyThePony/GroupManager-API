package de.donythepony.group.api.structure;

import org.bukkit.entity.Player;

public class GroupPlayer {
    private final Player player;
    private int collectedExp = 0;

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
}
