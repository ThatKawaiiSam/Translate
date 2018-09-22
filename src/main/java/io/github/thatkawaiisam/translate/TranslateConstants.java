package io.github.thatkawaiisam.translate;

import org.bukkit.configuration.Configuration;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class TranslateConstants {

    public static List<String>
            helpCommand = new ArrayList<>(),
            reloadCommand = new ArrayList<>(),
            translateCommand = new ArrayList<>();

    /**
     * Load Translate Values from configuration file
     */
    public static void loadFromConfig() {
        Configuration configuration = TranslatePlugin.getConfigFile().getConfiguration();
        helpCommand.clear();
        helpCommand.addAll(configuration.getStringList("Help-Command"));
        reloadCommand.clear();
        reloadCommand.addAll(configuration.getStringList("Reload-Command"));
        translateCommand.clear();
        translateCommand.addAll(configuration.getStringList("Translate-Command"));
    }
}
