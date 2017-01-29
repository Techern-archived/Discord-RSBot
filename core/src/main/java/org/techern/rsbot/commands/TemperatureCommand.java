package org.techern.rsbot.commands;

import org.techern.rsbot.util.Temperature;
import sx.blah.discord.handle.obj.IChannel;
import sx.blah.discord.handle.obj.IUser;

import java.util.List;

/**
 * An {@link ICommand} for displaying temperatures
 *
 * @since 0.0.1
 */
public class TemperatureCommand implements ICommand {

    /**
     * Gets the name of this {@link ICommand}
     *
     * @return The name
     * @since 0.0.1
     */
    @Override
    public String getName() {
        return "Temperature";
    }

    /**
     * Gets the description of this {@link ICommand}
     *
     * @return The description
     * @since 0.0.1
     */
    @Override
    public String getDescription() {
        return "Takes a temperature and displays it in other forms";
    }

    /**
     * Gets the usage details of this {@link ICommand}
     *
     * @return The usage details
     * @since 0.0.1
     */
    @Override
    public String getUsageDetails() {
        return "!Temperature [temperature] [c|f|k|celsius|fahrenheit|kelvin]";
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
        try {
            if (arguments.size() > 1) {
                Float temperature = Float.parseFloat(arguments.get(0));
                String type = arguments.get(1).toLowerCase();

                if (type.startsWith("f")) {
                    channel.sendMessage("Temperature: **" + temperature + " Fahrenheit**\n\n\\*\\*\\*\\*\\*\\*\\*\n\n"
                            + "Equal to **" + Temperature.fahrenheitToCelsius(temperature)
                            + " Celsius** and **" + Temperature.fahrenheitToKelvin(temperature) + " Kelvin**");
                    return true;
                } else if (type.startsWith("c")) {
                    channel.sendMessage("Temperature: **" + temperature + " Celsius**\n\n\\*\\*\\*\\*\\*\\*\\*\n\n"
                            + "Equal to **" + Temperature.celsiusToFahrenheit(temperature)
                            + " Fahrenheit** and **" + Temperature.celsiusToKelvin(temperature) + " Kelvin**");
                    return true;
                } else if (type.startsWith("k")) {
                    channel.sendMessage("Temperature: **" + temperature + " Kelvin**\n\n\\*\\*\\*\\*\\*\\*\\*\n\n"
                            + "Equal to **" + Temperature.kelvinToFahrenheit(temperature)
                            + " Fahrenheit** and **" + Temperature.kelvinToCelsius(temperature) + " Celsius**");
                    return true;
                } else {
                    return false;
                }
            } else return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
