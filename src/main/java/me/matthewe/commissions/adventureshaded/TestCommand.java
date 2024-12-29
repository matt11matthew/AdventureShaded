package me.matthewe.commissions.adventureshaded;

import net.kyori.adventure.platform.bukkit.BukkitAudiences;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class TestCommand implements CommandExecutor {

    private final BukkitAudiences adventure; // Use BukkitAudiences to send Adventure messages
    private static final Path TEXT_FILE_PATH = Path.of("plugins/AdventureShaded/messages.txt");

    public TestCommand(BukkitAudiences adventure) {
        this.adventure = adventure;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("Only players can use this command!");
            return true;
        }

        Player player = (Player) sender;

        // Read the content from the text file
        try {
            if (!Files.exists(TEXT_FILE_PATH)) {
                player.sendMessage("The message file does not exist!");
                return true;
            }

            String content = Files.readString(TEXT_FILE_PATH);
                player.sendMessage(content);

            // Parse with MiniMessage
            MiniMessage miniMessage = MiniMessage.miniMessage();
            Component parsedMessage = miniMessage.deserialize(content);

            System.out.println(parsedMessage);

            // Use BukkitAudiences to send the parsed message
            adventure.player(player).sendMessage(parsedMessage);

        } catch (IOException e) {
            e.printStackTrace();
            adventure.player(player).sendMessage(Component.text("An error occurred while reading the message file."));
        }

        return true;
    }
}
