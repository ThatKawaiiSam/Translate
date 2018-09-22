package io.github.thatkawaiisam.translate;

import io.github.thatkawaiisam.kawaiilibs.command.CommandHandler;
import io.github.thatkawaiisam.kawaiilibs.config.BukkitConfigHelper;
import lombok.Getter;
import org.bukkit.plugin.java.JavaPlugin;

public class TranslatePlugin extends JavaPlugin {

    /* Configuration File Instance */
    @Getter private static BukkitConfigHelper configFile;

    @Override
    public void onEnable() {
        /* Setup Configuration File */
        configFile = new BukkitConfigHelper(this, "config", getDataFolder().getAbsolutePath());

        /* Setup Commands */
        CommandHandler.init(this);
        CommandHandler.loadCommandsFromPackage(this,"io.github.thatkawaiisam.translate");

        /* Load Values */
        new TranslateConstants();
        TranslateConstants.loadFromConfig();
    }

}
