//Bakhat Nasar
//461954
#include <stdio.h>
#include <stdlib.h>
#include <time.h>

int n;       //global variable to access both in user def-function and main function
int multiplication(int, int);       //function declaration to multiply 2 numbers.
int diff_level(int);     //function declaration for level of difficulty.
void correct_ans();    //function declaration to show comments when ans is right.
void wrong_ans();   //function declaration to show comments when ans is wrong.
int operation(int u,int i,int j,int n);   //function declaration of operation.
void main()    //main function 

{

int i,j,a;                    //variables for checking if a==i(+,-,*)j
int difflevel;            //variable for difficulty level
int op;                     //variable for operation
int counter=0;      //count the loop
int acounter=0;   //count the number of right answers
int bcounter=0;  //count the number of wrong answers

//seed for to get random numbers each time
srand(time(NULL));
//level of difficulty
printf("Select the difficulty level:-\n\t|1.Easy| 1-10\n\t|2.Normal| 1-100\n\t|3.Hard| 1-300\n\t|4.Very difficult| 1-1000\n");
scanf("%d",&difflevel);
//operation to be performed
printf("Select the arithmetic operation of your choice:-\n\t|1.+|\n\t|2.-|\n\t|3.*|\n\t|4.Random|\n");
scanf("%d",&op);
//the outer most do-while loop while will keep asking question until terminated with "-1".
do{
if (difflevel>4){   //something other than 1-4 it is going to break the loop.
    break;
}
do{
i = diff_level(difflevel);  //function call to chosse which range of random number are going to appear on screen...

j = diff_level(difflevel);  //function call to chosse which range of random number are going to appear on screen...

//These "if else" statments will read which number is selected and show the output according to it

n = (rand()%3);
if(op==1){
printf("%d + %d = ?",i,j);    //Add
printf(" (-1 to exit)\n");}
else if(op==2){
printf("%d - %d = ?",i,j);      //Subtract
printf(" (-1 to exit)\n");}
else if(op==3){
printf("%d * %d = ?",i,j);     //Multiply
printf(" (-1 to exit)\n");}
else { 
    if(n==0){
    printf("%d + %d = ?",i,j);
    printf(" (-1 to exit)\n");}
    else if(n==1){
    printf("%d - %d = ?",i,j);
    printf(" (-1 to exit)\n");}   
    else if(n==2){
    printf("%d * %d = ?",i,j);
    printf(" (-1 to exit)\n");}
        
    }
int res = operation(op,i,j,n);   //Function call and storing in res

    //This inner do-while loop will keep asking the user same question until he give the right answer.
do{
scanf("%d",&a);    //read the user input

if (res == a){
correct_ans();
acounter++;}         //it iwll show a congratulation comment and break the loop.
else {
    if(a!=-1){
     wrong_ans();
     bcounter++;}
    else {                 //the program will confuse -1 with the user input so it is 
    break;}             //important to tell the program that everything other than -1
}                            // or correct answer is wrong. SO keep asking.
counter++;
}while(a != res );  //if a == res then it will automatically break the loop

    
}while(counter<10 && a!= -1);
float acounter2 = acounter;
if(acounter>(counter/2)){
    printf("\"Congratulation! You are ready for the next level.\"\n \"Percentage= %.3f%\"\n",(acounter2/(float)counter)*100);
    break;
}
else {
    printf("\"Please consult your teacher for the help.\"\n\"Percentage = %.3f%\"\n",(acounter2/(float)counter)*100);
    break;}

}while(a!=-1);   //It is a sentinel value press -1 to exit the outer loop (OR)main program.
printf(" \"Program terminated\"\n");


}

//functions:-
//function 01 definition:-
int multiplication(int x, int y){
    return x*y;
}
//function 02 definition:-
void correct_ans(){
    int i = (rand()%4)+1;
    switch(i){
        case 1:
        printf("\nExcellent!\n");
        break;
        case 2:
        printf("\nVery Good!\n");
        break;
        case 3:
        printf("\nNice work!\n");
        break;
        case 4:
        printf("\nKeep up the Good work!\n");
        break;
        
}
}
//function 03 definition:-
void wrong_ans(){
    int i = (rand()%4)+1;
    switch(i){
        case 1:
        printf("\nNo. Please try again.\n");
        break;
        case 2:
        printf("\nWrong. Try once more.\n");
        break;
        case 3:
        printf("\nDon't Give up!\n");
        break;
        case 4:
        printf("\nNo. keep trying.\n");
        break;
        
}
}
//function 04 definition:-
int diff_level(int x){
    int y;
    switch(x){
        case 1:
        return y=rand()%10;
        break;
        case 2:
        return y=rand()%100;
        break;
        case 3:
        return y=rand()%300;
        break;
        case 4:
        return y=rand()%1000;
        break;
        default:
        printf("Invalid option\n");
    }
}

//function 05 definition:-
int operation(int u,int i,int j,int n){
   
    switch(u){
        case 1:
        return i+j;
        break;
        case 2:
        return i-j;
        break;
        case 3:
        return i*j;
        break;
        case 4:
        if(n==0)
        return i+j;
        else if(n==1)
        return i-j;
        else if(n==2)
        return i*j;
        break;
    }
    
}
