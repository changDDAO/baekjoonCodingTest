package silverOrLowGold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek1991 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Node root = new Node('A', null, null);
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char parent = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);
            insertNode(root, parent, left, right);
            //트리 생성하기
        }
        //Pre
        preOrder(root);
        System.out.println();
        //in
        inOrder(root);
        System.out.println();
        //post
        postOrder(root);



    }
    static class Node{
        char value;
        Node left;
        Node right;

        public Node(char value, Node left, Node right) {
            this.value = value;
            this.left = left;
            right = right;
        }
    }
    static void insertNode(Node parent, char root, char left, char right) {
        if (parent.value == root) {//찾았을 때
            parent.left = left == '.' ? null : new Node(left, null, null);
            parent.right = right == '.' ? null : new Node(right, null, null);
        } else {//모든 노드 탐색과정
            if (parent.left != null) insertNode(parent.left, root,left,right);
            if(parent.right != null) insertNode(parent.right, root, left, right);
        }
    }
    static void inOrder(Node parent) {
        if(parent==null)return;
        inOrder(parent.left);
        System.out.print(parent.value);
        inOrder(parent.right);
    }

    static void preOrder(Node parent) {
        if(parent==null) return;
        System.out.print(parent.value);
        preOrder(parent.left);
        preOrder(parent.right);
    }
    static void postOrder(Node parent) {
        if (parent == null) return;
        postOrder(parent.left);
        postOrder(parent.right);
        System.out.print(parent.value);
    }
}
