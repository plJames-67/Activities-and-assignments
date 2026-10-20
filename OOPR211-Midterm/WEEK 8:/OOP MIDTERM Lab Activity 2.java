package com.mycompany.midterm_classact2;

import java.util.Scanner;

public class Midterm_ClassAct2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter total pages of the book: ");
        int totalPages = input.nextInt();

        System.out.print("Enter pages already read: ");
        int pagesRead = input.nextInt();

        System.out.print("Enter how many days you have been reading: ");
        int daysReading = input.nextInt();
        
        System.out.println("\n--- Enter Issue Date ---");
        System.out.print("Enter Day (1-31): ");
        int issueDay = input.nextInt();
        System.out.print("Enter Month (1-12): ");
        int issueMonth = input.nextInt();
        System.out.print("Enter Year (e.g., 2026): ");
        int issueYear = input.nextInt();
        
        System.out.println("\n--- Enter Due Date ---");
        System.out.print("Enter Day (1-31): ");
        int dueDay = input.nextInt();
        System.out.print("Enter Month (1-12): ");
        int dueMonth = input.nextInt();
        System.out.print("Enter Year (e.g., 2026): ");
        int dueYear = input.nextInt();
        
        int totalDays=0;
        
        if(dueMonth != issueMonth){
                if(issueMonth == 4 || issueMonth == 6 || issueMonth == 9 || issueMonth == 11){
                    totalDays = (dueDay-issueDay) + 30;
                } else if(issueMonth == 2){
                    totalDays = (dueDay-issueDay) + 28;
                } else{
                    totalDays = (dueDay-issueDay) + 31;
                }
            } else {
                totalDays = dueDay - issueDay;
            }
        
        int readProgress = (pagesRead * 100) / totalPages;
        int daysLeft = totalDays-daysReading;
        int pagesRate = (totalPages-pagesRead)/daysLeft;
        
        System.out.println("You have read " + readProgress +"% of the book");
        System.out.println("You have " + daysLeft +" days remaining to finish the book");
        System.out.println("You should read " + pagesRate +" pages per day");
        
        
    }

}
