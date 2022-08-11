package kyu4.Recover_a_secret_string_from_random_triplets;

import java.util.*;
import java.util.stream.Collectors;

public class SecretDetective {
    public static void main(String[] args) {
        var detective = new SecretDetective();
        System.out.println(detective.recoverSecret(new char[][] {
                {'t','u','p'},
                {'w','h','i'},
                {'t','s','u'},
                {'a','t','s'},
                {'h','a','p'},
                {'t','i','s'},
                {'w','h','s'}
        }));
    }

    public String recoverSecret(char[][] triplets) {
        Set<Character> letters = new HashSet<>();
        for (char[] triplet : triplets) {
            letters.addAll(new String(triplet).chars().mapToObj(o -> (char) o).toList());
        }
        List<Character> sortLetters = new ArrayList<>(letters);
        for (char[] triplet : triplets) {
            if (sortLetters.indexOf(triplet[1]) > sortLetters.indexOf(triplet[2]))
                move(sortLetters, sortLetters.indexOf(triplet[2]), sortLetters.indexOf(triplet[1]));
            if (sortLetters.indexOf(triplet[0]) > sortLetters.indexOf(triplet[1]))
                move(sortLetters, sortLetters.indexOf(triplet[1]), sortLetters.indexOf(triplet[0]));
        }
        return sortLetters.stream().map(String::valueOf).collect(Collectors.joining());
    }

    public static void move(List<Character> list, int moveTo, int moveFrom) {
        if (moveFrom == moveTo) return;
        Collections.rotate(moveFrom < moveTo ? list.subList(moveFrom, moveTo + 1) : list.subList(moveTo, moveFrom + 1), moveFrom < moveTo ? -1 : 1);
    }
}
