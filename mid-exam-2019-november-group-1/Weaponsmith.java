import java.util.Scanner;

public class Weaponsmith 
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
		String firstLine = sc.nextLine();
		String[] particles = firstLine.split("\\|");
		String command = sc.nextLine();
		
		while( !command.equals("Done") ){
			String[] commandParts = command.split(" ");
			switch(commandParts[0]){
					case "Move":
						int index = Integer.parseInt(commandParts[2]);
						if (index >= 0 && index < particles.length){
							switch(commandParts[1]){
								case "Left":
									if(index != 0){
										String temp1 = particles[index - 1];
										particles[index - 1] = particles[index];
										particles[index] = temp1;
									}
									break;
	
								case "Right":
									if(index != particles.length - 1){
										String temp2 = particles[index + 1];
										particles[index + 1] = particles[index];
										particles[index] = temp2;
									}
									break;
							}
						}	
						break;
					case "Check":
						switch(commandParts[1]){
							case "Even":
								for(int i = 0; i < particles.length; i += 2){
									System.out.print(particles[i] + " ");
								}
								System.out.println();
								break;
	
							case "Odd":
								for(int i = 1; i < particles.length; i += 2){
									System.out.print(particles[i] + " ");
								}
								System.out.println();
								break;
						}
					break;
			}
			if(sc.hasNextLine()){
				 command = sc.nextLine();
			}
		}
		String gun = String.join("", particles);
		System.out.println("You crafted " + gun + "!");
    }
}