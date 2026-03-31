#include<stdio.h>

int main(){
    int num, digit1, digit2, digit3, sum;


     printf("Enter a three-digit number: ");
     scanf("%d", &num);

     digit1 = num / 100;
    digit2 = (num /10) % 10;
    digit3 = num % 10;

    sum = digit1 + digit2 + digit3;
     printf("%d",sum);
}