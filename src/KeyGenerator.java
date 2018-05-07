import java.math.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.lang.*;
import java.io.*;

public class KeyGenerator
{
    String uid = "0001";
    String processname = "Key Generation";
    UpdateLog lg = new UpdateLog();

    private BigInteger q; // BigInteger q to hold the prime that is q
    private BigInteger p; // BigInteger p to hold the prime that is p
    public  BigInteger n; // BigInteger n to hold the value of p*q


    KeyGenerator()
    {
        p = GeneratePrime(); 				// Generate p
        System.out.println("Generated private key P with length: " + p.toString().length());

        q = GeneratePrime(); 				// Generate q
        System.out.println("Generated private key Q with length: " + q.toString().length());

        n = p.multiply(q);   				// Generate n
        System.out.println("Generated public key N with length: " + n.toString().length());

        CreatePublicKeyFile(n);		// Write to file
        CreatePrivateKeyFile(p, q);	// Write to file
    }


    private boolean Is3mod4(BigInteger prime)
    {
        String pid = "0101/0";
        try {
            lg.logit(uid, pid, processname);
        }catch(IOException ex)
        {
            System.out.println("File not found or does not exist!");
        }
        final BigInteger ZERO = new BigInteger("0");  // Constant BigInteger ZERO
        final BigInteger THREE = new BigInteger("3"); // Constant BigInteger THREE
        final BigInteger FOUR = new BigInteger("4");  // Constant BigInteger FOUR

        // To test for congruency, we must test if ((prime - 3) mod 4 = 0)
        pid = "0101/1";
        try {
            lg.logit(uid, pid, processname);
        }catch(IOException ex)
        {
            System.out.println("File not found or does not exist!");
        }
        if((((prime.subtract(THREE)).mod(FOUR)).equals(ZERO)))
        {
            return true;
        }
        return false;
    }


    private BigInteger GeneratePrime()
    {
        String pid = "0110/0";
        try {
            lg.logit(uid, pid, processname);
        }catch(IOException ex)
        {
            System.out.println("File not found or does not exist!");
        }

        final int LENGTH = 1024;                   	// Length of the key we want produced
        Random rnd = new Random();               	// Instantiate random number generator
        BigInteger prime = new BigInteger("13"); 	// The prime to be returned, starts at 13 to fail the initial congruency test

        // Loop while the generated primes are
        // NOT congruent to 3 mod 4
        while(!(Is3mod4(prime)))
        {
            StringBuilder sb = new StringBuilder(LENGTH); // Generate a string builder of fixed length LENGTH

            // For each digit in the speciffied length we want to generate
            // a random digit and append it
            for(int i = 0; i < LENGTH; i++)
            {
                // On the first digit, if we generate a zero, our key will be of [LENGTH - 1] length
                // which isn't what we want
                if(i == 0)
                {
                    sb.append((char)('0' + (rnd.nextInt(9) + 1)));
                }
                // We can have a zero for digit indices 1 - [LENGTH - 1]
                else
                {
                    sb.append((char)('0' + (rnd.nextInt(10))));
                }
            }

            String number = sb.toString();  // Generate a string and convert the sb to a string
            prime = new BigInteger(number); // Invoke BigInteger constructor for making a BigInteger from a string

            // Find the next prime AFTER the BigInteger we've created
            prime = prime.nextProbablePrime();
        }
        pid = "0110/1";
        try {
            lg.logit(uid, pid, processname);
        }catch(IOException ex)
        {
            System.out.println("File not found or does not exist!");
        }
        // Return the prime for testing at the beginning of the loop
        return prime;
    }


    public void CreatePublicKeyFile(BigInteger n)
    {
        String pid = "0111/0";
        try {
            lg.logit(uid, pid, processname);
        }catch(IOException ex)
        {
            System.out.println("File not found or does not exist!");
        }
        // Try to create a new file and write the results to it
        try
        {
            File outFile = new File("Public.txt");         // File to be written to
            PrintWriter writer = new PrintWriter(outFile); // Instantiate PrinterWriter so we can write to the file
            writer.println(n);
            writer.close();
            // This can fail, but shouldn't due to manually creating the file
            // Having this catch keeps the compiler happy
            pid = "0111/1";
            try {
                lg.logit(uid, pid, processname);
            }catch(IOException ex)
            {
                System.out.println("File not found or does not exist!");
            }
        } catch(FileNotFoundException e)
        {
            System.out.println("File not found or error creating file!");
        }
    }


    public void CreatePrivateKeyFile(BigInteger p, BigInteger q)
    {
         String pid = "0111/0";
        try {
            lg.logit(uid, pid, processname);
        }catch(IOException ex)
        {
            System.out.println("File not found or does not exist!");
        }
        // Try to create a new file and write the results to it
        try
        {
            File outFile = new File("Private.txt");        // File to be written to
            PrintWriter writer = new PrintWriter(outFile); // Instantiate PrintWriter so we can write to the file
            writer.println(p);
            writer.println(q);
            writer.close();
            // This can fail, but shouldn't due to manually creating the file
            // Having this catch keeps the compiler happy
            pid = "0111/1";
            try {
                lg.logit(uid, pid, processname);
            }catch(IOException ex)
            {
                System.out.println("File not found or does not exist!");
            }
        } catch(FileNotFoundException e)
        {
            System.out.println("File not found or error creating file!");
        }
    }


    /*public static void main(String args[])
    {
        KeyGenerator generateKeys = new KeyGenerator();
    }*/

}