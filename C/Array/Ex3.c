// Exercise 03

// Cho người dùng nhập một số x.
// Chương trình phải đếm xem số x xuất hiện bao nhiêu lần trong mảng.

#include<stdio.h>

int main(){
  
    int n;
    int arr[100];
    int x,sum = 0;

    printf("Enter max size of array: ");
    scanf("%d",&n);

    for(int i = 0; i < n; i++){
        printf("Enter element %d: ", i);
        scanf("%d",&arr[i]);
    }


     printf("Enter X: ");
     scanf("%d",&x);

      for(int i = 0; i < n; i++){
        if(arr[i] == x){
            sum++;
        }
        
    }
    printf("So lan X xuat hien trong mang: %d",sum);


}