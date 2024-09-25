package LeetCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class _2416_Sum_of_Prefix_Scores_of_Strings {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution_2416_Sum_of_Prefix_Scores_of_Strings().sumPrefixScores2(new String[]{"abc", "ab", "bc", "b"})));
    }
}

class Solution_2416_Sum_of_Prefix_Scores_of_Strings {
    public int[] sumPrefixScores(String[] words) {
        Map<String, Integer> map = new TreeMap<>();
        for (String str : words) {
            String prefix = "";
            for (char cha : str.toCharArray()) {
                prefix += cha;
                map.put(prefix, map.getOrDefault(prefix, 0) + 1);
            }
        }
        int[] result = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            String prefix = "";
            int sum = 0;
            for (char cha : words[i].toCharArray()) {
                prefix += cha;
                sum += map.getOrDefault(prefix, 0);
            }
            result[i] = sum;
        }
        return result;
    }

    // ChatGPT
    public int[] sumPrefixScores2(String[] words) {
        TrieNode root = new TrieNode();

        // 트라이에 단어 삽입 및 접두사 카운트 증가
        for (String word : words) {
            TrieNode node = root;
            for (char cha : word.toCharArray()) {
                int index = cha - 'a'; // 알파벳에 해당하는 인덱스
                if (node.children[index] == null) {
                    node.children[index] = new TrieNode();
                }
                node = node.children[index];
                node.count++; // 해당 접두사를 공유하는 단어 수 증가
            }
        }

        int[] result = new int[words.length];

        // 각 단어의 접두사 점수 계산
        for (int i = 0; i < words.length; i++) {
            TrieNode node = root;
            int sum = 0;
            for (char cha : words[i].toCharArray()) {
                int index = cha - 'a';
                node = node.children[index];
                sum += node.count; // 현재 접두사의 점수 더하기
            }
            result[i] = sum;
        }

        return result;
    }

    class TrieNode {
        TrieNode[] children = new TrieNode[26]; // 각 알파벳에 대해 자식을 가리키는 배열
        int count = 0; // 이 노드를 지나가는 문자열의 수
    }
}

