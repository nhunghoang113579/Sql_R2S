// Viết chương trình in bảng cửu chương cho một số cho trước.
// Số được nhập trong khoảng từ 2 đến 9.

#include <stdio.h>

int main() {

    int pass = 12345;
    int count = 0;
    int inputPass;

    

    // for (int i = 0; i < 3; i++)
    // {
    //     printf("Enter password:");
    //     scanf("%d",&inputPass);
    //     if(inputPass == pass){
    //         printf("Access granted");
    //         break;
    //     }else{
    //         printf("Invalid password\n");

    //     }
    // }


    while(count < 3){
         printf("Enter password:");
        scanf("%d",&inputPass);
        if(inputPass == pass){
            printf("Access granted");
            break;
        }else{
            printf("Invalid password\n");

        }
        count++;
    }
    

    
}

