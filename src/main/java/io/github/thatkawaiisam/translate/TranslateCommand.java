package io.github.thatkawaiisam.translate;

import io.github.thatkawaiisam.kawaiilibs.command.Command;
import io.github.thatkawaiisam.kawaiilibs.command.param.Parameter;

import io.github.thatkawaiisam.kawaiilibs.utils.MessageUtility;
import org.bukkit.command.CommandSender;

public class TranslateCommand {

    @Command(
            names = "translate",
            async = true
    )
    public static void translateCommand(
            CommandSender commandSender,
            @Parameter(name = "language from") String from,
            @Parameter(name = "language to") String to,
            @Parameter(name = "content", wildcard = true) String content){
        try {
            for (String message : TranslateConstants.translateCommand) {
                String finalMessage = message
                        .replaceAll("%to-language%", to)
                        .replaceAll("%from-language%", from)
                        .replaceAll("%original-content%", content)
                        .replaceAll("%translated-content%", TranslateUtils.translateText(from, to, content));
                commandSender.sendMessage(MessageUtility.formatMessage(finalMessage));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Command(
            names = {
                    "translate help",
                    "translate ?",
            },
            async = true
    )
    public static void translateHelpCommand(CommandSender commandSender) {
        for (String message : TranslateConstants.helpCommand) {
            commandSender.sendMessage(MessageUtility.formatMessage(message));
        }
    }

    @Command(
            names = {
                    "translate config",
                    "trasnlate config reload",
                    "translate reload"
            },
            async = true
    )
    public static void translateConfigReloadCommand(CommandSender commandSender) {
        TranslateConstants.loadFromConfig();
        for (String message : TranslateConstants.reloadCommand) {
            commandSender.sendMessage(MessageUtility.formatMessage(message));
        }
    }

}
