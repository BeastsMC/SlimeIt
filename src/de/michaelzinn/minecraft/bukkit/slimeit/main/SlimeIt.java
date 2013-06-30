package de.michaelzinn.minecraft.bukkit.slimeit.main;

import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import com.sk89q.worldguard.bukkit.WorldGuardPlugin;


/**
 * 
 * @author Michael Zinn (@RedNifre)
 * 
 */
public class SlimeIt extends JavaPlugin {
	public Logger log;
	public WorldGuardPlugin wg;
	public boolean wgenabled = false;

	@Override
	public void onEnable() {
		super.onEnable();
		log = getLogger();
		Bukkit.getPluginManager().registerEvents(new BlockPunchListener(this), this);
		wg = getWorldGuard();
		if(wg!=null) {
			log.info("Hooked into WorldGuard.");
			wgenabled = true;
		}
	}
	private WorldGuardPlugin getWorldGuard() {
	    Plugin plugin = getServer().getPluginManager().getPlugin("WorldGuard");
	 
	    // WorldGuard may not be loaded
	    if (plugin == null || !(plugin instanceof WorldGuardPlugin)) {
	        return null;
	    }
	 
	    return (WorldGuardPlugin) plugin;
	}
}
