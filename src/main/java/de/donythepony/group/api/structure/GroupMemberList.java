package de.donythepony.group.api.structure;

import net.md_5.bungee.api.chat.BaseComponent;
import org.bukkit.entity.Player;

import java.util.LinkedList;

public class GroupMemberList {

    private final LinkedList<Player> playerList = new LinkedList<>();
    private final LinkedList<GroupPlayer> groupPlayerList = new LinkedList<>();

    public int getSize() {
        return playerList.size();
    }

    public void addPlayer(Player player) {
        if(!playerList.contains(player)) {
            playerList.add(player);
            groupPlayerList.add(new GroupPlayer(player));
        }
    }

    public void notifyAllMembers(BaseComponent[] message) {
        for(Player player : playerList) {
            player.spigot().sendMessage(message);
        }
    }

    public boolean hasPlayer(Player player) {
        return playerList.contains(player);
    }

    public GroupPlayer getGroupPlayerFromPlayer(Player player) {
        GroupPlayer foundGroupPlayer = null;
        for(GroupPlayer currentGroupPlayer : groupPlayerList) {
            if(player == currentGroupPlayer.getPlayer()) {
                foundGroupPlayer = currentGroupPlayer;
            }
        }
        return  foundGroupPlayer;
    }

    public boolean hasGroupPlayer(GroupPlayer groupPlayer) {
        return groupPlayerList.contains(groupPlayer);
    }

    public LinkedList<Player> getAllPlayers() {
        return playerList;
    }

    public void kickPlayer(Player player) {
        playerList.remove(player);
    }
}
