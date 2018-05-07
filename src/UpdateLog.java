/**
 * Created by hp on 25-03-2018.
 */
import java.lang.*;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UpdateLog {
    public void logit(String uid, String processId, String processName) throws IOException {
        String inFile = "Log.txt";
        FileWriter fileWriter = new FileWriter(inFile, true);
        PrintWriter printWriter = new PrintWriter(fileWriter);
        String time = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
        printWriter.printf("("+ uid +"/"+ processId +"/"+ processName + "/"+ time + ")//");
        printWriter.close();
    }
}
