
/**
 * This class represents a Date object
 *
 * @author Nisim eiloz
 */
public class Date
{

    private int _day;
    private int _month;
    private int _year;

    private final int _DEFAUL_DAY_AND_MONTH=1;
    private final int _DEFAUL_YEAR=2000;

    private final int MAX_MONTH=12;
    private final int MIN_DATE =0;
    final int MAX_DAY_IN_MONTH =31;
    final int MAX_FEBUARY_DAY =29;
    /**
     * Constructor for new objects of class Date
     * creates a new Date object if the date is valid, otherwise creates the date 1/1/2000
     * @param _day the day in the month(1-31)
     * @param _month the month in the year
     * @param _year the year (in 4 digits) 
     */
    public Date(int day, int month, int year)
    {

        if(dateChecker(day, month, year)) {
            _day=day;
            _month=month;
            _year=year;
        } //end of if

        else {
            _day=_DEFAUL_DAY_AND_MONTH;
            _month=_DEFAUL_DAY_AND_MONTH;
            _year=_DEFAUL_YEAR;
        } //end of else
    } //end of the Constructor

    /**
     * Copy constructor for objects of class Date
     * creates a new Date object based on another object
     * @param date to be copy
     */
    public Date(Date other) {
        if(other!=null) {
            this._day=other._day;
            this._month=other._month;
            this._year= other. _year;
        }
    } //end of the copy constructor

    /**
     * gets the day
     * @return _day the day in the date
     */
    public int getDay() {
        return _day;
    }

    /**
     * gets the month
     * @return _month the month in the date
     */
    public int getMonth() {
        return _month;
    }

    /** 
     * gets the year
     * @return _year the year in the date
     */
    public int getYear() {
        return _year;
    }

    /** 
     * sets the day (only if date remains valid)
     * @param  dayToSet the value to be sett
     */
    public void setDay(int dayToSet) {
        if(dateChecker(dayToSet,getMonth(),getYear())) {
            _day= dayToSet;
        }
        // The only way because the number of days in a month depends on the month and year (in February)

    }

    /** 
     * set the month (only if date remains valid)
     * @param monthToSet the value to be set
     */
    public void setMonth(int monthToSet) {
        if(dateChecker(getDay(),monthToSet,getYear())) {
            _month = monthToSet;
        }

    }

    /** 
     * sets the year (only if date remains valid)
     *  @param monthToSet the value to be set
     */
    public void setYear(int yearToSet){
        if(dateChecker(getDay(),getMonth(),yearToSet)) {
            _year= yearToSet;
        }
    }

    /** 
     * Checks whether the two dates are equal
     *  @param other other date
     *  @return true for equals, fals for nor equals
     */
    public boolean equals (Date other){
        if( this.getDay()==other.getDay() && this.getMonth()==other.getMonth() && this.getYear()==other.getYear())  {
            return true;
        }
        return false;
    }

    /** 
     * check if this date is before other date
     * @param other the given date
     * @retun true iff this date comes before the other date
     */
    public boolean before (Date other){
        int thisYear=this.getYear();
        int thisMonth=this.getMonth();
        
        int year=other.getYear();
        int month=other.getMonth();


        if( thisYear<year) {
            return true; 
        }
        else {
            if(thisYear==year &&  thisMonth<month) {
                return true; 
            }
            else{
                if (thisMonth==month && this.getDay()< other.getDay()) {
                    return true; 
                }
            } //end of if  (this._year==other._year &&  this._month<other._month)
        } // end of if( this._year<other._year) 
        return false;

    } //end of the method before

    /** 
     * check if this date is after other date
     * @param other the given date
     * @retun true if this date is after other date
     */
    public boolean after (Date other){
        return other.before(this);
    }

    /** 
     * calculates the difference in days between two dates
     * @param other other date
     * @return the Absolute value difference
     */
    public int difference(Date other) {
        final double NUM_OF_DAY_IN_YEAR=365.25;
        double differenceYear;
        int differenceMonths, difference;

        differenceYear = (double)(this.getYear()-other.getYear())*NUM_OF_DAY_IN_YEAR;
        differenceMonths= sumOfDayUntilMonth(this.getMonth(),this.getYear())  -  sumOfDayUntilMonth(other.getMonth(),other.getYear());
        difference =  this.getDay()-other.getDay();

        differenceYear= Math.round(differenceYear);

        difference= difference+differenceMonths+(int)differenceYear;
        return Math.abs(difference);
    }

    /**
     * @return a String that represents this date
     */
    public String toString() {
        return (getDay()+"/"+getMonth()+"/"+getYear());
    }

    /**
     * calculate the day of the week that this date occurs on 0-Saturday 1-Sunday 2-Monday etc.
     * @return nuber for day (0 for Saturday)
     */
    public int dayInWeek() {
        final int FOR_TWE_DIGITS=100;
        final int TWENTY_SIX= 26;
        final int TEN= 10;
        final int TWE= 2;
        final int MOD= 7;
        

        int dayInWeek;
        int day=getDay();
        int effectiveManth=getMonth();
        int effectiveYear= getYear();

        if(effectiveManth<3) {
            effectiveManth+=MAX_MONTH;
            effectiveYear--;
        }

        int LatestTweNumberOfYear= effectiveYear%FOR_TWE_DIGITS;
        int firstTweNumberOfYear = effectiveYear/FOR_TWE_DIGITS;

        dayInWeek = (int)(getDay() + (TWENTY_SIX*(effectiveManth+1))/TEN +LatestTweNumberOfYear + LatestTweNumberOfYear/(TWE*TWE) + firstTweNumberOfYear/(TWE*TWE) - TWE*firstTweNumberOfYear);
        dayInWeek=dayInWeek%MOD;
        return (Math.floorMod(dayInWeek,MOD));
    }

    /* The method checks whether the date entered is possible
    return true if the date is possible and false if not
     */
    private boolean dateChecker (int day, int month, int year) {

        if(year>MIN_DATE) {
            if (day>MIN_DATE) {
                switch (month) {
                    case 1:
                    case 3:
                    case 5:
                    case 7:
                    case 8:
                    case 10:
                    case 12:
                    if(day<=MAX_DAY_IN_MONTH) {
                        return true;
                    }
                    break;

                    case 4:
                    case 6:
                    case 9:
                    case 11:
                    if(day<MAX_DAY_IN_MONTH) {
                        return true;
                    }
                    break;

                    case 2:
                    if(leap(year)) {
                        if(day<=MAX_FEBUARY_DAY){
                            return true; 
                        }
                    }
                    else {
                        if(day<MAX_FEBUARY_DAY)
                            return true;
                    }
                    break;

                    default: // in case that month is not between 1-12 
                    return false;
                } //switch  
            } // end of if(day>MIN_DATE)
        }  // end of if((year>0)
        return false;
    } // end of the method dateChecker

    /* The method return true if the year is a leap year
     * (and then there are 29 days in February)  ,another false
     */  
    private boolean leap (int y) {
        return (y % 4 == 0 && y % 100 != 0) || (y % 400 == 0);
    }

    /* The method return the number of day until this month does not include this month
     */
    private int sumOfDayUntilMonth(int month, int year) {
        int sum=0;

        month--;
        switch (month) {
            case 12 : 
            sum=sum+MAX_DAY_IN_MONTH;
            case 11 :
            sum=sum+(MAX_DAY_IN_MONTH-1);
            case 10 :
            sum=sum+MAX_DAY_IN_MONTH;
            case 9 :
            sum=sum+(MAX_DAY_IN_MONTH-1);
            case 8 :
            sum=sum+MAX_DAY_IN_MONTH;
            case 7 :
            sum=sum+MAX_DAY_IN_MONTH;
            case 6 :
            sum=sum+(MAX_DAY_IN_MONTH-1);
            case 5 :
            sum=sum+MAX_DAY_IN_MONTH;    
            case 4 :
            sum=sum+(MAX_DAY_IN_MONTH-1);
            case 3 :
            sum=sum+MAX_DAY_IN_MONTH;
            case 2 :
            if(leap(year)) {
                sum=sum+MAX_FEBUARY_DAY;
            }
            else {
                sum=sum+(MAX_FEBUARY_DAY-1);
            }
            case 1 :
            sum=sum+MAX_DAY_IN_MONTH;
        } // end of switch

        return sum;
    } // end of the method sunOfDayUntilMonth
} //end of the class
