import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;



public class BinarySearchToBST {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws NumberFormatException 
	 */
	Node root;
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
	
	public Node levelOrder(int []arr, Node root, int k){
		
		if(k<arr.length){
			Node temp=new Node(arr[k]);
			root = temp;
			root.left= levelOrder(arr, root.left, 2*k+1);
			root.right= levelOrder(arr, root.right, 2*k+2);
			
		}
		return root;
	}
	
	public ArrayList<Integer> inorder (ArrayList<Integer> ar, Node root){
		if(root != null){
			inorder(ar, root.left);
			ar.add(root.data);
			inorder(ar, root.right);
		}
		return ar;
	}
	
	public int minSwap(int [] ar1){
		int N = ar1.length;
		Map<Integer,Integer> m =new HashMap<Integer, Integer>();
		for(int i=0;i<N;i++){
			m.put(ar1[i], i);
		}
		
		Arrays.sort(ar1);
		
		for(int i=0;i<N;i++){
			ar1[i]=m.get(ar1[i]);
		}
		m=null;
		int swaps=0;
		for(int i=0; i<N; i++){
			int val=ar1[i];
			if(val<0)
				continue;
			while (val != i) {
                int new_val = ar1[val];
                ar1[val] = -1;
                val = new_val;
                swaps++;
            }
            ar1[i] = -1;
		}
		return swaps;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt( br.readLine() );
		String s[]=br.readLine().split(" ");
		int arr[] = new int[N];
		for(int i=0;i<N;i++){
			arr[i]=Integer.parseInt(s[i]);
		}
		
		BinarySearchToBST bs = new BinarySearchToBST();
		bs.root = bs.levelOrder(arr, bs.root, 0);
		
		ArrayList<Integer> ar= new ArrayList<Integer>();
		
		bs.inorder(ar, bs.root);
		
		int ar1[] = new int[N];
		
		for(int i=0;i<ar.size();i++){
			ar1[i] = ar.get(i);
		}
		
		int swap=bs.minSwap(ar1);
		
		System.out.print(swap);
	}

}
