// Exercise 03
// Công ty ABC cấp phụ cấp (allowance) cho nhân viên tùy theo grade (xếp loại)
// | Grade  | Allowance |
// | ------ | --------- |
// | A      | 300       |
// | B      | 200       |
// | Others | 100       |
// Hãy tính lương cuối tháng của nhân viên.

// Yêu cầu:

// Người dùng nhập Salary (lương)
// Người dùng nhập Grade
#include <stdio.h>

int main(){

    float salary, totalSalary;
    char grade;
    int allowance;

    printf("Enter salary: ");
    scanf("%f", &salary);

    printf("Enter grade (A/B/Other): ");
    scanf(" %c", &grade);

    if(grade =='A' || grade =='a'){
        allowance = 300;
       

    }else if (grade =='B' || grade =='b')
    {
        allowance = 200;
    }else{
        allowance = 100;
    }
    
    totalSalary = salary * allowance;
     printf("Total Salary = %.2f",totalSalary);

}