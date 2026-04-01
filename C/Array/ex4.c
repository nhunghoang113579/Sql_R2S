// Exercise 04
// Hiển thị các phần tử trong mảng chia hết cho 3 hoặc 5.

#include <stdio.h>

int main() {

    int n;
    int arr[100];

    printf("Enter number of elements: ");
    scanf("%d",&n);

    for(int i = 0; i < n; i++){
        printf("Enter element %d: ", i);
        scanf("%d",&arr[i]);
    }

    printf("Elements divisible by 3 or 5:\n");

    for(int i = 0; i < n; i++){

        if(arr[i] % 3 == 0 || arr[i] % 5 == 0){
            printf("%d ", arr[i]);
        }

    }

    return 0;
}