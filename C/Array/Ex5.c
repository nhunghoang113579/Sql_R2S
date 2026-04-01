// Exercise 05

// Đếm bao nhiêu phần tử trong mảng có giá trị nhỏ hơn 0.

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

    for(int i = 0; i < n; i++){
        if(arr[i] < 0){
            sum++;
        }
    }

    printf("Number of elements less than 0: %d\n", sum);

    return 0;
}