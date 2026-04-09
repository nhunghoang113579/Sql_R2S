// : Accept two numbers num1 and num2. Find the sum of all odd numbers 
// between the two numbers entered. 


#include<stdio.h>

int main(){
   int number1,number2;
   int sum =0;
   printf("Input number 1:");
    scanf("%d",&number1);
    printf("Input number 2:");
    scanf("%d",&number2);
for (int i = number1; i < number2; i++)
{
    if(i % 2 == 1){
        sum += i;
        continue;
    }
}

printf("he sum of all odd numbers : %d",sum);



}