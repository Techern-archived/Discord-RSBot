package org.techern.rsbot.commands;

import org.techern.rsbot.RSBot;
import sx.blah.discord.handle.obj.IChannel;
import sx.blah.discord.handle.obj.IUser;
import sx.blah.discord.util.DiscordException;
import sx.blah.discord.util.MissingPermissionsException;
import sx.blah.discord.util.RateLimitException;

import java.util.List;

/**
 * An implementation of {@link ICommand} that reports on {@link ICommand}s
 *
 * @since 0.0.1
 */
public class CommandsCommand implements ICommand {
    /**
     * Gets the name of this {@link ICommand}
     *
     * @return The name
     * @since 0.0.1
     */
    @Override
    public String getName() {
        return "commands";
    }

    /**
     * Gets the description of this {@link ICommand}
     *
     * @return The description
     * @since 0.0.1
     */
    @Override
    public String getDescription() {
        return "Reports information on commands";
    }

    /**
     * Gets the usage details of this {@link ICommand}
     *
     * @return The usage details
     * @since 0.0.1
     */
    @Override
    public String getUsageDetails() {
        return "\"!commands\", otherwise \"!commands [command]\" for usage details";
    }

    /**
     * Attempts to execute this {@link ICommand}
     *
     * @param channel     The {@link IChannel} that this {@link ICommand} was called in
     * @param callingUser The {@link IUser} that called this {@link ICommand}
     * @param arguments   Any arguments passed on
     * @return {@code true} if successful, otherwise {@code false}
     * @since 0.0.1
     */
    @Override
    public boolean execute(IChannel channel, IUser callingUser, List<String> arguments) {

        StringBuilder responseBuilder = new StringBuilder(50);

        if (arguments.size() == 0) {

            responseBuilder.append("Help for commands: \n\n");

            for (ICommand commands : CommandManager.COMMAND_LIST.values()) {
                responseBuilder.append("**!").append(commands.getName().toLowerCase()).append("** - ")
                        .append(commands.getDescription())
                        .append("\n");
            }

        } else {

            for (String commandQueried : arguments) {
                try {
                    if (CommandManager.COMMAND_LIST.containsKey(commandQueried.toLowerCase())) {
                        responseBuilder.append("**!").append(commandQueried.toLowerCase()).append("**").append(" usage: ")
                                .append(CommandManager.COMMAND_LIST.get(commandQueried.toLowerCase()).getUsageDetails())
                                .append("\n");
                    } else {
                        responseBuilder.append("**!").append(commandQueried.toLowerCase()).append("**").append(" does not exist!").append("\n");
                    }
                } catch (Exception e) {
                    responseBuilder.append("**").append(e.getMessage()).append("while loading data for ").append(commandQueried.toLowerCase()).append(", spam?");
                }
            }
        }

        try {
            channel.sendMessage(responseBuilder.toString());
            return true;
        } catch (MissingPermissionsException | RateLimitException | DiscordException e) {
            RSBot.LOGGER.error("Error while processing commands command", e);
            return false;
        }
    }
}
