package de.donythepony.group.api.event;

import de.donythepony.group.api.structure.Group;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class GroupKillEvent extends Event {

    private static final HandlerList HANDLER_LIST = new HandlerList();

    private final Player killer;
    private final Group group;
    private final Entity victim;

    public GroupKillEvent(Player killer, Entity victim, Group group) {
        this.killer = killer;
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

    public Player getKiller() {
        return killer;
    }

    public Entity getVictim() {return victim;}

    public Group getGroup() {
        return group;
    }
}
