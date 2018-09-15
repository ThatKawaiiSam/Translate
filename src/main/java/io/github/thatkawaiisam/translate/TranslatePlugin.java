package io.github.thatkawaiisam.translate;

import io.github.thatkawaiisam.kawaiilibs.command.CommandHandler;
import org.bukkit.plugin.java.JavaPlugin;

public class TranslatePlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        CommandHandler.init(this);
        CommandHandler.loadCommandsFromPackage(this,"io.github.thatkawaiisam.translate");
    }

}
