package org.techern.rsbot;

import com.google.code.chatterbotapi.ChatterBot;
import com.google.code.chatterbotapi.ChatterBotFactory;
import com.google.code.chatterbotapi.ChatterBotSession;
import com.google.code.chatterbotapi.ChatterBotType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.techern.rsbot.commands.CommandManager;
import org.techern.rsbot.discord.DiscordUtilities;
import org.techern.rsbot.discord.events.EventListenerLoader;
import org.techern.rsbot.io.ConfigurationLoader;
import sx.blah.discord.api.IDiscordClient;
import sx.blah.discord.handle.obj.IMessage;
import sx.blah.discord.handle.obj.IUser;
import sx.blah.discord.util.DiscordException;

import java.time.Instant;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

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
    public static IDiscordClient CLIENT_INSTANCE = null;

    /**
     * The {@link ChatterBot} instance
     *
     * @since 0.0.1
     */
    public static ChatterBot BOT = null;

    /**
     * An {@link AtomicLong} showing how many chat bot requests have been made
     *
     * @since 0.0.1
     */
    public static AtomicLong CHAT_BOT_REQUESTS = new AtomicLong(0);

    /**
     * An {@link AtomicLong} showing how many command requests have been made
     *
     * @since 0.0.1
     */
    public static AtomicLong COMMAND_REQUESTS = new AtomicLong(0);

    /**
     * The {@link ConcurrentHashMap} of {@link ChatterBotSession}s
     *
     * @since 0.0.1
     */
    public static Map<IUser, ChatterBotSession> BOT_SESSIONS = new ConcurrentHashMap<>(15);

    /**
     * The {@link Instant} that the {@link RSBot} was started
     *
     * @since 0.0.1
     */
    public static Instant STARTUP_INSTANT = null;

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

        STARTUP_INSTANT = Instant.now();

        LOGGER = LoggerFactory.getLogger("RSBot");

        LOGGER.info("Starting RSBot version 0.0.1 (SNAPSHOT)"); //TODO Move

        ChatterBotFactory factory = new ChatterBotFactory();

        try {
            BOT = factory.create(ChatterBotType.CLEVERBOT);
        } catch (Exception e) {
            LOGGER.error("Could not create Cleverbot instance", e);
            System.exit(1);
        }

        if (!ConfigurationLoader.loadTokenFromFile() || TOKEN.equals("UNDEFINED")) {
            LOGGER.error("Undefined token! Please edit configuration/TOKEN");
            System.exit(1);
        }

        try {

            CLIENT_INSTANCE = DiscordUtilities.getClient(TOKEN, false);

            EventListenerLoader.loadEventListeners();

            CommandManager.loadCommands();

            CLIENT_INSTANCE.login(true);

            LOGGER.info("Startup complete!");

        } catch (DiscordException e1) {
            e1.printStackTrace();
        }
    }

}
