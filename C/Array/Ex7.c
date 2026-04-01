// Exercise 07

// Find and display all the prime numbers in the array

// 👉 Tìm và hiển thị tất cả các số nguyên tố trong mảng.

#include <stdio.h>
#include <math.h> // để dùng hàm sqrt()

// Hàm kiểm tra số nguyên tố
int isPrime(int n) {
    if(n < 2) return 0; // các số < 2 không phải nguyên tố

    // Duyệt từ 2 đến căn bậc 2 của n
    for(int i = 2; i <= sqrt(n); i++) {
        if(n % i == 0) {
            return 0; // nếu chia hết -> không phải nguyên tố
        }
    }

    return 1; // nếu không chia hết cho số nào -> là nguyên tố
}

int main() {
    // Khai báo mảng số nguyên
    int arr[8] = {2, 3, 4, 5, 6, 7, 8, 11};
    int size = 8; // số phần tử trong mảng

    printf("Cac so nguyen to trong mang: ");

    // Duyệt từng phần tử của mảng
    for(int i = 0; i < size; i++) {

        // Kiểm tra nếu phần tử là số nguyên tố
        if(isPrime(arr[i])) {

            // In ra số nguyên tố đó
            printf("%d ", arr[i]);
        }
    }

    printf("\n"); // xuống dòng sau khi in xong
    return 0;
}