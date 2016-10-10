package org.techern.rsbot.discord;

import sx.blah.discord.api.ClientBuilder;
import sx.blah.discord.api.IDiscordClient;
import sx.blah.discord.util.DiscordException;

/**
 * Utilities for Discord; Will be split up in a future release
 *
 * @since 0.0.1
 */
public class DiscordUtilities {

    /**
     * Gets a {@link IDiscordClient} instance
     *
     * @param token The token to use
     * @param shouldLogInImmediately True if logging in immediately
     *
     * @return A {@link IDiscordClient} instance
     * @throws DiscordException An exception occurred
     */
    public static IDiscordClient getClient(String token, boolean shouldLogInImmediately) throws DiscordException {
        ClientBuilder clientBuilder = new ClientBuilder().withToken(token); // Adds the login info to the builder
        if (shouldLogInImmediately) {
            return clientBuilder.login(); // Creates the client instance and logs the client in
        } else {
            return clientBuilder.build(); // Creates the client instance but it doesn't log the client in yet, you would have to call client.login() yourself
        }
    }
}
