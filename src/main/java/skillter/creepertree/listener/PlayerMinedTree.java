package skillter.creepertree.listener;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Server;
import org.bukkit.block.data.BlockData;
import org.bukkit.entity.EntityType;
import org.bukkit.event.Event;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerAnimationEvent;
import skillter.creepertree.CreeperTree;

public class PlayerMinedTree implements Listener {


    @EventHandler
    public void PlayerMinedTree(BlockBreakEvent e) {
        Bukkit.broadcastMessage("1");
        if (e.getBlock().getType().toString().contains("_LOG")) {
            Location blockLocation = e.getBlock().getLocation();
            Bukkit.broadcastMessage("2");
            Bukkit.broadcastMessage(blockLocation.clone().add(1,0,0).getBlock().getType().toString());
            if (blockLocation.clone().add(1,0,0).getBlock().getType().toString().contains("_LEAVES") || blockLocation.clone().add(-1,0,0).getBlock().getType().toString().contains("_LEAVES") || blockLocation.clone().add(0,0,1).getBlock().getType().toString().contains("_LEAVES") || blockLocation.clone().add(0,0,-1).getBlock().getType().toString().contains("_LEAVES")) {
                Bukkit.broadcastMessage("3");
                Bukkit.broadcastMessage(blockLocation.clone().add(0,1,0).getBlock().getType().toString());
                if (blockLocation.clone().add(0,1,0).getBlock().getType().toString().contains("_LOG")) {
                    e.getBlock().getWorld().spawnEntity(e.getBlock().getLocation().add(0.5,1,0.5), EntityType.CREEPER);
                    BlockData block1, block2;
                    block1 = e.getBlock().getLocation().add(0,1,0).getBlock().getBlockData();
                    e.getBlock().getLocation().add(0,1,0).getBlock().setType(Material.AIR);
                    block2 = e.getBlock().getLocation().add(0,2,0).getBlock().getBlockData();
                    e.getBlock().getLocation().add(0,2,0).getBlock().setType(Material.AIR);

                    Bukkit.getScheduler().scheduleSyncDelayedTask(CreeperTree.INSTANCE, () -> {
                        Bukkit.broadcastMessage("testtt");
                        e.getPlayer().sendBlockChange(e.getBlock().getLocation().add(0,1,0), block1);
                        e.getPlayer().sendBlockChange(e.getBlock().getLocation().add(0,2,0), block2);
                    }, 2L);


                }
            }
        }
    }
}
