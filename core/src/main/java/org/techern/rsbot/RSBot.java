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
import sx.blah.discord.handle.obj.IMessage;
import sx.blah.discord.handle.obj.IUser;
import sx.blah.discord.util.DiscordException;
import sx.blah.discord.util.MissingPermissionsException;
import sx.blah.discord.util.RateLimitException;

import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

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
     * The {@link ConcurrentHashMap} of {@link ChatterBotSession}s
     *
     * @since 0.0.1
     */
    public static Map<IUser, ChatterBotSession> BOT_SESSIONS = new ConcurrentHashMap<>(15);

    /**
     * Gets a {@link ChatterBotSession} for a given {@link IMessage} from an {@link IUser}
     *
     * @param messageFromAuthor The {@link IMessage} being scoured for the {@link IUser}
     * @return A {@link ChatterBotSession}
     */
    public static ChatterBotSession getChatBotSession(IMessage messageFromAuthor) {
        if (!BOT_SESSIONS.containsKey(messageFromAuthor.getAuthor())) {
            BOT_SESSIONS.put(messageFromAuthor.getAuthor(), BOT.createSession(Locale.getDefault()));
            LOGGER.info("Created chat bot session for author " + messageFromAuthor.getAuthor().getName());
        }

        return BOT_SESSIONS.get(messageFromAuthor.getAuthor());
    }

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
