// Exercise 02
// Viết chương trình tính tổng các phần tử lẻ trong một mảng.

#include<stdio.h>

int main(){
  
    int n;
    int arr[100];
    int sum = 0;

    printf("Enter max size of array: ");
    scanf("%d",&n);

    for(int i = 0; i < n; i++){
        printf("Enter element %d: ", i);
        scanf("%d",&arr[i]);
         if(arr[i] % 2 == 1){
            sum += arr[i];
            continue;
        }
        
    }
     printf(" Tong cac phan tu le cua mang %d",sum);
}
    