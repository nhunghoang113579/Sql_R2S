// Viết chương trình in bảng cửu chương cho một số cho trước.
// Số được nhập trong khoảng từ 2 đến 9.

#include <stdio.h>

int main() {

    int num;

    printf("Enter a number (2-9): ");
    scanf("%d", &num);

    if (num < 2 || num > 9)
    {
        printf("Invalid number\n");
    }
    else
    {
        for (int i = 1; i <= 10; i++)
        {
            printf("%d x %d = %d\n", num, i, num * i);
        }
    }

    return 0;
}


        

        
        
    
    

