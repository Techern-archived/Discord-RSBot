package org.techern.rsbot.discord.events;

import org.reflections.Reflections;
import org.reflections.scanners.SubTypesScanner;
import org.reflections.util.ClasspathHelper;
import org.reflections.util.ConfigurationBuilder;
import org.reflections.util.FilterBuilder;
import org.techern.rsbot.RSBot;
import org.tritonus.share.ArraySet;
import sx.blah.discord.api.IDiscordClient;
import sx.blah.discord.api.events.Event;
import sx.blah.discord.api.events.IListener;

import java.util.ArrayList;
import java.util.Set;

import static org.techern.rsbot.RSBot.CLIENT_INSTANCE;

/**
 * A loader for all {@link EventListenerLoader}s in the {@link org.techern.rsbot.RSBot} classpath
 *
 * @since 0.0.1
 */
public class EventListenerLoader {

    /**
     * The list of {@link IListener}s
     *
     * @since 0.0.1
     */
    public static Set<Class<? extends IListener>> LISTENER_LIST = new ArraySet<>();

    /**
     * Loads all {@link Event} {@link IListener}s
     *
     * @since 0.0.1
     */
    public static void loadEventListeners() {
        Reflections reflectionsUtility = new Reflections(new ConfigurationBuilder().setUrls(ClasspathHelper.forPackage("org.techern.rsbot"))
                .setScanners(new SubTypesScanner())
                .filterInputsBy(new FilterBuilder().includePackage("org.techern.rsbot")));

        LISTENER_LIST = reflectionsUtility.getSubTypesOf(IListener.class);
        RSBot.LOGGER.info("Found " + reflectionsUtility.getSubTypesOf(IListener.class).size() + " listeners");

        for (Class<? extends IListener> listener : LISTENER_LIST) {
            try {
                IListener realListener = listener.newInstance();
                CLIENT_INSTANCE.getDispatcher().registerListener(realListener);
                RSBot.LOGGER.info("Loaded listener " + listener.getCanonicalName());
            } catch (InstantiationException | IllegalAccessException e) {
                RSBot.LOGGER.error("Could not load listeners", e);
                System.exit(0);
            }

        }

    }
}
