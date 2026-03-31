#include<stdio.h>

int main(){
    float basic = 12000;
    float DA ,HRA = 150, TA = 120, OT = 450;
    float PF,IT;
    float nextSalary;

    DA = basic * 0.12;

    PF = basic * 0.14;
    IT = basic * 0.1;

    nextSalary = basic+ DA + HRA + TA + OT - (PF + IT); 

    printf("Net Salary = %.2f\n:", nextSalary);

}