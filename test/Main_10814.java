import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br; static BufferedWriter bw; static StringTokenizer st;

    static int n;
    static Person[] arr;
    public static void main(String[] args) throws IOException  {
        init();
        run();
        ourprint();
    }

    static void init() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        arr = new Person[n];

        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine().trim());
            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            arr[i] = new Person(age, i, name);
        }
        
        Arrays.sort(arr);
    }

    static void run() throws IOException {

    }

    static void ourprint() throws IOException {
        for(Person p : arr)
            bw.write(p.age + " " + p.name + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}

class Person implements Comparable<Person> {
    int age;
    String name;
    int idx;

    Person(int age, int idx, String name) {
        this.age = age;
        this.idx = idx;
        this.name = name;
    }

    @Override
    public int compareTo(Person p) {
        if(this.age != p.age)
            return Integer.compare(this.age, p.age);

        return Integer.compare(this.idx, p.idx);
    }
}