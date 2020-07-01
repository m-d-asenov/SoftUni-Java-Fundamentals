import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class WizardPoker 
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

		String firstLine = sc.nextLine();
		
		String[] cards = firstLine.split(":");
		
		Arrays.sort(cards);
		
		List<String> deck = new ArrayList<>();

		String command = sc.nextLine();
		
		while( !command.equals("Ready") ){
			String[] commandParts = command.split(" ");
			
			switch(commandParts[0]){
				
					case "Add":
					if(Arrays.binarySearch(cards, commandParts[1]) >= 0){
						deck.add(commandParts[1]); 
					}else{
						System.out.println("Card not found." );
					}
					break;
					
					case "Insert":
					int index = Integer.parseInt(commandParts[2]);
					if(Arrays.binarySearch(cards, commandParts[1]) >= 0 && index >= 0 && index < deck.size()){
						deck.add(index,commandParts[1]); 
					}else{
						System.out.println("Error!" );
					}
					break;
					
					case "Remove":
					if(deck.contains(commandParts[1])){
						 deck.remove(commandParts[1]);
					}else{
						System.out.println("Card not found." );
					}
					break;
					
					case "Swap":
					int ind1 = deck.indexOf(commandParts[1]);
					int ind2 = deck.indexOf(commandParts[2]);
					deck.set(ind2, commandParts[1]);
				    deck.set(ind1, commandParts[2]);
					 
					break;
					
					case "Shuffle":
					Collections.reverse(deck);
					break;
			}
			if(sc.hasNextLine()){
				 command = sc.nextLine();
			}
		}
		String result = String.join(" ", deck);
		System.out.println(result);
    }
}