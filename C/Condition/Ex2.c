// Viết một chương trình nhập 2 số.
// Tính hiệu (difference) giữa hai số đó.

// Nếu hiệu bằng một trong hai giá trị đã nhập, hiển thị thông báo:
// Difference is equal to value <number of value entered
// Nếu hiệu không bằng giá trị nào đã nhập, hiển thị thông báo:
// Difference is not equal to any of the values entered

#include<stdio.h>
int main(){
    int number1,number2,difference;
    printf("Input number 1:");
    scanf("%d",&number1);
    printf("Input number 2:");
    scanf("%d",&number2);
    difference = number1 - number2;

    if(difference == number1 || difference == number2){
        printf("Difference is equal to value <number of value entered>");

    }else{
        printf("Difference is not equal to any of the values entered");
    }


}