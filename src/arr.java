import java.lang.*;
import java.text.SimpleDateFormat;


public class arr
{
    String id[] = new String[10];
    private int psw[] = new int[10];
    String mail[] = new String[10];
    String name[] = new String[10];
    int count=1;
    String ts;
    arr()
    {
        name[0]="avi";
        id[0]= "0001";
        psw[0] = 34;
    }
    public int getpassword(int i)
    {
        int ps = psw[i];
        return ps;
    }
    public void givepassword(int ps)
    {
        psw[count] = ps;
    }

}