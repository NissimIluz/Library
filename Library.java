
/**
 * This class represents a Library object
 *
 * @author Nisim eiloz
 * @version 1 
 */
public class Library
{
    private Book [] lib;
    private int _noOfBooks;

    private final int MAX_BOOKS=200;
    private final int MIN_BOOKS=0;
    /**
     * Constructor for objects of class Library
     * Size of the array,  the optional numbers of books in the Library,= MAX_BOOKS=200
     * The number of books in the library =0
     */
    public Library()
    {
        lib = new Book [MAX_BOOKS];
        _noOfBooks= MIN_BOOKS;
    }

    /**
     * The method get a book and add the book to the first empty place in the array.
     * 
     * @param b book (an object of class Book) to add to the Library
     * @return true if the add is succeeded, false if not (in case thet the book is null or there is no room in the object)
     */
    public boolean addBook (Book b){
        final int EMPYY_PLACE =(_noOfBooks);

        if(b!=null && EMPYY_PLACE<MAX_BOOKS) { // if EMPYY_PLACE= MAX_BOOKS so there is no place in the array
            _noOfBooks++;
            lib[EMPYY_PLACE]=new Book(b); //for prevent aliasing 

            return true;
        }
        return false;
    }

    /**
     * 
     * The method get book and removok all the book in the Library thet equals to this book
     * 
     * @param b book (an object of class Book) to delete from the Library
     * 
     */
    public void removeBook (Book b) {
        int i,j;
        if(b!=null) { //the book to for comparison isn't null
            for (i=0; i<_noOfBooks; i++) {  /* if the library is empty (_noOfBooks=0) no entry to this loop, if the library is empty
                 * ther is no books to remove */
                if( lib[i].equals(b)) {  

                    /* if the book in place (i+1) equal to the delete book, we replace the latest book to place (i+1) 
                     * (in an doing so we remove the book in the place (i+1)) ) and setting the latest book the null.
                     * 
                     * but first we need to check whatever the latest book is equals too to the book to delete.
                     * if so we setting the latest book to null and checking the new latest book.
                     * if not we replacements the latest book place to place and setting the latest book to null.
                     */
                    for(j=(_noOfBooks-1);j>=i;j--) { 
                        if(lib[j].equals(b)) {
                            lib[j]=null;
                            _noOfBooks--;
                        }
                        else { // the latest book isn't equals to deleste book
                            RemovalAndIncitement(i,j);
                            break;
                        } //The end of the second if - (lib[j].equals(b)) latest book equals to deleste book

                    } // The end of the second loop
                } //The end of the first if ( lib[i].equals(b)) book in place (i+1) equals to deleste book
            }  //The end of first loop
        } //The end of if(b!=null)
    } //End of the method

    /** 
     * The method count how many books are borrowed
     * 
     * @return the number of book that borrowed
     */
    public int howManyBooksBorrowed () {
        int count=0;
        for (int i=0; i<_noOfBooks; i++) {
            if(lib[i].getBorrowed())  {
                count++;   
            }
        }
        return count;
    }

    /** 
     * The method got a student name and count how many books are borrowing to a student with this name
     * 
     * @param name the student name to count
     * @return the number of book that borrowed to a student with this name
     */
    public int howManyBooksBorrowedToStudent (String name) {
        int count=0;
        for (int i=0; i<_noOfBooks; i++) {
            if(lib[i].getBorrowed())  {
                if((lib[i].getStudentName()).equals(name)) {
                    count++; 
                }
            }
        } //The end of the loop
        return count;  
    }

    /** 
     * The method finds the first Author name that has the most books in the library
     * 
     * 
     * @return the firs name of the author withe the most book in the library. if the library is empty return null.
     */
    public String mostPopularAuthor() {
        int max=0, mostPopularIndex=0;
        int i,j;

        String nameForCheck1;
        int [] counter= new int [_noOfBooks]; // counter in any place = 0

        if(_noOfBooks==0){ //the library is empty
            return null;
        }

        /*This nested loop get two books.
         * the author name of the first book then comparison to the author name of the secaned book. 
         * 
         * if this name are equals 1 add to counter in the place thet is the same as a place thet book 2
         * (book 2 Without any special reason as long as it is for all books)
         * 
         * 
         * In the end we get an array of integers that represents the number of times each author's name appears.
         * This number save in the same place as book's i with this author's name
         *
         * Of course, every author who appears more than once goes through a number of cells, equal to the number of times it appears,
         * containing the number of nations it appears
         */
        for(i=0; i<_noOfBooks;i++) { //loop for name 1
            nameForCheck1=lib[i].getAuthor();
            for(j=0; j<_noOfBooks;j++) { //loop for name 2
                if(nameForCheck1.equals(lib[j].getAuthor())) {
                    counter[j]++;
                }
            } // end of loop for name 2
        } // end of loop for name 1

        /* this loop chack who is the hgiest integers in the array.
         * In the end we get the index of the higest integers.
         */
        for(i=0; i<counter.length;i++) {  //this loop check what is the (first) high number in counters
            if(counter[i]>max) {
                max=counter[i];
                mostPopularIndex=i;
            }
        } //

        return (lib[mostPopularIndex].getAuthor());
    } //End of mothed

    /** 
     * The method return the oldest book in the library
     * 
     * 
     * @return the firs oldest the oldest book in the library, if the library is empty retutn null
     */
    public Book oldestBook() {
        Book oldest;
        if(_noOfBooks==MIN_BOOKS){
            return null;
        }

        //In order not to overload the program we performed aliasing. But the value that comes out is a new object 
        oldest=(lib[0]);
        for(int i=1;i<_noOfBooks;i++) {
            if(lib[i].olderBook (oldest)) {
                oldest=lib[i];
            }
        }
        return new Book(oldest); //not aliasing
    }

    /** 
     * The method remove the first book with same name as input name
     * 
     * @param name the Name of book to remove 
     * @return the book that has been removed, if there isn't book with same name return null
     */
    public Book remove(String name) {

        for (int i=0; i<_noOfBooks; i++) {
            if((lib[i].getTitle()).equals(name)) {
                Book same =new Book(lib[i]);
                RemovalAndIncitement(i,(_noOfBooks-1));
                return (same);
            }
        }
        return null;
    }

    /** 
     * The method create a string the represent the library
     * 
     * @return a String with a title end all of this detals of all books in the library: Title, Author,Year,pages. 
     */
    public String toString() {
        String s="The books in the library are:\n";;
        for(int i=0; i<_noOfBooks;i++) {
            s=s+(lib[i].toString());
            s+="\n";
        }
        return s;
    }

    /* replace the book in j palce to place i.
     * set the book is place j to nell
     */
    private void RemovalAndIncitement(int i, int j) {
        lib[i]=lib[j];
        lib[j]=null;
        _noOfBooks--;
    }

}