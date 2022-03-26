package interview;

import io.vertx.core.json.JsonObject;

import java.util.HashMap;

public class MostOccurringWords {
    public static JsonObject mostOccurringWords(String sentence) throws Exception {
        if (sentence == null || sentence.isEmpty() || sentence.trim().isEmpty()) {
            throw new Exception("sentence cannot be empty");
        }
        HashMap<String, Integer> map = new HashMap<>();
        String mostOccurringString = "";
        Integer mostOccurringNumber = 0;
        String[] strings = sentence.split(" ");
        for (String s : strings) {
            Integer occurrence = map.getOrDefault(s, 0) + 1;
            map.put(s, occurrence);
            if (occurrence > mostOccurringNumber) {
                mostOccurringNumber = occurrence;
                mostOccurringString = s;
            }
        }
        return new JsonObject().put(mostOccurringString, mostOccurringNumber);
    }
}
