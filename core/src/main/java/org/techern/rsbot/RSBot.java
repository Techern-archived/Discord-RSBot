package org.techern.rsbot;

import com.google.code.chatterbotapi.ChatterBot;
import com.google.code.chatterbotapi.ChatterBotFactory;
import com.google.code.chatterbotapi.ChatterBotSession;
import com.google.code.chatterbotapi.ChatterBotType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.techern.rsbot.discord.DiscordUtilities;
import org.techern.rsbot.discord.events.GuildCreateEventListener;
import org.techern.rsbot.discord.events.MentionEventListener;
import org.techern.rsbot.io.ConfigurationLoader;
import sx.blah.discord.api.IDiscordClient;
import sx.blah.discord.handle.obj.IChannel;
import sx.blah.discord.handle.obj.IGuild;
import sx.blah.discord.util.DiscordException;
import sx.blah.discord.util.MissingPermissionsException;
import sx.blah.discord.util.RateLimitException;

import java.util.Locale;

/**
 * RSBot; The entry class
 *
 * @since 0.0.1
 */
public class RSBot {

    /**
     * The token used by this {@link RSBot}
     *
     * @since 0.0.1
     */
    public static String TOKEN = "UNDEFINED";

    /**
     * The {@link Logger} used by {@link RSBot}
     *
     * @since 0.0.1
     */
    public static Logger LOGGER = null;

    /**
     * The {@link IDiscordClient} instance
     *
     * @since 0.0.1
     */
    public static IDiscordClient clientInstance = null;

    /**
     * The {@link ChatterBot} instance
     *
     * @since 0.0.1
     */
    public static ChatterBot BOT = null;

    /**
     * The {@link ChatterBotSession}
     *
     * @since 0.0.2
     * TODO Remove me
     */
    public static ChatterBotSession BOT_SESSION = null;

    /**
     * The entry point
     * @param arguments Any command-line arguments passed on
     *
     * @since 0.0.1
     */
    public static void main(String... arguments) throws InterruptedException {

        LOGGER = LoggerFactory.getLogger("RSBot");

        LOGGER.info("Starting RSBot version 0.0.1 (SNAPSHOT)"); //TODO Move

        ChatterBotFactory factory = new ChatterBotFactory();

        try {
            BOT = factory.create(ChatterBotType.CLEVERBOT);
            BOT_SESSION = BOT.createSession(Locale.getDefault());
        } catch (Exception e) {
            LOGGER.error("Could not create cleverbot instance", e);
            System.exit(1);
        }

        if (!ConfigurationLoader.loadTokenFromFile() || TOKEN.equals("UNDEFINED")) {
            LOGGER.error("Undefined token! Please edit configuration/TOKEN");
            System.exit(1);
        }

        try {

            clientInstance = DiscordUtilities.getClient(TOKEN, false);

            clientInstance.getDispatcher().registerListener(new GuildCreateEventListener());
            clientInstance.getDispatcher().registerListener(new MentionEventListener());

            clientInstance.login(true);

            LOGGER.info("Startup complete!");

        } catch (DiscordException e1) {
            e1.printStackTrace();
        }
    }

}
