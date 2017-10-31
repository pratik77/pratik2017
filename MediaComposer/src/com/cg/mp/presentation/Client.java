package com.cg.mp.presentation;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.cg.mp.dto.ComposerMasterDTO;
import com.cg.mp.exception.SongException;
import com.cg.mp.service.ISongService;
import com.cg.mp.service.SongService;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ISongService songService=new SongService();
		ComposerMasterDTO composerMasterDTO=new ComposerMasterDTO();
		Scanner sc = new Scanner(System.in);
		int choice1,choice2,choice3,userId,composerId=0;
		char choice5;
		String password;
		DateTimeFormatter formatter=null;
		System.out.println("Enter choice");
		System.out.println("*************");
		System.out.println("1.Login");
		System.out.println("2.Exit :(");
		choice1=sc.nextInt();
		switch(choice1)
		{
		case 1:
			System.out.println("Enter Credentials");
			System.out.print("UserId (no space in userId): ");
			userId=sc.nextInt();
			System.out.println("Password: ");
			password=sc.next();
			String checkLogin="invalid";
			try {
				checkLogin=songService.checkLogin(userId,password);
			} catch (SongException e) {
				// TODO Auto-generated catch block
				e.getMessage();
			}
			if(checkLogin=="admin")
			{
				System.out.println("Hello Admin.");
				System.out.println("****************");
				do
				{
					System.out.println("Admin Menu:");
					System.out.println();
					System.out.println("1. Add a Composer.");
					System.out.println("2. Search for a Composer");
					System.out.println("3. Edit an existing Composer details.");
					System.out.println("4. Delete a Composer.");
					System.out.println("5. Associate song/songs to a Composer.");
					System.out.println("6. Add an Artist.");
					System.out.println("7. Search for an Artist");
					System.out.println("8. Edit an existing Artist details.");
					System.out.println("9. Delete an Artist.");
					System.out.println("10.Associate song/songs to a Composer.");
					System.out.println("11.Add Songs.");
					System.out.println("12.Logout");
					System.out.println("Enter choice:");
					choice3=sc.nextInt();
					switch(choice3)
					{
					case 1:
						
						System.out.println("Enter Composer name:");
						String composerName=sc.next();
						System.out.println("Enter Composer Born date:");
						String composerBorn=sc.next();
						formatter=DateTimeFormatter.ofPattern("yyyy-MM-dd");
						LocalDate bornDateLocal=LocalDate.parse(composerBorn,formatter);
						Date composerBornDate=Date.valueOf(bornDateLocal);
						System.out.println("Is the composer dead?(y/n)");
						String choice4=sc.next();
						if(choice4.equals("Y") || choice4.equals("y"))
						{
						System.out.println("Enter Composer Died date:");
						String composerDied=sc.next();
						LocalDate diedDateLocal=LocalDate.parse(composerDied,formatter);
						Date composerDiedDate=Date.valueOf(diedDateLocal);
						composerMasterDTO.setComposerDiedDate(composerDiedDate);
						}
						else
							composerMasterDTO.setComposerDiedDate(null);
						System.out.println("Enter Composer Caeipi number:");
						String composerCaeipiNumber=sc.next();
						System.out.println("Enter Composer Music Society Id");
						String composerMusicSocId=sc.next();
						composerMasterDTO.setComposerName(composerName);
						composerMasterDTO.setComposerBornDate(composerBornDate);
						composerMasterDTO.setComposerCaeipiNumber(composerCaeipiNumber);
						composerMasterDTO.setComposerMusicSocId(composerMusicSocId);
						composerMasterDTO.setComposerDelFlag(1);
						try {
							System.out.println(userId);
							songService.addComposer(composerMasterDTO,userId);
							System.out.println("Composer succesfully added.");
						} catch (SongException e) {
							// TODO Auto-generated catch block
							System.out.println(e.getMessage());
						}
						break;
					case 2:
						System.out.println("Enter composer id:");
						composerId=sc.nextInt();
						try {
							composerMasterDTO=songService.getComposerById(composerId);
							if(composerMasterDTO.getComposerName()==null)
							{
								try
								{
									throw new SongException("The composer you are searching for is unavailable.");
								}
								catch(SongException e) {
									System.out.println(e.getMessage());
								}
							}
								
							else
								System.out.println(composerMasterDTO);
						} catch (SongException e) {
							// TODO Auto-generated catch block
							System.out.println(e.getMessage());
						}
						
						break;
					case 3:
						System.out.println("Enter the composer Id you want to edit: ");
						composerId=sc.nextInt();
						System.out.println("What do u want to edit?");
						System.out.println("*************************");
						System.out.println("1.Death Date");
						System.out.println("2.Caeipi number");
						System.out.println("3.Music Society Id");
						System.out.println("Enter choice: ");
						int choice6=sc.nextInt();
						ComposerMasterDTO composerMasterDTOEdit=new ComposerMasterDTO();
						switch(choice6)
						{
						case 1:
							System.out.println("Enter the death date in yyyy-mm-dd format: ");
							String deathDate=sc.next();
							formatter=DateTimeFormatter.ofPattern("yyyy-MM-dd");
							LocalDate deathDateLocal=LocalDate.parse(deathDate,formatter);
							Date deathDateDate=Date.valueOf(deathDateLocal);
							composerMasterDTOEdit.setComposerDiedDate(deathDateDate);
							composerMasterDTOEdit.setComposerId(composerId);
							try {
								songService.editComposerDetails(composerMasterDTOEdit,choice6,userId);
								System.out.println("Composer details succesfully edited");
							} catch (SongException e) {
								// TODO Auto-generated catch block
								System.out.println(e.getMessage());
							}
							
							break;
						}
						break;
					}
					System.out.println("Wnat to continue (y/n)");
					choice5=sc.next().charAt(0);
				}while(choice5 =='y' || choice5=='Y');
			}
			else if(checkLogin=="user")
			{
				System.out.println("Hello User");
				System.out.println("************");
			}
			else
			{
				System.err.println("Invalid userid password combination. Login denied. Sorry");
			}
			break;
			
			
		}
	}

}
