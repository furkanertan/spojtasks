import java.util.*;
import java.io.*;
public class Main
{
    public static void main(String args [])	throws IOException
    {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw=new PrintWriter(System.out, true);
        int numberOfTests=Integer.parseInt(in.readLine());
        while(numberOfTests>0)
        {
            int numberOfAccounts=Integer.parseInt(in.readLine());
            Map<String,Integer> map=new HashMap<String,Integer>();
            List <String> accounts=new ArrayList<String>();
            String accountInfo="";
            for(int i=0; i<numberOfAccounts; i++)
            {
                accountInfo=in.readLine();
                if(map.containsKey(accountInfo))
                {
                    int accountCount=(int)map.get(accountInfo);
                    accountCount+=1;
                    map.put(accountInfo,accountCount);
                }
                else
                {
                    map.put(accountInfo,1);
                    accounts.add(accountInfo);
                }
            }
            Collections.sort(accounts);
            for(int j=0; j<accounts.size(); j++)
            {
                accountInfo=accounts.get(j);
                int repeatCount=map.get(accountInfo);
                System.out.println(accountInfo+" "+repeatCount);
            }
            in.readLine();
            System.out.println();
            numberOfTests--;
        }
    }
}