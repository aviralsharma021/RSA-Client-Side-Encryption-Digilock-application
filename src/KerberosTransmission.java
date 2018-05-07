/**
 * Created by hp on 25-03-2018.
 */
import java.math.*;
import java.util.*;
import java.lang.*;
import java.io.*;
import java.util.Calendar;
import java.text.SimpleDateFormat;


public class KerberosTransmission{
    String uid = "0001";
    String processname = "Transmission of File";
    UpdateLog lg = new UpdateLog();
    KerberosTransmission()
    {

    }

    // request access from Authentication server to access ticket provider
    public boolean accessGrant()
    {
        String pid = "1101/0";
        try {
            lg.logit(uid, pid, processname);
        }catch(IOException ex)
        {
            System.out.println("File not found or does not exist!");
        }
        return true;
    }
    public void RequestAccess()
    {
        String pid = "1100/0";
        try {
            lg.logit(uid, pid, processname);
        }catch(IOException ex)
        {
            System.out.println("File not found or does not exist!");
        }
        arr client = new arr();
        if(accessGrant());
        {
            System.out.println("request to access ticket provider granted");
            int seckey = (9 * client.getpassword(0) + 2) % 26;
            client.ts=new SimpleDateFormat("dd-MM-yyyy").format(new Date());
            System.out.println("("+seckey + " | " + client.id + " | "+ client.ts+ " | TTP)");
        }
    }
    public void ExtractTicket(){
        String pid = "1101/0";
        try {
            lg.logit(uid, pid, processname);
        }catch(IOException ex)
        {
            System.out.println("File not found or does not exist!");
        }

    }
    public void Extractcertificate(){
        String pid = "1101/0";
        try {
            lg.logit(uid, pid, processname);
        }catch(IOException ex)
        {
            System.out.println("File not found or does not exist!");
        }
    }
    private static void copyFile(File source, File dest) throws IOException {
        String pid = "1110/0";
        String uid = "0001";
        String processname = "Transmission of File";
        UpdateLog g = new UpdateLog();
        try {
            g.logit(uid, pid, processname);
        }catch(IOException ex)
        {
            System.out.println("File not found or does not exist!");
        }
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
    public void transmissionto() throws IOException
    {
        /*RequestAccess();
        ExtractTicket();
        Extractcertificate();
        String pid = "1111/0";
        try {
            lg.logit(uid, pid, processname);
        }catch(IOException ex)
        {
            System.out.println("File not found or does not exist!");
        }
        File source = new File("C:\\Users\\hp\\IdeaProjects\\Hybrid RSA client Side Encryption Sec Digi Lock\\server\\Encryptserv.txt");
        File dest = new File("C:\\Users\\hp\\IdeaProjects\\Hybrid RSA client Side Encryption Sec Digi Lock\\EncryptedDownload.txt");

        copyFile(source, dest);
        System.out.println("Successfully Transmitted The file Securely");
        */
    }
    public void transmissionfrom() throws IOException
    {
        RequestAccess();
        ExtractTicket();
        Extractcertificate();
        String pid = "1111/0";
        try {
            lg.logit(uid, pid, processname);
        }catch(IOException ex)
        {
            System.out.println("File not found or does not exist!");
        }
        File source = new File("C:\\Users\\hp\\IdeaProjects\\Hybrid RSA client Side Encryption Sec Digi Lock\\Encrypted.txt");
        File dest = new File("C:\\Users\\hp\\IdeaProjects\\Hybrid RSA client Side Encryption Sec Digi Lock\\server\\Encryptserv.txt");

        copyFile(source, dest);
        System.out.println("Successfully Transmitted The file Securely");
    }

    /*public static void main(String args[]) throws IOException
    {
        KerberosTransmission kt = new KerberosTransmission();
        kt.transmission();
    }*/

}
