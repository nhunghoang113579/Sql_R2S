#include <stdio.h>

int main(){
    float salary;
    int age;

    printf("Input salary:\n");
    scanf("%f",&salary);

    printf("Your salary: %.2f\n\n", salary);

    printf("Input age:\n");
    scanf("%d",&age);

    printf("Your age: %d\n", age);

    return 0;
}