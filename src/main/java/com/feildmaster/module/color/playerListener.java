package com.feildmaster.module.color;

import com.feildmaster.channelchat.event.channel.ReloadEvent;
import org.bukkit.event.*;
import com.feildmaster.channelchat.channel.Channel;
import com.feildmaster.channelchat.event.player.ChannelPlayerChatEvent;
import org.bukkit.event.player.PlayerChatEvent;
import static com.feildmaster.channelchat.channel.ChannelManager.getManager;

public class playerListener implements Listener {
    @EventHandler
    public void onPlayerChat(PlayerChatEvent event) {
        if(event.isCancelled()) return;

        Channel channel = event instanceof ChannelPlayerChatEvent ? ((ChannelPlayerChatEvent)event).getChannel() : getManager().getActiveChannel(event.getPlayer());

        if(channel == null) return;

        event.setMessage(Colorize.getInstance().getColor(channel.getName())+event.getMessage());
    }

    @EventHandler
    public void onReload(ReloadEvent event) {
        Colorize.getInstance().getConfig().load();
    }
}
