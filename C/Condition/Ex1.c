// Exercise 01
// Viết một chương trình nhập 2 số và kiểm tra xem tích của hai số đó có bằng hoặc lớn hơn 1000 hay không.

#include<stdio.h>

int main(){

    float number1,number2,product;
    printf("Input number 1:");
    scanf("%f",&number1);
    printf("Input number 2:");
    scanf("%f",&number2);
    product = number1 * number2;
      printf("Product = %.2f\n",product);
    if(product >= 1000){
        printf("Product > 1000");

    }else{
        printf("Product < 1000");
    }
}