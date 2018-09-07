
import java.util.*;
import java.io.*;

import javax.swing.InputMap;


public class MirrorNode {

	/**
	 * @param args
	 */
	static Node root=null;
	static class Node{
		int data;
		Node left;
		Node right;
		Node(int val){
			data=val;
			left = null;
			right = null;
		}
	}
	
	public static void tree(String str[], Node node){
		int p=Integer.parseInt(str[0]);
		int c=Integer.parseInt(str[1]);
		char k= str[2].charAt(0);
		if(node == null){
			Node temp= new Node(p);
			Node temp1=new Node(c);
			if(k=='L')
				temp.left=temp1;
			if(k=='R')
				temp.right=temp1;
			
			root = temp;
		}
		else{
			Node temp = search(p,root);
			Node temp1= new Node(c);
			//System.out.print(temp.data);
			if(k=='L')
				temp.left=temp1;
			if(k=='R')
				temp.right=temp1;
			
		}
		
		
	}
	
	public static Node search(int data,Node node){
		Node temp=null;
		if(node == null)
			return null;
		if(node.data == data)
			return node;
		
		temp=search(data, node.left);
		if(temp==null){
			temp=search(data, node.right);
		}
		return temp;
	}
	
	public static int mirrorSearch(Node left_node, Node right_node, int data){
		if(left_node == null || right_node == null)
			return -1;
		
		if(left_node.data == data)
			return right_node.data;
		else if(right_node.data == data)
			return left_node.data;
		int val =-5;
		val=mirrorSearch(left_node.left, right_node.right, data);
		if(val >0)
			return val;
		return mirrorSearch(left_node.right, right_node.left, data);
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str[] = br.readLine().split(" ");
		int n = Integer.parseInt(str[0]);
		int k = Integer.parseInt(str[1]);
		
		MirrorNode mn= new MirrorNode();
		
		for(int i=0; i<n-1; i++ ){
			str = br.readLine().split(" ");
			tree(str, root);
		}
		//System.out.println(root.data);
		for(int i=0;i<k;i++){
			int target = Integer.parseInt(br.readLine());
			
			int ans = mirrorSearch(root.left, root.right, target);
			System.out.println(ans);
		}

	}

}
