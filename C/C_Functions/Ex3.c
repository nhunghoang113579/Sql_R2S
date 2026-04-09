#include <stdio.h>

#define SUBJECTS 4

// Hàm nhập điểm
float inputMark(char courseName[]){
    float mark;
    do{
        printf("Enter score for %s (0-10): ", courseName);
        scanf("%f",&mark);

        if(mark < 0 || mark > 10){
            printf("Invalid score! Please enter again.\n");
        }

    }while(mark < 0 || mark > 10);

    return mark;
}

// Tính trung bình
float avg(float marks[]){
    float sum = 0;

    for(int i = 0; i < SUBJECTS; i++){
        sum += marks[i];
    }

    return sum / SUBJECTS;
}

// Tính GPA
float gpaFromAvg(float avg10){
    return (avg10 / 10.0) * 4.0;
}

// Xếp loại
void displayRank(float gpa){

    if(gpa >= 3.60)
        printf("Excellent\n");

    else if(gpa >= 3.20)
        printf("Good\n");

    else if(gpa >= 2.50)
        printf("Fair\n");

    else if(gpa >= 2.00)
        printf("Average\n");

    else
        printf("Weak\n");
}

int main(){

    float marks[SUBJECTS];
    char courses[SUBJECTS][20] = {"Database","C","OOP","Java"};

    float avgResult = 0;
    float gpaResult = 0;

    int choice;

    do{

        printf("\n===== MENU =====\n");
        printf("1. Input marks\n");
        printf("2. Display GPA\n");
        printf("3. Display Rank\n");
        printf("4. Quit\n");

        printf("Enter your choice: ");
        scanf("%d",&choice);

        switch(choice){

            case 1:

                for(int i = 0; i < SUBJECTS; i++){
                    marks[i] = inputMark(courses[i]);
                }

                avgResult = avg(marks);
                gpaResult = gpaFromAvg(avgResult);

                break;

            case 2:

                if(avgResult == 0)
                    printf("Please input marks first!\n");
                else
                    printf("Your GPA is: %.2f\n", gpaResult);

                break;

            case 3:

                if(avgResult == 0)
                    printf("Please input marks first!\n");
                else
                    displayRank(gpaResult);

                break;

            case 4:

                printf("Exiting program...\n");
                break;

            default:

                printf("Invalid choice!\n");
        }

    }while(choice != 4);

    return 0;
}