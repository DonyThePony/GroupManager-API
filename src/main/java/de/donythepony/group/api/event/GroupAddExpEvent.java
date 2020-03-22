package de.donythepony.group.api.event;

import de.donythepony.group.api.structure.Group;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class GroupAddExpEvent extends Event {

    private static final HandlerList HANDLER_LIST = new HandlerList();

    private final int experiencePoints;
    private final Group group;
    private final Player player;

    public GroupAddExpEvent(Player player, Group group, int experiencePoints) {
        this.group = group;
        this.experiencePoints = experiencePoints;
        this.player = player;
    }

    @Override
    public HandlerList getHandlers() {
        return HANDLER_LIST;
    }

    public static HandlerList getHandlerList() {
        return HANDLER_LIST;
    }

    public Group getGroup() {
        return group;
    }

    public Player getPayer() {return player;}

    public int getExperiencePoints() {
        return experiencePoints;
    }
}
