// Exercise 06

// Giải phương trình bậc hai

// Viết chương trình giải phương trình bậc hai dạng:

#include <stdio.h>
#include <math.h>

int main(){

    float a, b, c;
    float delta, x1, x2;

    printf("Enter a b c: ");
    scanf("%f %f %f", &a, &b, &c);

    delta = b*b - 4*a*c;

    if(delta > 0){
        x1 = (-b + sqrt(delta)) / (2*a);
        x2 = (-b - sqrt(delta)) / (2*a);

        printf("x1 = %.2f\n", x1);
        printf("x2 = %.2f\n", x2);
    }
    else if(delta == 0){
        x1 = -b / (2*a);
        printf("Double root x = %.2f\n", x1);
    }
    else{
        printf("No real solution\n");
    }

    return 0;
}