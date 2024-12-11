import java.io.BufferedReader;  //чтение ответа с сервера
import java.io.InputStreamReader;
import java.net.HttpURLConnection;   //класс для создания HTTP-соединений.
import java.net.URL;
import java.net.URLEncoder;

public class WikipediaAPI {
    public static String search(String query) throws Exception {    //метод
        // Кодируем запрос
        String encodedQuery = URLEncoder.encode(query, "UTF-8");

        // Создание URL для API-запроса
        String url = "https://ru.wikipedia.org/w/api.php?action=query&list=search&utf8=&format=json&srsearch=" + encodedQuery;
        URL obj = new URL(url);

        // Устанавливаем соединение с сервером
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");

        // Читаем ответ сервера
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        StringBuilder response = new StringBuilder();
        int ch;
        while ((ch = in.read()) != -1) {   //если есть что читать
            response.append((char)ch);
        }
        in.close();

        return response.toString(); // Возвращаем ответ в виде строки
    }
}
