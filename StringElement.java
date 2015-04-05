package laba_1;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Vector;

public class StringElement 
{
	String IPAddress;
	Date DateTime;
	String Name;
	int CodeAnswer;
	int CountBytes;
	
	public StringElement(String ipAddress, Date dataTime, String name, int codeAnswer, int countBytes)
	{
		
		IPAddress = ipAddress;
		DateTime = dataTime;
		Name = name;
		CodeAnswer = codeAnswer;
		CountBytes = countBytes;
	}

	
	public String GetString()
	{
		 SimpleDateFormat dateFormat = new SimpleDateFormat("[dd/MMM/yyyy:HH:mm:ss Z]", Locale.ENGLISH);
		  StringBuilder string = new StringBuilder();
		  	  
		  string.append(IPAddress + " - - " + dateFormat.format(DateTime) + " \"" + Name + "\" " + CodeAnswer + " " + CountBytes);
		  
		  return string.toString();
	}
}
