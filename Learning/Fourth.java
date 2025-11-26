//TODO: String Methods

public class Fourth {
    public static void main(String[] args) 
    {
        
/*
* Non-primitive/Reference data types = String, Arrays, Classes, Interface
*/

//! Strings

String name = "Mikky";
String nickname = "Mikky";
String fullname = " Yuvraj Sarathe ";
System.out.println("My name is " + name);
System.out.println(name.length()); //& length() method is used to get the length of the string
System.out.println(name.toUpperCase());

String address = "Locate the New York City on the world map.";
System.out.println(address.indexOf("locate"));

System.out.println(name.charAt(3));

if(name.equals(nickname))
{
    System.out.println("Names are equal");
}

System.out.println("Before: [" + fullname + "]");
System.out.println("After:  [" + fullname.trim() + "]");

System.out.println(name.concat(fullname));

String txt = "We are the so called \"Vikings\" from the north.";
System.out.println(txt);

String txt3 = "Hello\rWorld!";
System.out.println(txt3); //& \r is used to move the cursor to the beginning of the line

String txt4 = "Hello\fWorld!";
System.out.println(txt4); //& \f is used to form a page break


String txt5 = "Hello \\ World!";
System.out.println(txt5); //& \ is used to escape a character

    }
}
