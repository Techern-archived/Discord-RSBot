package org.techern.rsbot.commands;

import org.techern.rsbot.RSBot;
import org.techern.rsbot.util.Anagram;
import sx.blah.discord.handle.obj.IChannel;
import sx.blah.discord.handle.obj.IUser;
import sx.blah.discord.util.DiscordException;
import sx.blah.discord.util.MissingPermissionsException;
import sx.blah.discord.util.RateLimitException;

import java.util.List;

/**
 * A {@link ICommand} for {@link org.techern.rsbot.util.Anagram}s
 *
 * @since 0.0.1
 */
public class AnagramCommand implements ICommand {

    /**
     * Gets the name of this {@link ICommand}
     *
     * @return The name
     * @since 0.0.1
     */
    @Override
    public String getName() {
        return "anagram";
    }

    /**
     * Gets the description of this {@link ICommand}
     *
     * @return The description
     * @since 0.0.1
     */
    @Override
    public String getDescription() {
        return "Solves Clue Scroll anagrams (Well, shows you the answer, anyway)";
    }

    /**
     * Gets the usage details of this {@link ICommand}
     *
     * @return The usage details
     * @since 0.0.1
     */
    @Override
    public String getUsageDetails() {
        return "!anagram {jumbled text}";
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
        if (arguments.size() == 0) {
            return false;
        }

        StringBuilder textBuilder = new StringBuilder();

        for (String textFragment : arguments) {
            textBuilder.append(" ").append(textFragment);
        }
        textBuilder.deleteCharAt(0);

        String jumbledText = textBuilder.toString();

        try {
            if (Anagram.doesAnagramExist(jumbledText)) {
                channel.sendMessage(Anagram.getAnagram(jumbledText).toString());
                return true;
            } else {
                channel.sendMessage("Anagram \"" + jumbledText + "\" does not exist or is not added. Is it new?");
                return true;
            }

        } catch (MissingPermissionsException | RateLimitException | DiscordException e) {
            RSBot.LOGGER.error("Error while doing anagram command", e);
            return false;
        }

    }
}
