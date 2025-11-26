//TODO: Making a madlibs game in JAVA


import java.util.Scanner;

public  class MadLibs 
{
    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);
        String story = "Last night, I went to a ";

        System.out.print(story);
        System.out.print("(Enter 1st adjective)");
        String adj1 = scanner.nextLine();
        story += adj1 + " bakery down the street. The baker was ";

        System.out.print("(\n" + story);
        System.out.print("(Enter a verb ending in -ing)");
        String verb1 = scanner.nextLine();
        story += verb1 + " his ";

        System.out.print("(\n" + story);
        System.out.print("(Enter a thing/item)");
        String item1 = scanner.nextLine();
        story += item1 + " so hard that ";

        System.out.print("(\n" + story);
        System.out.print("(Enter a liquid)");
        String liquid = scanner.nextLine();
        story += liquid + " started flying everywhere!\n\nI asked for something sweet, and he offered me his ";

        System.out.print("(\n" + story);
        System.out.print("(Enter a food item)");
        String foodItem = scanner.nextLine();
        story += foodItem + " — it was so ";

        System.out.print("(\n" + story);
        System.out.print("(Enter 2nd adjective)");
        String adj2 = scanner.nextLine();
        story += adj2 + " that I couldn't resist taking a big ";

        System.out.print("(\n" + story);
        System.out.print("(Enter a verb)");
        String verb2 = scanner.nextLine();
        story += verb2 + "!\n\nSuddenly, the lights went out! In the darkness, I felt something ";

        System.out.print("(\n" + story);
        System.out.print("(Enter an adjective)");
        String adj3 = scanner.nextLine();
        story += adj3 + " brush against my ";

        System.out.print("(\n" + story);
        System.out.print("(Enter a body part)");
        String bodyPart = scanner.nextLine();
        story += bodyPart + ".\n\nWhen the lights came back on, everyone was ";

        System.out.print("(\n" + story);
        System.out.print("(Enter a verb ending in -ing)");
        String verbEnding = scanner.nextLine();
        story += verbEnding + " and laughing.\n\nTurns out, it was just the baker's ";

        System.out.print("(\n" + story);
        System.out.print("(Enter an object)");
        String object = scanner.nextLine();
        story += object + " that slipped!\n\nBy the time I left, my ";

        System.out.print("(\n" + story);
        System.out.print("(Enter a clothing item)");
        String clothingItem = scanner.nextLine();
        story += clothingItem + " was completely covered in ";

        System.out.print("(\n" + story);
        System.out.print("(Enter a substance)");
        String substance = scanner.nextLine();
        story += substance + ", but honestly, it was the best ";

        System.out.print("(\n" + story);
        System.out.print("(Enter a noun)");
        String noun = scanner.nextLine();
        story += noun + " I've ever had.\n\nI can't wait to go back and ";

        System.out.print("(\n" + story);
        System.out.print("(Enter a verb)");
        String verb3 = scanner.nextLine();
        story += verb3 + " his buns again!";

        System.out.print("(\n\n=== COMPLETE STORY ===\n" + story);

        scanner.close();
    }
}
