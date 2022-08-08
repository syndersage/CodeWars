package kyu4.Most_frequently_used_words_in_a_text;

import java.util.*;

public class TopWords {
    public static void main(String[] args) {
        System.out.println(top3("In a village of La Mancha, the name of which I have no desire to call to\"," +
                "                        \"mind, there lived not long since one of those gentlemen that keep a lance\",\n" +
                "                        \"in the lance-rack, an old buckler, a lean hack, and a greyhound for\",\n" +
                "                        \"coursing. An olla of rather more beef than mutton, a salad on most\",\n" +
                "                        \"nights, scraps on Saturdays, lentils on Fridays, and a pigeon or so extra\",\n" +
                "                        \"on Sundays, made away with three-quarters of his income."));
    }

    public static List<String> top3(String s) {
        Map<String, Integer> wordMap = new HashMap<>();
        List<String> words = new ArrayList<>(Arrays.asList(s.strip().replaceAll("[^A-Za-z ']", " ").replaceAll(" +", " ").split(" ")));
        for (int i = 0; i < words.size(); i++) {
            if (words.get(i).length() == 0 || words.get(i).replaceAll("'", "").length() == 0) words.remove(i);
        }
        if (words.size() == 0) return words;
        for (String word : words) {
            wordMap.merge(word, 1, Integer::sum);
        }
        SortedSet<Map.Entry<String, Integer>> wordSet = new TreeSet<>(((Comparator<Map.Entry<String, Integer>>) (o1, o2) -> o2.getValue() - o1.getValue()).thenComparing(Map.Entry::getKey));
        wordSet.addAll(wordMap.entrySet());
        words.clear();
        int maxWords = Math.min(3, wordSet.size());
        for (int i = 0; i < maxWords; i++) {
            System.out.println(i);
            words.add(wordSet.first().getKey().toLowerCase(Locale.ROOT));
            wordSet.remove(wordSet.first());
        }
        return words;
    }
}
