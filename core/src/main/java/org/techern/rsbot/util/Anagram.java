package org.techern.rsbot.util;

import java.util.HashMap;
import java.util.Map;

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
        addAnagram(new Anagram("A Zen She", "Zenesha", "East Ardougne; Platebody shop at the **south** of the marketplace", "None"));
        addAnagram(new Anagram("Ace Match Elm", "Cam the Camel", "Al Kharid; North of the Gnome Glider", "None"));
        addAnagram(new Anagram("Aha Jar", "Jaraah", "Duel Arena; In the hospital", "None"));
        addAnagram(new Anagram("An Paint Tonic", "Captain Ninto", "(Requires Fishing Contest) - White Wolf Mountain, in the bar underground", "None"));
        addAnagram(new Anagram("Arc O Line", "Caroline", "Originally north Witchaven. After Sea Slug, on the coastline. After Kennith's Concerns, upstairs in her house", "11 until Salt in the Wound, then 0"));
        addAnagram(new Anagram("Are Col", "Oracle", "Ice Mountain (summit)", "48"));
        addAnagram(new Anagram("Arr! So I am a crust, and?", "Ramara do Croissant", "Requires: Swan Song. Piscatoris Fishing Colony, in the forge", "None"));
        addAnagram(new Anagram("A Bas", "Saba", "Burthorpe; In a cave to the north west", "None"));
        addAnagram(new Anagram("A Baker", "Baraek", "Varrock; Fur trader in the town square", "5"));
        addAnagram(new Anagram("A Basic Anti Pot", "Captain Tobias", "Port Sarim", "6"));
        addAnagram(new Anagram("A Heart", "Aretha", "Soul altar", "2"));
        addAnagram(new Anagram("Armchair The Pelt", "Charlie the Tramp", "Varrock; In an alleyway at the South entrance", "None"));
        addAnagram(new Anagram("At Herg", "Regath", "Arceuus House in Zeah; South-eastern general store", "None"));
        addAnagram(new Anagram("Area Chef Trek", "Father Aereck", "Lumbridge; In the church", "19"));
        addAnagram(new Anagram("Bail Trims", "Brinstail", "Gnome Stronghold; In a cave to the **west** of the **south** bank", "None"));
        addAnagram(new Anagram("By Look", "Bolkoy", "Tree Gnome Village; In the General Store", "13"));
        addAnagram(new Anagram("Boast B", "Sabbot", "Burthorpe | Death Plateau Cave Shortcut", "None"));
        addAnagram(new Anagram("Baker Climb", "Brambickle", "Trollweiss Mountain", "None"));
        addAnagram(new Anagram("Blue Brim Guided", "Lumbridge Guide", "Lumbridge; Outside the castle", "None"));
        addAnagram(new Anagram("C On Game Hoc", "Gnome Coach", "Grand Tree; At the Gnomeball course", "6"));
        addAnagram(new Anagram("Car If Ices", "", "", "None"));
        addAnagram(new Anagram("Career In Moon", "", "", "25"));
        addAnagram(new Anagram("Cool Nerd", "You :P No? It's the Old Crone", "In her house, east of the Slayer Tower", "619"));
        addAnagram(new Anagram("Copper Ore Crypts", "Prospector Percy", "(Pickaxe needed) Motherlode Mine", "12"));
        addAnagram(new Anagram("DED WAR", "Edward", "Rogue's Castle", "None"));
        addAnagram(new Anagram("Dekagram", "Dark Mage", "Abyss; Cengre of the inner ring", "13"));
        addAnagram(new Anagram("Do Say More", "Doomsayer", "Lumbridge; East of the Castle", "95"));
        addAnagram(new Anagram("Dr Hitman", "Mandrith", "Wilderness Resource Area", "28, sometimes None"));
        addAnagram(new Anagram("DIM THARN", "Mandrith", "Wilderness Resource Area", "None, sometimes 28"));
        addAnagram(new Anagram("Dr Warden Funk", "Drunken Dwarf", "East Keldagrim; In the house with broken glass", "None"));
        addAnagram(new Anagram("Dragons Lament", "Strange Old Man", "Barrows; Gravedigger", "40"));
        addAnagram(new Anagram("Dt Run B", "Brundt the Chieftain", "Rellekka; In the main hall", "4"));
        addAnagram(new Anagram("Duo Plug", "Dugopul", "Ape Atoll; In the graveyard south of Awowogei's throne room", "None"));
        addAnagram(new Anagram("Eek Zero Op", "Zookeeper", "Ardougne Zoo", "40 (Eagles Peak and Hunt for Red Raktuber both add one each if completed)"));
        addAnagram(new Anagram("El Ow", "Lowe", "Varrock; In the Archery shop", "None"));
        addAnagram(new Anagram("Err Cure It", "Recruiter", "West Ardougne; In the centre square", "20"));
        addAnagram(new Anagram("Forlun", "Runolf", "Miscellania | Etceteria. In the dungeon", "None"));
        addAnagram(new Anagram("Goblin Kern", "King Bolren", "Tree Gnome Village; Next to the Spirit Tree", "None"));
        addAnagram(new Anagram("Got A Boy", "Gabooty", "Tai Bwo Wannai (Centre)", "11"));
        addAnagram(new Anagram("Gulag Run", "Uglug Nar", "West of Jiggig, south of the Castle Wars lobby", "None"));
        addAnagram(new Anagram("Goblets Odd Toes", "Otto Godblessed", "Otto's Grotto, south of the Barbarian Outpost", "2"));
        addAnagram(new Anagram("Halt us", "Luthas", "Musa Point; Owner of the Banana plantation", "33 (sometimes)"));
        addAnagram(new Anagram("He Do Pose. It Is Cultrrl, Mk?", "Riki the Sculptor's model", "East Keldagrim; South of the kebab seller. Gravestone exchange in RS3", "None"));
        addAnagram(new Anagram("Heoric", "Eohric", "Burthorpe Castle, on the top floor", "36"));
        addAnagram(new Anagram("HIS PHOR", "Horphis", "Arceuus House Library on Zeah", "1"));
        addAnagram(new Anagram("Icy Fe", "Fycie", "Rantz's cave, south east of Gu'Tanoth", "None"));
        addAnagram(new Anagram("I Eat Its Chart Hints Do U", "Shiratti the Custodian", "Nardah; North of the fountain", "None"));
        addAnagram(new Anagram("IFaffy run", "Fairy Nuff", "Usually north of the Zanaris bank, otherwise get a certificate from the potion shelf and use fairy rings **A-I-R, D-L-R, D-J-Q, A-J-S**", "None"));
        addAnagram(new Anagram("I Faffy run", "Fairy Nuff", "Usually north of the Zanaris bank, otherwise get a certificate from the potion shelf and use fairy rings **A-I-R, D-L-R, D-J-Q, A-J-S**", "None"));
        addAnagram(new Anagram("Im Krom", "Rommik", "Rimmington; Rommik's Crafty Supplies", "10 (but there's really 11)"));
        addAnagram(new Anagram("Iz A Ammo Load For Mrs Yakkers", "Moldark, Emissary of Zamorak", "Edgeville, north-east of the bank", "7, but 3 after Ritual of the Mahjarrat"));
        addAnagram(new Anagram("I Am Sir", "Marisi", "Great Kourend; Allotment patch in Hosidius House, on the south coast", "5"));
        addAnagram(new Anagram("I Doom Icon Inn", "Dominic Onion", "Nightmare Zone", "9500"));
        addAnagram(new Anagram("I Even", "Nieve", "Gnome Stronghold (slayer master)", "2"));
        addAnagram(new Anagram("Im N Zezim", "Immenizz", "Puro-Puro (He's an imp)", "None"));
        addAnagram(new Anagram("Kay Sir", "Sir Kay", "Camelot Castle courtyard", "6"));
        addAnagram(new Anagram("Leakey", "Kaylee", "Falador, in the Rising Sun Inn", "18"));
        addAnagram(new Anagram("Land Doomed", "Odd Old Man", "Limestone mine, north-east of Varrock, towards Paterdomus", "None"));
        addAnagram(new Anagram("Lark in Dog", "King Roald", "Varrock Castle, ground floor.", "24"));
        addAnagram(new Anagram("Low Lag", "Gallow", "Great Koruend, in the Vinery", "12"));
        addAnagram(new Anagram("Ladder Memo Guv", "Guard Vemmeldo", "Gnome Stronghold, in the bank west of the agility course", "3"));
        addAnagram(new Anagram("Majors Lava Bads Air", "Ambassador Alvijar", "Another Slice of HAM needed; Upper north-east Ddorgesh-Kaan, south of the house with the quest symbol", "2505"));
        addAnagram(new Anagram("Mal in Tau", "Luminata", "Burgh de Rott, near the entrance", "None"));
        addAnagram(new Anagram("Me Am The Calc", "Cam the Camel", "Duel Arena, just outside the gates", "None"));
        addAnagram(new Anagram("Machete Clam", "Cam the Camel", "Duel Arena, just outside the gates", "6"));
        addAnagram(new Anagram("Me if", "Femo", "Tree Gnome Stronghold, outside the gates", "None"));
        addAnagram(new Anagram("Mold La Ran", "Old Man Ral", "Meiyerditch", "None"));
        addAnagram(new Anagram("Motherboard", "Brother Omad", "Monastery, south of Ardougne", "129"));
        addAnagram(new Anagram("Mus Kil Reader", "Radiumus Erkle", "Legend's Guild", "None"));
        addAnagram(new Anagram("My Mangle Lal", "Lammy Lange", "Hosidius House spirit tree patch", "None"));
        addAnagram(new Anagram("No Owner", "Oronwen", "Lletya Seamstress shop", "20"));
        addAnagram(new Anagram("Nod Med", "Edmond", "East Ardougne; behind the most north-western house", "3"));
        addAnagram(new Anagram("Or A Vile", "Valerio", "Citharede Abbey", "17"));
        addAnagram(new Anagram("O Birdz A Zany En Pc", "Cap'n Izzy no Beardd", "Brimhaven Agility Arena", "33"));
        addAnagram(new Anagram("Ok Co", "Cook", "Lumbridge Castle kitchen", "9"));
        addAnagram(new Anagram("Or Zinc Fumes Ward", "Wizard Frumscone", "Wizards' Guild basement", "None"));
        addAnagram(new Anagram("Our Own Needs", "Nurse Wooned", "Shayzien House infirmary, southern tent", "52"));
        addAnagram(new Anagram("Pacinng a taie", "Captain Ginea", "East of the Shayzien combat ring", "113"));
        addAnagram(new Anagram("Peak Reflex", "Flax keeper", "Seers Village; In the flax field", "676"));
        addAnagram(new Anagram("Peaty Pert", "Party Pete", "Falador; In the party room", "None"));
        addAnagram(new Anagram("Profs Lose Wrong Pie", "Professor Onglewip", "Wizards' Tower, ground floor", "None"));
        addAnagram(new Anagram("Quit Horrible Tyrant", "Brother Tranquility", "Mos le'Harmless OR Harmony Island", "7"));
        addAnagram(new Anagram("Que Sir", "Squire", "Falador; Castle courtyard", "654"));
        addAnagram(new Anagram("R Ak Mi", "Karim", "Al Kharid; In the kebab shop", "5"));
        addAnagram(new Anagram("Rat Mat Within", "Martin Thwait", "Rogues' Den", "2"));
        addAnagram(new Anagram("Red Art Trans", "Trader Stan", "Port Sarim, at the Charter boat. How do you not see a charter boat?", "None"));
        addAnagram(new Anagram("Ratai", "Taria", "Rimmington bush patch ( ͡° ͜ʖ ͡°)", "7"));
        addAnagram(new Anagram("R SLICER", "Clerris", "Arceuus essence mine", "738"));
        addAnagram(new Anagram("Slam Duster Grail", "Guildmaster Lars", "Zeah woodcutting guild", "None"));
        addAnagram(new Anagram("Slide Woman", "Wise Old Man", "Draynor Village", "28"));
        addAnagram(new Anagram("Snakes So I Sail", "Lisse Isaakson", "Neitiznot", "2"));
        addAnagram(new Anagram("Sand Nut", "Dunstan", "Burthorpe; Anvils at the north-east", "8"));
        addAnagram(new Anagram("Sequin Dirge", "Queen Sigrid", "Etceteria Castle throne room, Miscellania Castle throne room after Blood Runs Deep", "None"));
        addAnagram(new Anagram("Snah", "Hans", "Lumbridge Castle courtyard", "None"));
        addAnagram(new Anagram("Soy Drain", "Ysondria", "Lumbridge Swap, The Nexus", "10"));
        addAnagram(new Anagram("Stab Ob", "Sabbot", "Burthorpe | Death Plateau Cave Shortcut", "None"));
        addAnagram(new Anagram("Tamed Rocks", "Dockmaster", "Great Kourend, Piscarilius House; Northeast of the general store", "5"));
        addAnagram(new Anagram("Ten Wigs On", "Wingstone", "Between nardah and the Agility Pyramid", "None"));
        addAnagram(new Anagram("Them Cal Came", "Cam the Camel", "Duel Arena gates", "None"));
        addAnagram(new Anagram("Thickno", "Hickton", "Catherby; In the archery shop", "2"));
        addAnagram(new Anagram("Twenty Cure Iron", "New recruit Tony", "Great Koruend; In Shayzien House's Graveyard", "None"));
        addAnagram(new Anagram("Unleash Night Mist", "Sigli the Huntsman", "Rellekka", "302"));
        addAnagram(new Anagram("Veste", "Steve", "Upstairs in the Asgarnian Ice Dungeon Wyvern dyngeon, otherwise at the entrance to the Stronghold Slayer Cave", "2"));
        addAnagram(new Anagram("Veil Veda", "Evil Dave", "In his **EEEEEVIL** house, down the **EEEEVIL** trapdoor", "666"));
        addAnagram(new Anagram("Winston Lane", "Nails Newton", "Taverley Lodestone, plotting his next move", "10"));
        addAnagram(new Anagram("Woo an egg kiwi", "Awowogei", "Ape Atoll", "24"));
        addAnagram(new Anagram("YAWNS GY", "Ysgawyn", "Lleyta", "None"));


        //addAnagram(new Anagram("", "", "", "None"));

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
     * Checks to see if a text entry is a partial match to an {@link Anagram}
     *
     * @param jumbledText The text entry
     * @return {@code true} if a partial match is found, otherwise {@code false}
     * @since 0.0.1
     */
    public static boolean doesPartialAnagramExist(String jumbledText) {
        for (String key : ANAGRAMS.keySet()) {
            if (key.startsWith(jumbledText.toLowerCase())) return true;
        }

        return false;
    }

    /**
     * Adds an {@link Anagram}
     *
     * @param anagram The {@link Anagram} to add
     * @since 0.0.1
     */
    private static void addAnagram(Anagram anagram) {
        ANAGRAMS.put(anagram.getJumbledText().toLowerCase(), anagram);
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

    /**
     * Gets a partial {@link Anagram} match
     *
     * @param jumbledText The text we're looking for
     * @return An {@link Anagram}
     *
     * @since 0.0.1
     */
    public static Anagram getPartialAnagram(String jumbledText) {
        for (Map.Entry<String, Anagram> entry : ANAGRAMS.entrySet()) {
            if (entry.getKey().startsWith(jumbledText.toLowerCase())) {
                return entry.getValue();
            }
        }

        return new Anagram("FILA", "FAIL", "Does not exist", "Your keyboard");
    }

}
