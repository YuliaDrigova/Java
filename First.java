package laba_1;
import java.io.*;
import java.util.*;

public class First {
	public static Vector <String> fun (int Numline, int Countlines, String File) throws IOException
	{
		BufferedReader reader = new BufferedReader(new FileReader(File));
		Vector<String> result = new Vector<String>();
		
		int i = 0;
		while(i != Numline-1)
		{
			reader.readLine();
			i++;
		}
		
		int j = 0;
		while(j != Countlines)
		{
			j++;
			result.add(reader.readLine());
		}
		
		reader.close();
		return result;
	}
	public static void main(String[] args) throws IOException{
	try {
		int Numline = Integer.valueOf(args[0]);
		int Countlines = Integer.valueOf(args[1]);
		String File = args[2];
		 if (Numline < 0 || Countlines < 0)
			 throw new Exception();
		Vector<String> res = fun(Numline, Countlines, File);
		if (res.size() != Countlines)
			throw new Exception();
		
		for(String s:res)
		{
			if(s == null)
				throw new Exception();
			System.out.println(s);
		}
		}
		 catch(Exception ex) {System.out.println("Something goes wrong! Error!");}
		
	}
}
