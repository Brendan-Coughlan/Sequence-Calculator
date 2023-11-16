import java.util.*;

public class Main
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        ArrayList<Integer> sequence = new ArrayList<Integer>();
        System.out.print("Enter a sequence: ");
        String sequenceInput = input.nextLine();
        //Converts String input to integers and add them to the sequence ArrayList
        String numBeingAdded = "";
        for(int i = 0; i < sequenceInput.length(); i++)
        {
            if(sequenceInput.substring(i, i+1).equals(","))
            {
                sequence.add(Integer.valueOf(numBeingAdded));
                numBeingAdded = "";
            }
            else if(i == sequenceInput.length() - 1)
            {
                numBeingAdded += sequenceInput.substring(i, i+1);
                sequence.add(Integer.valueOf(numBeingAdded));
            }
            else if(!sequenceInput.substring(i, i+1).equals(" "))
            {
                numBeingAdded += sequenceInput.substring(i, i+1);
            }
        }

        while(true)
        {
            if(sequence.size() > 2)
            {
                System.out.print("Enter a command: ");
                String command = input.nextLine().toUpperCase();
                switch(command)
                {
                    case "SEQUENCE":
                        System.out.println(sequence);
                        break;
                    case "TYPE":
                        //Arithmetic
                        if(sequence.get(1) - sequence.get(0) == sequence.get(2) - sequence.get(1))
                        {
                            System.out.println("This is an arithmetic sequence.");
                        }
                        //Geometric
                        else if(sequence.get(1) / sequence.get(0) == sequence.get(2) / sequence.get(1))
                        {
                            System.out.println("This is an geometric sequence");
                        }
                        //Not a sequence
                        else
                        {
                            System.out.println("This is not a sequence.");
                            System.exit(0);
                        }
                        break;
                    case "COMMON":
                        //Arithmetic
                        if(sequence.get(1) - sequence.get(0) == sequence.get(2) - sequence.get(1))
                        {
                            System.out.println("The common difference is " + (sequence.get(1) - sequence.get(0)));
                        }
                        //Geometric
                        else if(sequence.get(1) / sequence.get(0) == sequence.get(2) / sequence.get(1))
                        {
                            System.out.println("The common ratio is " + (sequence.get(1) / sequence.get(0)));
                        }
                        //Not a sequence
                        else
                        {
                            System.out.println("This is not a sequence.");
                            System.exit(0);
                        }
                        break;
                    case "FORMULA":
                        //Arithmetic
                        if(sequence.get(1) - sequence.get(0) == sequence.get(2) - sequence.get(1))
                        {
                            int commonDifference = sequence.get(1) - sequence.get(0);
                            if((sequence.get(0) - commonDifference) < 0)
                            {
                                System.out.println("The formula is: a_n = " + commonDifference + "n" + (sequence.get(0) - commonDifference));
                            }
                            else if((sequence.get(0) - commonDifference) > 0)
                            {
                                System.out.println("The formula is: a_n = " + commonDifference + "n+" + (sequence.get(0) - commonDifference));
                            }
                            else
                            {
                                System.out.println("The formula is: a_n = " + commonDifference + "n");
                            }
                        }
                        //Geometric
                        else if(sequence.get(1) / sequence.get(0) == sequence.get(2) / sequence.get(1))
                        {
                            int commonRatio = sequence.get(1) / sequence.get(0);
                            System.out.println("The formula is: a_n = " + sequence.get(0) + "(" + commonRatio + ")^(n-1)");
                        }
                        //Not a sequence
                        else
                        {
                            System.out.println("This is not a sequence.");
                            System.exit(0);
                        }
                        break;
                    case "FIND":
                        System.out.print("Term: ");
                        int findTerm = input.nextInt();
                        //Arithmetic
                        if(sequence.get(1) - sequence.get(0) == sequence.get(2) - sequence.get(1))
                        {
                            int commonDifference = sequence.get(1) - sequence.get(0);
                            int term = (findTerm * commonDifference) + (sequence.get(0) - commonDifference);
                            System.out.println("a_" + findTerm + " = " + term);
                        }
                        //Geometric
                        else if(sequence.get(1) / sequence.get(0) == sequence.get(2) / sequence.get(1))
                        {
                            int commonRatio = sequence.get(1) / sequence.get(0);
                            int term = (int)Math.pow((sequence.get(0) * commonRatio), (findTerm - 1));
                            System.out.println("a_" + findTerm + " = " + term);
                        }
                        //Not a sequnece
                        else
                        {
                            System.out.println("This is not a sequence.");
                            System.exit(0);
                        }
                        input.nextLine();
                        break;
                    case "CHANGE":
                        System.out.print("Enter new sequence: ");
                        sequenceInput = input.nextLine();
                        //Converts String input to integers and add them to the sequence ArrayList
                        numBeingAdded = "";
                        sequence.clear();
                        for(int i = 0; i < sequenceInput.length(); i++)
                        {
                            if(sequenceInput.substring(i, i+1).equals(","))
                            {
                                sequence.add(Integer.valueOf(numBeingAdded));
                                numBeingAdded = "";
                            }
                            else if(i == sequenceInput.length() - 1)
                            {
                                numBeingAdded += sequenceInput.substring(i, i+1);
                                sequence.add(Integer.valueOf(numBeingAdded));
                            }
                            else if(!sequenceInput.substring(i, i+1).equals(" "))
                            {
                                numBeingAdded += sequenceInput.substring(i, i+1);
                            }
                        }
                        break;
                    case "EXIT":
                        System.out.println("Exiting...");
                        System.exit(0);
                        break;
                    case "HELP":
                        System.out.println("Commands:\nSequence - Prints out your sequence.\nCommon - Prints out the common difference/ratio.\nFormula - Prints out the formula for your sequence.\nFind - Enter the term number and it will print out what it is.\nChange - Enter a new sequence.\nExit - Stops the program.");
                        break;
                    default:
                        System.out.println("Invalid command. Type 'Help' for commands");
                        break;
                }
            }
            else
            {
                System.out.println("Not enough information.");
                System.exit(0);
            }
        }
    }
}