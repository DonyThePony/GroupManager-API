package de.donythepony.group.api.structure;

import de.donythepony.group.api.event.GroupAddExpEvent;
import de.donythepony.group.api.event.GroupKillEvent;
import de.donythepony.group.api.structure.Group;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class GroupEventListener implements Listener {

    @EventHandler
    protected void addExpToGroup(GroupAddExpEvent event) {
        Player player = event.getPayer();
        System.out.println(player.getDisplayName() + " Collected " + event.getExperiencePoints());
        Group group = event.getGroup();
        group.addExperiencePoints(event.getPayer(), event.getExperiencePoints());
    }

    @EventHandler
    protected void addKillsToGroup(GroupKillEvent event) {
        Player killer = event.getKiller();
        GroupPlayer groupPlayer = event.getGroup().getGroupPlayerFromPlayer(killer);
        Entity victim = event.getVictim();

        groupPlayer.addKills(1);
        if(victim instanceof Player) {
            groupPlayer.addPlayerKills(1);
        }

    }

}
