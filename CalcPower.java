import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

public class CalcPower {

	/**
	 * @param args
	 */
	static long e = 1000000007;
	
	static long power(long a, long b){
		long ans=1, y=a;
		
		while(b>0){
			if(b%2 == 1){
				ans=(y*ans)%e;
			}
			y=(y*y)%e;
			b=b/2;
			//System.out.print(ans+" "+b+" ");
		}
		return ans;
	}
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter log = new BufferedWriter(new OutputStreamWriter(System.out));
		String str[] = br.readLine().split(" ");
		
		long a = Long.parseLong(str[0]);
		long b = Long.parseLong(str[1]);
		long ans = power(a,b);
		
		log.write(ans+"\n");
		
		log.flush();
		br.close();
		log.close();
		
		
	}

}
