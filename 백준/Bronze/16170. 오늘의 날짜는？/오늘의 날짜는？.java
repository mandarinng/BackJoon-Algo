import java.text.SimpleDateFormat;
import java.util.*;

public class Main {
	public static void main (String[] args) {
        
    	SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        String[] date = simpleDateFormat.format(Calendar.getInstance().getTime()).split("-");
        StringBuilder sb = new StringBuilder();
        sb.append(date[0]).append("\n");
        sb.append(date[1]).append("\n");
        sb.append(date[2]).append("\n");
        System.out.println(sb.toString());
    }
}