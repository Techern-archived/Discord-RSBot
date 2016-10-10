package org.techern.rsbot.discord.events;

import org.techern.rsbot.RSBot;
import sx.blah.discord.api.events.IListener;
import sx.blah.discord.handle.impl.events.MentionEvent;
import sx.blah.discord.util.DiscordException;
import sx.blah.discord.util.MissingPermissionsException;
import sx.blah.discord.util.RateLimitException;

/**
 * An implementation of the {@link MentionEvent}
 *
 * @since 0.0.1
 */
public class MentionEventListener implements IListener<MentionEvent> {

    /**
     * Handles the {@link MentionEvent}
     *
     * @param event The {@link MentionEvent}
     * @since 0.0.1
     */
    @Override
    public void handle(MentionEvent event) {
        try {
            event.getMessage().getChannel().sendMessage("WHAT DO YOU WANT? I'M NOT READY FOR THIS YET!");
        } catch (MissingPermissionsException | DiscordException | RateLimitException e) {
            RSBot.LOGGER.error("Error while replying to a mention", e);
        }
    }
}
