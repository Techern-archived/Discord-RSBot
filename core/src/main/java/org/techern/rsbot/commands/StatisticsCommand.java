package org.techern.rsbot.commands;

import org.techern.rsbot.RSBot;
import org.techern.rsbot.discord.events.EventListenerLoader;
import sx.blah.discord.handle.obj.IChannel;
import sx.blah.discord.handle.obj.IUser;
import sx.blah.discord.util.DiscordException;
import sx.blah.discord.util.MissingPermissionsException;
import sx.blah.discord.util.RateLimitException;

import java.time.Duration;
import java.time.Instant;
import java.util.List;

/**
 * An implementation of {@link ICommand} that displays statistics for {@link RSBot}
 *
 * @since 0.0.1
 */
public class StatisticsCommand implements ICommand {

    /**
     * Gets the name of this {@link ICommand}
     *
     * @return The name
     * @since 0.0.1
     */
    @Override
    public String getName() {
        return "stats";
    }

    /**
     * Gets the description of this {@link ICommand}
     *
     * @return The description
     * @since 0.0.1
     */
    @Override
    public String getDescription() {
        return "Displays bot statistics (based on the bot installation, not just your server)";
    }

    /**
     * Gets the usage details of this {@link ICommand}
     *
     * @return The usage details
     * @since 0.0.1
     */
    @Override
    public String getUsageDetails() {
        return "\"!stats\" (What were you expecting? :P)";
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

        Instant now = Instant.now(); //lol really

        Duration uptime = Duration.between(RSBot.STARTUP_INSTANT, now);

        responseBuilder.append("**Uptime:** ");

        if (uptime.isNegative()) {
            try {
                channel.sendMessage("Bot has been up for negative period of time");
                return false;
            } catch (MissingPermissionsException | RateLimitException | DiscordException e) {
                RSBot.LOGGER.error("Error while processing statistics command", e);
                return false;
            }

        } else {

            long days = uptime.toDays();

            if (days > 0) {
                Duration _days = Duration.ofDays(days);
                uptime = uptime.minus(_days);
            }

            long hours = uptime.toHours();

            if (hours > 0) {
                Duration _hours = Duration.ofHours(hours);
                uptime = uptime.minus(_hours);
            }

            long minutes = uptime.toMinutes();

            if (minutes > 0) {
                Duration _minutes = Duration.ofMinutes(minutes);
                uptime = uptime.minus(_minutes);
            }

            long seconds = uptime.getSeconds();

            if (days > 0) {
                responseBuilder.append(days).append(days == 1 ? " day" : " days").append(", ");
            }
            if (hours > 0) {
                responseBuilder.append(hours).append(hours == 1 ? " hour" : " hours").append(", ");
            }
            if (minutes > 0) {
                responseBuilder.append(minutes).append(minutes == 1 ? " minute" : " minutes").append(", ");
            }
            if (seconds > 0) {
                responseBuilder.append(seconds).append(seconds == 1 ? " second" : " seconds").append(", ");
            }

        }

        responseBuilder.deleteCharAt(responseBuilder.length() - 1);
        responseBuilder.deleteCharAt(responseBuilder.length() - 1);

        responseBuilder.append("\n \n");

        responseBuilder.append("**Command requests:** ").append(RSBot.COMMAND_REQUESTS.get()).append("\n");

        responseBuilder.append("**Chat bot requests:** ").append(RSBot.CHAT_BOT_REQUESTS.get());

        responseBuilder.append("\n \n");

        responseBuilder.append("**Commands loaded:** ").append(CommandManager.COMMAND_LIST.size()).append("\n");
        responseBuilder.append("**Listeners loaded:** ").append(EventListenerLoader.LISTENER_LIST.size());

        try {
            channel.sendMessage(responseBuilder.toString());
            return true;
        } catch (MissingPermissionsException | RateLimitException | DiscordException e) {
            RSBot.LOGGER.error("Error while processing statistics command", e);
            return false;
        }
    }
}
