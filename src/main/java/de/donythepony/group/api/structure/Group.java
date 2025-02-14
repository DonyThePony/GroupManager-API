package de.donythepony.group.api.structure;

import de.donythepony.group.api.util.GroupManager;
import net.md_5.bungee.api.chat.BaseComponent;
import org.bukkit.entity.Player;

import java.util.LinkedList;
import java.util.UUID;

/**
 * Represents the Group.
 * A group has many properties and a Memberlist which contains all the players.
 */
public class Group {

    private final GroupMemberList memberList = new GroupMemberList();
    private final LinkedList<Player> invitedList = new LinkedList<>();

    private Player leader;
    private String name;
    private int level;
    private int experiencePoints;
    private int maxSize;
    private final UUID id;

    public Group(String name, Player leader) {
        this.name = name;
        this.leader = leader;
        memberList.addPlayer(leader);
        id = UUID.randomUUID();
    }

    /**
     * Invite a player to group.
     * Only possible if the player isn't in a group.
     * @param player
     * @return if invitation was sent successfully
     */
    public boolean invitePlayer(Player player) {
        if(GroupManager.getInstance().getGroupByPlayer(player) == null) {
            invitedList.add(player);
            return true;
        } else {
            return false;
        }
    }

    /**
     * Adds a Player to a group and removes him from the invitation list.
     * @param player
     */
    public void addPlayer(Player player) {
        invitedList.remove(player);
        memberList.addPlayer(player);
    }

    /**
     * Sends a message to all Players in the Group.
     * @param message
     */
    public void notifyAllMembers(BaseComponent[] message) {
        memberList.notifyAllMembers(message);
    }

    /**
     * Checks if a player is already invited for this group.
     * @param player
     * @return true if the player was invited.
     */
    public boolean isPlayerInvited(Player player) {
        return invitedList.contains(player);
    }

    /**
     * Checks if the Player is in this Group.
     * @param player
     * @return
     */
    public boolean hasPlayer(Player player) {
        return memberList.hasPlayer(player);
    }

    /**
     *
     * @return the leader of the Group
     */
    public Player getLeader() {
        return leader;
    }

    /**
     * Sets a new leader for this group.
     * @param leader
     */
    public void setLeader(Player leader) {
        this.leader = leader;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getMaxSize() {
        return maxSize;
    }

    public int getSize() {
        return memberList.getSize();
    }

    public String getId() {
        return id.toString();
    }

    public LinkedList<Player> getAllMembers() {
        return memberList.getAllPlayers();
    }

    public int getExperiencePoints() {
        return experiencePoints;
    }

    public void setExperiencePoints(int experiencePoints) {
        this.experiencePoints = experiencePoints;
    }

    protected void addExperiencePoints(Player player, int experiencePoints) {
        this.experiencePoints += experiencePoints;
        getGroupPlayerFromPlayer(player).addCollectedExp(experiencePoints);
        System.out.println(getGroupPlayerFromPlayer(player).getPlayer().getDisplayName() + " Collected " + experiencePoints);
    }

    public GroupPlayer getGroupPlayerFromPlayer(Player player) {
        return memberList.getGroupPlayerFromPlayer(player);
    }

    public void kickPlayer(Player player) {
       memberList.kickPlayer(player);
    }
}
