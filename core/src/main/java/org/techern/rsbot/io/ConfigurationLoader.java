package org.techern.rsbot.io;

import org.techern.rsbot.RSBot;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * A class that loads the configuration of this {@link org.techern.rsbot.RSBot}
 *
 * @since 0.0.1
 */
public class ConfigurationLoader {

    /**
     * Gets the configuration path and creates it if needed
     *
     * @return The configuration {@link Path}
     * @since 0.0.1
     */
    private static Path getConfigurationPath() {
        Path configPath = Paths.get("").toAbsolutePath().resolve("configuration");
        if (!Files.exists(configPath)) {
            try {
                Files.createDirectories(configPath);
                RSBot.LOGGER.info("Configuration directory not found, creating...");
            } catch (IOException e) {
                RSBot.LOGGER.error("Could not create directories for configuration, aborting...");
                System.exit(1);
            }

        }

        return configPath;
    }

    /**
     * Attempts to load the token from the file, creating a new one if it doesn't exist
     *
     * @return {@code true} if loaded, otherwise {@code false}
     * @since 0.0.1
     */
    public static boolean loadTokenFromFile() {

        Path filePath = getConfigurationPath().resolve("TOKEN");

        if (Files.exists(filePath)) {
            try {
                RSBot.TOKEN = new String(Files.readAllBytes(filePath));
            } catch (IOException e) {
                RSBot.LOGGER.error("Error while reading token file", e);
            }
        } else {
            try {
                Files.createFile(filePath);

                Files.write(filePath, "UNDEFINED".getBytes());

                return false;
            } catch (IOException e) {
                RSBot.LOGGER.error("Error while writing token file", e);
                System.exit(1);
            }
        }

        RSBot.LOGGER.info("Token read");

        return true;

    }

}
