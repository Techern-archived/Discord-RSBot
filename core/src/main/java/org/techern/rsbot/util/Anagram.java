package org.techern.rsbot.util;

import java.util.HashMap;

/**
 * An anagram used in RuneScape's Clue Scrolls
 *
 * @since 0.0.1
 */
public class Anagram {

    /**
     * The map of {@link Anagram}s
     *
     * @since 0.0.1
     */
    public static HashMap<String, Anagram> ANAGRAMS = new HashMap<>(100);

    /**
     * The jumbled text in this {@link Anagram}
     *
     * @since 0.0.1
     */
    private String jumbledText;

    /**
     * Gets the jumbled text for this {@link Anagram}
     *
     * @return The jumbled text
     * @since 0.0.1
     */
    public String getJumbledText() {
        return jumbledText;
    }

    /**
     * The normal text in this {@link Anagram}
     *
     * @since 0.0.1
     */
    private String normalText;

    /**
     * Gets the normal text for this {@link Anagram}
     *
     * @return The normal text
     * @since 0.0.1
     */
    public String getNormalText() {
        return normalText;
    }

    /**
     * The location of this {@link Anagram}'s target
     *
     * @since 0.0.1
     */
    private String location;

    /**
     * Gets this {@link Anagram}'s target's location
     *
     * @return The location
     * @since 0.0.1
     */
    public String getLocation() {
        return location;
    }

    /**
     * The challenge answer for this {@link Anagram}
     *
     * @since 0.0.1
     */
    private String challengeAnswer;

    /**
     * Gets the challenge answer for this {@link Anagram}
     *
     * @return The challenge answer
     * @since 0.0.1
     */
    public String getChallengeAnswer() {
        return challengeAnswer;
    }

    /**
     * Creates a new {@link Anagram}
     *
     * @param jumbledText The jumbled text
     * @param normalText The normal text
     * @param location The location of this {@link Anagram}'s target
     * @param challengeAnswer The challenge answer (if any)
     * @since 0.0.1
     */
    public Anagram(String jumbledText, String normalText, String location, String challengeAnswer) {

        this.jumbledText = jumbledText;
        this.normalText = normalText;
        this.location = location;
        this.challengeAnswer = challengeAnswer;

    }

    /**
     * Gets a {@link String} representing this {@link Anagram}
     *
     * @return A {@link String}
     * @since 0.0.1
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder(50);
        builder.append("*").append(jumbledText).append("* - ")
                .append("**").append(normalText).append("**");

        if (!challengeAnswer.equals("None")) {
            builder.append(" - Challenge answer: ").append(challengeAnswer);
        }

        builder.append("\n").append("Location of target: ").append("**").append(location).append("**");

        return builder.toString();
    }

    /**
     * Load all {@link Anagram}s
     *
     * @since 0.0.1
     */
    public static void loadAnagrams() {
        ANAGRAMS.put("Cruz", new Anagram("Cruz", "Chat Bot", "Behind his laptop", "Coffee (unless sick, then more coffee)"));
    }

    /**
     * Checks to see if an {@link Anagram} exists
     *
     * @param jumbledText The jumbled text
     * @return {@code true} if found, otherwise {@code} false
     * @since 0.0.1
     */
    public static boolean doesAnagramExist(String jumbledText) {
        return ANAGRAMS.containsKey(jumbledText.toLowerCase());
    }

    /**
     * Gets an {@link Anagram}
     *
     * @param jumbledText The jumbled text
     * @return The {@link Anagram}
     * @since 0.0.1
     */
    public static Anagram getAnagram(String jumbledText) {
        return ANAGRAMS.get(jumbledText.toLowerCase());
    }

}
