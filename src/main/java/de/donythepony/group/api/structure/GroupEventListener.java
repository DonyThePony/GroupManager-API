package de.donythepony.group.api.structure;

import de.donythepony.group.api.event.GroupAddExpEvent;
import de.donythepony.group.api.structure.Group;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class GroupEventListener implements Listener {

    @EventHandler
    protected void addExpToGroup(GroupAddExpEvent event) {
        Group group = event.getGroup();
        group.addExperiencePoints(event.getExperiencePoints());
    }

}
