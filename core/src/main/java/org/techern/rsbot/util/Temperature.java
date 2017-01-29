package org.techern.rsbot.util;

/**
 * A utility class for temperatures
 *
 * @since 0.0.1
 */
public class Temperature {

    /**
     * Takes a value in celsius and returns it in fahrenheit
     * @param celsius The temperature in celsius
     *
     * @return The temperature in fahrenheit
     * @since 0.0.1
     */
    public static float celsiusToFahrenheit(float celsius) {
        return ((celsius * 1.8f) + 32f);
    }

    /**
     * Takes a value in fahrenheit and returns it in celsius
     * @param fahrenheit The temperature in fahrenheit
     *
     * @return The temperature in celsius
     * @since 0.0.1
     */
    public static float fahrenheitToCelsius(float fahrenheit) {
        return ((fahrenheit - 32f) / 1.8f);
    }

    /**
     * Takes a value in celsius and returns it in kelvin
     *
     * @param celsius The temperature in celsius
     * @return The temperature in kelvin
     * @since 0.0.1
     */
    public static float celsiusToKelvin(float celsius) {
        return celsius + 273.15f;
    }

    /**
     * Takes a value in kelvin and returns it in celsius
     *
     * @param kelvin The temperature in kelvin
     * @return The temperature in celsius
     * @since 0.0.1
     */
    public static float kelvinToCelsius(float kelvin) {
        return kelvin - 273.15f;
    }

    /**
     * Takes a value in fahrenheit and returns it in kelvin
     *
     *  (T(°F) + 459.67)× 5/9
     *
     * @param fahrenheit The temperature in fahrenheit
     * @return The temperature in kelvin
     * @since 0.0.1
     */
    public static float fahrenheitToKelvin(float fahrenheit) {
        return ((fahrenheit + 459.67f) * (5f / 9f));
    }

    /**
     * Takes a value in kelvin and returns it in fahrenheit
     *
     * T(K) × 9/5 - 459.67
     *
     * @param kelvin The temperature in kelvin
     * @return The temperature in fahrenheit
     * @since 0.0.1
     */
    public static float kelvinToFahrenheit(float kelvin) {
        return (kelvin * (9f / 5f)) - 459.67f;
    }

}
