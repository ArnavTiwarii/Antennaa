import java.util.Arrays;
import java.util.Scanner;

//
///*create a class Antenna with below attributes.
//        antennaid=int
//        antennaName=String
//        projectLead=String
//        antennaVSWR=double
//
//        the above attribute should be private ,write getter and
//        setter and parametrized constructor as well.
//
//        create class MyClass with main method.
//        implement two static methods searchAntennaByName and sortAntennaByVSWR
//        in MyClass class.
//
//
//        searchAntennaByName :
//        This method will take an array of Antenna objects and the
//        string value as input parameter.The method will find out Antenna name(String parameter
//        passed) .it will return Antennaid if found.if there is no Antenna that matches then the
//        method will return zero.
//        the main method should print the antennaid,if the returned value is not 0.if the
//        returned value is 0 then print,"There is no antenna with the given parameter".
//
//
//        sortAntennaByVSWR:
//        This method will take an array of Antenna Objects and a double value as input.
//        this method will return an array of Antenna objects sorted in ascending orderof their
//        antennaVSWR. which is less than VSWR(double value passed)
//        the main method should print name of the project leads from the returned array
//        if the returned value is not null.if the returned value is null then main method should
//        print "No Antenna found";
//
//
//        input1:
//
//        111
//        Reconfigurable
//        Hema
//        0.4
//        222
//        Wearable
//        Kavya
//        0.9
//        333
//        Microstrip
//        Teju
//        0.3
//        444
//        Dielectric
//        Sai
//        0.65
//        Microstrip
//        0.5
//
//        output:
//        333
//        Teju
//        Hema
//
//
//        input 2:
//        111
//        Reconfigurable
//        Hema
//        0.3
//        222
//        Wearable
//        Kavya
//        0.9
//        333
//        Microstrip
//        Teju
//        0.4
//        444
//        Dielectric
//        Sai
//        0.65
//        Resonator
//        0.25
//
//        output:
//        There is no antenna with given parameter
//        No Antenna found
// */
public class Antenna {
    public static void main(String[] args)throws java.lang.Exception
    {
        Ante[] arr = new Ante[4];
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 4; i++)
        {
            int a = sc.nextInt();
            sc.nextLine();
            String b = sc.nextLine();
            String c = sc.nextLine();
            double d = sc.nextDouble();sc.nextLine();
            arr[i] = new Ante(a,b,c,d);
        }
        String inputantennaName = sc.nextLine();
        double inputantennaVSMR = sc.nextDouble();sc.nextLine();

        int sum=searchAntennaByName(arr,inputantennaName);
        if(sum==0)
        {
            System.out.println("No id");
        }
        else {
            System.out.println(sum);
        }


        Ante [] obj1 = sortAntennaByVSWR(arr,inputantennaVSMR);
        if(obj1==null)
        {
            System.out.println("NO Found");
        }
        else
        {
            for (int i = 0; i < obj1.length; i++)
            {
                System.out.println(obj1[i].projectLead);
            }
        }
    }

    public static int searchAntennaByName(Ante arr[],String input)
    {

        for (int i=0;i<arr.length;i++)
        {
            if((arr[i].antennaName).equalsIgnoreCase(input))
            {
                return arr[i].antennaid;
            }
        }
        return 0;
    }
    public static Ante[] sortAntennaByVSWR(Ante[] arr,double input2)
    {
        Ante ary[]=new Ante[0];
        for(int i =0;i<arr.length;i++)
        {
            if(arr[i].antennaVSWR <input2)
            {
                ary= Arrays.copyOf(ary,ary.length+1);
                ary[ary.length-1]=arr[i];
            }
        }
        //bubble sort
        for(int i=0;i<ary.length-1;i++)
        {
            for(int j=0;j<ary.length-i-1;j++)
            {
                if (ary[j].antennaVSWR>ary[j+1].antennaVSWR)
                {
                    Ante temp=ary[j];
                    ary[j]=ary[j+1];
                    ary[j+1]=temp;
                }
            }
        }
        if(ary.length==0) {
            return null;
        }
        else {
            return ary;
        }
    }

}
class Ante
{
     int antennaid;
     String antennaName;
     String projectLead;
     double antennaVSWR;
     public Ante( int antennaId,String antennaName,String projectLead, double antennaVSWR)
     {
        this.antennaid=antennaId;
        this.antennaName=antennaName;
        this.projectLead=projectLead;
        this.antennaVSWR=antennaVSWR;
     }
}
