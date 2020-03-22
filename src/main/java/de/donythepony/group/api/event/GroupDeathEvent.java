package de.donythepony.group.api.event;

import de.donythepony.group.api.structure.Group;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class GroupDeathEvent extends Event {

    private static final HandlerList HANDLER_LIST = new HandlerList();

    private final Group group;
    private final Player victim;

    public GroupDeathEvent(Player victim, Group group) {
        this.group = group;
        this.victim = victim;
    }

    @Override
    public HandlerList getHandlers() {
        return HANDLER_LIST;
    }

    public static HandlerList getHandlerList() {
        return HANDLER_LIST;
    }

    public Player getVictim() {return victim;}

    public Group getGroup() {
        return group;
    }
}
