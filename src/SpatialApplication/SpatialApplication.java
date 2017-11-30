package SpatialApplication;

import Utils.FileReader;
import Utils.PrintMessage;

import java.nio.file.NoSuchFileException;
import java.util.ArrayList;

public class SpatialApplication {

    public static void main(String[] args) {
        if(args.length < 1) {
            System.out.println("Invalid Flag, use -h to see usage options");
            return;
        }
        switch(args[0]) {
            case "-h":
                PrintMessage.printHelpOptions();
                break;
            case "--help":
                PrintMessage.printHelpOptions();
                break;
            case "-p":
                String arguments;
                try {
                    arguments = args[1];
                } catch (NumberFormatException e) {
                    PrintMessage.printNotAValidProblemNo();
                    return;
                } catch (IndexOutOfBoundsException e) {
                    PrintMessage.printNoProblemNo();
                    PrintMessage.printFailedToExecute();
                    return;
                }
                int fileInputs = 0;
                try {
                    fileInputs = getNoOfFileInputs(arguments);
                } catch (Exception e) {
                    PrintMessage.printNotAValidProblemNo();
                    PrintMessage.printFailedToExecute();
                    return;
                }
                if(fileInputs == -1 || args.length != fileInputs+3) {
                    PrintMessage.printNoFilename();
                    PrintMessage.printFailedToExecute();
                    return;
                } else if( fileInputs+3 == args.length && args[2].equals("-f")) {
                    try {
                        String[] files = new String[fileInputs];
                        for ( int i = 0 ; i < fileInputs; i++)
                            files[i] = args[i+3];
                        executeProgramStatment(arguments,files);
                    } catch (NoSuchFileException f) {
                        PrintMessage.printInvalidFilePathGiven();
                        f.printStackTrace();
                        PrintMessage.printFailedToExecute();
                        return;
                    }
                    catch (Exception e) {
                        PrintMessage.printFailedToExecute();
                        e.printStackTrace();
                    }
                    System.out.println("----------------");
                    System.out.println("We are done here");
                } else {
                    System.out.println("Invalid Usage, use -h to see usage options");
                    return;
                }
                break;
            case "-f":
                System.out.println("please provide the problem No before providing the list of files." +
                        " Use '-h' or '--help' for usages options ");
                break;
            default:
                System.out.println("No valid flag used, use -h to see usage options");
                PrintMessage.printFailedToExecute();
        }
    }

    public static int getNoOfFileInputs(String value) throws Exception {
        int problemNo = Integer.parseInt(value.substring(0,value.indexOf('.')));
        int taskNo = Integer.parseInt(value.substring(value.indexOf('.')+1,value.length()));
        if( problemNo < 1 || problemNo > 6) {
            PrintMessage.printNotAValidProblemNo();
            return -1;
        }
        if(taskNo != 1 && taskNo != 2) {
            PrintMessage.printNotAValidTaskNo();
            return -1;
        }
        switch (problemNo) {
            case 1:
                if(taskNo == 1) {
                    return 1;
                } else if(taskNo == 2) {
                    return 1;
                }
            case 2:
                if(taskNo == 1) {
                    return 2;
                } else if(taskNo == 2) {
                    return 1;
                }
            case 3:
                if(taskNo == 1) {
                    return 2;
                } else if(taskNo == 2) {
                    return 1;
                }
            case 4:
                if(taskNo == 1) {
                    return 3;
                } else if(taskNo == 2) {
                    return 2;
                }
            case 5:
                if(taskNo == 1) {
                    return 5;
                } else if(taskNo == 2) {
                    return 4;
                }
            case 6:
                if(taskNo == 1) {
                    return 4;
                } else if(taskNo == 2) {
                    PrintMessage.printNotAValidProblemNo();
                    return -1;
                }
        }
        return 0;
    }

    public static void executeProgramStatment(String value, String [] files) throws Exception {
        int problemNo = Integer.parseInt(value.substring(0,value.indexOf('.')));
        int taskNo = Integer.parseInt(value.substring(value.indexOf('.')+1,value.length()));
        switch (problemNo) {
            case 1:
                if(taskNo == 1) {
                    ArrayList<String []> pairs = getPairsList(files[0]);
                    if(pairs == null)
                        return;
                    //Execute the problem
                    boolean result = Solution.verifyExchangeRules(pairs);
                    if (result)
                        PrintMessage.printValidPairStatus();
                    else
                        PrintMessage.printInvalidPairStatus();
                    break;
                } else if(taskNo == 2) {
                    ArrayList<String []> family = getFamilyList(files[0]);
                    if(family == null)
                        return;
                    //Execute the problem
                    Solution.createValidPairs(family);
                    break;
                }
            case 2:
                if(taskNo == 1) {
                    ArrayList<String []> pairs = getPairsList(files[0]);
                    ArrayList<String []> family = getFamilyList(files[1]);
                    if(pairs == null || family == null)
                        return;
                    //Execute the problem
                    boolean result = Solution.verifyDebrasExchangeRules(pairs,family);
                    if (result)
                        PrintMessage.printValidPairStatus();
                    else
                        PrintMessage.printInvalidPairStatus();
                    break;
                } else if(taskNo == 2) {
                    ArrayList<String []> family = getFamilyList(files[0]);
                    if(family == null)
                        return;
                    //Execute the problem
                    Solution.createDebrasPairs(family);
                    break;
                }
            case 3:
                if(taskNo == 1) {
                    ArrayList<String []> pairs = getPairsList(files[0]);
                    ArrayList<String []> family = getFamilyList(files[1]);
                    if(pairs == null || family == null)
                        return;
                    //Execute the problem
                    boolean result = Solution.verifyDebrasCircularExchangeRules(pairs,family);
                    if (result)
                        PrintMessage.printValidPairStatus();
                    else
                        PrintMessage.printInvalidPairStatus();
                    break;
                } else if(taskNo == 2) {
                    ArrayList<String []> family = getFamilyList(files[0]);
                    if(family == null)
                        return;
                    //Execute the problem
                    Solution.createDebrasCircularPairs(family);
                    break;
                }
            case 4:
                if(taskNo == 1) {
                    ArrayList<String []> pairs = getPairsList(files[0]);
                    ArrayList<String []> family = getFamilyList(files[1]);
                    ArrayList<String []> previous_pairs = getPairsList(files[2]);
                    if(pairs == null || family == null || previous_pairs == null)
                        return;
                    //Execute the problem
                    boolean result = Solution.verifyJensExchangeRules(pairs,family,previous_pairs);
                    if (result)
                        PrintMessage.printValidPairStatus();
                    else
                        PrintMessage.printInvalidPairStatus();
                    break;
                } else if(taskNo == 2) {
                    ArrayList<String []> family = getFamilyList(files[0]);
                    ArrayList<String []> previous_pairs = getPairsList(files[1]);
                    if(family == null || previous_pairs == null)
                        return;
                    //Execute the problem
                    Solution.createJensPairs(family,previous_pairs);
                    break;
                }
            case 5:
                if(taskNo == 1) {
                    ArrayList<String []> pairs = getPairsList(files[0]);
                    ArrayList<String []> family = getFamilyList(files[1]);
                    ArrayList<String []> previous_pairs = getPairsList(files[2]);
                    ArrayList<String []> good_pairs = getPairsList(files[3]);
                    ArrayList<String []> bad_pairs = getPairsList(files[4]);
                    if(pairs == null || family == null || previous_pairs == null || good_pairs == null || bad_pairs == null )
                        return;
                    //Execute the problem
                    boolean result = Solution.verifyDebraJensExchangeRules(pairs,family,previous_pairs,bad_pairs,good_pairs);
                    if (result)
                        PrintMessage.printValidPairStatus();
                    else
                        PrintMessage.printInvalidPairStatus();
                    break;
                } else if(taskNo == 2) {
                    ArrayList<String []> family = getFamilyList(files[0]);
                    ArrayList<String []> previous_pairs = getPairsList(files[1]);
                    ArrayList<String []> good_pairs = getPairsList(files[2]);
                    ArrayList<String []> bad_pairs = getPairsList(files[3]);
                    if(family == null || previous_pairs == null || good_pairs == null || bad_pairs == null )
                        return;
                    //Execute the problem
                    Solution.createDebraJensPairs(family,previous_pairs,bad_pairs,good_pairs);
                    break;
                }
            case 6:
                if(taskNo == 1) {
                    ArrayList<String []> family = getFamilyList(files[0]);
                    ArrayList<String []> previous_pairs = getPairsList(files[1]);
                    ArrayList<String []> good_pairs = getPairsList(files[2]);
                    ArrayList<String []> bad_pairs = getPairsList(files[3]);
                    if(family == null || previous_pairs == null || good_pairs == null || bad_pairs == null )
                        return;
                    //Execute the problem
                    Solution.createDebraJensPenaltyPairs(family,previous_pairs,bad_pairs,good_pairs);
                    break;
                }
        }
    }

    private static ArrayList<String []> getPairsList(String filename) throws Exception {
        FileReader f = new FileReader(filename);
        ArrayList<String []> input1 =  f.readFile();
        //Check header
        if(!input1.get(0)[0].equals("giver") || !input1.get(0)[1].equals("receiver")) {
            PrintMessage.printInvalidFileTypeInput();
            return null;
        }
        //remove Header
        return removeHeader(input1);
    }

    private static ArrayList<String []> getFamilyList(String filename) throws Exception {
        FileReader f = new FileReader(filename);
        ArrayList<String []> input1 =  f.readFile();
        //Check header
        if(!input1.get(0)[0].equals("Name") || !input1.get(0)[1].equals("household")) {
            PrintMessage.printInvalidFileTypeInput();
            return null;
        }
        //remove Header
        return removeHeader(input1);
    }

    private static ArrayList<String []> removeHeader(ArrayList<String[]> val) {
        ArrayList<String []> result = new ArrayList<String[]>();
        for (int i = 1; i < val.size(); i++ )
            result.add(val.get(i));
        return result;
    }
}