import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class WikipediaAPI {
    public static String search(String query) throws Exception {
        // Кодируем запрос
        String encodedQuery = URLEncoder.encode(query, "UTF-8");

        // Создание URL для API-запроса
        String url = "https://ru.wikipedia.org/w/api.php?action=query&list=search&utf8=&format=json&srsearch=" + encodedQuery;
        URL obj = new URL(url);

        // Устанавливаем соединение
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");

        // Читаем ответ сервера
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        StringBuilder response = new StringBuilder();
        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        return response.toString(); // Возвращаем ответ в виде строки
    }
}
