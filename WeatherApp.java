/*import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;

public class WeatherApp {
    public static void main(String[] args) {
        // Step 1: Define the API URL with your API key and city
        //String apiKey = "my key"; // Replace with your OpenWeatherMap API key
        String city = "London"; // Replace with the desired city
        //String urlString = "https://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=" + apiKey + "&units=metric";
        String urlString = "https://wttr.in/" + city + "?format=j1"; // JSON format
        try {
            // Step 2: Create a URL object and open a connection
            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            // Step 3: Read the response from the API
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();

            // Step 4: Parse the JSON response
            JSONObject jsonResponse = new JSONObject(response.toString());
            JSONObject main = jsonResponse.getJSONObject("main");
            double temperature = main.getDouble("temp");
            int humidity = main.getInt("humidity");
            String weatherDescription = jsonResponse.getJSONArray("weather").getJSONObject(0).getString("description");

            // Step 5: Display the weather data
            System.out.println("City: " + city);
            System.out.println("Temperature: " + temperature + "°C");
            System.out.println("Humidity: " + humidity + "%");
            System.out.println("Weather: " + weatherDescription);

        } catch (Exception e) {
            // Step 6: Handle exceptions
            System.out.println("Error fetching weather data: " + e.getMessage());
        }
    }
}*/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class WeatherApp {
    public static void main(String[] args) {
        // Step 1: Define the location and API URL
        String location = "London"; // Replace with your desired location (e.g., "New York", "Berlin")
        String urlString = "https://wttr.in/" + location + "?format=j1"; // JSON format

        try {
            // Step 2: Create a URL object and open a connection
            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            // Step 3: Read the response from the API
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();

            // Step 4: Parse the JSON response (using org.json library)
            org.json.JSONObject jsonResponse = new org.json.JSONObject(response.toString());
            org.json.JSONArray currentCondition = jsonResponse.getJSONArray("current_condition");
            org.json.JSONObject condition = currentCondition.getJSONObject(0);

            String temperature = condition.getString("temp_C"); // Temperature in Celsius
            String weatherDesc = condition.getJSONArray("weatherDesc").getJSONObject(0).getString("value");

            // Step 5: Display the weather data
            System.out.println("Location: " + location);
            System.out.println("Temperature: " + temperature + "°C");
            System.out.println("Weather: " + weatherDesc);

        } catch (Exception e) {
            // Step 6: Handle exceptions
            System.out.println("Error fetching weather data: " + e.getMessage());
        }
    }
}