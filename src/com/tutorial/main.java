package com.tutorial;

import java.util.ArrayList;
import java.util.Scanner;

class Book { 

  private String title;
  private int releaseDate;
  private String author;
  
  public Book (String title, String author, int releaseDate){
    this.title = title;
    this.author = author;
    this.releaseDate = releaseDate;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public int getReleaseDate() {
    return releaseDate;
  }

  public void setReleaseDate(int releaseDate) {
    this.releaseDate = releaseDate;
  }

  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public void printBook(){
    System.out.println("- BOOK INFORMATION - ");
    System.out.println("Title       \t: "+this.title);
    System.out.println("Author      \t: "+this.author);
    System.out.println("Release Date \t: "+this.releaseDate);
  }

}

class Library {
  private ArrayList<Book> bookCollection;

  public Library (){
    bookCollection = new ArrayList<>();
  }

  public void addBook(Book book){
    bookCollection.add(book);
  }

  public void removeBook(Book book){
    bookCollection.remove(book);
  }

  public void showAllBook(){
    if (bookCollection.isEmpty()){
      System.out.println("\nThere is no Book in here..");
    } else {
      for (Book book : bookCollection){
        System.out.println("\nTitle     \t: " + book.getTitle());
        System.out.println("Author    \t: " + book.getAuthor());
        System.out.println("Release Date \t: " + book.getReleaseDate());
      }
    }
  }

  public Book findBook(String title){
    for(Book book : bookCollection){
      if (book.getTitle().equalsIgnoreCase(title)) {
        return book;
      }
    }
    return null;
  }

  public boolean isEmpty() {
    return bookCollection.isEmpty();
  }

}


public class main {
  public static void main(String[] args) {

    Library lailLibrary = new Library(); 
    Scanner scanner = new Scanner(System.in);
    int input;

    do{
      System.out.println("LIBRARY MANAGEMENT SYSTEM");
      System.out.println("1. Add Book");
      System.out.println("2. Remove Book");
      System.out.println("3. Show All Books");
      System.out.println("4. Search for Books by Title");
      System.out.println("5. Change Book Information");
      System.out.println("6. Quit");
      System.out.print("Select option: ");
      input = scanner.nextInt();
      scanner.nextLine();

      switch(input){
        case 1:
        System.out.print("Input Title: ");
        String title = scanner.nextLine();
        System.out.print("Input Author: ");
        String author = scanner.nextLine();
        System.out.print("Input Release Date: ");
        int releaseDate = scanner.nextInt();
        scanner.nextLine();

        Book book1 = new Book(title, author, releaseDate);
        lailLibrary.addBook(book1);
        System.out.println("book added!");
        break;

        case 2:
        if (lailLibrary.isEmpty()){
          System.out.println("\nEmpty.. no books to delete");
          break;
        } else {
          System.out.print("Enter the title of the book you want to remove : ");
          String titleBookDeleted = scanner.nextLine();
          Book foundedBookDlt = lailLibrary.findBook(titleBookDeleted);
          if (foundedBookDlt != null){
            lailLibrary.removeBook(foundedBookDlt);
            System.out.println(titleBookDeleted + " book has been removed.");
            break;
          } else {
            System.out.println("\nThere is no book with " + titleBookDeleted + " title found.");
          }
          break;
          
        }


        case 3:
        System.out.println("List of Books in the Lail's Library:");
        lailLibrary.showAllBook();
        break;

        case 4:
        System.out.print("Enter the title of the book you are looking for: ");
        String titleBookSearched = scanner.nextLine();
        Book foundedBookSrc = lailLibrary.findBook(titleBookSearched);
        if (foundedBookSrc != null){
          System.out.println("\nBook founded!");
          System.out.println("Title     \t: " + foundedBookSrc.getTitle());
          System.out.println("Author    \t: " + foundedBookSrc.getAuthor());
          System.out.println("Release Date \t: " + foundedBookSrc.getReleaseDate());

        } else {
          System.out.println("\nno book with " + titleBookSearched + " title found.");
        }
        break;

        case 6:
        System.out.println("\nQuiting...");
        break;

        case 5:
        System.out.print("Enter the title of the book you want to change : ");
        String titleBookChanged = scanner.nextLine();
        Book foundedBookChg = lailLibrary.findBook(titleBookChanged);
        if (foundedBookChg != null){
          System.out.println("\nBook founded!");
          System.out.println("Title     \t: " + foundedBookChg.getTitle());
          System.out.println("Author    \t: " + foundedBookChg.getAuthor());
          System.out.println("Release Date \t: " + foundedBookChg.getReleaseDate());
          System.out.println("1. Edit Title");
          System.out.println("2. Edit Author");
          System.out.println("3. Edit Release Date");
          System.out.print("Select what you want to change :");
          int input1 = scanner.nextInt();
          scanner.nextLine();

          switch (input1) {
            case 1:
                System.out.print("Input new Title: ");
                String newTitle = scanner.nextLine();
                foundedBookChg.setTitle(newTitle);
                System.out.println("Title Changed!");
                break;
            case 2:
                System.out.print("Input new Author: ");
                String newAuthor = scanner.nextLine();
                foundedBookChg.setAuthor(newAuthor);
                System.out.println("Author Changed!");
                break;
            case 3:
                System.out.print("Input new Release Date: ");
                int newReleaseDate = scanner.nextInt();
                scanner.nextLine();  // Membersihkan buffer setelah nextInt
                foundedBookChg.setReleaseDate(newReleaseDate);
                System.out.println("Release Date Changed!");
                break;
            default:
                System.out.println("Invalid selection.");
                break;
        }
        } else {
          System.out.println("\nno book with " + titleBookChanged + " title found.");
        }
        break;

        default:
        System.out.println("Invalid Input... Try again!");
      }

      System.out.println();
    } while (input != 6);

    scanner.close();
  }
  
}
