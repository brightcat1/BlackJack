import java.util.Random;
import java.util.Scanner;

public class BlackJack {

	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		Random jack = new Random();
		Random mark2 = new Random();
		Random decide = new Random();
		
		int mark = 0;
		int black = 0;
		int cpu = 0;
		String markname = "";
		int point = 0;
		int cpupoint = 0;
		int key = 0; //dealer turn flag
		
		int[][] card = new int[4][13]; 
		
		System.out.println("Dealer's turn.");
		while(key == 0){
			if(cpupoint <= 14){
				while(true){
					mark = mark2.nextInt(4);
					black = jack.nextInt(13);
					if(card[mark][black] == 0){
						card[mark][black] = 1;
						cpupoint += black + 1;		 //calculate dealer point
						break;
					}
				}
			}else if(cpupoint >= 15){
				cpu = decide.nextInt(3) + 1; // With a probability of one third to draw the card.
				if(cpu == 1){
					while(true){
						mark = mark2.nextInt(4);
						black = jack.nextInt(13);
						if(card[mark][black] == 0){
							card[mark][black] = 1;
							cpupoint += black + 1;
							break;
						}
					}
				}
				if(cpupoint == 21){
					System.out.println("Black Jack! Dealer win!");
					System.out.println("Dealer's hand value is " + cpupoint);
					stdIn.close();
					return;
				}
				if(cpupoint > 21){
					System.out.println("busting! You Win!");
					System.out.println("Dealer's hand value is " + cpupoint);
					stdIn.close();
					return;
				}
				if(cpupoint < 21 && (cpu == 2 || cpu == 3)){
					key = 1;  						//turn to player turn
				}
			}
		}
		
		
		if(key == 1){	//only if key is 1, player turn coming
			System.out.println("It's your turn.");
			while(true){
				System.out.println("Do you want to draw? 1:Yes 2:No");
				int draw = stdIn.nextInt();
				
				// Drawing process
				if(draw == 1){
					while(true){
						mark = mark2.nextInt(4);
						black = jack.nextInt(13);
						if(card[mark][black] == 0){
							card[mark][black] = 1;
							point = point + black + 1;
							break;
						}
					}
				}
				// Drawing process end
				
				
				// Define suit of cards
				switch(mark+1){
				case 1:
					markname = "SPADES";
					break;
				case 2:
					markname = "HEARTS";
					break;
				case 3:
					markname = "DIAMONDS";
					break;
				case 4:
					markname = "CLUBS";
					break;
				}
				if(draw == 1){
					System.out.println( "the " + (black + 1) + " of " + markname);
					System.out.println("Your hand value is " + point);
				}
				if(draw == 2){
					System.out.println("Your hand value is " + point);
					break;
				}
				
				if(point == 21){
					System.out.println("Black Jack!");
					break;
				}
				if(point > 21){
					System.out.println("Burst! You Lose!");
					break;
				}
			}
			System.out.println("Dealer's hand value is " + cpupoint); //Final hand of dealer when player win.
			if(point >= cpupoint && point <= 21) System.out.println("You Win!");
			if(point <= cpupoint || point > 21) System.out.println("You Lose!");
			stdIn.close();
		}
			
	}

}