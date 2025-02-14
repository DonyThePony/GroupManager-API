package de.donythepony.group.api.structure;

import de.donythepony.group.api.event.GroupAddExpEvent;
import de.donythepony.group.api.event.GroupDeathEvent;
import de.donythepony.group.api.event.GroupKillEvent;
import de.donythepony.group.api.structure.Group;
import de.donythepony.group.api.util.GroupManager;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class GroupEventListener implements Listener {

    @EventHandler
    protected void addExpToGroup(GroupAddExpEvent event) {
        Player player = event.getPayer();
        int exp = event.getExperiencePoints();
        Group group = event.getGroup();
        exp = Math.max(1, exp / group.getAllMembers().size());
        group.addExperiencePoints(event.getPayer(), event.getExperiencePoints());
        for(Player member : group.getAllMembers()) {
            member.giveExp(exp);
        }
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

    @EventHandler
    protected void addDeathToGroup(GroupDeathEvent event) {
        GroupPlayer groupPlayer = event.getGroup().getGroupPlayerFromPlayer(event.getVictim());
        groupPlayer.addDeath(1);
    }

}
