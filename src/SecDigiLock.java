import java.io.*;
import java.lang.*;
import java.util.*;

/**
 * Created by hp on 27-03-2018.
 */
public class SecDigiLock extends arr{
    public static void main(String args[]) throws IOException
    {
        SecDigiLock us = new SecDigiLock();
        System.out.println("Secure Digi Lock Appliction Prototype");
        Scanner inn = new Scanner( System.in );
        Register reg = new Register(us);
        Login lg = new Login(us);
        System.out.println("\tRegister1: 1\t\tLogin: 2");
        int ch = inn.nextInt();
        int k=0;
        switch(ch)
        {
            case 1: {
                reg.insertUser();
                break;
            }
            case 2: {
                if (lg.validateUser() == 0)
                    k = 1;
                break;
            }
            default: {
                k = 1;
                break;
            }
        }
        if(k!=1) {
            while (ch != 5) {
                System.out.println("\tFile Upload: 1\n\tFile Download: 2\n\tReceive Report: 3\n\tGive FeedBack: 4\n\tExit: 5");
                ch = inn.nextInt();
                KerberosTransmission kt = new KerberosTransmission();
                switch (ch) {
                    case 1: {
                        KeyGenerator generateKeys = new KeyGenerator();
                        Encrypt encryption = new Encrypt();
                        kt.transmissionfrom();
                        break;
                    }
                    case 2: {
                        kt.transmissionto();
                        Decrypt decryption = new Decrypt();
                        break;
                    }
                    case 3: {
                        ReportCreate rep = new ReportCreate();
                        rep.generate();
                        break;
                    }
                    case 4: {
                        Feedback f = new Feedback();
                        try {
                            f.receiver();

                        } catch (IOException e) {
                            System.out.println("Error in Receiving Feedback");
                        }
                        break;
                    }
                    case 5:
                        break;
                    default: {
                        k = 1;
                        break;
                    }
                }
            }
        }
        System.out.println("Application finished");
    }
}
