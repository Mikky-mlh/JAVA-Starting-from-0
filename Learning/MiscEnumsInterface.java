//TODO: Enums & Interface

//~ ENUMS (Enumerations)
//& An enum is a special "class" that represents a group of constants (unchangeable variables, like final variables).
enum Level {
    
    LOW(1),
    MEDIUM(2),
    HIGH(3);

    private final int levelCode;

    private Level(int levelCode) {
        this.levelCode = levelCode;
    }

    public int getLevelCode() {
        return this.levelCode;
    }

    public String getHint() {
        switch (this) {
            case LOW:
                return "Easy peasy.";
            case MEDIUM:
                return "Getting tricky.";
            case HIGH:
                return "Expert mode!";
            default:
                return "Unknown level.";
        }
    }
}

//~ INTERFACES
//& An interface is a completely "abstract class" that is used to group related methods with empty bodies.

//& It defines a "contract" or a "blueprint" for behavior. Any class that implements an interface

interface Loggable {

    void log(String message);


    default void logInfo(String message) {
        log("INFO: " + message);
    }
    
    static String getLoggerType() {
        return "Generic Logger Interface";
    }
}

//* This class "signs the contract" to be Loggable.
class ConsoleLogger implements Loggable {

    @Override
    public void log(String message) {
        System.out.println("[CONSOLE] " + message);
    }
}

//* This class also "signs the contract" and provides a different implementation.
class FileLogger implements Loggable {
    @Override
    public void log(String message) {
        // In a real app, this would write to a file.
        System.out.println("'{ " + message + " }' -> written to log.txt");
    }

    //& This class chooses to override the default method for custom behavior.
    @Override
    public void logInfo(String message) {
        log("INFORMATION: " + message.toUpperCase());
    }
}

public class MiscEnumsInterface{

    public static void main(String[] args) {
        Level difficulty = Level.MEDIUM;

        System.out.println("Selected difficulty: " + difficulty); 
        System.out.println("Difficulty level code: " + difficulty.getLevelCode()); 
        System.out.println("Hint: " + difficulty.getHint()); 

        System.out.println("\n--- INTERFACES DEMONSTRATION ---");
        Loggable console = new ConsoleLogger(); 
        Loggable file = new FileLogger();       

        console.log("System startup complete."); 
        file.log("User logged in.");            

        console.logInfo("This is an informational message."); 
        file.logInfo("This is another informational message."); 

        //& Static methods are called on the interface itself.
        System.out.println("Logger type: " + Loggable.getLoggerType());
    }
}