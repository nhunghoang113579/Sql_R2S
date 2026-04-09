// Exercise 03: Write a program to generate the Fibonacci series. 
// (1,1,2,3,5,8,13,………). 
#include <stdio.h>

int main() {
    int a = 1, b = 1, tmp,n;
    printf("Enter number of terms: ");
    scanf("%d", &n);

    for (int i = 0; i <= n; i++)
    {
         printf("%d ", a);
        tmp = a + b;
        // printf("tmp１ : % d\n",tmp);

        a = b;
        // printf("tmp2 : % d\n",tmp);

         b = tmp;
        // printf("b : % d\n",b);
    }

    return 0;

}