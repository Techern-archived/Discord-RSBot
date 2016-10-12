package org.techern.rsbot.discord.events;

import org.techern.rsbot.RSBot;
import sx.blah.discord.api.events.IListener;
import sx.blah.discord.handle.impl.events.MentionEvent;
import sx.blah.discord.handle.obj.IMessage;
import sx.blah.discord.util.DiscordException;
import sx.blah.discord.util.MissingPermissionsException;
import sx.blah.discord.util.RateLimitException;

import java.util.ArrayList;

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

        String messageText = event.getMessage().getContent();

        if (messageText.startsWith("<@")) {
            messageText = messageText.replace("<@" + event.getClient().getOurUser().getID() + "> ", "");

        }

        RSBot.LOGGER.info(messageText);

        if (messageText.toLowerCase().contains("go reset yourself")) {
            RSBot.BOT_SESSIONS.remove(event.getMessage().getAuthor());
        } else if (messageText.toLowerCase().contains("fucking shut up")) {
            ArrayList<IMessage> messageList = new ArrayList<>();
            messageList.add(event.getMessage()); //Gotta get rid of fucking shut up :p
            for (IMessage message : event.getMessage().getChannel().getMessages()) {
                if (message.getAuthor().equals(event.getClient().getOurUser()) || message.getMentions().contains(RSBot.CLIENT_INSTANCE.getOurUser())) {
                    messageList.add(message);
                }
            }

            try {
                event.getMessage().getChannel().getMessages().bulkDelete(messageList);
            } catch (MissingPermissionsException | DiscordException | RateLimitException e) {
                RSBot.LOGGER.error("Error while pruning chat bot", e);
            }


        } else {
            try {
                IMessage chatBotMessage = event.getMessage().getChannel().sendMessage("I'm thinking...");
                chatBotMessage.edit(RSBot.getChatBotSession(event.getMessage()).think(messageText));
            } catch (MissingPermissionsException | DiscordException | RateLimitException e) {
                if (e.getMessage().contains("is due to")) {
                    try {
                        event.getMessage().getAuthor().getOrCreatePMChannel().sendMessage("Couldn't send that, I was blocked by CloudFlare on Discord. Please try again if you want");
                    } catch (MissingPermissionsException | DiscordException | RateLimitException e1) {
                        RSBot.LOGGER.error("Error while PMing about CloudFlare", e);
                    }
                }
                RSBot.LOGGER.error("Error while replying to a mention", e);
            } catch (Exception e) {
                RSBot.LOGGER.error("Error while thinking", e);
            }
        }
    }
}
