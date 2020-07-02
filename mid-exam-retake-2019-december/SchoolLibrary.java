import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SchoolLibrary 
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

		String firstLine = sc.nextLine();
		
		List<String> shelf = new ArrayList<>( Arrays.asList( firstLine.split("&") ) );

		String command = sc.nextLine();
		
		while( !command.equals("Done") ){
			String[] commandParts = command.split(" \\| ");
			
			switch(commandParts[0]){
				
					case "Add Book":
					if(!shelf.contains(commandParts[1])){
						shelf.add(0,commandParts[1]); 
					}
					break;
					
					case "Take Book":
					if(shelf.contains(commandParts[1])){
						shelf.remove(commandParts[1]); 
					}
					break;
					
					case "Swap Books":
					if(shelf.contains(commandParts[1]) && shelf.contains(commandParts[2]) ){
						int ind1 = shelf.indexOf(commandParts[1]);
						int ind2 = shelf.indexOf(commandParts[2]);
						shelf.set(ind1,commandParts[2]);
						shelf.set(ind2,commandParts[1]);		
					}
					break;
					
					case "Insert Book":
					shelf.add(commandParts[1]); 
					break;
					
					case "Check Book":
					int ind = Integer.parseInt(commandParts[1]);
					if(ind >= 0 && ind < shelf.size()){
						System.out.println(shelf.get(ind)); 
					}
					break;
			}
			if(sc.hasNextLine()){
				 command = sc.nextLine();
			}
		}
		String result = String.join(", ", shelf);
		System.out.println(result);
    }
}