public class Welcome {

    static String spaces = "";
    static String space1 = "";
    static String space2 = "";
    
    static void welcome()
    {
        for(int i=0; i<40; i++)
            spaces += " ";
        
        for(int i=0; i<17; i++)
            space1 += " ";
        
        for(int i=0; i<16; i++)
            space2 += " ";
        
        System.out.println("******************************************");

        for(int i=0; i<=4; i++)
        {
            if(i!=2){
                System.out.println("*" + spaces + "*");
            }
            else
            {
                System.out.println("*"+ space1 + "Welcome" + space2 + "*" );
            }


        }

        System.out.println("******************************************");

    }
}
