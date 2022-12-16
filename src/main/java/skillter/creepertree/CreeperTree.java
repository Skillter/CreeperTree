package skillter.creepertree;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import skillter.creepertree.listener.PlayerMinedTree;

public final class CreeperTree extends JavaPlugin {

    public static CreeperTree INSTANCE = null;

    @Override
    public void onEnable() {
        INSTANCE = this;
        Bukkit.getPluginManager().registerEvents((Listener) new PlayerMinedTree(), this);
    }

    @Override
    public void onDisable() {
        INSTANCE = null;
    }
}
