import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


public class OptimalBinarySearch 
{
	
	public static void main(String[] args) 
	{
		int n = 0;		
		FileReader fileReader;		
		ArrayList<String> array = new ArrayList<String>(); 
		
		//Try and catch method to read a file line by line using FileReader and BufferedReader.
		try
		{
			
			String input = "input.txt";		//Name of the file to open.
			
			String line = null;			//This will reference one line at a time.
			
			 // FileReader reads text files in the default encoding.
			fileReader = new FileReader(input);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			boolean flag = false;
			while ((line = bufferedReader.readLine()) != null) 
			{
				if (!flag) 
				{
					n = Integer.parseInt(line);
					flag = true;
				} 
				else
				{					
					array.add(line);
				}
			}
			bufferedReader.close();
		} 
		catch (Exception exception) 
		{
			exception.printStackTrace();
		}
		
		// Optimal Binary Search Tree - Algorithm
		int[] p = new int[n];				
		
		int[][] s = new int[n+1][n+1];	//Dynamic Programming Values
		
		String[][]	r = new String[n+1][n+1];  //Dynamic Programming Roots
				

		for (int i = 0; i < n; i++)
		{
			p[i] = Integer.parseInt(array.get(i));
			
		}
		for (int i = 1; i < n+1; i++)
		{
			s[i][i - 1] = 0;
		}
		for (int i = 0; i < n; i++) 
		{
			s[i][i + 1] = p[i];
			r[i][i + 1] = Integer.toString(i);		
		}

		for (int d = 0; d < n; d++) 
		{
			for (int i = 1; i <= (n - d); i++) 
			{
				int j = i + d;
				int sum_p = 0;
				double inf = Double.POSITIVE_INFINITY; //Representing Infinity.
				double min_value = inf;
				String min_root = "";
				for (int k = i; k <= j; k++) 
				{
					sum_p = sum_p + p[k - 1];
					int value = s[i - 1][k - 1] + s[k][j];
					if (value < min_value) 
					{
						min_value = value;
						min_root = Integer.toString(k);
					}
				}
				Double z = new Double(min_value); //Converting min_value which is double
				int min_valuei = z.intValue();		// to integer.
				s[i - 1][j] = sum_p + min_valuei;
				r[i - 1][j] = min_root;
			}
		}

		FileWriter fileWriter;
		try
		{
			fileWriter = new FileWriter("vk0018.txt");
			

			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

			bufferedWriter.write("**********\\Dynamic Programming Values Table//**********\n\n");
		
			bufferedWriter.write("-"+"\t");
			for(int i=0;i<=n;i++)
			{
				bufferedWriter.write(String.format("%6s",Integer.toString(i)));
				
				
			}
			bufferedWriter.write("\n	");
			for(int i=0;i<=n;i++)
			{ 
				bufferedWriter.write("   "+"---");
			}
			bufferedWriter.write("\n\n");
			for (int i = 0; i < n+1; i++) 
			{
				bufferedWriter.write(Integer.toString(i+1)+"\t");
				for (int j = 0; j < n+1; j++)
				{
					bufferedWriter.write(String.format("%6s",Integer.toString(s[i][j])));
				}
				bufferedWriter.newLine();
			}
			
			
			bufferedWriter.write("\n\n**********\\Dynamic Programming Roots Table//**********\n\n ");
			
			bufferedWriter.write("-"+"\t");
			for(int i=0;i<=n;i++)
			{
				bufferedWriter.write(String.format("%6s",Integer.toString(i)));
			}
			bufferedWriter.write("\n\t ");
			for(int i=0; i<=n; i++)
			{
				bufferedWriter.write("  ----");
			}
			bufferedWriter.write("\n\n");
			for (int i = 0; i < n+1; i++)
			{
				bufferedWriter.write(Integer.toString(i+1)+"\t");
				for (int j = 0; j < n+1; j++) 
				{
					if(r[i][j] == null)
					{
						r[i][j] = "0";
					}
					bufferedWriter.write(String.format("%6s",r[i][j].toString()));
				}
				bufferedWriter.newLine();
			}
			bufferedWriter.newLine();
			bufferedWriter.write("Optimal BSTree ");
			bufferedWriter.newLine();
			String B[][]=new String[n+2][n+1];
			for(int i=0;i<B[0].length;i++)
			{
				B[0][i]="0";
			}
			for(int i=1;i<B.length;i++)
			{
				for(int j=0;j<B[0].length;j++)
				{
					B[i][j]=r[i-1][j];
				}
			}
			PrintingTree(B,1,n,0,bufferedWriter);	
			
			bufferedWriter.close();
	
			System.out.println("A text file(vk0018.txt) is generated!!!");
		} 
		catch (IOException exception1) 
		{
			exception1.printStackTrace();
		}
		
	}
	
	public static void PrintingTree(String roots[][],int i,int j,int space_needed,BufferedWriter bufferedWriter) throws IOException
	{
		
		    if(i <= j)
		    {
		    	for(int a=0;a<=space_needed;a++)
		    	{
		    		bufferedWriter.write("   ");
		    	}
		    	bufferedWriter.write(roots[i][j]+"\n");
		    	
		    	PrintingTree(roots, i, Integer.parseInt(roots[i][j]) - 1,space_needed+1,bufferedWriter);
		        
		    	PrintingTree(roots, Integer.parseInt(roots[i][j]) + 1, j,space_needed+1,bufferedWriter);
		    }
		    else
		    {
		    	for(int b=0;b<=space_needed;b++)
		    	{
		    		bufferedWriter.write("   ");
		    	}
		    	bufferedWriter.write("-"+"\n");
		    }
		    
	}
	
	
}
