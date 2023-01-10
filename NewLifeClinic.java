import java.io.*;
public class NewLifeClinic
{
    //Data Members
    BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
    int SrNo[]={1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};
    String nameStore[]=new String[9];
    String name[]=new String[20];
    String doctorStore[]=new String[9];
    String doctor[]=new String[20];
    String qualStore[]=new String[9];
    String qual[]=new String[20];
    String phoneStore[]=new String[9];
    String phone[]=new String[20];
    double revenueStore[]=new double[9];
    double revenue[]=new double[20];
    double totalStore[]=new double[9];
    double total[]=new double[20];
    int surgeryStore[]=new int[9];
    int surgery[]=new int[20];
    int salary;
    int n;
    int choice;
    int check;
    boolean work;
    double rev;
    double tot;
    //Constructor for pre-initialised list
    NewLifeClinic()
    {
        choice=0;
        salary=30000;
        n=9;
        check=0;
        work=true;
        double rev=0,tot=0;
        nameStore=new String[]{"Dr.Arvind Kulkarni","Dr.Rajveer Singh","Dr.Syeda Mubashira","Dr.Vikas Dwivedi","Dr.Umachandran","Dr.Ramprasad","Dr.Vishal Gupta","Dr.Rohit Singh"
        ,"Dr.Virat Sharma"};
        doctorStore=new String[]{"Immunologist","Cardiologist","Dermatologist","Physician","Hematologist","Neurologist","Gynecologist","Pathologist","Pediatrician"};
        qualStore=new String[]{"MBBS","MD","BDS","BHMS","BAMS","BP","DP","BTO","BSPharm","BSN"};
        phoneStore=new String[]{"9413107117","9865640831","8999827218","7299380137","9000146346","8336682324","7197981975","8517106315","9282125345"};
        surgeryStore=new int[]{4,16,17,13,7,8,3,5,14};
        revenueStore=new double[]{1500,6000,6000,4500,3000,3000,1500,1500,4500};
        totalStore=new double[]
        {31500,36000,36000,34500,33000,33000,31500,31500,34500};
    }
    //To store the pre-initialised list into main arrays
    void bind()
    {
        for(int a=0;a<9;a++)
        {
            name[a]=nameStore[a];
            doctor[a]=doctorStore[a];
            qual[a]=qualStore[a];
            phone[a]=phoneStore[a];
            surgery[a]=surgeryStore[a];
            revenue[a]=revenueStore[a];
            total[a]=totalStore[a];
        }
    }
    //menu() displays the root options of the program
    public void menu()throws IOException
    {
        do
        {
            System.out.println("1.To Enter Doctor's Details");
            System.out.println("2.To Display Doctor's List in Ascending Order of theirSalary");
            System.out.println("3.To Display Doctor's List in Alphabetical Order of their Names");
            System.out.println("4.To Display Maximum and Minimum Salaries");
            System.out.println("5.To Search for the Salary of a Doctor by Entering their Name");
            System.out.println("6.To Exit the Program");
            System.out.println();
            System.out.println("Enter Your Choice");
            try
            {
                this.choice=Integer.parseInt(buff.readLine());
                work=true;
            }
            catch(Exception e)
            {
                System.out.print('\u000c');
                System.out.println("Please Enter in Number Format Only");
                work=false;
            }
            if (choice>6||choice==0)
            {
                System.out.print('\u000c');
                System.out.println("Enter Your Choice Within The Limits of this Menu");
                work=false;
            }
        }
        while(!work);
    }
    //To accept the details of doctors
    void getData()throws IOException
    {
        for (int a=9;a<20;a++,n++)
        {
            System.out.print('\u000c');
            System.out.println("Enter Doctor's Name");
            name[a]=buff.readLine();
            System.out.print('\u000c');
            System.out.println("Enter the Field of Speciality");
            do
            {
                for(int b=0;b<9;b++)
                {
                    System.out.println(SrNo[b]+"."+doctor[b]);
                }
                System.out.println("Enter Your Choice");
                try
                {
                    choice=Integer.parseInt(buff.readLine());
                    if (choice>9||choice==0)
                    {
                        System.out.print('\u000c');
                        work=false;
                        System.out.println("Enter Within the Limits of The Menu");
                    }
                    else
                        work=true;
                }
                catch (Exception e)
                {
                    System.out.print('\u000c');
                    work=false;
                    System.out.println("Enter in Number Format Only");
                }
            }
            while (!work);
            doctor[a]=doctor[choice-1];
            System.out.print('\u000c');
            System.out.println("Enter Qualifications");
            do
            {
                for(int b=0;b<9;b++)
                {
                    System.out.println(SrNo[b]+"."+qual[b]);
                }
                System.out.println("Enter Your Choice");
                try
                {
                    choice=Integer.parseInt(buff.readLine());
                    if (choice>9)
                    {
                        System.out.print('\u000c');
                        work=false;
                        System.out.println("Enter Within the Limits of The Menu");
                    }
                    else
                        work=true;
                }
                catch (Exception e)
                {
                    System.out.print('\u000c');
                    work=false;
                    System.out.println("Enter in Number Format Only");
                }
            }
            while (!work);
            qual[a]=qual[choice-1];
            System.out.print('\u000c');
            System.out.println("Enter Phone Number");
            do
            {
                phone[a]=buff.readLine();
                if (phone[a].length()==10&&phone[a].matches("[0-9]+"))
                    work=true;
                else
                {
                    work=false;
                    System.out.println("Enter 10 Digits Only");
                }
            }
            while(!work);
            System.out.print('\u000c');
            do
            {
                try
                {
                    System.out.println("Enter the Number of Surgeries Performed");
                    surgery[a]=Integer.parseInt(buff.readLine());
                    work=true;
                }
                catch (NumberFormatException e)
                {
                    System.out.print('\u000c');
                    System.out.println("Please Enter in Number Format Only");
                    work=false;
                }
            }
            while(!work);
            SalCal(surgery[a]);
            revenue[a]=rev;
            total[a]=tot;
            System.out.print('\u000c');
            char c;
            do
            {
                System.out.println("Would you like to Enter One More Entry?(y/n)");
                c=buff.readLine().charAt(0);
                if (c=='Y'||c=='y')
                {
                    work=true;
                    continue;
                }
                else if (c=='N'||c=='n')
                {
                    work=true;
                    System.out.println("Ok");
                    break;
                }
                else
                {
                    System.out.println("Wrong Choice");
                    work=false;
                }
            }
            while(!work);
            n++;
            if (c=='n'||c=='N')
                break;
        }
    }

    void SalCal(int n)
    {
        if (n<=5)
            rev=salary*0.05;
        if (n>5&&n<=10)
            rev=salary*0.1;
        if (n>10&&n<=15)
            rev=salary*0.15;
        if (n>15)
            rev=salary*0.2;
        tot=rev+salary;
    }
    //Sort Doctor's names in Ascending Order of Salary
    void SortAO()
    {
        int min,i,j;
        String Tname,Tdoctor,Tqual,Tphone;
        int Tsurgery;
        double Trevenue,Ttotal;
        for (i=0;i<n;i++)
        {
            min=i;
            for (j=i+1;j<n;j++)
            {
                if (total[j]<total[min])
                    min=j;
            }
            Ttotal=total[i];
            Tname=name[i];
            Tdoctor=doctor[i];
            Tqual=qual[i];
            Tphone=phone[i];
            Tsurgery=surgery[i];
            Trevenue=revenue[i];
            total[i]=total[min];
            name[i]=name[min];
            doctor[i]=doctor[min];
            qual[i]=qual[min];
            phone[i]=phone[min];
            surgery[i]=surgery[min];
            revenue[i]=revenue[min];
            total[min]=Ttotal;
            name[min]=Tname;
            doctor[min]=Tdoctor;
            qual[min]=Tqual;
            phone[min]=Tphone;
            surgery[min]=Tsurgery;
            revenue[min]=Trevenue;
        }
        if (choice==2)
        {
            System.out.println("Doctor's List in Ascending Order of their Salary:");
            System.out.println("SrNo\tName\t \t Department \t Qualification \tPhoneNo\t Salary");
            for (int a=0;a<n;a++)
            {
                System.out.format("%2d%24s%16s%16s%16s%16s",SrNo[a],name[a],doctor[a],qual
                    [a],phone[a],total[a]);
                System.out.println("");
            }
            System.out.println();
        }
    }
    //Arrange Doctor's Names in Lexicographical Order
    void Lexicographer()
    {
        int min,i,j;
        String Tname,Tdoctor,Tqual,Tphone;
        int Tsurgery;
        double Trevenue,Ttotal;
        for (i=0;i<n;i++)
        {
            min=i;
            for (j=i+1;j<n;j++)
            {
                if (name[j].compareTo(name[min])<0)
                    min=j;
            }
            Ttotal=total[i];
            Tname=name[i];
            Tdoctor=doctor[i];
            Tqual=qual[i];
            Tphone=phone[i];
            Tsurgery=surgery[i];
            Trevenue=revenue[i];
            total[i]=total[min];
            name[i]=name[min];
            doctor[i]=doctor[min];
            qual[i]=qual[min];
            phone[i]=phone[min];
            surgery[i]=surgery[min];
            revenue[i]=revenue[min];
            total[min]=Ttotal;
            name[min]=Tname;
            doctor[min]=Tdoctor;
            qual[min]=Tqual;
            phone[min]=Tphone;
            surgery[min]=Tsurgery;
            revenue[min]=Trevenue;
        }
        System.out.println("Doctor's List in Alphabetical Order of their Names");
        System.out.println("SrNo\tName\t \t Department Qualification \t PhoneNo\tSalary");
        for (int a=0;a<n;a++)
        {
            System.out.format("%2d%24s%16s%16s%16s%16s",SrNo[a],name[a],doctor[a],qual
                [a],phone[a],total[a]);
            System.out.println("");
        }
        System.out.println();
    }
    //Find the Maximum and Minimum Salary
    void MaxMin()
    {
        SortAO();
        System.out.println("Minimum Salary: ");
        System.out.println("");
        System.out.println("\tName\t \t Department Qualification \t PhoneNo\tSalary");
        System.out.format("%24s%16s%16s%16s%16s",name[0],doctor[0],qual[0],phone[0]
        ,total[0]);
        System.out.println();
        System.out.println("Maximum Salary: ");
        System.out.println("");
        System.out.println("\tName\t \t Department Qualification \t PhoneNo\tSalary");
        System.out.format("%24s%16s%16s%16s%16s",name[n-1],doctor[n-1],qual[n-1],phone[n-1],total[n-1]);
        System.out.println();System.out.println();
    }
    //Search the Salary of a Doctor by Accepting thier Name
    void Search() throws IOException
    {
        int flag=0;
        System.out.println("Enter the Doctor's Name to be Searched");
        String name1=buff.readLine();
        for (int a=0;a<n;a++)
        {
            if (name[a].equalsIgnoreCase(name1))
            {
                System.out.println("SrNo\tName\t \t Department Qualification \tPhoneNo\t Salary");
                System.out.format("%2d%24s%16s%16s%16s%16s",SrNo[a],name[a],doctor[a],qual[a],phone[a],total[a]);
                System.out.println("");System.out.println();
                flag=1;
                break;
            }
        }
        if (flag==0)
            System.out.println("The Doctor's Name was Not Found in the List");
    }
    //To return non static variable to static member
    public int getChoice()
    {
        return this.choice;
    }
    //Displays Thank You Screen
    void ThankYou()
    {
        System.out.print('\u000c');
        char health[]={'S','T','A','Y','H','E','A','L','T','H','Y'};
        char thank[]={'T','H','A','N','K',' ','Y','O','U'};
        for (int a=0;a<9;a++)
        {
            for (int b=0;b<=a; b++)
            {
                if (a==3)
                {
                    System.out.print(health[b]+" ");
                }
                else if (a==6)
                {
                    System.out.print(health[b+4]+" ");
                }
                else if (a==8)
                {
                    System.out.print(thank[b]+" ");
                }
                else
                {
                    System.out.print("* ");
                }
            }
            System.out.println();
        }
    }

    public static void main()throws IOException
    {
        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
        char c=0;
        NewLifeClinic dl=new NewLifeClinic();
        dl.bind();
        do{
            dl.menu();
            int choice=dl.getChoice();
            switch(choice)
            {
                case 1:
                    dl.getData();
                    break;
                case 2:
                    dl.SortAO();
                    break;
                case 3:
                    dl.Lexicographer();
                    break;
                case 4:
                    dl.MaxMin();
                    break;
                case 5:
                    dl.Search();
                    break;
                case 6:
                    dl.ThankYou();
                    break;
            }
            if (choice!=6)
            {
                boolean work=true;
                do
                {
                    System.out.println("Would You Like to see the Menu Again? (y/n)");
                    c=buff.readLine().charAt(0);
                    c=Character.toUpperCase(c);
                    if (c=='N')
                    {
                        dl.ThankYou();
                    }
                    if (c=='Y')
                        System.out.print('\u000c');
                    if (c!='Y'&&c!='N')
                    {
                        System.out.println("Enter y or n Only");
                        work=false;
                    }
                }
                while (!work);
            }
        }
        while (c=='Y');
    }
}