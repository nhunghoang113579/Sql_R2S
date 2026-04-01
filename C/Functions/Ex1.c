// Exercise 01:

// Viết chương trình tính diện tích và chu vi của hình tròn.

#include<stdio.h>

float area(float pi, float r){
   float area = pi * r * r;
     return area;
}

float perimeter(float pi, float r){
   float perimeter = pi * 2 * r;
     return perimeter;
}

// Viết chương trình tính giai thừa (factorial) của một số nguyên.

double factorial(int n){
    double result = 1;
    for (int i = 1; i <= n; i++)
    {
        result *= i;
    }
    return result;
    
}


int main(){
    // 1
    const float PI = 3.14;
    float a = area(PI,2);
    float p = perimeter(PI,2);

    printf("Dien tich = %.2f\n", a);
    printf("Chu vi = %.2f\n", p);

    //2

    int n;
    printf("Nhap mot so nguyen n: ");
    scanf("%d", &n);

    if(n < 0){
        printf("Khong tinh giai thua so am.\n");
    } else {
        printf("%d! = %.0f\n", n, factorial(n)); // in không thập phân
    }

    return 0;

}


// Viết chương trình tính giai thừa (factorial) của một số nguyên.

// Exercise 03:

// Phần mềm cho phép người dùng nhập điểm các môn học và tính GPA.

// Yêu cầu chi tiết:
// Nhập điểm các môn học:
// Database
// C
// OOP
// Java

// Tính GPA:

// Tính trung bình điểm các môn

// Quy đổi sang thang 4 điểm:

// 𝐺
// 𝑃
// 𝐴
// =
// (
// Điểm tr
// e
// ˆ
// n thang 10
// /
// 10
// )
// ∗
// 4
// GPA=(Điểm tr
// e
// ˆ
// n thang 10/10)∗4

// Ví dụ:

// Điểm 10 → GPA = (10/10)*4 = 4
// Điểm 6.5 → GPA = (6.5/10)*4 = 2.6
// Điểm 4 → GPA = (4/10)*4 = 1.6
// Phân loại GPA:
// Xuất sắc (Excellent): 3.60 → 4.00
// Tốt (Good): 3.20 → 3.59
// Khá (Fair): 2.50 → 3.19
// Trung bình (Average): 2.00 → 2.49
// Yếu (Weak): < 2.00
// Kiểm tra đầu vào (Input Validation):
// Điểm phải từ 0 → 10
// Yêu cầu kỹ thuật:
// Dùng hàm (functions) cho mỗi chức năng:
// Nhập điểm (input mark)
// Tính GPA (calculate GPA)
// Hiển thị GPA (display GPA)
// Hiển thị xếp loại (display Rank)
// Giao diện người dùng (User Interface):
// Nhập điểm
// Hiển thị GPA
// Hiển thị xếp loại
// Thoát (Quit)