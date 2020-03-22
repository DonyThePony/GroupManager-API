package de.donythepony.group.api.util;

import de.donythepony.group.api.structure.Group;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.LinkedList;
import java.util.UUID;

/**
 * This Utility Class helps to work with groups.
 */
public class GroupManager extends JavaPlugin {

    private static GroupManager instance;
    public String instanceID;

    private final LinkedList<Group> groupList = new LinkedList<>();

    @Override
    public void onEnable() {
        instanceID = UUID.randomUUID().toString();
        System.out.println("[GroupManager-API] my id: " + instanceID);
    }

    public static GroupManager getInstance() {
        if(instance == null) {
            instance = new GroupManager();
            instance.instanceID = UUID.randomUUID().toString();
        }

        return instance;
    }

    public Group getGroupById(String id) {
        for(Group group : groupList) {
            if(group.getId().equals(id)) {
                return group;
            }
        }

        return null;
    }

    public boolean addGroup(Group group) {
        if(!groupList.contains(group)) {
            groupList.add(group);
            return true;
        }
        return false;
    }

    public Group getGroupByPlayer(Player player) {
        for(Group group : groupList) {
            if(group.hasPlayer(player)) {
                return group;
            }
        }

        return null;
    }

    public boolean doesGroupNameExist(String groupName) {
        return getGroupByName(groupName) != null;
    }

    public Group getGroupByName(String groupName) {
        for(Group group : groupList) {
            if(group.getName().equals(groupName)) {
                return group;
            }
        }
        return null;
    }

    public boolean givePlayersGroupExp(Player player, int experience) {
        Group group = getGroupByPlayer(player);
        if(group != null) {
            group.setExperiencePoints(group.getExperiencePoints() + experience);
            return true;
        }
        return false;
    }
}
