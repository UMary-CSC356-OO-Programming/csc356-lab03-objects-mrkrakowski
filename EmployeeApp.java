import java.util.Scanner;

class Employee
{
    /* Task 3B: Add instance variables */
    private String firstName, lastName;
    private int employeeId;
    private double salary;

    /* Task 3C: Add three constructors */
    public Employee()
    {
    }

    ;

    public Employee( String last, String first )
    {
        this.lastName = last;
        this.firstName = first;
    }

    public Employee( String last, String first, double wage )
    {
        this.lastName = last;
        this.firstName = first;
        this.salary = wage;
    }

    public Employee( String last, String first, int id, double wage )
    {
        this.lastName = last;
        this.firstName = first;
        this.employeeId = id;
        this.salary = wage;
    }

    public String getFirstName()
    {
        return this.firstName;
    }

    /* Task 3D: Add set (mutator) and get (accessor) methods */
    public void setFirstName( String fName )
    {
        this.firstName = fName;
    }

    public String getLastName()
    {
        return this.lastName;
    }

    public void setLastName( String lName )
    {
        this.lastName = lName;
    }

    public int getEmployeeId()
    {
        return this.employeeId;
    }

    public void setEmployeeId( int id )
    {
        this.employeeId = id;
    }

    public double getSalary()
    {
        return this.salary;
    }

    public void setSalary( double wage )
    {
        this.salary = ( wage > 0 ) ? wage : 0.0;
    }

    /* Task 3F: Add toString method */
    public String toString()
    {
        return "Full name  : " + this.firstName + " " + this.lastName +
                "\nEmployee ID: " + this.employeeId +
                "\nSalary     : " + this.salary;
    }

    public Boolean equals( String name )
    {
        return name.equals( this.lastName );
    }

    ;

    /* Task 3G: Add equals method */

}


public class EmployeeApp
{
    public static final int MAX_EMPLOYEES = 5;

    public static void main( String[] args )
    {
        Scanner keyboard = new Scanner( System.in );
        Employee[] employees = new Employee[ MAX_EMPLOYEES ];
        Employee currentEmployee;
        String inputString;
        int inputInt;
        double inputDouble;
        char choice;
        int empCount = 0;

        employees[ empCount++ ] = new Employee( "Mitchum", "Robert", 120402, 34000.0 );
        employees[ empCount++ ] = new Employee( "Ryan", "Cornelius" );
        employees[ empCount++ ] = new Employee( "Asimov", "Isaac" );

        do
        {
            System.out.println( "\n   Enter Selection\n   ===============" );
            System.out.println( "A> Add new Employee" );
            System.out.println( "E> Edit Employee" );
            System.out.println( "L> List Employees" );
            System.out.println( "Q> Quit" );
            System.out.print( "   Select: " );
            inputString = keyboard.nextLine();
            choice = inputString.toUpperCase().charAt( 0 );
            System.out.println();

            switch( choice )
            {
                case 'A':
                    if( empCount < MAX_EMPLOYEES - 1 )
                    {
                        // Create object for new Employee
                        employees[ empCount ] = new Employee();

                        // Task 3E: Prompt for user information and set the object
                        // parameters via the mutator methods
                        System.out.print( "Input first name : " );
                        inputString = keyboard.nextLine();
                        employees[ empCount ].setFirstName( inputString );

                        System.out.print( "Input last name  : " );
                        inputString = keyboard.nextLine();
                        employees[ empCount ].setLastName( inputString );

                        System.out.print( "Input employee ID: " );
                        inputInt = keyboard.nextInt();
                        employees[ empCount ].setEmployeeId( inputInt );

                        System.out.print( "Input salary     : " );
                        inputDouble = keyboard.nextDouble();
                        employees[ empCount ].setSalary( inputDouble );

                        empCount++;
                    }
                    keyboard.nextLine();
                    break;

                case 'E':
                    System.out.print( "Enter Last Name of Employee to Edit: " );
                    inputString = keyboard.nextLine();
                    for( int lp = 0; lp < MAX_EMPLOYEES; lp++ )
                    {
                        // Verify that the employee entry has been allocated before Editing
                        if( employees[ lp ] != null )
                        {
                            if( employees[ lp ].equals( inputString ) )
                            {
                                System.out.print( "Enter Employee ID    : " );
                                inputInt = keyboard.nextInt();
                                employees[ lp ].setEmployeeId( inputInt );

                                System.out.print( "Enter Employee Salary: " );
                                inputDouble = keyboard.nextDouble();
                                employees[ lp ].setSalary( inputDouble );

                                keyboard.nextLine();
                            }
                        }
                    }
                    break;

                case 'L':
                    for( int lp = 0; lp < MAX_EMPLOYEES; lp++ )
                    {
                        if( employees[ lp ] != null )
                        {

                            System.out.println( employees[ lp ].toString() );
                        }
                    }
                    break;
            }
            keyboard.reset();
        } while( choice != 'Q' );
    }
}
