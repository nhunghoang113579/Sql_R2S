#include<stdio.h>

int main(){
     float r, area, perimeter;
     const float PI = 3.14;
      printf("Enter radius: ");
      scanf("%f",&r);

      area = PI * r * r;
      perimeter = PI * 2 * r;
       printf("Area = %.2f\n", area);
       printf("Perimeter = %.2f\n",perimeter);

}