import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class JsonPars {
    public static String parseArticleUrl(String jsonResponse) {
        // Парсим строку JSON в объект JsonElement
        JsonElement jsonElement = JsonParser.parseString(jsonResponse);

        // Проверяем, является ли элемент объектом
        if (jsonElement.isJsonObject()) {
            JsonObject jsonObject = jsonElement.getAsJsonObject();

            if (jsonObject.has("query")) {
                JsonObject queryObject = jsonObject.getAsJsonObject("query");

                if (queryObject.has("search")) {
                    JsonArray searchResults = queryObject.getAsJsonArray("search");

                    if (searchResults.size() > 0) {
                        JsonElement result = searchResults.get(0); // Берём первый результат
                        JsonObject resultObject = result.getAsJsonObject();

                        // Извлекаем pageid и формируем URL статьи
                        int pageId = resultObject.get("pageid").getAsInt();
                        return "https://ru.wikipedia.org/w/index.php?curid=" + pageId;
                    }
                }
            }
        }
        return null; // Если результатов нет
    }
}
