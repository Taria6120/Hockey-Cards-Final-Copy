// Filename: W5U1A7P1_Alishba_Tariq_HockeyCards
// Author: Alishba Tariq 
// Date:  Monday, May 20, 2024
// Purpose:  To demonstrate the use of binary and linear search algorithms to search for a specific value in an array. The array was supposed to located a number and a string from a file attached. 
// */



import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the card number:");
        String cardNumber = sc.nextLine();

        ArrayList<Integer> cardNum = new ArrayList<>();
        ArrayList<String> playerName = new ArrayList<>();
        ArrayList<String> teamName = new ArrayList<>();
        String fileName = "cardlist.txt";
      // I made 3 arrays, each for the output that needed to be put out. 

        fileToArrayIntStr(cardNum, playerName, teamName, fileName);

  boolean cardFound = false;
  for (int i = 0; i < cardNum.size(); i++) {
    if (cardNumber.equals(cardNum.get(i).toString())) {
    System.out.println("Card Number is " + cardNum.get(i) + ", the player is " + playerName.get(i) + ", and the team is " + teamName.get(i));
  cardFound = true;

  break;
    }
 }

    if (!cardFound) {
      System.out.println("Card not found.");
    }
      // I used a for loop to check if the card number is in the array. If it is, it will print out the card number, player name, and team name. If it is not, it will print out that the card number is not found.

    boolean cards = true;
    while (cards) {
      System.out.println("Which player are you looking for? Please enter the player number:");
      int targetNum = sc.nextInt();
    

            // Binary search result
      int index = binarySearch(cardNum, targetNum);
      if (index == -1) {
      System.out.println("Card number not found using binary search.");
      } else {
      System.out.println("Card number found using binary search.");
      System.out.println("Player name: " + playerName.get(index));
      System.out.println("Team name: " + teamName.get(index));
      }
      

      // Linear search result
      index = linearSearch(cardNum, targetNum);
      if (index == -1) {
        System.out.println("Card number not found using linear search.");
      } else {
          System.out.println("Card number found using linear search.");
          System.out.println("Player name: " + playerName.get(index));
          System.out.println("Team name: " + teamName.get(index));
      }

  cards = false;
  // exit the loop after the search
      }
  }

public static int binarySearch(ArrayList<Integer> arr, int target) {
  int low = 0, high = arr.size() - 1;
  while (low <= high) {
    int mid = low + (high - low) / 2;
    if (arr.get(mid) == target) {
      return mid;
      } else if (arr.get(mid) < target) {
          low = mid + 1;
      } else {
          high = mid - 1;
      }
  }
    return -1;
  }
  // I used a binary search to find the card number.

  public static int linearSearch(ArrayList<Integer> arr, int target) {
  for (int i = 0; i < arr.size(); i++) {
  if (arr.get(i) == target) {
    return i;
  }
  }
    return -1;
}
  // This is the method for linear search

  public static void fileToArrayIntStr(ArrayList<Integer> alInt, ArrayList<String> alPlayer, ArrayList<String> alTeam, String fileName) {
  try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
  String line;
  int lineNumber = 1;
  while ((line = br.readLine()) != null) {
  line = line.trim();
    if (lineNumber % 2 != 0) {
  // Odd-numbered line (1, 3, 5, ...) - expected to be an integer
// At first, I was confused as to why I was getting an error. I didnt take into consideration that the integer and strings we on a different line. That is why i assigned all the odd number lines to the integer array and even number lines to the string array.
      try {
      int number = Integer.parseInt(line);
      alInt.add(number);
      } catch (NumberFormatException e) {
      System.err.println("Invalid integer on line " + lineNumber + ": " + line);
      }
    } else {
                    // Even-numbered line (2, 4, 6, ...) - expected to be a string "PlayerName, TeamName"
        String[] parts = line.split(", ");
        if (parts.length == 2) {
          alPlayer.add(parts[0]);
          alTeam.add(parts[1]);
        } else {
            System.err.println("Invalid format on line " + lineNumber + ": " + line);
        }
            }
    lineNumber++;
      }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
