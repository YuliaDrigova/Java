package laba_1;
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class First 
{
	public static Vector <String> ReadLines (int Numline, int Countlines, String File) throws IOException
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
	
	public static Vector <String> Parser (String string)
	{
		Vector<String> lines = new Vector<String>();
		String buf[] = string.split(" - - ");
		lines.add(buf[0]);
		String buf1[] = buf[1].split(" \"");
		lines.add(buf1[0]);
		buf = buf1[1].split("\" ");
		lines.add(buf[0]);
		buf1 = buf[1].split(" ");
		lines.add(buf1[0]);
		lines.add(buf1[1]);
		return lines; 
	}


	
	public static StringElement StringAnalyzer(String line) throws ParseException
	{
		Vector<String> result = Parser(line);
		
		String IPAddress = result.elementAt(0);
		String dateTime = result.elementAt(1);
		SimpleDateFormat dateform = new SimpleDateFormat("[dd/MMM/yyyy:HH:mm:ss Z]", Locale.ENGLISH);
		Date date = dateform.parse(dateTime);
		String name = result.elementAt(2);
		int codeAnswer = Integer.valueOf(result.elementAt(3));
		int countBytes = Integer.valueOf(result.elementAt(4));
		return new StringElement(IPAddress, date, name, codeAnswer, countBytes);
	}
	
	public static void Output(String FileName, Vector <String> a) throws IOException
	{
		BufferedWriter writer = new BufferedWriter(new FileWriter(FileName));
		for(String s: a)
		{
			writer.write(s);
			writer.newLine();
			
		}
		writer.close();
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
			Vector<String> res = ReadLines(Numline, Countlines, File);
			if (res.size() != Countlines)
				throw new Exception();
			Vector <String> finalStrings = new Vector<String>();
			for(String s: res)
			{
				StringElement a = StringAnalyzer(s);
				finalStrings.add(a.GetString());
			}
		
			Output(args[3], finalStrings);
		}
		
		catch(IOException ex) {System.out.println("Something goes wrong1! Error!");}
		catch(ParseException ex) {System.out.println("Something goes wrong2! Error!");} 
		catch (Exception e) {System.out.println("Something goes wrong3! Error!");}
	}
}
