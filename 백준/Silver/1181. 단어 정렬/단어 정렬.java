import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        ArrayList<String> sArr = new ArrayList<>();

        HashSet<String> hs = new HashSet<>();

        for (int i = 0; i < N; i++) {
            hs.add(br.readLine());
        }

        for (String s : hs) {
            sArr.add(s);
        }

        Collections.sort(sArr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() > o2.length()) {
                    return 1;
                } else if (o1.length() < o2.length()) {
                    return -1;
                } else if (o1.length() == o2.length()) {
                    return o1.compareTo(o2);
                }
                return 0;
            }
        });


        StringBuilder sb = new StringBuilder();
        for (String s : sArr) {
            sb.append(s);
            sb.append("\n");
        }
        System.out.println(sb);
    }

}