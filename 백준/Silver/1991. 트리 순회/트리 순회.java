//백준 1991 트리 순회
import java.io.*;
import java.util.*;

public class Main {
	static class Node {
		char data;
		Node left, right;

		public Node(char data, Node left, Node right) {
			this.data = data;
			this.left = left;
			this.right = right;
		}
	}

	static int n;
	static Node head = new Node('A', null, null); // 루트 노드는 A부터 시작!!
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			char root = st.nextToken().charAt(0);
			char left = st.nextToken().charAt(0);
			char right = st.nextToken().charAt(0);

			insertNode(head, root, left, right); // head 트리에 root 와 자식인 left,right를 삽입함
		}
		pre(head);
		sb.append("\n");
		in(head);
		sb.append("\n");
		post(head);
		System.out.println(sb.toString());
	}
	// insertNode 메서드: 특정 노드를 부모로 하여 왼쪽과 오른쪽 자식 노드를 연결
	public static void insertNode(Node current, char root, char left, char right) {
		if (current.data == root) { // 현재 노드가 부모 노드와 일치하면(현재 노드가 삽입할 위치라면)
			current.left = (left == '.' ? null : new Node(left, null, null));// 왼쪽 자식 노드 삽입
			current.right = (right == '.' ? null : new Node(right, null, null));// 오른쪽 자식 노드 삽입

		} else { // 아직 삽입할 위치에 도달하지 못한 경우 : 원하는 root 노드 찾을 때까지 계속 탐색
					// (따라서 왼쪽 오른쪽 자식 순서대로 탐색하면서 재귀적으로 insertNode 메서드 호출)
			if (current.left != null) {
				insertNode(current.left, root, left, right);
			}
			if (current.right != null) {
				insertNode(current.right, root, left, right);
			}
		}
	}
	// 전위순회 : 부모 -> 왼쪽 -> 오른쪽
	public static void pre(Node node) {
		if (node == null)
			return;
		sb.append(node.data);
		pre(node.left); // 왼쪽 자식 재귀
		pre(node.right); // 오른쪽 자식 재귀
	}
	// 중위 순회 (Inorder): 왼쪽 -> 부모 -> 오른쪽
	public static void in(Node node) {
		if (node == null)
			return;
		in(node.left); // 왼쪽 자식 재귀 호출
		sb.append(node.data); // 현재 노드 출력
		in(node.right); // 오른쪽 자식 재귀 호출
	}
	// 후위 순회 (Postorder): 왼쪽 -> 오른쪽 -> 부모
	public static void post(Node node) {
		if (node == null) return;
        post(node.left);          // 왼쪽 자식 재귀 호출
        post(node.right);         // 오른쪽 자식 재귀 호출
        sb.append(node.data);     // 현재 노드 출력
	}
}