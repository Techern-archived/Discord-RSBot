package org.techern.rsbot.discord.events;

import org.techern.rsbot.RSBot;
import sx.blah.discord.api.events.IListener;
import sx.blah.discord.handle.impl.events.PresenceUpdateEvent;
import sx.blah.discord.handle.obj.Presences;

/**
 * An implementation of the {@link PresenceUpdateEvent}
 *
 * @since 0.0.1
 */
public class PresenceUpdateEventListener implements IListener<PresenceUpdateEvent> {

    /**
     * Handles the {@link PresenceUpdateEvent}
     *
     * @param event The {@link PresenceUpdateEvent}
     * @since 0.0.1
     */
    @Override
    public void handle(PresenceUpdateEvent event) {
        if (event.getNewPresence().equals(Presences.OFFLINE)) {
            RSBot.BOT_SESSIONS.remove(event.getUser());
        }
    }
}
