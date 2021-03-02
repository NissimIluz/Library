
/**
 * This class represents a Date object
 *
 * @author Nisim eiloz
 */
public class Book
{
    // instance variables - replace the example below with your own
    private String _title;
    private String _author;
    private int _yearPublished;
    private int _noOfPages;
    private boolean _borrowed;
    private String _studentName;
    private Date _borrowedDate;
    private Date _returnDate;

    private final int MAX_DAYS=30;
    private final int FINE_PER_DAY=5;

    private final int DEFAUL_NUM_OF_PAGE=1;
    private final int DEFAUL_YEAR_OF_PUBLISHED=2000;

    /**
     * Constructor for objects of class Book
     * creator a new Book object
     * @param _title the title of the book
     * @param _author the autor name
     * @param _yearPublished the year thet to book published
     * @param _noOfPages the number of pages on the book
     * @param _borrowed (_borrowed=false) a boolaen virbale true for yes false for no
     * @param  _borrowedDate =null. the borrowe date
     * @param _returnDate =null. the return date
     */
    public Book(String title, String author, int year, int num) {
        _title=title;
        _author=author;
        if(yearPublishedChecker(year))
        {
            _yearPublished=year;
        } 
        else {
            _yearPublished=DEFAUL_YEAR_OF_PUBLISHED;
        }

        if(numOfPagesChecker(num)) {
            _noOfPages=num;
        }
        else {
            _noOfPages=DEFAUL_NUM_OF_PAGE;
        }

        _borrowed=false;

        //The rest of the entries start with null automatic

    }

    /**
     * Copy constructor for objects of class Date
     * creates a new Book object based on another object
     * @parm other book
     */
    public Book(Book other){
        this._title=other._title;
        this._author=other._author;
        this._yearPublished= other. _yearPublished;
        this._noOfPages=other._noOfPages;
        this._borrowed=other._borrowed;
        this._studentName=other._studentName;

        if(_borrowedDate!=null) {
            this._borrowedDate=new Date (other._borrowedDate);
        }
        if(_returnDate!=null) {
            this._returnDate=new Date (other._returnDate);
        }

    } //end of the copy constructor

    /**
     * @return _title the book title.
     */
    public String getTitle() {
        return _title;
    }

    /**
     * @return _author the book author.
     */
    public String getAuthor() {
        return _author;
    }

    /** 
     * @return _yearPublished the year the book was published.
     */
    public int  getYear() {
        return _yearPublished;
    }

    /** 
     * @return the book number of pages.
     */
    public int getPages() {
        return _noOfPages;
    }

    /** 
     * @return true if the book is borrowed; false otherwise.
     */
    public boolean getBorrowed() {
        return _borrowed;
    }

    /** 
     * @return the student name.
     */
    public String getStudentName() {
        return _studentName;
    }

    /**
     * @return  a new objects of book class which is identical to borrowe date
     */   
    public Date getBorrowedDate() {
        return new Date(_borrowedDate);
    }

    /**
     * @return  a new objects of book class which is identical to return date
     */
    public Date getReturnDate() {
        return new Date(_returnDate);
    }

    /**
     * set the book title.
     * @param s  the new book title String to be set
     */
    public void setTitle(String s) {
        _title=s;
    }

    /**
     * set the book author.
     * @param s  the new book author String to be set
     */

    public void setAuthor(String s) {
        _author=s;
    }

    /** 
     * set the year the book was published.
     * @param n  the book published year to be set
     */

    public void setYear(int n) {
        if(numOfPagesChecker(n)) {
            _yearPublished=n;
        }
    }

    /** 
     * set the book number of pages.
     * @param n  the book pages to be set
     */
    public void setPages(int n) {
        if(numOfPagesChecker(n)) {
            _noOfPages=n;
        }
    }

    /** 
     * set true if the book is borrowed; false otherwise.
     * @param newBorrowed the new vailo
     */
    public void setBorrowed(boolean newBorrowed) {
        _borrowed=newBorrowed;
    }

    /** 
     * set the student name.
     * @param newName
     */
    public void setStudentName(String newName) {
        _studentName=newName;
    }

    /**
     * Create a new object of date to be set the book
     * @param anther the new date
     */   
    public void setBorrowedDate(Date other) {
        _borrowedDate=new Date(other);

    }

    /**
     * Create a new object of date to be set the book
     * @param anther the new date of return date
     */
    public void setReturnDate(Date anther) {
        _returnDate= new Date(anther);

    }

    /**
     * The method checks whether two objects are the same
     * According to the Carthaginians:
     * the name of the book, the name of the author, the year of publishing Lurat, the number of pages
     *
     * @param other book to Comparison
     * @return    true for equals, false for not
     */
    public boolean equals (Book other) {

        // In order for the code to be readable, the code is written in this manner

        if((this.getTitle()).equals(other.getTitle())) 
        /* Comparison between two stirng 
         * Because the dynamic link will be activated the method for comparing two string
         * 
         */ {
            if((this.getAuthor()).equals(other.getAuthor())) { //same as above
                if(this.getYear()==other.getYear()  && this.getPages()==other.getPages()) {
                    return true;
                }
            }
        }// end of the firs if
        return false;
    }

    /**
     * @retur a string representation of this book. Title: Pride and Prejudice       Author: Jane Austen      Year: 1819, 318  pages 
     */
    public String toString() {
        return ("Title: "+getTitle()+"\t"+"Author: "+getAuthor()+"\tYear: "+getYear()+",  "+getPages()+" pages");
    }

    /**
     * Checks if this book is older than other book.
     * @prarm other the book to compare to
     * @return true if this book is older than other book; false otherwise
     */
    public boolean olderBook(Book other) {
        if( this.getYear() > other.getYear()) {
            return true;
        }
        return false;
    }

    /**
     * Checks if this book and other book have same author.
     * @param other - the book to compare to
     * @return true if this book and other book have same author; false otherwise
     */
    public boolean sameAuthor(Book other) {
        if( this.getAuthor().equals( other.getAuthor() ) ){
            return true;
        }
        return false;
    }

    /**
     * Gets student name and borrow date and updates the appropriate book attributes
     * @para name the mane of the student
     * @param d a borrow date
     */
    public void borrowBook (String name, Date d) {
        if(!(getBorrowed())) {
            setStudentName(name);
            setBorrowedDate(d);
            setBorrowed(true);
        }
    }

    /**
     * Gets return date and updates the appropriate book attributes.
     * @param d return date
     * @retrun true if student is late or book is not borrowed; false otherwise
     */
    public boolean returnBook (Date d) {
        boolean trueOrOfalse= true;
        if(getBorrowed( )){
            if(getBorrowedDate().difference(d)<=MAX_DAYS) {
                trueOrOfalse= false;
            }

            setReturnDate(d);
            setStudentName(null);
            setBorrowed(false);
        }
        return trueOrOfalse;
    }

    /**
     * Gets today's date and if book is borrowed returns how many days the book is borrowed; otherwise returns 0.
     * @param today today's date
     * @retrun how many days the book is borrowed
     */
    public int howLongBorrowed(Date today) {
        if(getBorrowedDate().after(today) || !(getBorrowed())) {
            return 0;
        }
        return getBorrowedDate().difference(today);
    }

    /**
     * Checks if book is available.
     * @param todat today date
     * @return false if the book is borrowed; otherwise if book is not borrowed returns false if today's day is Friday or Saturday; otherwise returns true
     */
    public boolean isAvailable (Date today) {
        if (getBorrowed()) {
            return false;
        }
        final int FRIDAY=6;
        final int SATURDAY=0;
        int dayInWeek=today.dayInWeek();
        if(dayInWeek==FRIDAY || dayInWeek ==SATURDAY) {
            return false;
        }
        return true;
    }

    /**
     * Computes penalty given return date.
     * @param d return date
     * @return penalty if book is borrowed and student is late; 0 otherwise.
     */
    public int computePenalty (Date d) {
        int numOfDay= howLongBorrowed(d);
        int fine =0;
        final int TWE=2;
        if(numOfDay>MAX_DAYS) {
            if(numOfDay>(TWE*MAX_DAYS)) {
                numOfDay=numOfDay - MAX_DAYS*TWE;
                fine= MAX_DAYS*FINE_PER_DAY+numOfDay*FINE_PER_DAY*TWE;
            }
            else {
                fine= (-MAX_DAYS+numOfDay)*FINE_PER_DAY;
            }
        }

        return fine;
    }

    /*
     * The method checks whether the value of the year is valid
     *  if yes, the method returns true. if not, the method returns fals
     */
    private boolean yearPublishedChecker(int year) {
        final int MIN_YEAR=1800;
        final int MAX_YEAR= 2018;

        if(year>=MIN_YEAR && year<=MAX_YEAR) {
            return true;
        }
        return false;
    }

    /*
     * The method checks whether the value of the number of pages is valid
     *  if yes, the method returns true. if not, the method returns fals
     */
    private boolean numOfPagesChecker(int num) {
        final int MIN_NUM_OF_PAGE=1;
        if(num>=MIN_NUM_OF_PAGE) {
            return true;
        }
        return false;
    }

}
