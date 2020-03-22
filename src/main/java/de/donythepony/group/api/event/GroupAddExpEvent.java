package de.donythepony.group.api.event;

import de.donythepony.group.api.structure.Group;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class GroupAddExpEvent extends Event {

    private static final HandlerList HANDLER_LIST = new HandlerList();

    private final int experiencePoints;
    private final Group group;

    public GroupAddExpEvent(Group group, int experiencePoints) {
        this.group = group;
        this.experiencePoints = experiencePoints;
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

    public int getExperiencePoints() {
        return experiencePoints;
    }
}
