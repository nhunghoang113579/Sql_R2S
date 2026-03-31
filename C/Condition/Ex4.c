// Exercise 04

// Viết chương trình đánh giá xếp loại của sinh viên theo điều kiện sau:

// Điểm (marks)	Grade
// marks > 75	A
// 60 < marks < 75	B
// 45 < marks < 60	C
// 35 < marks < 45	D
// marks < 35	E

#include <stdio.h>

int main(){

    int marks;

    printf("Enter marks: ");
    scanf("%d", &marks);

    if(marks >= 75){
        printf("grade A");
       

    }else if (marks >= 60){
         printf("grade B");

    }else if (marks >= 45)
    {
        printf("grade C");
    }else if (marks >= 35)
    {
        printf("grade D");
    }else{
        printf("grade E");
    }


}