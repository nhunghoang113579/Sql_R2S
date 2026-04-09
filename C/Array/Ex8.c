#include<stdio.h>

int main(){
    int checkDigit = 10;
    int ISBN;
    int weight, digitSum;
    int arr[10];
    int sum = 0;

    for (int i = 0; i < 10; i++)
    {
        printf("Enter digit %d: ", i + 1 );
        scanf("%d",&arr[i]);
    }
    //  for(int i = 1; i < 10; i++){
    //     printf("%d ", arr[i]);
    // }
    // printf()
    for (int i = 0; i < 9 ; i++)
    {
         sum +=(arr[i] * (10 - i));
       
    }

    
    
     digitSum = (sum + checkDigit);
        if( digitSum % 11 == 0){
            printf("Valid ISBN");

        }else{
            printf("Invalid ISBN");

         }
}