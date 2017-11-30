package Utils;

public class PrintMessage {
	public static void printHelpOptions() {
        System.out.println();
        System.out.println("Welcome to the Gift Exchange Program");
        System.out.println("====================================");
        System.out.println("-p flag: Provide the problem no with the subpart as an argument to run the program you wish to run ");
        System.out.println("-f flag: Provide the corresponding file path for all the files needed for the problem ");
        System.out.println();
        System.out.println("Example:");
        System.out.println("------------------------------------------");
        System.out.println("java -jar Spatial.jar -p 2.2 -f \"family.csv\"");
        System.out.println("------------------------------------------");
        System.out.println("Will run the problem no 2 with task no 2");
        System.out.println("family.csv is the file needed to compute this function");
        System.out.println();
        System.out.println("----------------------------------------------");
        System.out.println("Sample inputs for all different valid problems");
        System.out.println("----------------------------------------------");
        System.out.println("java -jar Spatial.jar -p 1.2 -f \"family.csv\"");
        System.out.println("java -jar Spatial.jar -p 2.2 -f \"family.csv\"");
        System.out.println("java -jar Spatial.jar -p 3.2 -f \"family.csv\"");
        System.out.println("java -jar Spatial.jar -p 4.2 -f \"family.csv\" \"last_years_pairs.csv\"");
        System.out.println("java -jar Spatial.jar -p 5.2 -f \"family.csv\" \"last_years_pairs.csv\" \"good_list.csv\" \"bad_list.csv\"");
        System.out.println("java -jar Spatial.jar -p 6.2 -f \"family.csv\" \"last_years_pairs.csv\" \"good_list.csv\" \"bad_list.csv\"");
    }

    public static void printFailedToExecute() {
        System.out.println("Failed to execute. Exiting...");
    }

    public static void printNotAValidProblemNo() {
        System.out.println("Not a valid Problem number");
    }

    public static void printNotAValidTaskNo() {
        System.out.println("Not a valid Task number");
    }

    public static void printNoProblemNo() {
        System.out.println("Did not provide a valid Problem no");
    }

    public static void printNoFilename() {
        System.out.println("Did not provide a valid Filename");
    }

    public static void printInvalidFilePathGiven() {
        System.out.println("Invalid File Path");
    }

    public static void printInvalidFileTypeInput() {
        System.out.println("The File contains InvalidInput");
    }

    public static void printInvalidPairStatus() {
        System.out.println("The given pairs DO NOT follow the given rules");
    }

    public static void printValidPairStatus() {
        System.out.println("The given pairs DO follow the given rules");
    }
}

