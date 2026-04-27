package constroucts.lab2;

import java.util.Locale;

public class Trainee {
    private String id;
    private String name;
    private String gender;
    private byte age;

    public Trainee(String id, String name, String gender, byte age) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        if (id == null || id.trim().isEmpty()){
         throw new IllegalArgumentException("ID not vaild");
        }
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()){
            throw new IllegalArgumentException("Name not empty");
        }
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        if (gender == null || gender.trim().isEmpty()){
            throw new IllegalArgumentException("Gender not empty");
        }
        if(!gender.equalsIgnoreCase("male")&&!gender.equalsIgnoreCase("female")){
            throw new IllegalArgumentException("Gender not vaild");
        }

        this.gender = gender;
    }

    public byte getAge() {
        return age;
    }

    public void setAge(byte age) {
        if(age < 18){
            throw new IllegalArgumentException("Age must be >= 18 ");

        }
        this.age = age;
    }

    @Override
    public String toString() {
        return "Trainee{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                '}';
    }
}
