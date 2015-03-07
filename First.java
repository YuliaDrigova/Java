package laba_1;
import java.io.*;
import java.util.*;

public class First 
{
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
	
	public static void main(String[] args) throws IOException
	{
	
		try 
		{
			int Numline = Integer.valueOf(args[0]);
			int Countlines = Integer.valueOf(args[1]);
			String File = args[2];
			if (Numline < 0 || Countlines < 0)
				throw new Exception();
			Vector<String> res = fun(Numline, Countlines, File);
			if (res.size() != Countlines)
				throw new Exception();
		
			Vector <String>	output = new Vector<String>();
			Vector <String> lines = new Vector<String>();

				for(String l:res)
				{
					String buf[] = l.split(" - - ");
					lines.add(buf[0]);
					String buf1[] = buf[1].split(" \"");
					lines.add(buf1[0]);
					buf = buf1[1].split("\" ");
					lines.add(buf[0]);
					buf1 = buf[1].split(" ");
					lines.add(buf1[0]);
					lines.add(buf1[1]);

					String_element result = new String_element(lines);

					output.add(result.GetString());
					lines.clear();
				}

			BufferedWriter writer = new BufferedWriter(new FileWriter (args[3]));

			for (String v:output)
			{
				writer.write(v);
				writer.newLine();
			}
			writer.close();
		}
		
		catch(Exception ex) {System.out.println("Something goes wrong! Error!");}
		
	}
}
