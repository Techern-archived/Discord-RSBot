package org.techern.rsbot.commands;

import sx.blah.discord.handle.obj.IChannel;
import sx.blah.discord.handle.obj.IUser;

import java.util.List;

/**
 * An interface for commands
 *
 * @since 0.0.1
 */
public interface ICommand {

    /**
     * Gets the name of this {@link ICommand}
     *
     * @return The name
     *
     * @since 0.0.1
     */
    String getName();

    /**
     * Gets the description of this {@link ICommand}
     *
     * @return The description
     *
     * @since 0.0.1
     */
    String getDescription();

    /**
     * Gets the usage details of this {@link ICommand}
     *
     * @return The usage details
     *
     * @since 0.0.1
     */
    String getUsageDetails();

    /**
     * Attempts to execute this {@link ICommand}
     *
     * @param channel The {@link IChannel} that this {@link ICommand} was called in
     * @param callingUser The {@link IUser} that called this {@link ICommand}
     * @param arguments Any arguments passed on
     *
     * @return {@code true} if successful, otherwise {@code false}
     *
     * @since 0.0.1
     */
    boolean execute(IChannel channel, IUser callingUser, List<String> arguments);
}
