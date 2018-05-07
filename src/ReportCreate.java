import java.io.*;

/**
 * Created by hp on 29-03-2018.
 */
public class ReportCreate {
    public void generate() throws IOException
    {
        File source = new File("C:\\Users\\hp\\IdeaProjects\\Hybrid RSA client Side Encryption Sec Digi Lock\\log.txt");
        File dest = new File("C:\\Users\\hp\\IdeaProjects\\Hybrid RSA client Side Encryption Sec Digi Lock\\server\\Report.txt");

        InputStream is = null;
        OutputStream os = null;
        try {
            is = new FileInputStream(source);
            os = new FileOutputStream(dest);
            byte[] buffer = new byte[1024];
            int length;
            while ((length = is.read(buffer)) > 0) {
                os.write(buffer, 0, length);
            }
        } finally {
            is.close();
            os.close();
        }

    }
}
