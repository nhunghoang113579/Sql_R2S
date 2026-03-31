// Exercise 01: Write a program to print the series 100, 95 , 90, 85,………., 5. 

#include<stdio.h>

int main(){
   int maxNumber = 100;

//    do{
//      maxNumber -= 5;

//     printf("%d\n", maxNumber);

//    }while (maxNumber >= 5);

//     return 0;

// while (maxNumber > 5)
// {
//     maxNumber -= 5;
//    printf("%d\n", maxNumber);
// }

 for(int i = 100; i >= 5; i -= 5){
        printf("%d ", i);
    }

    return 0;
   
}