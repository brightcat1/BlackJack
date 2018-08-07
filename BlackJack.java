package blackjack;
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
		int key = 0; //cpuの行動制御にフラグ変数を使用
		
		int[][] card = new int[4][13]; 
		
		System.out.println("コンピュータの手番です。");
		while(key == 0){
			if(cpupoint <= 14){
				while(true){
					mark = mark2.nextInt(4);
					black = jack.nextInt(13);
					if(card[mark][black] == 0){
						card[mark][black] = 1;
						cpupoint += black + 1;		 //点数の計算が正しくないのを修正し、コードの位置を最適化
						break;
					}
				}
			}else if(cpupoint >= 15){
				cpu = decide.nextInt(2) + 1;
				if(cpu == 1){
					while(true){
						mark = mark2.nextInt(4);
						black = jack.nextInt(13);
						if(card[mark][black] == 0){
							card[mark][black] = 1;
							cpupoint += black + 1; 	//点数の計算が正しくないのを修正し、コードの位置を最適化
							break;
						}
					}
				}
				if(cpu == 2){
					key = 1;  						//プレイヤーの手番に回すときはkeyに1を代入
				}
			}
			if(cpupoint == 21){
				System.out.println("ブラック・ジャック！！親の勝ちじゃ！！");
				System.out.println("CPUの点数は" + cpupoint + "でした");	 	//ゲーム終了時CPUのポイントを表示するように変更				
				key = 2; 							//プレイヤーの手番が来ないままゲーム終了する場合はkeyに2を代入
			}
			if(cpupoint > 21){
				System.out.println("奴がやられたか・・・。お前の勝ちだ・・・ぐっ。");
				System.out.println("CPUの点数は" + cpupoint + "でした");		 //ゲーム終了時CPUのポイントを表示するように変更
				key = 2; 							//プレイヤーの手番が来ないままゲーム終了する場合はkeyに2を代入
			}
		}
		
		
		if(key == 1){	//keyに2を代入してある場合はプレイヤーの手番を飛ばす
			System.out.println("コンピュータの手番は終了です。");
			System.out.println("次はあなたの番です。");
			while(true){
				System.out.println("ドローしますか？1:Yes 2:No");
				int draw = stdIn.nextInt();
				
				// 以下ドローの処理
				if(draw == 1){
					while(true){
						mark = mark2.nextInt(4);
						black = jack.nextInt(13);
						if(card[mark][black] == 0){
							card[mark][black] = 1;
							point = point + black + 1;		// 点数の計算
							break;
						}
					}
				}
				// ドロー処理の終了
				
				
				// 以下表示処理
				switch(mark+1){
				case 1:
					markname = "スペード";
					break;
				case 2:
					markname = "ハート";
					break;
				case 3:
					markname = "ダイヤ";
					break;
				case 4:
					markname = "クローバー";
					break;
				}
				if(draw == 1){
					System.out.println(markname + "の" + (black + 1));
					System.out.println("現在のポイントは" + point + "です。");
				}
				if(draw == 2){
					System.out.println("現在のポイントは" + point + "です。");
					break;
				}
				
				if(point == 21){
					System.out.println("ブラック・ジャック");
					break;
				}
				if(point > 21){
					System.out.println("ドボン");
					break;
				}
				// 表示処理の終了
			}
			System.out.println("CPUの点数は" + cpupoint + "でした"); //ゲーム終了時CPUのポイントを表示するように変更
			if(point >= cpupoint && point <= 21) System.out.println("貴様の・・・勝ちだ・・・！ぐっ・・・！");
			if(point <= cpupoint || point > 21) System.out.println("貴様の負けだ！ふぅーはっはっは！！");
			stdIn.close();
		}
			
	}

}