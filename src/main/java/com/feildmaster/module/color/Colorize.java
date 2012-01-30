package com.feildmaster.module.color;

import com.feildmaster.channelchat.Module;
import org.bukkit.ChatColor;

public class Colorize extends Module {
    private final ChatColor defaultColor = ChatColor.WHITE;
    private static Colorize instance;

    public void onEnable() {
        instance = this;

        if(!getConfig().fileExists()) {
            saveDefaultConfig();
        }

        registerEvents(new playerListener());
    }

    public void onDisable() {}

    public static Colorize getInstance() {
        return instance;
    }

    public ChatColor getColor(String channel) {
        ChatColor color = null;

        // TODO: custom value parser
        Object value = getConfig().get(channel);

        if(value instanceof Character) {
            color = ChatColor.getByChar((Character) value);
            if(color != null) return color;
        }

        if(value instanceof String) {
            color = ChatColor.valueOf((String) value);
            if(color != null) return color;
        }

        return defaultColor;
    }
}
