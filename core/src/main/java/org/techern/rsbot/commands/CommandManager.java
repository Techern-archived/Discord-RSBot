package org.techern.rsbot.commands;

import org.reflections.Reflections;
import org.reflections.scanners.SubTypesScanner;
import org.reflections.util.ClasspathHelper;
import org.reflections.util.ConfigurationBuilder;
import org.reflections.util.FilterBuilder;
import org.techern.rsbot.RSBot;

import java.util.HashMap;
import java.util.Set;

/**
 * A manager for all {@link ICommand}s in the {@link org.techern.rsbot.RSBot} classpath
 *
 * @since 0.0.1
 */
public class CommandManager {

    /**
     * The real list of {@link ICommand}s
     */
    public static HashMap<String, ICommand> COMMAND_LIST = new HashMap<>();

    /**
     * Loads all {@link ICommand}s
     *
     * @since 0.0.1
     */
    public static void loadCommands() {
        Reflections reflectionsUtility = new Reflections(new ConfigurationBuilder().setUrls(ClasspathHelper.forPackage("org.techern.rsbot"))
                .setScanners(new SubTypesScanner())
                .filterInputsBy(new FilterBuilder().includePackage("org.techern.rsbot")));


        Set<Class<? extends ICommand>> dummyCommandList = reflectionsUtility.getSubTypesOf(ICommand.class);
        RSBot.LOGGER.info("Found " + reflectionsUtility.getSubTypesOf(ICommand.class).size() + " commands");

        for (Class<? extends ICommand> command : dummyCommandList) {
            try {
                ICommand realCommand = command.newInstance();
                COMMAND_LIST.put(realCommand.getName().toLowerCase(), realCommand);
                RSBot.LOGGER.info("Loaded command " + command.getCanonicalName());
            } catch (InstantiationException | IllegalAccessException e) {
                RSBot.LOGGER.error("Could not load commands", e);
                System.exit(0);
            }

        }

    }
}
