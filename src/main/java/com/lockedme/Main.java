package com.lockedme;

import java.util.List;
import java.util.Scanner;

import com.lockedme.bo.UserBO;
import com.lockedme.bo.impl.UserBOImpl;
import com.lockedme.dao.impl.UserDaoImpl;
import com.lockedme.exception.BusinessException;
import com.lockedme.model.User;

public class Main {

	public static void main(String[] args) {
		System.out.println("Welcome to LockedMe App V1.0");
		System.out.println("---------------------------------------");
		Scanner scanner = new Scanner(System.in);
		int ch = 0;
		UserBO userBO = new UserBOImpl();

		do {
			System.out.println("Main Menu");
			System.out.println("-----------");
			System.out.println("1)Registration");
			System.out.println("2)Get All Users");
			System.out.println("3)Search User");
			System.out.println("4)Delete User");
			System.out.println("5)EXIT");
			System.out.println("Enter your choice");
			try {
				ch = Integer.parseInt(scanner.nextLine());
			} catch (NumberFormatException e) {

			}
			switch (ch) {
			case 1:
				User user = new User();
				System.out.println("Enter User First Name");
				user.setFirstName(scanner.nextLine());
				System.out.println("Enter User Last Name");
				user.setLastName(scanner.nextLine());
				System.out.println("Enter User Name");
				user.setUserName(scanner.nextLine());
				System.out.println("Enter Password");
				user.setPassword(scanner.nextLine());
				try {
					user = userBO.addUser(user);
				} catch (BusinessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				break;
			case 2:
				try {
					List<User> userList = new UserDaoImpl().getAllUsers();
					System.out.println("Printing all the Users");
					for (User u : userList) {
						System.out.println(u);
					}
				} catch (BusinessException e) {
					System.out.println(e.getMessage());
				}
				break;
			case 3:
				System.out.println("Enter username to get User details");
				try {
					String userName = scanner.nextLine();
					User user_fetch = userBO.getUser(userName);
					if (user_fetch != null) {
						System.out.println("Product with id " + userName + " found. Details are...");
						System.out.println(user_fetch);
					}
				} catch (NumberFormatException e) {
					System.out.println("Id should be number only");
				} catch (BusinessException e) {
					System.out.println(e.getMessage());
				}
				break;
			case 4:
				System.out.println("Enter username to be deleted");
				try {
					String userName = scanner.nextLine();
					userBO.deleteUser(userName);
				} catch (BusinessException e) {
					System.out.println(e.getMessage());
				}
				break;
			case 5:
				System.out.println("Thank you for using our LockedMe app....");

				break;
			default:
				System.out.println("Entered choice is invalid. Choice should numerical between (1-7)");
				break;
			}
		} while (ch != 5);
		scanner.close();

	}

}