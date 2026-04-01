// Exercise 06

// Check if all elements of the array are odd

// 👉 Kiểm tra xem tất cả các phần tử trong mảng có phải là số lẻ hay không.

// Nếu tất cả đều là số lẻ → in ra thông báo đúng
// Nếu có ít nhất một số chẵn → in ra thông báo sai

#include <stdio.h>

int main() {

    int n;
    int arr[100];
    int sum = 0;

    printf("Enter number of elements: ");
    scanf("%d",&n);

    for(int i = 0; i < n; i++){
        printf("Enter element %d: ", i);
        scanf("%d",&arr[i]);
    }

    for(int i = 0; i < n; i++)
    {
        if(arr[i] % 2 != 0){
            sum++;
        }
    }

    if(sum == n){
        printf("All elements are odd\n");
    } else {
        printf("Not all elements are odd\n");
    }
    


}