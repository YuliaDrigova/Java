package laba_1;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Vector;

public class StringElement 
{
	Vector <Integer> IP;
	Vector <String> IPAddress;
	Date DateTime;
	String Name;
	int CodeAnswer;
	int CountBytes;
	
	public StringElement(Vector <Integer> ip, Vector <String> ipAddress, Date dataTime, String name, int codeAnswer, int countBytes)
	{
		IP = ip;
		IPAddress = ipAddress;
		DateTime = dataTime;
		Name = name;
		CodeAnswer = codeAnswer;
		CountBytes = countBytes;
	}
	
	public String GetStringOfIpAddress()
	{
		StringBuilder string = new StringBuilder();
		if (IP.size() == 0)
		{
			for(Integer i: IP)
			{
				string.append(i.toString() + ".");
			}
		}
		else
		{
			for(String i: IPAddress)
			{
				string.append(i + ".");
			}
		}
		return string.toString();
	}
	
	public String GetString()
	{
		 SimpleDateFormat dateFormat = new SimpleDateFormat("[dd/MMM/yyyy:HH:mm:ss Z]", Locale.ENGLISH);
		  StringBuilder string = new StringBuilder();
		  
		  string.append(GetStringOfIpAddress());
		  	  
		  string.append(" - - " + dateFormat.format(DateTime) + " \"" + Name + "\" " + CodeAnswer + " " + CountBytes);
		  
		  return string.toString();
	}
}
