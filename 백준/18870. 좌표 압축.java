package coding_test.Algo20220826;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_18870_좌표압축 {
	static int[] arr1, arr2;
	static StringBuilder sb;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		arr1 = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++)	arr1[i] = Integer.parseInt(st.nextToken());
		arr2 = Arrays.stream(arr1).distinct().sorted().toArray();
		sb = new StringBuilder();
		for(int i = 0; i < N; i++)	DC(i, 0, arr2.length);
		System.out.println(sb.toString().trim());
	}
	private static void DC(int idx, int start, int end) {
		int mid = (start + end)/2;
		if(arr2[mid] == arr1[idx]) {
			sb.append(mid+" ");
			return;
		}
		if(arr2[mid] > arr1[idx])DC(idx, start, mid);
		else DC(idx, mid+1, end);
	}
}
