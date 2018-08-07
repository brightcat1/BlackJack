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
		int key = 0; //cpu�̍s������Ƀt���O�ϐ����g�p
		
		int[][] card = new int[4][13]; 
		
		System.out.println("�R���s���[�^�̎�Ԃł��B");
		while(key == 0){
			if(cpupoint <= 14){
				while(true){
					mark = mark2.nextInt(4);
					black = jack.nextInt(13);
					if(card[mark][black] == 0){
						card[mark][black] = 1;
						cpupoint += black + 1;		 //�_���̌v�Z���������Ȃ��̂��C�����A�R�[�h�̈ʒu���œK��
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
							cpupoint += black + 1; 	//�_���̌v�Z���������Ȃ��̂��C�����A�R�[�h�̈ʒu���œK��
							break;
						}
					}
				}
				if(cpu == 2){
					key = 1;  						//�v���C���[�̎�Ԃɉ񂷂Ƃ���key��1����
				}
			}
			if(cpupoint == 21){
				System.out.println("�u���b�N�E�W���b�N�I�I�e�̏�������I�I");
				System.out.println("CPU�̓_����" + cpupoint + "�ł���");	 	//�Q�[���I����CPU�̃|�C���g��\������悤�ɕύX				
				key = 2; 							//�v���C���[�̎�Ԃ����Ȃ��܂܃Q�[���I������ꍇ��key��2����
			}
			if(cpupoint > 21){
				System.out.println("�z�����ꂽ���E�E�E�B���O�̏������E�E�E�����B");
				System.out.println("CPU�̓_����" + cpupoint + "�ł���");		 //�Q�[���I����CPU�̃|�C���g��\������悤�ɕύX
				key = 2; 							//�v���C���[�̎�Ԃ����Ȃ��܂܃Q�[���I������ꍇ��key��2����
			}
		}
		
		
		if(key == 1){	//key��2�������Ă���ꍇ�̓v���C���[�̎�Ԃ��΂�
			System.out.println("�R���s���[�^�̎�Ԃ͏I���ł��B");
			System.out.println("���͂��Ȃ��̔Ԃł��B");
			while(true){
				System.out.println("�h���[���܂����H1:Yes 2:No");
				int draw = stdIn.nextInt();
				
				// �ȉ��h���[�̏���
				if(draw == 1){
					while(true){
						mark = mark2.nextInt(4);
						black = jack.nextInt(13);
						if(card[mark][black] == 0){
							card[mark][black] = 1;
							point = point + black + 1;		// �_���̌v�Z
							break;
						}
					}
				}
				// �h���[�����̏I��
				
				
				// �ȉ��\������
				switch(mark+1){
				case 1:
					markname = "�X�y�[�h";
					break;
				case 2:
					markname = "�n�[�g";
					break;
				case 3:
					markname = "�_�C��";
					break;
				case 4:
					markname = "�N���[�o�[";
					break;
				}
				if(draw == 1){
					System.out.println(markname + "��" + (black + 1));
					System.out.println("���݂̃|�C���g��" + point + "�ł��B");
				}
				if(draw == 2){
					System.out.println("���݂̃|�C���g��" + point + "�ł��B");
					break;
				}
				
				if(point == 21){
					System.out.println("�u���b�N�E�W���b�N");
					break;
				}
				if(point > 21){
					System.out.println("�h�{��");
					break;
				}
				// �\�������̏I��
			}
			System.out.println("CPU�̓_����" + cpupoint + "�ł���"); //�Q�[���I����CPU�̃|�C���g��\������悤�ɕύX
			if(point >= cpupoint && point <= 21) System.out.println("�M�l�́E�E�E�������E�E�E�I�����E�E�E�I");
			if(point <= cpupoint || point > 21) System.out.println("�M�l�̕������I�ӂ��[�͂��͂��́I�I");
			stdIn.close();
		}
			
	}

}