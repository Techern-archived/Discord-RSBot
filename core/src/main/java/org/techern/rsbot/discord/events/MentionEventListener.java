package org.techern.rsbot.discord.events;

import org.techern.rsbot.RSBot;
import sx.blah.discord.api.events.IListener;
import sx.blah.discord.handle.impl.events.MentionEvent;
import sx.blah.discord.util.DiscordException;
import sx.blah.discord.util.MissingPermissionsException;
import sx.blah.discord.util.RateLimitException;

import java.util.Locale;

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
        if (event.getMessage().getContent().toLowerCase().contains("go reset yourself!")) {
            try {
                event.getMessage().getChannel().sendMessage("Resetting myself... :(");
            } catch (MissingPermissionsException | DiscordException | RateLimitException e) {
                RSBot.LOGGER.error("Error while resetting chat bot", e);
            }
            RSBot.BOT_SESSION = RSBot.BOT.createSession(Locale.getDefault());
        } else {

            try {
                event.getMessage().getChannel().sendMessage(RSBot.BOT_SESSION.think(event.getMessage().getContent()));
            } catch (MissingPermissionsException | DiscordException | RateLimitException e) {
                RSBot.LOGGER.error("Error while replying to a mention", e);
            } catch (Exception e) {
                RSBot.LOGGER.error("Error while thinking", e);
            }
        }
    }
}
