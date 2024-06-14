import java.io.*;
import java.util.*;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int N;
	static PriorityQueue<Person> pq = new PriorityQueue<>();

	static int answer;

	public static void main(String[] args) throws IOException {
		input();
		solve();
		System.out.println(answer);
	}

	static void input() throws IOException {
		N = Integer.parseInt(br.readLine());
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int time = Integer.parseInt(st.nextToken());
			pq.add(new Person(start, time));
		}
	}

	static void solve() {
		int sleep = 1;
		for (int time = 1; time <= 1_000_000 * 100 && !pq.isEmpty(); time++) {
			if (sleep > time) {
				continue;
			}
			if (pq.peek().start <= time) {
				sleep = time + pq.poll().time;
			}
		}
		answer = sleep;
	}

	static class Person implements Comparable<Person> {
		int start;
		int time;

		public Person(int start, int end) {
			this.start = start;
			this.time = end;
		}

		@Override
		public int compareTo(Person o) {
			return Integer.compare(start, o.start);
		}
	}
}