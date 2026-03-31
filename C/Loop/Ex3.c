// Exercise 03: Write a program to generate the Fibonacci series. 
// (1,1,2,3,5,8,13,………). 
#include <stdio.h>

int main() {

    int a = 1;
    int b = 1;
    int next;

    printf("%d %d ", a, b);

    for(int i = 1; i <= 8; i++)
    {
        next = a + b;
        printf("%d ", next);

        a = b;
        b = next;
    }

    return 0;
}