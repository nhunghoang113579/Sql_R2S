// Exercise 05
// Viết chương trình hiển thị khả năng của máy tính.
// Người dùng nhập một chữ cái trong bảng chữ cái, chương trình sẽ hiển thị ngôn ngữ lập trình hoặc phần mềm tương ứng.
// Ví dụ:
// Input	Output
// B hoặc b	Basic
// C hoặc c	Cobol
// F hoặc f	Fortran
// P hoặc p	Pascal
// V hoặc v	Visual C++

#include <stdio.h>

int main(){

    char alphabet;

    printf("Enter alphabet: ");
    scanf("%c", &alphabet);

    switch (alphabet)
    {
        case 'B':
        case 'b':
            printf("Basic");
            break;

        case 'C':
        case 'c':
            printf("Cobol");
            break;

        case 'F':
        case 'f':
            printf("Fortran");
            break;

        case 'P':
        case 'p':
            printf("Pascal");
            break;

        case 'V':
        case 'v':
            printf("Visual C++");
            break;

        default:
            printf("Invalid");
    }

    return 0;
}