package com.wonderwebdev.assignment3;

import java.util.Scanner;

public class UserLoginApplication {

	public static void main(String[] args) {
		UserService userService = new UserService();
		Scanner scanner = new Scanner(System.in);
		int attempts = 0;

		try {
			while (attempts < 5) {
				System.out.println("Enter your username:");
				String username = scanner.nextLine();

				System.out.println("Enter your password:");
				String password = scanner.nextLine();

				User user = userService.validateUser(username, password);

				if (user != null) {
					System.out.println("Welcome," + user.getName());
					return;
				} else {
					System.out.println("Invalid login. Please try again.");
					attempts++;
				}
			}

			System.out.println("Too many failed login attempts. You are now locked out.");
		} finally {
			scanner.close();
		}
	}

}
