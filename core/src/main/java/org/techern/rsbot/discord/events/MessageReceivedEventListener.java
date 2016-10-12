package org.techern.rsbot.discord.events;

import org.techern.rsbot.RSBot;

import org.techern.rsbot.commands.CommandManager;
import org.techern.rsbot.commands.ICommand;
import sx.blah.discord.api.events.IListener;
import sx.blah.discord.handle.impl.events.MessageReceivedEvent;
import sx.blah.discord.util.DiscordException;
import sx.blah.discord.util.MissingPermissionsException;
import sx.blah.discord.util.RateLimitException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * An implementation of the {@link MessageReceivedEvent}
 *
 * @since 0.0.1
 */
public class MessageReceivedEventListener implements IListener<MessageReceivedEvent> {

    /**
     * Handles the {@link MessageReceivedEvent}
     *
     * @param event The {@link MessageReceivedEvent}
     * @since 0.0.1
     */
    @Override
    public void handle(MessageReceivedEvent event) {

        String messageText = event.getMessage().getContent();

        if (messageText.startsWith("!") && messageText.length() > 1) {
            messageText = messageText.replaceFirst("!", ""); //First get rid of this :p


            //Now get the components
            ArrayList<String> components = new ArrayList<>(Arrays.asList(messageText.split("\\s+")));

            String commandName = components.remove(0); //No, this is not a bug. It returns what we removed

            if (CommandManager.COMMAND_LIST.containsKey(commandName)) {
                try {
                    ICommand command = CommandManager.COMMAND_LIST.get(commandName);

                    if (!command.execute(event.getMessage().getChannel(), event.getMessage().getAuthor(), components)) {
                        try {
                            event.getMessage().getChannel().sendMessage("Hmm, that one was rejected. Maybe try " + command.getUsageDetails());

                        } catch (MissingPermissionsException | DiscordException | RateLimitException ee) {
                            RSBot.LOGGER.error("Error notifying about errored command " + components.get(0), ee);
                        }
                    }
                } catch (Exception e) {
                    try {
                        event.getMessage().getChannel().sendMessage("Exception while handling command: " + e.getMessage());

                    } catch (MissingPermissionsException | DiscordException | RateLimitException ee) {
                        RSBot.LOGGER.error("Error notifying about errored errored command " + components.get(0), ee);
                    }
                }
            } else {
                try {
                    event.getMessage().getChannel().sendMessage("Unknown command, maybe try again? !commands may help you :)");

                    RSBot.LOGGER.info("Stage 6b " + messageText);
                } catch (MissingPermissionsException | DiscordException | RateLimitException e) {
                    RSBot.LOGGER.error("Error notifying about unknown command " + components.get(0), e);
                }
            }
        }
    }
}
