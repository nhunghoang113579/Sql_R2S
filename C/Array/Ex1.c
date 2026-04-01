// Exercise 01
// Viết chương trình C để tìm giá trị nhỏ nhất (min) và giá trị lớn nhất (max) trong một mảng.

#include<stdio.h>

int main(){
  
    int n;
    int arr[100];

    printf("Enter max size of array: ");
    scanf("%d",&n);

    for(int i = 0; i < n; i++){
        printf("Enter element %d: ", i);
        scanf("%d",&arr[i]);
    }

    int maxNumber = arr[0];
    int minNumber = arr[0];

    for (size_t i = 0; i < n; i++)
    {
        if(arr[i] < minNumber){
            minNumber = arr[i];
        }
        if(arr[i] > maxNumber){
            maxNumber = arr[i];
        }
    }
    printf("Min = %d\n", minNumber);
    printf("Max = %d\n", maxNumber);
    return 0;
    
}
