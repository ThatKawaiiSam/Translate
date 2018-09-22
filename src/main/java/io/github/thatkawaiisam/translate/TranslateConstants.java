package io.github.thatkawaiisam.translate;

import org.bukkit.configuration.Configuration;

import java.util.ArrayList;
import java.util.List;

class TranslateConstants {

    static List<String>
            helpCommand = new ArrayList<>(),
            reloadCommand = new ArrayList<>(),
            translateCommand = new ArrayList<>();

    /**
     * Load Translate Values from configuration file
     */
    static void loadFromConfig() {
        Configuration configuration = TranslatePlugin.getConfigFile().getConfiguration();
        helpCommand = configuration.getStringList("Help-Command");
        reloadCommand = configuration.getStringList("Reload-Command");
        translateCommand = configuration.getStringList("Translate-Command");
    }
}
