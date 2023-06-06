package silverOrLowGold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Baek1181 {
    public static class Word implements Comparable<Word> {
        private int len;
        private String sentence;

        public Word(int len, String sentence) {
            this.len = len;
            this.sentence = sentence;
        }

        @Override
        public int compareTo(Word o) {
            if(len<o.len)return -1;
            else if (len == o.len) {
                return sentence.compareTo(o.sentence);
            } else {
                return 1;
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Word word = (Word) o;

            if (len != word.len) return false;
            return sentence.equals(word.sentence);
        }

        @Override
        public int hashCode() {
            return Objects.hash(sentence);
        }
    }

    public static void main(String[] args) throws IOException {
        List<Word> wordList = new ArrayList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int N = Integer.parseInt(s);
        for (int i = 0; i < N; i++) {
            s= br.readLine();
            Word word = new Word(s.length(), s);
            wordList.add(word);
        }
        Collections.sort(wordList);
        List<Word> filtered = wordList.stream().distinct().collect(Collectors.toList());
        filtered.forEach(o-> System.out.println(o.sentence));
    }
}
