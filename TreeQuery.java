import java.util.*;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.OutputStreamWriter;
import java.math.*;


public class TreeQuery {

	/**
	 * @param args
	 */
	Node root;
	static class Node{
		int data;
		Node left;
		Node right;
		
		Node(int data){
			this.data = data;
			left = null;
			right = null;
		}
	}
	
	Node tree(Node node, int arr[], int i){
		if(i< arr.length){
			Node temp=new Node(arr[i]);
			temp.left = tree(temp.left, arr, 2*i+1);
			temp.right = tree(temp.right, arr, 2*i+2);
			node = temp;
		}
		return node;
	}
	public static int getElement(int[] ar, int ind) {
        int ret = 0;
        ret = ar[ind];
        return ret;
    }
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter log = new BufferedWriter(new OutputStreamWriter(System.out));
		String str[] = br.readLine().split(" ");
		int n = Integer.parseInt(str[0]);
		int q = Integer.parseInt(str[1]);
		
		str = br.readLine().split(" ");
		int arr[] = new int [n+1];
		for(int i=0;i<n;i++){
			arr[i+1] = Integer.parseInt(str[i]);
		}
		
		TreeQuery tq = new TreeQuery();
		
		tq.root = tq.tree(tq.root, arr, 0);
		//System.out.print(tq.root.data);
		
		ArrayList<Long> levelSum = new ArrayList<Long>();
		ArrayList<Long> ans = new ArrayList<Long>();
		
		//System.out.println(label+"label");
		
		int level = 0;
        long sum = 0;
        for(int i=1; i<arr.length; i++) {
            if( i == ( (int)( Math.pow(2,level) ) ) ) {
                levelSum.add(sum);  //previous level populate sum
                sum = 0;
                level++;
            }
            sum = sum + arr[i];
        }
        levelSum.add(sum);
		
		for (int i=0;i<q;i++){
			str = br.readLine().split(" ");
			
			int l = Integer.parseInt(str[0]);
			if(l==1){
				int x = Integer.parseInt(str[1]);
                int level1 = Integer.parseInt(str[2]);
                long tmp = getElement(arr, ( (int)(Math.pow(2,level1-1) ) ) + x -1 );
                ans.add(tmp);
				
			}
			else if(l==2){
				int l1 = Integer.parseInt(str[1]);
                int r = Integer.parseInt(str[2]);
                
                long tmp = 0L;
                for(int j=l1; j<=r; j++) {
                    tmp = tmp + levelSum.get(j).intValue();
                }
				ans.add(tmp);
			}
			else{
				int x = Integer.parseInt(str[1]);
                int level1 = Integer.parseInt(str[2]);
                int newVal = Integer.parseInt(str[3]);
                int ind = ( (int)(Math.pow(2,level1-1) ) ) + x -1;
                int diff = newVal - arr[ind];
                arr[ind] = newVal;
                long temp = levelSum.get(level1).intValue();
                levelSum.set(level1,temp+diff);
			}
		}
		for(int i=0; i<ans.size(); i++) {
            log.write(ans.get(i).toString()+"\n");
        }
		log.flush();
		br.close();
		log.close();

	}

}
