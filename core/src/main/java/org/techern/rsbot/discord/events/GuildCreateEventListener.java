package org.techern.rsbot.discord.events;

import org.techern.rsbot.RSBot;
import sx.blah.discord.api.events.IListener;
import sx.blah.discord.handle.impl.events.GuildCreateEvent;
import sx.blah.discord.handle.obj.IChannel;
import sx.blah.discord.util.DiscordException;
import sx.blah.discord.util.MissingPermissionsException;
import sx.blah.discord.util.RateLimitException;

/**
 * An implementation of the {@link GuildCreateEvent}
 *
 * @since 0.0.1
 */
public class GuildCreateEventListener implements IListener<GuildCreateEvent> {

    /**
     * Handles the {@link GuildCreateEvent}
     *
     * @param event The {@link GuildCreateEvent}
     * @since 0.0.1
     */
    @Override
    public void handle(GuildCreateEvent event) {
        /*for (IChannel channel : event.getGuild().getChannels()) {
            try {
                channel.sendMessage("Hi! I've just been turned on");
            } catch (MissingPermissionsException | RateLimitException | DiscordException e) {
                RSBot.LOGGER.error("Error while handling guild creation: ", e);
            }
        }*/
    }
}
