#include <stdio.h>                                                //standard input and output library
#include <string.h>                                               //standard library for strings
#include <stdlib.h>                                               //standard library to generate random numbers
#include <time.h>                                                 //standard library for time
#include <ctype.h>                                                //library to handle some String functions
#include <conio.h>                                                //library to handle getch and many functions
#include <windows.h>                                              //library to handle user interface(UI)
 

#define RED     "\x1b[31m"                                        // ANSI escape codes for text                                          
#define GREEN   "\x1b[32m"                                        // ANSI escape codes for text 
#define YELLOW  "\x1b[33m"                                        // ANSI escape codes for text 
#define RESET   "\x1b[0m"                                         // ANSI escape codes for text 
#define BLUE    "\x1b[34m"                                        // ANSI escape codes for text
#define MAGENTA "\x1b[35m"                                        // ANSI escape codes for text
#define CYAN    "\x1b[36m"                                        // ANSI escape codes for text
#define RESET   "\x1b[0m"                                         // ANSI escape codes for text
#define ENTER 13                                                  //defining the ASCII value of enter
#define TAB 9                                                     //defining the ASCII value of tab
#define BCKSPC 8                                                  //defining the ASCII value of Backspace


    char opt[50];
    short check = 0;
    short check0 = 0;
    short check1 = 0;
    short check2 = 0;
    short check3 = 0;
    short check4 = 0;

struct user{                                                       //Creating a struct for user information
        char fullName[50];
	char email[50];
	char password[50];
	char username[50];
	char phone[50];
        char bank[50];
};


void welcome();
void takeinput(char[]);                                              //function to take inputs
void takepassword(char []);                                          //function to take password
char generateUsername(char [],char []);                              //function to generate username 
int checkname(char []);                                              //function to check name
int checkemail(char []);                                             //function to check mail
int checkphone(char []);                                             //function to check phone
int checkbalance(char[]);                                            //function to check balance
int checkpass(char[]);                                               //function to check pass
void restaurant(void);                                               //function for different resturants
void types(char []);                                                 //function for different types of resturants
void dates(char []);                                                 //function to gererate different dates
void tables(char [],int);                                            //function for tables available
void menu(char [],int);                                              //function for menu


void main()
{                                                        
    system("color 0c");
    printf("      _   _       _       _  ______                               _   _             \n");
    printf("     | | | |     | |     | | | ___ \\                             | | (_)            \n");
    printf("     | |_| | ___ | |_ ___| | | |_/ /___  ___  ___ _ ____   ____ _| |_ _  ___  _ __  \n");
    printf("     |  _  |/ _ \\| __/ _ \\ | |    // _ \\/ __|/ _ \\ '__\\ \\ / / _` | __| |/ _ \\| '_ \\ \n");
    printf("     | | | | (_) | ||  __/ | | |\\ \\  __/\\__ \\  __/ |   \\ V / (_| | |_| | (_) | | | |\n");
    printf("     \\_| |_/\\___/ \\__\\___|_| \\_| \\_\\___||___/\\___|_|    \\_/ \\__,_|\\__|_|\\___/|_| |_|\n");
    printf("\n");
    system("pause");
    system("cls");

    system("color 0b");                                              //Change the colour of text to blue
    FILE *fp;                                                        //file pointer


    int usrFound = 0;                                                //variable to read options                 
    struct user user;                                                //variable user of type struct
    char password2[50];                                              //variable to confirm password
	
while (check == 0)
{    
 welcome();

if(!(strcmp(opt,"1"))) 
{                                                  
    // Clear the console and flush the standard input
	system("cls");
    fflush(stdin);

    // Prompt the user to enter their full name
    printf("\nEnter your full name:\t");
	takeinput(user.fullName);  // Function to scan the user's full name
    check0 = checkname(user.fullName);  // Check if the name is valid

    while (check0 >= 1)
    {
        // Display an error message for an invalid name and prompt the user to enter again
        printf("\nInvalid name\t\tHint:(Mr John Harry)\n\n");
        Beep(800, 300);
        printf("Enter your full name:\t");
        takeinput(user.fullName);
        check0 = checkname(user.fullName);
    }

    // Prompt the user to enter their email
    printf("Enter your email:\t");
    takeinput(user.email);  // Function to scan the user's email
    check1 = checkemail(user.email);  // Check if the email is valid
            
    while (check1 >= 1)
    {
        // Display an error message for an invalid email and prompt the user to enter again
        printf("\nInvalid Email.\t\tHint:(john123@gmail.com)\n\n");
        Beep(800, 300);
        printf("Enter your email:\t");     
        takeinput(user.email);
        check1 = checkemail(user.email);
    }
			
    // Prompt the user to enter their contact number
    printf("Enter your contact no:\t");
    takeinput(user.phone);  // Function to scan the user's phone number
    check2 = checkphone(user.phone);  // Check if the phone number is valid

    while (check2 >= 1)
    {
        // Display an error message for an invalid phone number and prompt the user to enter again
        printf("\nInvalid contact no.\t\tHint:(03XXXXXXXXX)\n\n");
        Beep(800, 300); 
        printf("Enter your contact no:\t");
        takeinput(user.phone);
        check2 = checkphone(user.phone);
    }

    // Prompt the user to enter their bank balance
    printf("Enter your balance(in $):\t");
    takeinput(user.bank);
    check3 = checkbalance(user.bank);  // Check if the balance is valid

    while (check3 >= 1)
    {
        // Display an error message for an invalid balance and prompt the user to enter again
        printf("\nInvalid currency or format\tHint:(65$)\n\n");
        Beep(800, 300);
        printf("Enter your balance(in $):\t");
        takeinput(user.bank);
        check3 = checkbalance(user.bank);
    }

    // Prompt the user to enter their password
    printf("Enter your password (At least 6 chars):\t");
    takepassword(user.password);  // Function to scan the user's password
    check4 = checkpass(user.password);  // Check if the password is valid

    while (check4 >= 1)
    {        
        // Display an error message for an invalid password and prompt the user to enter again
        printf("\nInvalid password \t\tHint:(******)\n\n");
        Beep(800, 300);
        printf("Enter your password (At least 6 chars):\t");
        takepassword(user.password);
        check4 = checkpass(user.password);
    }

    // Prompt the user to confirm their password
    printf("\nConfirm your password:\t");
    takepassword(password2);  // Function to scan the user's second password

    // Check if the password matches the confirmation
    if(!strcmp(user.password, password2))
    { 
        // Generate a username based on the email
        generateUsername(user.email, user.username);

        // Open the file for writing and write the user information
        fp = fopen("Login.txt", "w");
        fwrite(&user, sizeof(struct user), 1, fp);

        // Check if the write operation was successful
        if(fwrite != 0)
            printf("\n\nUser registration success, Your username is %s", user.username);
        else 
            printf("\n\nSorry! Something went wrong :(");

        // Close the file
        fclose(fp);
    }
    else
    {
        // Display an error message for non-matching passwords
        printf("\n\nPassword don't matched");
        Beep(750, 300);
    }

    // Display a new line, pause the system, and clear the console
    printf("\n");
    system("pause");
    system("cls");
}


else if (strcmp(opt, "2") == 0)
{
    // Display a welcome message
    system("cls");

    // Declare variables for username, password, and a user structure
    char username[50], pword[50];
    struct user u;

    // Clear the input buffer
    fflush(stdin);
    printf("\n%s+-----------------------------------------------+%s\n", BLUE, RESET);
    printf("%s|               %sLogin to Hotel System%s           |%s\n", BLUE, CYAN, BLUE, RESET);
    printf("%s+-----------------------------------------------+%s\n", BLUE, RESET);

    // Prompt the user to enter their username
    printf("\n%sEnter your username:%s\t", CYAN, RESET);
    takeinput(username);

    // Prompt the user to enter their password
    printf("%sEnter your password:%s\t", CYAN, RESET);
    takepassword(pword);
    printf("\n%s+-----------------------------------------------+%s\n", BLUE, RESET);
    // Open the file for reading
    fp = fopen("Login.txt", "r");

    // Loop through each user in the file
    while (fread(&u, sizeof(struct user), 1, fp))
    {
        // Check if the entered username matches a user in the file
        if (!strcmp(u.username, username))
        {
            // Check if the entered password matches the user's password
            if (!strcmp(u.password, pword))
            {
                // Clear the console and display a personalized welcome message
                system("cls");
                printf("\n\t\t\t\t\t\tWelcome %s", u.fullName);

                // Display user information
                printf("\n\n|Full Name:\t%s", u.fullName);
                printf("\n|Email:\t\t%s", u.email);
                printf("\n|Username:\t%s", u.username);
                printf("\n|Contact no.:\t%s", u.phone);
                printf("\n|Bank Balance:\t%s", u.bank);

                // Call the restaurant function to continue with the application
                restaurant();
            }
            else
            {
                // Display an error message for invalid password
                printf("\n\nInvalid Password!");
                Beep(800, 300);
            }

            // Set the flag indicating that the user is found
            usrFound = 1;
        }
    }

    // Check if the user was not found in the file
    if (!usrFound)
    {
        // Display an error message for an unregistered user
        printf("\n\nUser is not registered!");
        Beep(800, 300);
    }

    // Close the file
    fclose(fp);

    // Display a new line and clear the console
    printf("\n");
    system("cls");
}



else if (strcmp(opt, "3") == 0)
{
    // Display a farewell message
    printf("See You Again!");

    // Pause the execution for 3000 milliseconds (3 seconds)
    Sleep(3000);

    // Set the flag 'check' to 1 to exit the program
    check = 1;
}
else
{
    // Display an error message for an invalid option
    printf("\nInvalid Option");

    // Pause the execution for 1000 milliseconds (1 second)
    Sleep(1000);

    // Clear the console screen
    system("cls");
}
}
}


                                                   
// FUNCTION NUMBER 1
// This function displays a welcome message and options for a hotel reservation system.

void welcome() {
    // Displaying the welcome message and system title with ASCII art.
    printf("\n\t\t\t  %s********************************************%s\n", YELLOW, RESET);
    printf("\t\t\t  %s*%s        %sWelcome to Hotel Reservation%s       %s*%s\n", YELLOW, RESET, GREEN, RESET, YELLOW, RESET);
    printf("\t\t\t  %s*%s               %sSystem%s                      %s*%s\n", YELLOW, RESET, GREEN, RESET, YELLOW, RESET);
    printf("\t\t\t  %s********************************************%s\n", YELLOW, RESET);

    // Box around the menu options
    printf("\n%s----------------------------------------------%s\n", YELLOW, RESET);
    printf("%s| %s1. Signup%s                                   |%s\n", YELLOW, RED,YELLOW, RESET);
    printf("%s| %s2. Login%s                                    |%s\n", YELLOW, RED,YELLOW,RESET);
    printf("%s| %s3. Exit%s                                     |%s\n", YELLOW, RED,YELLOW,RESET);
    printf("%s----------------------------------------------%s\n", YELLOW, RESET);

    // Prompting the user to enter their choice.
    printf("\nYour choice: ");

    // Reading user input and storing it in the 'opt' variable.
   // char opt[5];  // Assuming a reasonable size for the input
    fgets(opt, sizeof(opt), stdin);

    // Removing the newline character from the user input.
    opt[strcspn(opt, "\n")] = '\0';
} // End of the welcome function





// FUNCTION NUMBER 2
// This function checks the validity of a given name by examining the number of spaces and the characters it contains.

int checkname(char name[])
{
    // Variable 'a' to count the number of spaces in the name.
    short a = 0;

    // Flag variable to indicate if there are any issues with the name.
    short flag = 0;

    // Loop to count the number of spaces in the name.
    for (int i = 0; i < strlen(name); i++)
    {
        if (name[i] == 32)  // Checking for space character (ASCII value 32).
        {
            a++;
        }
    }

    // If there are more than 2 spaces, set the flag to indicate an issue.
    if (a > 2)
        flag = 1;

    // Loop to check each character in the name.
    for (int i = 0; i < strlen(name); i++)
    {
        // Checking if the character is not an uppercase letter, lowercase letter, or space.
        if (!((name[i] >= 65 && name[i] <= 90) || (name[i] >= 97 && name[i] <= 122) || (name[i] == 32)))
            flag = 1;
    }

    // Returning the flag value to indicate whether there are issues with the name.
    return flag;
}
// End of the checkname function
             

  

                                                      
// FUNCTION NUMBER 3
// This function checks the validity of a given password by examining its length.

int checkpass(char pass[])
{
    // Variable 'a' to indicate if there is an issue with the password.
    short a = 0;

    // Checking if the length of the password is less than 6 characters.
    if (strlen(pass) < 6)
    {
        a = 1; // Set 'a' to 1 to indicate a short password.
    }

    // Returning the value of 'a' to indicate whether there are issues with the password.
    return a;
}
// End of the checkpass function
      



// FUNCTION NUMBER 4
// This function checks the validity of a given balance by examining its format.

int checkbalance(char balance[])
{
    // Variable 'a' to indicate if there is an issue with the balance.
    short a = 0;

    // Loop to check each character in the balance except the last one.
    for (int i = 0; i < strlen(balance) - 1; i++)
    {
        // Checking if the character is not a digit (0-9).
        if (balance[i] <= 47 || balance[i] >= 58)
        {
            a = 1; // Set 'a' to 1 to indicate a non-digit character in the balance.
        }
    }

    // Checking if the last character of the balance is not '$'.
    if (balance[strlen(balance) - 1] != '$')
    {
        a = 1; // Set 'a' to 1 to indicate a missing '$' at the end of the balance.
    }

    // Returning the value of 'a' to indicate whether there are issues with the balance.
    return a;
}
// End of the checkbalance function




// FUNCTION NUMBER 5
// This function checks the validity of a given phone number by examining its format.

int checkphone(char phone[])
{
    // Variable 'a' to indicate if there is an issue with the phone number.
    short a = 0;

    // Loop to check each character in the phone number.
    for (int i = 0; i < strlen(phone); i++)
    {
        // Checking if the character is not a digit (0-9).
        if (phone[i] <= 47 || phone[i] >= 58)
        {
            a = 1; // Set 'a' to 1 to indicate a non-digit character in the phone number.
        }
    }

    // Checking if the length of the phone number is not equal to 11 digits.
    if (strlen(phone) < 11 || strlen(phone) > 11)
    {
        a = 1; // Set 'a' to 1 to indicate an incorrect length of the phone number.
    }

    // Checking if the first two digits of the phone number are not '03'.
    if (phone[0] != '0' || phone[1] != '3')
    {
        a = 1; // Set 'a' to 1 to indicate an incorrect prefix in the phone number.
    }

    // Returning the value of 'a' to indicate whether there are issues with the phone number.
    return a;
}
// End of the checkphone function

     

// FUNCTION NUMBER 6
// This function checks the validity of a given email address by examining its format.

int checkemail(char email[])
{
    // Variables to track different conditions and overall flag.
    short a = 0;
    short b = 0;
    short flag = 1;   // Flag for checking domain and top-level domain.
    short flag1 = 1;  // Flag for checking the absence of spaces.
    short flag2 = 1;  // Flag for checking the number of '@' symbols.
    short flag3 = 1;  // Flag for checking the position of '@'.
    short flag4 = 1;  // Overall flag indicating any issues with the email.

    // Loop to check the format of the email address for domain and top-level domain.
    for (int i = 0; i < strlen(email); i++)
    {
        if (email[i] == '@' && email[strlen(email) - 1] == 'm' && email[strlen(email) - 2] == 'o' && email[strlen(email) - 3] == 'c' && email[strlen(email) - 4] == 46)
        {
            flag = 0; // Set 'flag' to 0 to indicate a valid domain and top-level domain.
        }
    }

    // Loop to count the number of spaces in the email address.
    for (int i = 0; i < strlen(email); i++)
    {
        if (email[i] == 32)
        {
            a++; // Increment 'a' for each space found.
        }
    }

    // Check if there are no spaces in the email address.
    if (a == 0)
    {
        flag1 = 0; // Set 'flag1' to 0 to indicate the absence of spaces.
    }

    // Loop to count the number of '@' symbols in the email address.
    for (int i = 0; i < strlen(email); i++)
    {
        if (email[i] == '@')
        {
            b++; // Increment 'b' for each '@' symbol found.
        }
    }

    // Check if there are less than 2 '@' symbols in the email address.
    if (b < 2)
    {
        flag2 = 0; // Set 'flag2' to 0 to indicate an incorrect number of '@' symbols.
    }

    // Check if the first character of the email address is not '@'.
    if (email[0] != '@')
    {
        flag3 = 0; // Set 'flag3' to 0 to indicate an incorrect position of '@'.
    }

    // Check if none of the individual flags are set.
    if (!(flag || flag1 || flag2 || flag3))
    {
        flag4 = 0; // Set 'flag4' to 0 to indicate overall issues with the email address.
    }

    // Returning the value of 'flag4' to indicate whether there are issues with the email address.
    return flag4;
}
// End of the checkemail function

 

// FUNCTION NUMBER 7
// This function takes a password as input without displaying it on the screen.

void takepassword(char pass[50])
{
    char ch;
    int i = 0;

    // Infinite loop for password input.
    while (1)
    {
        ch = getch();  // Read a character without displaying it on the screen.

        // Check if the entered character is Enter or Tab.
        if (ch == ENTER || ch == TAB)
        {
            pass[i] = '\0';  // Set the end of the password string.
            break;  // Exit the loop when Enter or Tab is pressed.
        }
        // Check if the entered character is Backspace.
        else if (ch == BCKSPC)
        {
            // Check if there are characters to erase.
            if (i > 0)
            {
                i--;
                printf("\b \b");  // Move the cursor back, print a space, and move the cursor back again.
            }
        }
        // Handle regular characters.
        else
        {
            pass[i++] = ch;  // Store the entered character in the password array.
            printf("* \b");  // Print an asterisk to represent the entered character without showing it.
        }
    }
}
// End of the takepassword function



// FUNCTION NUMBER 8
// This function takes user input as a string, using fgets, and removes the newline character if present.

void takeinput(char ch[50])
{
    // Using fgets to get input from the user with a maximum limit of 50 characters.
    fgets(ch, 50, stdin);

    // Removing the newline character from the input string.
    ch[strlen(ch) - 1] = 0;
}



// FUNCTION NUMBER 9
// This function generates a username based on the provided email address.

char generateUsername(char email[50], char username[50])
{
    // Loop through each character in the email address.
    for (int i = 0; i < strlen(email); i++)
    {
        // Check if the current character is '@'.
        if (email[i] == '@')
        {
            username[i] = '\0'; // Set the end of the username string and exit the loop.
            break;
        }
        else
        {
            username[i] = email[i]; // Copy the character from the email to the username.
        }
    }
}



// FUNCTION NUMBER 10
// This function presents a menu of restaurant types and calls another function based on the user's choice.

void restaurant(void)
{
    // Setting the console color to red on black.
    system("color 0c");

    // Array to store user input.
    char n[50];

    printf("\n\n\
    $$$$$$\\                        $$\\                                                       $$\\               \n\
    $$  __$$\\                       $$ |                                                      $$ |              \n\
    $$ |  $$ | $$$$$$\\   $$$$$$$\\ $$$$$$\\    $$$$$$\\  $$\\   $$\\  $$$$$$\\  $$$$$$\\  $$$$$$$\\ $$$$$$\\    $$$$$$$\\ \n\
    $$$$$$$  |$$  __$$\\ $$  _____|\\_$$  _|   \\____$$\\ $$ |  $$ |$$  __$$\\ \\____$$\\ $$  __$$\\\\_$$  _|  $$  _____|\n\
    $$  __$$< $$$$$$$$ |\\$$$$$$\\    $$ |     $$$$$$$ |$$ |  $$ |$$ |  \\__|$$$$$$$ |$$ |  $$ | $$ |    \\$$$$$$\\  \n\
    $$ |  $$ |$$   ____| \\____$$\\   $$ |$$\\ $$  __$$ |$$ |  $$ |$$ |     $$  __$$ |$$ |  $$ | $$ |$$\\  \\____$$\\ \n\
    $$ |  $$ |\\$$$$$$$\\ $$$$$$$  |  \\$$$$  |\\$$$$$$$ |\\$$$$$$  |$$ |     \\$$$$$$$ |$$ |  $$ | \\$$$$  |$$$$$$$  |\n\
    \\__|  \\__| \\_______|\\_______/    \\____/  \\_______| \\______/ \\__|      \\_______|\\__|  \\__|  \\____/ \\_______/ \n\
                                                                                                                 \n\
                                                                                                                 \n\
    ");
    // Displaying the menu of restaurant types.
    printf("%s+-----------------------------------------------+%s\n", CYAN, RESET);
    printf("%s    1. Casual Restaurants                           %s\n", CYAN, RESET);
    printf("%s    2. Fine Dining Restaurant                       %s\n", CYAN, RESET);
    printf("%s    3. Fast Food Restaurant                         %s\n", CYAN, RESET);
    printf("%s    4. Cafe or Coffee Shop                          %s\n", CYAN, RESET);
    printf("%s    5. Buffet-style Restaurant                      %s\n", CYAN, RESET);
    printf("%s    6. Return                                       %s\n", CYAN, RESET);
    printf("%s    +-----------------------------------------------+%s\n", CYAN, RESET);

    // Reading user input.
    fgets(n, sizeof(n), stdin);

    // Removing the newline character from the user input.
    n[strcspn(n, "\n")] = '\0';

    // Checking the user's choice and calling the 'types' function accordingly.
    if (strcmp(n, "1") == 0)
        types(n);
    else if (strcmp(n, "2") == 0)
        types(n);
    else if (strcmp(n, "3") == 0)
        types(n);
    else if (strcmp(n, "4") == 0)
        types(n);
    else if (strcmp(n, "5") == 0)
        types(n);
    else if (strcmp(n, "6") == 0)
    {
        // Clearing the console and returning to the main function.
        system("cls");
        return main();
    }
    else
    {
        // Displaying an error message for invalid options, generating a beep sound, and clearing the console.
        printf("Invalid Option");
        Beep(800, 300);
        Sleep(1000);
        system("cls");

        // Recursively calling the 'restaurant' function to allow the user to choose again.
        restaurant();
    }
}



// FUNCTION NUMBER 11
// This function displays different types of restaurants based on user choices and calls another function based on the user's choice.

void types(char n[50])
{
    // Setting the console color to bright cyan on black.
    system("color 0c");
    system("cls");
    printf(" $$$$$$\\             $$\\     $$\\                               \n");
    printf("$$  __$$\\            $$ |    \\__|                              \n");
    printf("$$ /  $$ | $$$$$$\\ $$$$$$\\   $$\\  $$$$$$\\  $$$$$$$\\   $$$$$$$\\ \n");
    printf("$$ |  $$ |$$  __$$\\_$$  _|  $$ |$$  __$$\\ $$  __$$\\ $$  _____|\n");
    printf("$$ |  $$ |$$ /  $$ | $$ |    $$ |$$ /  $$ |$$ |  $$ |\\$$$$$$\\  \n");
    printf("$$ |  $$ |$$ |  $$ | $$ |$$\\ $$ |$$ |  $$ |$$ |  $$ | \\____$$\\ \n");
    printf(" $$$$$$  |$$$$$$$  | \\$$$$  |$$ |\\$$$$$$  |$$ |  $$ |$$$$$$$  |\n");
    printf(" \\______/ $$  ____/   \\____/ \\__| \\______/ \\__|  \\__|\\_______/ \n");
    printf("          $$ |                                                  \n");
    printf("          $$ |                                                  \n");
    printf("          \\__|                                                  \n");
    // Array to store user input.
    char m[50];

    // Check the value of 'n' to determine the type of restaurant.
    if (strcmp(n, "1") == 0)
    {
        // Displaying options for Casual Restaurants.
    printf("%s+-----------------------------------------------+%s\n", CYAN, RESET);
    printf("%s1. Kabul Restaurant                             %s\n", CYAN, RESET);
    printf("%s2. Habibi Restauranat                           %s\n", CYAN, RESET);
    printf("%s3. Kala khan Restaurant                         %s\n", CYAN, RESET);
    printf("%s4. Return                                       %s\n", CYAN, RESET);
    printf("%s+-----------------------------------------------+%s\n", CYAN, RESET);

        fgets(m, sizeof(m), stdin);
        m[strcspn(m, "\n")] = '\0';

        // Check user choice and call the 'dates' function accordingly.
        if (strcmp(m, "1") == 0)
            dates(n);
        else if (strcmp(m, "2") == 0)
            dates(n);
        else if (strcmp(m, "3") == 0)
            dates(n);
        else if (strcmp(m, "4") == 0)
        {
            system("cls");
            restaurant();
        }
        else
        {
            // Displaying an error message for invalid options, generating a beep sound, clearing the console, and recursively calling itself.
            printf("Invalid Option");
            Beep(800, 300);
            Sleep(1000);
            system("cls");
            types(n);
        }
    }

// Handle the case when user chooses Fine Dining Restaurant (option "2").
else if(strcmp(n, "2") == 0)
{


    // Displaying options for Fine Dining Restaurants.
    printf("%s+-----------------------------------------------+%s\n", CYAN, RESET);
    printf("%s1. Okra.                                        %s\n", CYAN, RESET);
    printf("%s2. Chef's Table.                                %s\n", CYAN, RESET);
    printf("%s3. Cafe Aylanto.                                %s\n", CYAN, RESET);
    printf("%s4. Return                                       %s\n", CYAN, RESET);
    printf("%s+-----------------------------------------------+%s\n", CYAN, RESET);


    // Read user input for the selected Fine Dining Restaurant.
    fgets(m, sizeof(m), stdin);
    m[strcspn(m, "\n")] = '\0';

    // Check user choice and call the 'dates' function accordingly.
    if (strcmp(m, "1") == 0)
        dates(n);
    else if (strcmp(m, "2") == 0)
        dates(n);
    else if (strcmp(m, "3") == 0)
        dates(n);
    else if (strcmp(m, "4") == 0)
    {
        // Clear the console and return to the 'restaurant' function.
        system("cls");
        restaurant();
    }
    else
    {
        // Displaying an error message for invalid options, generating a beep sound, clearing the console, and recursively calling itself.
        printf("Invalid Option");
        Beep(800, 300);
        Sleep(1000);
        system("cls");
        types(n);
    }
}
                
// Handle the case when user chooses Fast food Restaurant (option "3").
else if(strcmp(n, "3") == 0)
{

    // Displaying options for Fast food Restaurants.
    printf("%s+-----------------------------------------------+%s\n", CYAN, RESET);
    printf("%s1. KFC.                                         %s\n", CYAN, RESET);
    printf("%s2. Burger Lab.                                  %s\n", CYAN, RESET);
    printf("%s3. Ranchers.                                    %s\n", CYAN, RESET);
    printf("%s4. Return                                       %s\n", CYAN, RESET);
    printf("%s+-----------------------------------------------+%s\n", CYAN, RESET);

    // Read user input for the selected Fast food Restaurant.
    fgets(m, sizeof(m), stdin);
    m[strcspn(m, "\n")] = '\0';

    // Check user choice and call the 'dates' function accordingly.
    if (strcmp(m, "1") == 0)
        dates(n);
    else if (strcmp(m, "2") == 0)
        dates(n);
    else if (strcmp(m, "3") == 0)
        dates(n);
    else if (strcmp(m, "4") == 0)
    {
        // Clear the console and return to the 'restaurant' function.
        system("cls");
        restaurant();
    }
    else
    {
        // Displaying an error message for invalid options, generating a beep sound, clearing the console, and recursively calling itself.
        printf("Invalid Option");
        Beep(800, 300);
        Sleep(1000);
        system("cls");
        types(n);
    }
}

                
// Handle the case when user chooses Cafe or Coffee Shop (option "4").
else if(strcmp(n, "4") == 0)
{

    // Displaying options for Cafe or Coffee Shop.
        // Displaying options for Fast food Restaurants.
    printf("%s+-----------------------------------------------+%s\n", CYAN, RESET);
    printf("%s1. The Coffee House.                            %s\n", CYAN, RESET);
    printf("%s2. Cinnabon                                     %s\n", CYAN, RESET);
    printf("%s3. Chaaye Khana.                                %s\n", CYAN, RESET);
    printf("%s4. Return                                       %s\n", CYAN, RESET);
    printf("%s+-----------------------------------------------+%s\n", CYAN, RESET);

    // Read user input for the selected Cafe or Coffee Shop.
    fgets(m, sizeof(m), stdin);
    m[strcspn(m, "\n")] = '\0';

    // Check user choice and call the 'dates' function accordingly.
    if (strcmp(m, "1") == 0)
        dates(n);
    else if (strcmp(m, "2") == 0)
        dates(n);
    else if (strcmp(m, "3") == 0)
        dates(n);
    else if (strcmp(m, "4") == 0)
    {
        // Clear the console and return to the 'restaurant' function.
        system("cls");
        restaurant();
    }
    else
    {
        // Displaying an error message for invalid options, generating a beep sound, clearing the console, and recursively calling itself.
        printf("Invalid Option");
        Beep(800, 300);
        Sleep(1000);
        system("cls");
        types(n);
    }
}

        
// Handle the case when user chooses Buffet style Restaurant (option "5").
else if(strcmp(n, "5") == 0)
{

    // Displaying options for Buffet style Restaurants.
    printf("%s+-----------------------------------------------+%s\n", CYAN, RESET);
    printf("%s1. Aradian Cafe.                                %s\n", CYAN, RESET);
    printf("%s2. Chandni Chowk Restaurant.                    %s\n", CYAN, RESET);
    printf("%s3. Village High tea.                            %s\n", CYAN, RESET);
    printf("%s4. Return                                       %s\n", CYAN, RESET);
    printf("%s+-----------------------------------------------+%s\n", CYAN, RESET);

    // Read user input for the selected Buffet style Restaurant.
    fgets(m, sizeof(m), stdin);
    m[strcspn(m, "\n")] = '\0';

    // Check user choice and call the 'dates' function accordingly.
    if (strcmp(m, "1") == 0)
        dates(n);
    else if (strcmp(m, "2") == 0)
        dates(n);
    else if (strcmp(m, "3") == 0)
        dates(n);
    else if (strcmp(m, "4") == 0)
    {
        // Clear the console and return to the 'restaurant' function.
        system("cls");
        restaurant();
    }
    else
    {
        // Displaying an error message for invalid options, generating a beep sound, clearing the console, and recursively calling itself.
        printf("Invalid Option");
        Beep(800, 300);
        Sleep(1000);
        system("cls");
        types(n);
    }
}

}
// End of the 'types' function.



// FUNCTION NUMBER 12
// This function handles the selection of available dates for a given restaurant and calls another function based on the user's choice.

void dates(char n[50])
{
    // Array to store user input for date selection.
    char option[50];

    // Clear the console for a clean display.
    system("cls");
    system("color 0c");

    printf("$$$$$$$\\             $$\\                         \n");
    printf("$$  __$$\\            $$ |                        \n");
    printf("$$ |  $$ | $$$$$$\\ $$$$$$\\    $$$$$$\\   $$$$$$$\\ \n");
    printf("$$ |  $$ | \\____$$\\\\_$$  _|  $$  __$$\\ $$  _____|\n");
    printf("$$ |  $$ | $$$$$$$ | $$ |     $$$$$$$$ |\\$$$$$$\\  \n");
    printf("$$ |  $$ |$$  __$$ | $$ |$$\\  $$   ____| \\____$$\\ \n");
    printf("$$$$$$$$ |\\$$$$$$$ | \\$$$$  |\\$$$$$$$\\ $$$$$$$  |\n");
    printf("\\________| \\_______|  \\____/  \\_______|\\_______/ \n");
    printf("                                                 \n");
    printf("                                                 \n");
    printf("                                                 \n");
    // Displaying the available dates for the restaurant.
    printf("%s+-----------------------------------------------+%s\n", CYAN, RESET);
    printf("%s1. 02-01-2024.                                  %s\n", CYAN, RESET);
    printf("%s2. 14-01-2024.                                  %s\n", CYAN, RESET);
    printf("%s3. 16-01-2024.                                  %s\n", CYAN, RESET);
    printf("%s4. Return                                       %s\n", CYAN, RESET);
    printf("%s+-----------------------------------------------+%s\n", CYAN, RESET);

    // Read user input for date selection.
    fgets(option, sizeof(option), stdin);
    option[strcspn(option, "\n")] = '\0';

    // Check user choice and call the 'tables' function accordingly.
    if (strcmp(option, "1") == 0)
        tables(n, 2);
    else if (strcmp(option, "2") == 0)
        tables(n, 14);
    else if (strcmp(option, "3") == 0)
        tables(n, 16);
    else if (strcmp(option, "4") == 0)
        types(n);
    else
    {
        // Displaying an error message for invalid options, generating a beep sound, clearing the console, and recursively calling itself.
        printf("Invalid Option");
        Beep(800, 300);
        Sleep(1000);
        system("cls");
        dates(n);
    }
}



// FUNCTION NUMBER 13
// This function handles table reservation for a given date and displays table options. It allows users to choose a table and proceed to menu selection.

void tables(char n[50], int d)
{
    // File pointer for reading user data from the login file.
    FILE *fp;
    
    // Structure to store user data.
    struct user u;
    
    // Open the login file for reading.
    fp = fopen("login.txt", "r");

    // Array to represent table numbers.
    int array[7] = {0, 1, 7, 3, 8, 5, 10};
    char choice[10];

    // Clear the console for a clean display.
    system("cls");
    system("color 0c");
    printf("$$$$$$$$\\       $$\\        $$\\                    \n");
    printf("\\__$$  __|      $$ |       $$ |                   \n");
    printf("   $$ | $$$$$$\\ $$$$$$$\\   $$ | $$$$$$\\   $$$$$$$\\ \n");
    printf("   $$ | \\____$$\\$$  __$$\\ $$ | $$  __$$\\ $$  _____|\n");
    printf("   $$ | $$$$$$$ |$$ |  $$ |$$ | $$$$$$$$ |\\$$$$$$\\  \n");
    printf("   $$ |$$  __$$ |$$ |  $$ |$$ | $$   ____| \\____$$\\ \n");
    printf("   $$ |\\$$$$$$$ |$$$$$$$  |$$ |\\$$$$$$$\\ $$$$$$$  |\n");
    printf("   \\__| \\_______|\\_______/ \\__| \\_______|\\_______/ \n");
    printf("                                                   \n");
    printf("                                                   \n");
    printf("                                                   \n");

    // Displaying table options for business and normal services.
    printf("\n%s __________________________________________________________ \n",RESET);
    printf("|   %sBusiness Services%s         |            %sNormal Services%s |\n", CYAN, RESET, CYAN, RESET);
    printf("|-----------------------------|----------------------------|\n");
    printf("|   %s1. Table 1%s                |              %s2. Table 7%s    |\n", CYAN, RESET, CYAN, RESET);
    printf("|   %s3. Table 3%s                |              %s4. Table 8%s    |\n", CYAN, RESET, CYAN, RESET);
    printf("|   %s5. Table 5%s                |              %s6. Table 10%s   |\n", CYAN, RESET, CYAN, RESET);
    printf("|   %s7. Return%s                 |                            |\n", CYAN, RESET);
    printf("|__________________________________________________________|\n\n");

    // Prompt the user to select a table.
    printf("Select the table: ");
    fgets(choice, sizeof(choice), stdin);
    choice[strcspn(choice, "\n")] = '\0';

    // Read user data from the login file and check the selected table.
    while (fread(&u, sizeof(struct user), 1, fp))
    {
        if (strcmp(choice, "1") == 0)
            printf("\nTable no.%d is reserved for %s\n", array[1], u.fullName);
        else if (strcmp(choice, "2") == 0)
            printf("\nTable no.%d is reserved for %s\n", array[2], u.fullName);
        else if (strcmp(choice, "3") == 0)
            printf("\nTable no.%d is reserved for %s\n", array[3], u.fullName);
        else if (strcmp(choice, "4") == 0)
            printf("\nTable no.%d is reserved for %s\n", array[4], u.fullName);
        else if (strcmp(choice, "5") == 0)
            printf("\nTable no.%d is reserved for %s\n", array[5], u.fullName);
        else if (strcmp(choice, "6") == 0)
            printf("\nTable no.%d is reserved for %s\n", array[6], u.fullName);
        else if (strcmp(choice, "7") == 0)
            dates(n);
        else
        {
            // Displaying an error message for invalid options, generating a beep sound, clearing the console, and recursively calling itself.
            printf("Invalid Option");
            Beep(800, 300);
            Sleep(1000);
            system("cls");
            tables(n, d);
        }
    }

    // Prompt the user to pre-select the menu or return to the previous options.
    printf("If you want to pre-select your menu, press '1' (OR) '2' to return\n");
    char y[50];
    fgets(y, sizeof(y), stdin);
    y[strcspn(y, "\n")] = '\0';

    // Check the user's choice and call the corresponding function.
    if (strcmp(y, "1") == 0)
    {
        menu(n, d);
    }
    else if (strcmp(y, "2") == 0)
    {
        dates(n);
    }
    else
    {
        // Displaying an error message for invalid options, generating a beep sound, clearing the console, and recursively calling itself.
        printf("Invalid Option");
        Beep(800, 300);
        Sleep(1000);
        system("cls");
        tables(n, d);
    }
}



//FUNCTION NUMBER 14
void menu(char n[50],int d)
{

FILE *fp;
struct user u;
fp = fopen("Login.txt","r");


 float price[65]={0,10.0,5.0,10.0,6.4,7.0,3.6,15.0,13.8,30.0,16.0,9.3,15.0,0.7,11.0,16.0,25.0,15.6,13.2,12.5,20.0,14.5,10.0,7.0,15.2,13.4,11.0,12.0,15.0,6.0,8.0,2.0,15.0,21.0,23.0,25.1,21.4,30.0,13.6,15.0,11.8,23.0,14.0,19.3,24.5,7.6,8.2,6.5,5.0,9.5,10.0,9.0,8.2,11.4,11.6,12.9,12.1,9.4,8.7,7.4,10.0,16.0,8.0,19.0,7.0};
 char  fname[65][50]={"0","Mutton Karahi","Chicken Haleem","Tawa fish","Chicken Seekh Kabab(8pcs)","Beef Seekh Kabab(8pcs)","Chicken Boti","Batair tikka(6pcs)","Fish Tikka","Whole lamb roast","Batair masala","Mutton Hareesa","Sarsoon ka saag","Makai ki roti","Mutton paya","Beef nehari","Lamb Karahi","Super Cheeze Pizza","Fajita Pizza","Creamy Mughlai Pizza","Arabic Ranch Pizza","Malai Boti Pizza","BBQ Chicken Pizza","Chicken wings(6pcs)","Mighty Zinger Burger","Krunch Combo Burger","Twister Combo","Rice and Spice,","Zinger Stacker Burger","Fries Bucket","Hot Shots","Cheeze Sauce","Tikka Pizza","Branzino with Caper Butter","Blanc-Steamed Mussels","Crispy Crab Cakes with Tomato","Seared Tuna with Soy","Mussels with Harissa","Buttery Shrimp with Peas","Venetian Shrimp with Polenta","Spaghetti with Clams","Monkfish Piccata","Maine-Style Lobster Rolls","Cajun Seafood Boil","Carolina Fish","Chana Masala","Dal Makhni","Dal Tadka","Shahi Rajma","Aloo Gobi","Aloo Mutter","Achari Aloo","Bhindi Masala","Paneer Tikka Masala","Paneer Makhni","Mutter Paneer","Malai Kofta","Espresso coffe","Chilled Latte coffe","Strawberry Shake","Choclate Shake","Three Milk Lotus Cake","Triple Choclate Cookie","Cheeze Cake","Brownie"};
 
 float sum=0.0;
 int NOD;
 float current;
 float total;
 float res1;
 int *ptr2;
 int *ptr;
system("cls");
    printf("$$\\      $$\\                               \n");
    printf("$$$\\    $$$ |                              \n");
    printf("$$$$\\  $$$$ | $$$$$$\\  $$$$$$$\\  $$\\   $$\\ \n");
    printf("$$\\$$\\$$ $$ |$$  __$$\\ $$  __$$\\ $$ |  $$ |\n");
    printf("$$ \\$$$  $$ |$$$$$$$$ |$$ |  $$ |$$ |  $$ |\n");
    printf("$$ |\\$  /$$ |$$   ____|$$ |  $$ |$$ |  $$ |\n");
    printf("$$ | \\_/ $$ |\\$$$$$$$\\ $$ |  $$ |\\$$$$$$  |\n");
    printf("\\__|     \\__| \\_______|\\__|  \\__| \\______/ \n");


 system("color 08");

     printf("\n|                Desi                      |                 |                 Fastfood                  | \n");
     printf("|                                          |                 |                                           | \n");
     printf("| 1.Mutton Karahi                    10.0$ |                 | 17.Super Cheeze Pizza               15.6$ |\n");
     printf("| 2.Chicken Haleem                    5.0$ |                 | 18.Fajita Pizza                     13.2$ |\n");
     printf("| 3.Tawa fish                        10.0$ |                 | 19.Creamy Mughlai Pizza             12.5$ |\n");
     printf("| 4.Chicken Seekh Kabab(8pcs)         6.4$ |                 | 20.Arabic Ranch Pizza               20.0$ |\n");
     printf("| 5.Beef Seekh Kabab(8pcs)            7.0$ |                 | 21.Malai Boti Pizza                 14.5$ |\n");
     printf("| 6.Chicken Boti                      3.6$ |                 | 22.BBQ Chicken Pizza                10.0$ |\n");
     printf("| 7.Batair tikka(6pcs)               15.0$ |                 | 23.Chicken wings(6pcs)               7.0$ |\n");
     printf("| 8.Fish Tikka                       13.8$ |                 | 24.Mighty Zinger Burger             15.2$ |\n");
     printf("| 9.Whole lamb roast                 30.0$ |                 | 25.Krunch Combo Burger              13.4$ |\n");
     printf("| 10.Batair masala                   16.0$ |                 | 26.Twister Combo                    11.0$ |\n");
     printf("| 11.Mutton Hareesa                   9.3$ |                 | 27.Rice and Spice                   12.0$ |\n");
     printf("| 12.Sarsoon ka saag                 15.0$ |                 | 28.Zinger Stacker Burger            15.0$ |\n");
     printf("| 13.Makai ki roti                    0.7$ |                 | 29.Fries Bucket                      6.0$ |\n");
     printf("| 14.Mutton paya                     11.0$ |                 | 30.Hot Shots                         8.0$ |\n");
     printf("| 15.Beef nehari                     16.0$ |                 | 31.Cheeze Sauce                      2.0$ |\n");
     printf("| 16.Lamb Karahi                     25.0$ |                 | 32.Tikka Pizza                      15.0$ |\n");
    puts("");
    puts("");
     printf("|                Sea food                  |                 |                 Indian                    |\n");
     printf("|                                          |                 |                                           |\n");
     printf("| 33.Branzino with Caper Butter      21.0$ |                 | 45.Chana Masala                      7.6$ |\n");
     printf("| 34.Blanc-Steamed Mussels           23.0$ |                 | 46.Dal Makhni                        8.2$ |\n");
     printf("| 35.Crispy Crab Cakes with Tomato   25.1$ |                 | 47.Dal Tadka                         6.5$ |\n");
     printf("| 36.Seared Tuna with Soy            21.4$ |                 | 48.Shahi Rajma                       5.0$ |\n");
     printf("| 37.Mussels with Harissa            30.0$ |                 | 49.Aloo Gobi                         9.5$ |\n");
     printf("| 38.Buttery Shrimp with Peas        13.6$ |                 | 50.Aloo Mutter                      10.0$ |\n");
     printf("| 39.Venetian Shrimp with Polenta    15.0$ |                 | 51.Achari Aloo                       9.0$ |\n");
     printf("| 40.Spaghetti with Clams            11.8$ |                 | 52.Bhindi Masala                     8.2$ |\n");
     printf("| 41.Monkfish Piccata                23.0$ |                 | 53.Paneer Tikka Masala              11.4$ |\n");
     printf("| 42.Maine-Style Lobster Rolls       14.0$ |                 | 54.Paneer Makhni                    11.6$ |\n");
     printf("| 43.Cajun Seafood Boil              19.3$ |                 | 55.Mutter Paneer                    12.9$ |\n");
     printf("| 44.Carolina Fish                   24.5$ |                 | 56.Malai Kofta                      12.1$ |\n");
    puts("");
    puts("");
     printf("|               Drinks                     |                 |               Sweets                      |\n");
     printf("|                                          |                 |                                           |\n");
     printf("| 57.Espresso coffe                   9.4$ |                 | 61.Three Milk Lotus Cake            16.0$ |\n");
     printf("| 58.Chilled Latte coffe              8.7$ |                 | 62.Triple Choclate Cookie            8.0$ |\n");
     printf("| 59.Strawberry Shake                 7.4$ |                 | 63.Cheeze Cake                      19.0$ |\n");
     printf("| 60.Choclate Shake                  10.0$ |                 | 64.Brownie                           7.0$ |\n");

// Prompt the user to input the number of dishes they would like.
printf("\n\nHow many dishes do you like: ");
scanf("%d", &NOD);

// Check if the number of dishes exceeds a certain limit.
if (NOD > 64)
{
    // Display an error message for an invalid demand, generate a beep sound, clear the console, and recursively call the 'menu' function.
    printf("\nInvalid demand\n");
    Beep(700, 350);
    Sleep(1000);
    system("cls");
    menu(n, d);
}

// Dynamic memory allocation for arrays to store dish indices and quantities.
ptr = (int *)malloc(NOD * sizeof(int) + 100);
ptr2 = (int *)malloc(NOD * sizeof(int) + 100);

// Loop to input dish indices and quantities.
for (int i = 1; i <= NOD; i++)
{
    // Loop until a valid index is entered.
    while (1)
    {
        printf("Enter index of dish %d:\n", i);
        scanf("%d", &ptr[i]);

        // Check for invalid index and prompt the user to enter again.
        if (ptr[i] > 64)
        {
            printf("\nInvalid index\n");
            continue;
        }
        else
            break;
    }

    // Prompt the user to input the quantity of the dish.
    printf("Enter the quantity: ");
    scanf("%d", &ptr2[i]);
}

// Set the console color to red and clear the console.
system("color 0c");
system("cls");

// Read user data from the login file and display relevant information.
while (fread(&u, sizeof(struct user), 1, fp))
{
    printf("\n|Full Name:\t%s", u.fullName);
    printf("\n|Email:\t\t%s", u.email);
    printf("\n|Username:\t%s", u.username);
    printf("\n|Contact no.:\t%s", u.phone);
    printf("\n|Bank Balance:\t%s\n\n", u.bank);
    // Write comments to explain the purpose of displaying user information.
    printf("\n$$$$$$\\                               $$\\                     \n");
    printf("\\_$$  _|                              \\__|                    \n");
    printf("   $$ |  $$$$$$$\\ $$\\    $$\\  $$$$$$\\  $$\\  $$$$$$$\\  $$$$$$\\  \n");
    printf("   $$ |  $$  __$$\\$$\\  $$  |$$  __$$\\ $$ |$$  _____|$$  __$$\\ \n");
    printf("   $$ |  $$ |  $$ | \\$$$$/   $$ /  $$ |$$ |$$ /      $$$$$$$$ |\n");
    printf("   $$ |  $$ |  $$ |  \\$$$/    $$ |  $$ |$$ |$$ |      $$   ____|\n");
    printf("$$$$$$\\ $$ |  $$ |   \\_/     \\$$$$$$  |$$ |\\$$$$$$$\\ \\$$$$$$$\\ \n");
    printf("\\______|\\__|  \\__|            \\______/ \\__| \\_______| \\_______|\n\n");
  system("color 0b");
    
    
   
    printf("                                 BILL INVOICE                                \n");
    printf("                      ----------------------------------                     \n");
    printf("Date: %d/10/2023                                                             \n",d);
    printf("Invoice to: %s                                                               \n",u.fullName);
    printf("-----------------------------------------------------------------------------\n");
    printf("Item                                   Qty                   Total           \n");
    printf("-----------------------------------------------------------------------------\n");
    fflush(stdin);
    for (int i = 1; i <= NOD; i++) {
        printf("%-30s%15d%20.2f$\n", fname[ptr[i]], ptr2[i], price[ptr[i]] * (ptr2[i]));
        sum = sum + (price[ptr[i]] * (ptr2[i]));
    }

    printf("-----------------------------------------------------------------------------\n");
    printf("Sub Total%61.1f$\n", sum);
    printf("Discount @10%c%56.1f$\n", 37, sum / (float)10);
    printf("%74s\n", "---------");
    printf("Net Total%60.1f$\n", sum - (sum / (float)10));
    printf("CGST @9%c%61.1f$\n", 37, (sum - (sum / (float)10)) / 9);
    printf("SGST @9%c%61.1f$\n", 37, (sum - (sum / (float)10)) / 9);
    printf("-----------------------------------------------------------------------------\n");
    printf("Grand Total%58.1f$\n", (sum - (sum / (float)10)) + ((sum - (sum / (float)10)) / 9) + ((sum - (sum / (float)10)) / 9));
    printf("-----------------------------------------------------------------------------\n");
  
  char op;
   res1 = atoi(u.bank);
   total = (sum - (sum / (float)10)) + ((sum - (sum / (float)10)) / 9) + ((sum - (sum / (float)10)) / 9);
   current = res1-((sum - (sum / (float)10)) + ((sum - (sum / (float)10)) / 9) + ((sum - (sum / (float)10)) / 9));
  
    printf("\n\nDo you want to continue the payment (press y) to continue payment OR (press n) to exit\n");
    scanf("%c",&op);
    switch(op){
        case 'y':
        case 'Y':
if(res1>total) 
{
    system("cls");
    printf("\n$$$$$$\\                       $$\\                      $$\\     \n");
    printf("$$  __$$\\                      \\__|                     $$ |    \n");
    printf("$$ |  $$ | $$$$$$\\   $$$$$$$\\ $$\\  $$$$$$\\   $$$$$$\\ $$$$$$\\   \n");
    printf("$$$$$$$  |$$  __$$\\ $$  _____|$$ |$$  __$$\\ $$  __$$\\_$$  _|  \n");
    printf("$$  __$$< $$$$$$$$ |$$ /      $$ |$$$$$$$$ |$$ /  $$ | $$ |    \n");
    printf("$$ |  $$ |$$   ____|$$ |      $$ |$$   ____|$$ |  $$ | $$ |$$\\ \n");
    printf("$$ |  $$ |\\$$$$$$$\\ \\$$$$$$$\\ $$ |\\$$$$$$$\\ $$$$$$$  | \\$$$$  |\n");
    printf("\\__|  \\__| \\_______| \\_______|\\__| \\_______|$$  ____/   \\____/ \n\n\n");

    printf("                   ********** Payment Success Receipt **********\n");
    printf("                   Customer:%s \n",u.fullName);
    printf("                   Date:%d/01/2024 \n",d);
    printf("                   Transaction ID: 3310043236311\n");
    printf("                   ----------------------------------------------\n");
    printf("                   |Account Details: $%.2f                     |\n",res1);
    printf("                   |Grand Total: $%.2f                          |\n",total);
    printf("                   |Amount Paid: $%.2f                          |\n",total);
    printf("                   |Payment Method: Easy Paisa                   |\n");
    printf("                   |Remaining Balance: $%.2f                   |\n",current);
    printf("                   **********************************************\n\n\n");
    system("pause");
}

else if(res1<total)
{
    printf("Not Enough Cash\n");
    Sleep(3000);
    menu(n,d);
}
        break;
        case 'n':
        case 'N':
        system("cls");
        return main();
        break;
        default:
        printf("Invalid Operation\n");

    fclose(fp);
    system("pause");

}       
}
}

