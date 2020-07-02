import java.util.Arrays;
import java.util.Scanner;

public class ArcheryTournament 
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
		
		int[] targets = Arrays.stream(sc.nextLine().split("\\|"))
							  .mapToInt(e->Integer.parseInt(e))
							  .toArray();
		
		int size = targets.length;
		
		int maxIndex = targets.length - 1;
		
		int points = 0;

		String command = sc.nextLine();
		
		while( !command.equalsIgnoreCase("Game Over") ){
			String[] commandParts = command.split("@");
			
			switch(commandParts[0]){
				
				case "Shoot Left":
					int index1 = Integer.parseInt(commandParts[1]);
					int length1 = Integer.parseInt(commandParts[2]);
					 
					if(index1 >= 0 && index1 < size){
					
						int indexToShoot = index1 - length1;
					
						while(indexToShoot < 0){
							indexToShoot += size;
						}
						
						if(targets[indexToShoot] >= 5){
							targets[indexToShoot] -= 5;
							points += 5;
						}else{
							points += targets[indexToShoot];
							targets[indexToShoot] = 0;
						}
					} 
					break;
					
				case "Shoot Right":
					int index2 = Integer.parseInt(commandParts[1]);
					int length2 = Integer.parseInt(commandParts[2]);
					
					if(index2 >= 0 && index2 < size){
					
						int indexToShoot = index2 + length2;
					
						while(indexToShoot > maxIndex){
							indexToShoot -= size;
						}
						
						if(targets[indexToShoot] >= 5){
							targets[indexToShoot] -= 5;
							points += 5;
						}else{
							points += targets[indexToShoot];
							targets[indexToShoot] = 0;
						}
					}
					  
					break;
					
				case "Reverse":
					
					 for(int i = 0; i < size/2; i++){
						int temp1 = targets[i];
						int temp2 = targets[maxIndex - i];
						targets[i] = temp2;
						targets[maxIndex - i] = temp1;		
					 }
					
					break;		 
			}
			if(sc.hasNextLine()){
				 command = sc.nextLine();
			}
		}
		for(int i = 0; i < maxIndex; i++){
			System.out.print(targets[i] + " - ");
		}
		System.out.println(targets[maxIndex]);
		System.out.print("Iskren finished the archery tournament with " + points + " points!");
    }
} 