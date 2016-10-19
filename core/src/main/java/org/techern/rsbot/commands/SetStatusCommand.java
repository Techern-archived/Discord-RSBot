package org.techern.rsbot.commands;

import org.techern.rsbot.RSBot;
import sx.blah.discord.handle.obj.IChannel;
import sx.blah.discord.handle.obj.IUser;
import sx.blah.discord.handle.obj.Status;

import java.util.List;

/**
 * A {@link ICommand} to set the status of {@link org.techern.rsbot.RSBot}
 *
 * @since 0.0.1
 */
public class SetStatusCommand implements ICommand {

    /**
     * Gets the name of this {@link ICommand}
     *
     * @return The name
     * @since 0.0.1
     */
    @Override
    public String getName() {
        return "SetStatus";
    }

    /**
     * Gets the description of this {@link ICommand}
     *
     * @return The description
     * @since 0.0.1
     */
    @Override
    public String getDescription() {
        return "Sets the status of the bot";
    }

    /**
     * Gets the usage details of this {@link ICommand}
     *
     * @return The usage details
     * @since 0.0.1
     */
    @Override
    public String getUsageDetails() {
        return "!SetStatus {status message}";
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
        if (arguments.isEmpty()) {
            RSBot.CLIENT_INSTANCE.changeStatus(Status.empty());
            return true;
        }

        StringBuilder builder = new StringBuilder();

        for (String string : arguments) {
            builder.append(" ").append(string);
        }

        builder.deleteCharAt(0);

        RSBot.CLIENT_INSTANCE.changeStatus(Status.game(builder.toString()));

        return true;
    }
}
