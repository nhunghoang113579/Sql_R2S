// Phát triển chương trình quản lý mảng số nguyên 1 chiều

// Viết một chương trình giúp người dùng quản lý mảng số nguyên 1 chiều (tối đa 100 phần tử) với menu đơn giản sau:
// Menu
// 1️⃣ Nhập mảng (1.5 điểm)
// 2️⃣ Xuất mảng (0.5 điểm)
// 3️⃣ In mảng theo thứ tự giảm dần (1 điểm)
// 4️⃣ Kiểm tra tất cả phần tử trong mảng có phải là số lẻ không (2 điểm)
// 5️⃣ Tìm kiếm một giá trị (2 điểm)
// 6️⃣ Hiển thị các số nguyên tố trong mảng (2 điểm)
// 7️⃣ Thoát chương trình (1 điểm)

// inputArray()
// outputArray()
// sortDescending()
// checkAllOdd()
// searchValue()
// displayPrime()
// quitProgram()

#include<stdio.h>


int inputArray(int arr[],int n){

    do
    {
        printf("Enter number of elements (1-100): ");
        scanf("%d", &n);
        if(n < 1 || n > 100){
             printf("Invalid number! Please enter again.\n");
        }
    } while (n < 1 || n > 100);
    
    for (int i = 0; i < n; i++)
    {
        printf("Enter element %d :",i + 1);
        scanf("%d",&arr[i]);
    }

    return n;
    
    
}
void outputArray(int arr[], int n){
    for (int i = 0; i < n; i++)
    {
        printf("%d ", arr[i]);
    }
}

void sortDescending(int arr[], int n){
    for (int i = 0; i < n - 1 ; i++)
    {
        for (int j = i + 1; j < n count; j++)
        {
            int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
        }
        
    }
    printf("Array in descending order: ");
    for(int i = 0; i < n; i++){
        printf("%d ", arr[i]);
    }
    printf("\n");
    
}

void checkAllOdd(int arr[], int n){
    for (int i = 0; i < n; i++)
    {
     if(arr[i] % 2 == 0)  {
         printf("Not all elements of the array are odd");
         return;
     }
     
    }
    
    

}


int searchValue(int arr[], int n, int x){
    int count = 0;
    for (int i = 0; i < n; i++)
    {
        if(arr[i] == x){
            count++;
            continue;
        }
    }
    printf("value %d appears %d in the array",x,count);
    return count;

}


void displayMenu(){
    printf("\n===== ARRAY MANAGEMENT PROGRAM =====\n");
    printf("1. Input the array\n");
    printf("2. Output the array\n");
    printf("3. Print array in descending order\n");
    printf("4. Check if all elements are odd\n");
    printf("5. Search a value\n");
    printf("6. Display prime numbers in the array\n");
    printf("7. Quit\n");
    printf("Choose an option: ");
}

int isPrime(int num){
        if(num < 2 ){
            return 0;
        }
        for (int i = 2; i <= num/2; i++)
        {
            if(num % i == 0){
                return 0;
            }
        }
        return 1;
}

void displayPrime(int arr[],int n){
     printf("Prime numbers in the array: ");
     for (int i = 0; i < n; i++)
     {
        if(isPrime){
           printf("%d ", arr[i]);
        }
     }
      printf("\n");
     
}

int quitProgram(){
     int confirm;
    printf("Are you sure? Enter 1 to exit the application: ");
    scanf("%d", &confirm);
    if(confirm == 1 ){
         printf("Exiting program...\n");
        return 1;
    } else {
        printf("Cancel exit. Returning to menu.\n");
        return 0; // trả về 0 để quay lại menu
    }
}





int main(){
    int arr[100];
    int n;
    int choice;
    int flag = 0;
  
    outputArray(arr,n);
    checkAllOdd(arr,n);
do
{
     displayMenu();
    printf("Enter choice of you：");
    scanf("%d",&choice);

    switch (choice)
    {
    case 1:
         n = inputArray(arr,n);
        break;
    case 2:
         outputArray(arr,n);
        break;

    case 3:
         sortDescending(arr,n);
        break;
    case 4:
         checkAllOdd(arr,n);
        break;
    case 5:
        int x;
        printf("Enter value to search: ");
        scanf("%d", &x);
        searchValue(arr,n,x);
        break;
    case 6:
        displayPrime(arr,n);
        break;
     case 7:
            flag = quitProgram(); 
    
    default:
        break;
    }
} while (flag == 0);

   
}
    




