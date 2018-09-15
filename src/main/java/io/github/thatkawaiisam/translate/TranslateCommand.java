package io.github.thatkawaiisam.translate;

import io.github.thatkawaiisam.kawaiilibs.command.Command;
import io.github.thatkawaiisam.kawaiilibs.command.param.Parameter;
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
            commandSender.sendMessage(TranslateUtils.translateText(from, to, content));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Command(
            names = {
                    "translate help",
                    "translate ?"
            },
            async = true
    )
    public static void translateHelpCommand(CommandSender commandSender) {
        commandSender.sendMessage("Translate Comamnd");
        commandSender.sendMessage(" Usage: /translate <language from> <language to> <content>");
        commandSender.sendMessage(" You can use AUTO in language from for Google to attempt to find the language of the content.");
    }

}
