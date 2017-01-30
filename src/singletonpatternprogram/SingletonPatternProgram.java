package singletonpatternprogram;

import java.util.*; // Import the java utility package

/**
 * Singleton Pattern Program (Week 1)
 * John D. Snurr
 * PRG/421
 * November 29, 2016
 * Roland Morales
 */

public class SingletonPatternProgram 
{
    public static void main(String[] args) 
    {
        Scanner readInput = new Scanner(System.in); // Declare and initialize new scanner for user input
        ValidateInput validation = new ValidateInput(); // Declare and instantiate new reference to ValidateInput class
        
        int numberOfRunners; // Declare number of runners to check user input for boundaries
        
        do { // Do-while loop for the number of runners that will be on the track
            System.out.print("Please enter the number of runners (1 - 8) you would like to assign to lanes: "); // Output message prompting user input
            numberOfRunners = validation.validateInt(false); // Assign a validated integer to numberOfRunners
            
        } while (numberOfRunners <= 0 || numberOfRunners >= 9); // End loop when numberOfRunners equals a number 1 - 8
        
        do { // Do-while loop for first and last name of the runners
            Track track = Track.getTrack(); // Get track reference
            
            String firstNameMessage = "Please enter the first name of the runner: "; // Create firstMessageString for validateString()
            String firstName = validation.validateString(firstNameMessage, false); // Call validateString() and store user input to firstName
            
            String lastNameMessage = "Please enter " + firstName + "'s last name: "; // Create lastMessageString for validateString()
            String lastName = validation.validateString(lastNameMessage, false); // Call validateString() and store user input to lastName
            
            int enteredLane = 0; // Declare and initialize enteredLane int for user input boundaries
            
            do { // Nested do-while loop for runners lane assignment
                System.out.print("Please enter tha lane (1 - 8) to assign " + firstName + " " + lastName + " to: "); // Prompt user to enter a lane for assignment
                enteredLane = validation.validateInt(false); // Call validateInt() to assign a validated integer to enteredLane
                
                if (enteredLane <= 0 || enteredLane >= 9) // If the enteredLane is not between 1 - 8...
                {
                    System.out.println(enteredLane + " is not a valid lane. Please enter a number between 1 and 8."); // inform the user of the error 
                }
                
            } while (enteredLane <= 0 || enteredLane >= 9); // End loop when enteredLane is between 1 - 8
            
            track.addRunner(enteredLane, firstName, lastName); // Call the addRunner() of the instanced track to populate the arrays and remove the lane
            numberOfRunners--; // Reduce the number of runners left to be added
             
        } while (numberOfRunners > 0); // End loop when there are no runners left to be entered
        
        System.out.println("\n----- LANE ASSIGNMENTS -----"); // Output to keep list seperated from input prompts
        
        for (int i = 0; i < 8; i++) // For-loop to output lane assignments
        {
            Track track = Track.getTrack(); // Get reference to track
            
            if (track.getFirstName(i) == null) // If there is no runner at the current lane assignment...
            {
                System.out.println("Lane " + (i + 1) + ": NO RUNNER ASSSIGNED"); // Output that no runner is assigned to the lane
            }
            else
            {
                System.out.println("Lane " + (i + 1) + ": " + track.getFirstName(i) + " " + track.getLastName(i)); // Else... output the name of the runner assigned to the lane
            }
        }
    }
}

/**
 * John D. Snurr
 * November 29, 2016
 */