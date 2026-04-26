
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
#include <stdio.h>

int inputArray(int arr[], int n){
    do {
        printf("Enter number of elements (1-100): ");
        scanf("%d",&n);
    } while (n <= 0 || n > 100);

    for (int i = 0; i < n; i++){
        printf("Enter element %d: ", i + 1);
        scanf("%d",&arr[i]);
    }
    return n;
}

void outputArray(int arr[], int n){
    printf("DEBUG n = %d\n", n);   // thêm dòng này

    if(n == 0){
        printf("Array is empty! Please input first.\n");
        return;
    }

    for (int i = 0; i < n; i++){
        printf("%d ", arr[i]);
    }
    printf("\n");
}


void sortDescending(int arr[], int n){
    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j < n - 1; j++)
        {
            if(arr[j] < arr[j+1]){
                int temp =arr[j];
                arr[j] = arr[j+1];
                arr[j+1] = temp;
            }
        }
        
    }

}

int checkAllOdd(int arr[], int n){
    for (int i = 0; i < n; i++)
    {
        if(arr[i] % 2 == 0){
            return 0;
        }
    }
    return 1;
    

}
// 5️⃣ Tìm kiếm một giá trị (2 điểm)
int searchValue(int arr[], int n, int x){
    int count = 0;
    for (int i = 0; i < n; i++)
    {
        if(arr[i] == x){
            count++;
            

        }
    }
    return count;
    

}

// displayPrime()
Nếu một số num mà:

// ngoài 1 và chính nó
// còn chia hết cho một số khác nữa

// → thì nó không phải số nguyên tố
int isPrime(int num){
    
  if(num < 2){
        return 0;
    }
    for (int i = 2; i < num; i++)
    {
        if(num % i == 0){
            return 0;
        }
    }
    return 1;
    
}

void displayPrime(int arr[], int n){
    printf("Cac so nguyen to trong mang:\n ");
    for (int i = 0; i < n; i++)
    {
       if(isPrime(arr[i])){
        printf("so nguyen to la %d\n", arr[i]);
       }
    }
     printf("\n");
    

}


// quitProgram()
int shouldExit(int confirm){
    return confirm == 1;
}
int quitProgram(){
    int confirm;
    printf("Are you sure? Enter 1 to exit the application: ");
    scanf("%d", &confirm);
    if(shouldExit){
        printf("Exiting program...\n");
        return 1;  
    } else {
        printf("Cancel exit. Returning to menu.\n");
        return 0; // trả về 0 để quay lại menu
    }

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
int main(){
    int arr[100];
    int n = 0;
    int choice,checkOdd,x, foundX;
    int flag = 0;
    
    

    do{
        displayMenu();
        scanf("%d",&choice);

        switch(choice){
            case 1:
                n = inputArray(arr,n);
                break;
            case 2:
                outputArray(arr,n);
                break;
            case 3:
               sortDescending(arr,n);
               outputArray(arr,n);
             
                break;
            case 4:
              checkOdd = checkAllOdd(arr,n);
              if(checkOdd == 0){
                printf("cac chu so khong phai so le");
              }else{
                printf("cac chu so la so le");

              }
              break;
            case 5:
               int x;
                printf("Enter value to search: ");
                scanf("%d", &x);
              foundX = searchValue(arr,n,x);
              if(foundX){
              printf("Found %d appears %d times\n", x, foundX);
              }else{
                printf("Not found %d\n", x);
            }
                break;
            case 6:
              displayPrime(arr,n);
                break;
            case 7:
               flag = quitProgram();
                break;
            default:
                printf("Invalid!\n");
        }

    }while(flag != 1);

    return 0;
}