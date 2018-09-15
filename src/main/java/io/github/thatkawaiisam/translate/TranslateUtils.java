package io.github.thatkawaiisam.translate;

import com.google.gson.JsonArray;
import org.bukkit.Bukkit;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class TranslateUtils {

    public static String translateText(String langFrom, String langTo, String content) throws Exception {
        String url = "https://translate.googleapis.com/translate_a/single?" + "client=gtx&" + "sl=" + langFrom + "&tl="
                + langTo + "&dt=t&q=" + URLEncoder.encode(content, "UTF-8");
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestProperty("User-Agent", "Mozilla/5.0");

        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        return parseResult(response.toString());
    }

    private static String parseResult(String inputJson) throws Exception {
        JSONParser parser = new JSONParser();
        JSONArray jsonArray = (JSONArray) parser.parse(inputJson);
        JSONArray jsonArray2 = (JSONArray) jsonArray.get(0);
        StringBuilder builder = new StringBuilder();
        for (Object elements : jsonArray2) {
            builder.append(((JSONArray) elements).get(0).toString());
        }
        return builder.toString();
    }
}
