import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.util.ArrayList;
import java.util.List;

public class JsonPars {
    public static List<String> parseArticleUrls(String jsonResponse) {
        List<String> articleUrls = new ArrayList<>();

        // Парсим строку JSON в объект JsonElement
        JsonElement jsonElement = JsonParser.parseString(jsonResponse);

        // Проверяем, является ли элемент объектом
        if (jsonElement.isJsonObject()) {
            JsonObject jsonObject = jsonElement.getAsJsonObject();

            if (jsonObject.has("query")) {
                JsonObject queryObject = jsonObject.getAsJsonObject("query");

                if (queryObject.has("search")) {
                    JsonArray searchResults = queryObject.getAsJsonArray("search");

                    // Проходим по всем результатам поиска
                    for (JsonElement result : searchResults) {
                        JsonObject resultObject = result.getAsJsonObject();

                        if (resultObject.has("pageid")) {
                            int pageId = resultObject.get("pageid").getAsInt();
                            String title = resultObject.get("title").getAsString();
                            // Формируем ссылку на статью
                            String articleUrl = "https://ru.wikipedia.org/w/index.php?curid=" + pageId;
                            articleUrls.add(title + " -> " + articleUrl); // Добавляем в список
                        }
                    }
                }
            }
        }
        return articleUrls; // Возвращаем список всех ссылок
    }
}
