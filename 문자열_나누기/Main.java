import java.util.*; // 까먹지 말기
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); 
        String Word = br.readLine();

				// 부분 집합(문자열 배열)로 된 리스트
        List<String[]> wordList = new ArrayList<>();
				// 중복없이
        Set<String> set = new TreeSet<>();

        // 위치를 2개 정하는 모든 조합 구하기, 1라도 포함시키기 위해
        for (int i = 1; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
								// .substring(0,i); 인덱스 0부터 i까지 자름, 다 소문자임!!
                String first = Word.substring(0, i);
                String second = Word.substring(i, j);
                String third = Word.substring(j);
                String[] words = { first, second, third };
								wordList.add(words);
                set.add(first);
                set.add(second);
                set.add(third);
            }
        }
				// 중복 제거된 HashSet을 순서가 있는 리스트 형태로(정렬하기 위해)
        List<String> tempScoreList = new ArrayList<>(set);

        Map<String, Integer> wordScore = new HashMap<>();
        for (int i = 0; i < tempScoreList.size(); i++) {
						// .put Map에서 (key value)
            wordScore.put(tempScoreList.get(i), i + 1);
        }

        int maxScore = -1;
        for (String[] words : wordList) {
            int tempScore = 0;
            for (String word : words) {
                tempScore += wordScore.get(word);
            }
            maxScore = Math.max(maxScore, tempScore);
        }
        
        System.out.println(maxScore);
    }
}