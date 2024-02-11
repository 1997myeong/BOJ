import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

    static class Person {
        int age;
        String name;

        public Person(int age, String name) {
            this.age = age;
            this.name = name;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int m = Integer.parseInt(br.readLine());

        ArrayList<Person> arr = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            Person person = new Person(Integer.parseInt(st.nextToken()), st.nextToken());
            arr.add(person);
        }

        /**
         * 첫 번째 객체가 두 번째 객체보다 작으면 음수, 같으면 0, 크면 양수 반환
         * compare() 에서 반환값이 양수이면 두 번째 객체를 첫 번째 객체 앞에 위치시킨다.
         */
        Collections.sort(arr, new Comparator<>() {
            @Override // 메소드 재정의
            public int compare(Person o1, Person o2) {
                return Integer.compare(o1.age, o2.age);
            }
        });

        for (Person person : arr) {
            sb.append(person.age + " " + person.name + "\n");
        }

        System.out.println(sb);
    }
}