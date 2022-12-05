package org.lumbabalumba.greetingplugin;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.ComponentBuilder;
import net.kyori.adventure.text.TextComponent;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class JoinListener implements Listener {
    private final GreetingPlugin plugin;

    public JoinListener(GreetingPlugin plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    void JoinEvent(PlayerJoinEvent event) {
        String msg = String.format(Objects.requireNonNull(plugin.getConfig().getString("standart-join-message")), event.getPlayer().getName());
        event.setJoinMessage(msg);
    }

    @EventHandler
    void LeaveEvent(PlayerQuitEvent event) {
        String msg = String.format(Objects.requireNonNull(plugin.getConfig().getString("standart-quit-message")), event.getPlayer().getName());
        event.setQuitMessage(msg);
    }
}
