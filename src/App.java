import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class App {

    static String line;

    public static void main(String args[]) throws IOException
    {
        Scanner k = new Scanner(System.in);


        Welcome.welcome();
        
        while(true)
        {
            System.out.print("\n\nEnter Ip Address[DEFAULT EXIT] : ");
            String ip = k.nextLine();
            if (ip == "")
            {
                System.out.println("Done, Have a Great day");
                break;
            }
            String output = connectionSetup(ip);
            System.out.println(Data(output));
        }

        k.close();
    }

    static String connectionSetup(String ip) throws IOException
    {
        StringBuilder builder = new StringBuilder();
        String base_url = helper.base + "&ip=" + ip + "&format=json";
        URL url = new URL(base_url);
        try{
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            
            while((line = reader.readLine()) != null)
            {
                builder.append(line);
            }
        }catch(Exception e)
        {
            
        }

        
        return builder.toString();
    }

    static String Data(String raw)
    {
        StringBuilder builder = new StringBuilder();
        JsonParser parser = new JsonParser();
        try {
            JsonElement element = parser.parse(raw);
            JsonObject object = element.getAsJsonObject();
            if(!object.get("statusCode").getAsString().equals("OK"))
            {
                return "Error";
            }
            String messString = "**************************************************\n";
            messString += "IP Address : " + object.get("ipAddress") + "\n\n"
                            + "Country Name : " + object.get("countryName") + "\n"
                            + "State : " + object.get("regionName") + "\n"
                            + "City Name : " + object.get("cityName") + "\n"
                            + "Lat / Long : (" + object.get("latitude") + "," + object.get("longitude") + ")\n\n";
            
            messString += "**************************************************";

            builder.append(messString);
        } catch (Exception e) {
            System.out.println("\nEnter a Valid IP Address");
        }
        
         
        return builder.toString();
        
    }
}
