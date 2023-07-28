import java.util.Scanner;
import java.awt.*;

public class Main {

	Player player = new Player();
	Monster monster = new Monster();
	Scanner scanner = new Scanner(System.in);

	public void MainMenu() {

		System.out.println(
				"Welcome to Little Adventure!\nTo Select a choice, type the number right next to it \n\n1: Begin\n");
		player.health = 3;
		player.attack = 1;
		monster.health = 6;
		monster.attack = 1;
		int menuIN = scanner.nextInt();
		switch (menuIN) {
		case 1:
			System.out.println("\nYour current HP is " + player.health);
			System.out.println("Your current Attack does " + player.attack + " damage");
			System.out.println("\n1: Continue\n\n");
			int menuIN1 = scanner.nextInt();
			switch (menuIN1) {
			case 1:
				Tree();
				break;
			}
		}

	}

	public void playerCheckHealth() {
		switch (player.health) {
		case 0:
			System.out.println("\nGame Over");
			System.out.println("\n\n1: Main Menu");
			int menuH = scanner.nextInt();
			switch (menuH) {
			case 1:
				MainMenu();
				break;
			}
		}
	}

	public void monsterCheckHealth() {
		switch (monster.health) {
		case 0:
			System.out.println("\nYou have Slayed the Monster!\nThe End");
			System.out.println("\n\n1: Continue");
			int MenuIN = scanner.nextInt();// replace the you with the users name, make a input for it in menu
			switch (MenuIN) {
			case 1:
				System.out.println("Thank you for playing Little Adventure!\nBy: Zyon Faccin\n\n1: Main Menu");
				int menuH = scanner.nextInt();
				switch (menuH) {
				case 1:
					MainMenu();
					break;
				}
			}
		}

	}

	public void Tree() {

		System.out.println(
				"You have woken up in the woods, and see a red tree in the distance. \n\n1: Go Towards Red Tree\n2: Go towards the opposite direction\n");
		int gameIN = scanner.nextInt();
		switch (gameIN) {
		case 1:
			player.health += 1;
			System.out.println("\nThis Tree is Magical and has given you 1 HP\nYou now have " + player.health + " HP");
			System.out.println("\n1: Continue");
			int menuIN1 = scanner.nextInt();
			switch (menuIN1) {
			case 1:
				Cave();
				break;
			}
		case 2:
			player.attack += 1;

			System.out.println("\nYou have found a sword! Your attack has increased by 1!\nYour Attack now does "
					+ player.attack + " damage");
			System.out.println("\n1: Continue");
			int menuIN2 = scanner.nextInt();
			switch (menuIN2) {
			case 1:
				Cave();
				break;
			}

		}
	}

	public void Cave() {
		System.out.println("While walking, you have stumbled upon a cave.\n\n1: Enter Cave\n2: Keep walkng\n");
		int menuIN3 = scanner.nextInt();
		switch (menuIN3) {
		case 1:
			player.health -= 1;
			System.out.println(
					"You have been swarmed by a group of bats, and ran away.\nAs a result you have lost a life\n\nYou now have "
							+ player.health + " HP\n\n1: Continue");
			int menuIN = scanner.nextInt();
			switch (menuIN) {
			case 1:
				Berries();
				break;
			}

		case 2:
			Berries();
			break;
		}
	}

	public void Berries() {
		System.out.println(
				"\nYou keep walking and find a bush with strange berries, do you want to eat it?\n\n1: Eat the Berries\n2: Keep Walking");
		int gameIN = scanner.nextInt();
		switch (gameIN) {
		case 1:
			player.health += 1;
			System.out.println("\nIt seems the berries are good! You have gained 1 life\nYou now have " + player.health
					+ " HP.\n1: Continue");
			int menuIN = scanner.nextInt();
			switch (menuIN) {
			case 1:
				greenObj();
				break;
			}

		case 2:
			greenObj();
			break;
		}

	}

	public void greenObj() {
		System.out.println("\n\nA green object appears in the distance...\n\n1: Investigate\n2: Keep Walking");
		int gameIN = scanner.nextInt();
		switch (gameIN) {
		case 1, 2:
			System.out.println("\nThe green object is coming towards you.\n\n1: Continue");
			int gameIN1 = scanner.nextInt();
			switch (gameIN1) {
			case 1:
				monsterEnc();
				break;
			}

		}

	}

	public void monsterEnc() {
		System.out.println("The green object is a monster! You must fight it!\n\n1: Continue\n");
		int gameIN1 = scanner.nextInt();
		switch (gameIN1) {
		case 1:
			switch (player.attack) {
			case 2:
				monsterAttk();
			case 1:
				player.attack += 1;
				System.out.println("You have found a sword next to a tree! Your attack now does " + player.attack
						+ " damage.\n\n1: Continue");
				int gameIN = scanner.nextInt();
				switch (gameIN) {
				case 1:
					monsterAttk();
					break;
				}

			}
		}

	}

	public void monsterAttk() {
		System.out.println("The monster is about to attack!\n\n1: Fight Back\n2: Dodge");
		int gameIN1 = scanner.nextInt();
		switch (gameIN1) {
		case 1:
			player.health -= monster.attack;
			System.out.println("You swung your sword too late and the monster attacked you.\nYou now have "
					+ player.health + " HP.\n\n1: Continue");
			int gameIN = scanner.nextInt();
			switch (gameIN) {
			case 1:
				monsterNoLook();
			}
		case 2:
			System.out.println("You sucefully dodged the Monster!\n\n1: Continue");
			int gameIN2 = scanner.nextInt();
			switch (gameIN2) {
			case 1:
				monsterNoLook();
			}

		}

	}

	public void monsterNoLook() {
		System.out.println("The monster is now distracted...\n\n1: Attack\n2: Flee");
		int gameIn1 = scanner.nextInt();
		switch (gameIn1) {
		case 1:
			monster.health -= player.attack;
			System.out.println("You hit the monster!\nThe monster now has " + monster.health + " HP.\n\n1: Continue");
			int gameIN = scanner.nextInt();
			switch (gameIN) {
			case 1:
				monsterStand();
			}
		case 2:
			player.health -= monster.attack;
			System.out.println("The monster saw you trying to flee and attacked you\nYou now have " + player.health
					+ " HP\n\n1: Continue");
			int gameIN1 = scanner.nextInt();
			switch (gameIN1) {
			case 1:
				playerCheckHealth();
				monsterStand();
			}
		}
	}

	public void monsterStand() {
		System.out.println("The monster is charging at you!\n\n1: Attack\n2: Run and hide behind the tree");// gotta do
																											// story for
																											// second
																											// option
		int gameIN = scanner.nextInt();
		switch (gameIN) {
		case 1:
			monster.health -= player.attack;
			player.health -= monster.attack;
			System.out.println("\nYou have sucessully attacked the monster!\nThe monster now has " + monster.health
					+ " HP\nHowever you also took damage\nYou now have " + player.health + " HP\n\n1: Continue");

			int gameIN1 = scanner.nextInt();
			switch (gameIN1) {
			case 1:
				playerCheckHealth();
				monsterHide();
			}
		case 2:
			System.out.println("You ran away and hid from the monster\n\n1: Continue");
			int gameIN2 = scanner.nextInt();
			switch (gameIN2) {
			case 1:
				monsterHide();
			}

		}
	}

	public void monsterHide() {
		System.out.println("The monster has disappeared\n\n1: Look around for the monster\n2: Leave");
		int gameIN = scanner.nextInt();
		switch (gameIN) {
		case 1:
			player.health -= monster.attack;
			System.out.println("The Monster was behind you and it attacked you\nYou now have " + player.health
					+ " HP.\n\n1: Continue");
			playerCheckHealth();
			int gameIN1 = scanner.nextInt();
			switch (gameIN1) {
			case 1:
				monsterDamage();
			}
		case 2:
			player.health -= monster.attack;
			System.out.println("While leaving, the monster teleported and attacked you.\nYou now have " + player.health
					+ " HP.\n\n1: Continue");
			playerCheckHealth();
			int gameIN2 = scanner.nextInt();
			switch (gameIN2) {
			case 1:
				monsterDamage();
			}

		}
	}

	public void monsterDamage() {
		System.out.println(
				"It appears the monster is losing energy.\n\n1: Attack the Monster from the front\n2: Attack the Monster from the back");
		int gameIN = scanner.nextInt();
		switch (gameIN) {
		case 1:
			monster.health -= player.attack;
			System.out.println("You attacked the monster from the front.\nThe monster now has " + monster.health
					+ " HP.\n\n1: Continue");
			monsterCheckHealth();
			int gameIN2 = scanner.nextInt();
			switch (gameIN2) {
			case 1:
				monsterFinish();
			}
		case 2:
			monster.health -= player.attack;
			System.out.println("You attacked the monster from the back.\nThe monster now has " + monster.health
					+ " HP.\n\n1: Continue");
			monsterCheckHealth();
			int gameIN1 = scanner.nextInt();
			switch (gameIN1) {
			case 1:
				monsterFinish();
			}
		}
	}

	public void monsterFinish() {
		System.out.println(
				"The monster is out of energy laying on the ground?\n\n1: Slay the monster\n2: Leave and let the monster survive");
		int gameIN = scanner.nextInt();
		switch (gameIN) {
		case 1:
			monster.health -= player.attack;
			monsterCheckHealth();
		case 2:
			System.out.println("You have left the monster\n\nThe End\nBy: Zyon Faccin\n\n");
			MainMenu();
		}
	}

	public static void main(String[] args) {
		new Main().MainMenu();

	}
}
