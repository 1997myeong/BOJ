import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        StringTokenizer one = new StringTokenizer(br.readLine());

        int w = Integer.parseInt(one.nextToken()); // 가로
        int h = Integer.parseInt(one.nextToken()); // 세로
        int count = Integer.parseInt(br.readLine());

        ArrayList<Integer> wArr = new ArrayList<>();
        ArrayList<Integer> hArr = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            StringTokenizer line = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(line.nextToken());
            int b = Integer.parseInt(line.nextToken());
            if (a == 0) {
                hArr.add(b);
            } else {
                wArr.add(b);
            }

        }
        Collections.sort(wArr);
        Collections.sort(hArr);


        int[] newW;
        if (wArr.size() < 1) {
            newW = new int[1];
            newW[0] = w;
        } else {
            newW = new int[wArr.size() + 1];
            newW[0] = wArr.get(0);
            newW[newW.length - 1] = w - wArr.get(wArr.size() - 1);
        }


        int[] newH;
        if (hArr.size() < 1) {
            newH = new int[1];
            newH[0] = h;
        } else {
            newH = new int[hArr.size() + 1];
            newH[0] = hArr.get(0);
            newH[newH.length - 1] = h - hArr.get(hArr.size() - 1);

        }


        for (int i = 1; i < wArr.size(); i++) {
            newW[i] = wArr.get(i) - wArr.get(i - 1);
        }
        for (int i = 1; i < hArr.size(); i++) {
            newH[i] = hArr.get(i) - hArr.get(i - 1);
        }

        int max = 0;
        for (int i = 0; i < newW.length; i++) {
            for (int j = 0; j < newH.length; j++) {
                int num = newW[i] * newH[j];
                max = Math.max(max, num);
            }
        }


        System.out.println(max);


    }
}
