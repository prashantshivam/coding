import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.ArrayList;

public class Modulo {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter log = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n= Integer.parseInt(br.readLine());
		int arr[] = new int[n];
		
		for(int i=0;i<n;i++){
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(arr);
		int max = Integer.MAX_VALUE;
		
		for(int i=0;i<n-1;i++){
			int max1= arr[i+1]-arr[i];
			if(max1<max)
				max=max1;
		}
		
		ArrayList<Integer> al = new ArrayList<Integer>();
		
		for(int i=2;i<=max;i++){
			int flag=0;
			int rem=arr[0]%i;
			for(int j=1;j<n;j++){
				if(arr[j]%i != rem){
					flag=1;
					break;
				}
			}
			if(flag==0)
				al.add(i);
		}
		
		for(int i=0; i<al.size(); i++) {
            log.write(al.get(i).toString()+" ");
        }
		
		log.flush();
		log.close();
		br.close();
		
	}

}
