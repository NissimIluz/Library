
public class Tester {
        public static void main(String[] args) {
        Book b1 = new Book("Pride and Prejudice" , "Jane Austen" , 1813 , 350);
        Book b2 = new Book("Harry Potter and the sorcerer's stone" , "J.K.Rowling" , 1997 , 309);
        Book b3 = new Book("Pride and Prejudice" , "Jane Austen" , 1813 , 350);
        Book b4 = new Book("Harry Potter and the sorcerer's stone" , "J.K.Rowling" , 1997 ,309 );
        Book b5 = new Book("The sun is also a star" , "Nicola Yoon" , 2016 , 340);

        Library lib = new Library();
        if (lib.addBook(b1)) {
            System.out.println(" OK to add a book");
        } else {
            System.out.println(" Fail to add a book - fix this method befor continue ...");
            return;
        }
        lib.addBook(b2);
        lib.addBook(b3);
        lib.addBook(b4);
        lib.addBook(b5);
        System.out.println("\n try toString:\n" + lib);
        
        int bor = lib.howManyBooksBorrowed();
        System.out.println("\n num of borrowed book = " + bor + "  expected 0");
        
        Book tmp = lib.remove("Pride and Prejudice");
        tmp.borrowBook("Yossi", new Date(1, 1, 2018));
        System.out.println("\n after remove first \"Pride and Prejudice\" copy - the library is: (expected 4 books)\n" + lib);
        
        lib.addBook(tmp);
        tmp = lib.remove("Harry Potter and the sorcerer's stone");
        tmp.borrowBook("Yossi", new Date(1, 1, 2018));
        lib.addBook(tmp);

        bor = lib.howManyBooksBorrowed();
        System.out.println("\n num of borrowed after Yossi borrowed 2 books = " + bor + "  expected 2");
        
        bor = lib.howManyBooksBorrowedToStudent("Yossi");
        System.out.println("\n howManyBooksBorrowedToStudent Yossi =" + bor + "  expected=" + 2);
        
        lib.addBook(b1);
        String pop = lib.mostPopularAuthor();
        System.out.println("\n mostPopularAuthor=" + pop + " expected=Jane Austen");
        
        Book old = lib.oldestBook();
        System.out.println("\n oldesBook = " + old + "  expected= Pride and Prejudice");
        
        lib.removeBook(b1);
        System.out.println("\n after remove all \"Pride and Prejudice\" books - the library should contained 3 books:\n" + lib);

        System.out.println("\nhow many books borrowed: " + lib.howManyBooksBorrowed() + ", expected= 1");
        bor = lib.howManyBooksBorrowedToStudent("Yossi");
        System.out.println("\nhowManyBooksBorrowedToStudent Yossi =" + bor + "  expected=" + "1 (because \"Pride and Prejudice\" has been removed)");
        
        System.out.println("\n#################################################\n");
        
        System.out.println("\nRemoving all of \"" + b2.getTitle() + "\" copies from the library..");
        lib.removeBook(b2);
        old = lib.oldestBook();
        pop = lib.mostPopularAuthor();
        System.out.println("\tAfter removed all of \"" + b2.getTitle() + "\" books - the library should contain 1 book:\n" + lib);
        System.out.println("\n\tThe oldest book = " + old + ",  expected= The sun is also a star");
        System.out.println("\tMost popular author is: " + pop + ",  expected= Nicola Yoon");
        System.out.println("\tHow many books borrowed: " + lib.howManyBooksBorrowed() + ", expected= 0");
        
        System.out.println("\n#################################################\n");
        
        System.out.println("*This one checks the results of the methods when the library is empty*");
        System.out.println("\nRemoving \"" + b5.getTitle() + "\" book...");
        lib.removeBook(b5);
        old = lib.oldestBook();
        pop = lib.mostPopularAuthor();
        bor = lib.howManyBooksBorrowedToStudent("Yossi");
        System.out.println("\n\tAfter removed all of \"" + b5.getTitle() + "\" books - the library should contain 0 books:\n" + lib);
        System.out.println("\n\tThe oldest book = " + old + ",  expected= null");
        System.out.println("\tThe most popular author is: " + pop + ",  expected= null");
        System.out.println("\tYossi has borrowed " + bor + " books, expected= 0");
        System.out.println("\tHow many books borrowed: " + lib.howManyBooksBorrowed() + ", expected= 0");
        
        System.out.println("\n#################################################\n");
        
        System.out.println("*This one checks for run-time errors when trying to remove books from an empty library*");
        System.out.println("\nRemoving \"" + b5.getTitle() + "\" book with the method \"removeBook\"...");
        lib.removeBook(b5);
        System.out.println("\n\tIf you see this massage, there were no run-time errors");
        System.out.println ("\nRemoving \"" + b5.getTitle() + "\" book with the method \"remove\"...");
        tmp = lib.remove("The sun is also a star");
        System.out.println("\n\tIf you see this massage, there were no run-time errors");
        
        System.out.println("\n#################################################\n");
        
        System.out.println("*This one checks what happens when adding more than 200 books*");
        System.out.println("\nAdding 300 copies of \"" + b1.getTitle() + "\" book to the library...");
        boolean check = false;
        int count = 0;
        for(int i = 0; i < 300; i++)
        {
            check = lib.addBook(b1);
            if (check == true)
                count++;
        }
        System.out.println("\n\tafter adding 300 books, the library should contain 200 books only, your library has: " + count + " books");
        pop = lib.mostPopularAuthor();
        System.out.println("\tmost popular author is: " + pop + ",  expected= " + b1.getAuthor());
        System.out.println("\n#################################################\n");
        
        System.out.println("*This one checks the result of the method \"mostPopularAuthor\" when the library has an equal number of books*");
        System.out.println("\nRemoving all of the books from the library...");
        lib.removeBook(b1);
        System.out.println("\nAdding 100 copies of \"" + b1.getTitle() + "\" and adding 100 copies of \"" + b2.getTitle() + "\"...");
        count = 0;
        for(int i = 0; i < 100; i++)
        {
            check = lib.addBook(b1);
            if (check == true)
                count++;
            check = lib.addBook(b2);
            if (check == true)
                count++;
        }
        pop = lib.mostPopularAuthor();
        System.out.println("\tMost popular author is: " + pop + ",  expected= " + b1.getAuthor() + " (because \"" + b1.getAuthor() + "\" is the first one in the array)");
        System.out.println("\nRemoving the first copy of \"" + b1.getTitle() + "\" and checks who is the most popular author");
        tmp = lib.remove(b1.getTitle());
        pop = lib.mostPopularAuthor();
        System.out.println("\tMost popular author is: " + pop + ",  expected= " + b2.getAuthor() + " (because \"" + b1.getTitle() + "\" has 1 less copy than \"" +  b2.getTitle() + "\")");
        System.out.println("\n#################################################\n");
        
        System.out.println("*This one checks the result of the method \"remove\" when trying to remove 1 book that is in the last cell of the array*");
        System.out.println("\nRemoving all of the books from the library...");
        lib.removeBook(b1);
        lib.removeBook(b2);
        pop = lib.mostPopularAuthor();
        System.out.println("\tMost popular author is: " + pop + ",  expected= null (that means that there are no books in the library, and the removal process has been succeeded)");
        System.out.println("\nAdding 199 copies of \"" + b2.getTitle() + "\" and adding 1 copy of \"" + b1.getTitle() + "\"...");
        count = 0;
        for(int i = 0; i < 199; i++)
        {
            check = lib.addBook(b2);
            if (check == true)
                count++;
        }
        check = lib.addBook(b1);
        if (check == true)
            count++;
        System.out.println("\n\tafter adding 200 books, the library should contain 200 books only, your library has: " + count + " books");
        old = lib.oldestBook();
        System.out.println("\n\tThe oldest book = " + old + ",  expected= " + b1.getTitle());
        System.out.println ("\nRemoving \"" + b1.getTitle() + "\" book with the method \"remove\"...");
        tmp = lib.remove(b1.getTitle());
        old = lib.oldestBook();
        System.out.println("\n\tAfter removing the only copy of " + b1.getTitle() + ", The oldest book is = " + old + ",  expected= " + b2.getTitle() + 
        "\n\t(that means, as long as the method \"oldestBook\" is working fine, that the removal proccess of the last book has been succeeded)");
        System.out.println("\n#################################################\n");
    }
}
