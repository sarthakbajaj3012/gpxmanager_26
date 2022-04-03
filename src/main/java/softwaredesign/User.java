package softwaredesign;

import static java.lang.System.out;


public class User {
    private String name;
    private Integer age;
    private String gender;
    private Integer height;
    private Integer weight;
//    private Input input;

    public User(String name , Integer age , String gender , Integer height , Integer weight ) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.weight = weight;
        this.height = height;
    }
//    public void setData(){
//        out.println("Name:");
//        this.name = input.getScan();
//        out.println("Age:");
//        this.age = Integer.parseInt(input.getScan());
//        out.println("Gender:");
//        this.gender = input.getScan();
//        out.println("Height in cm:");
//        this.height = Integer.parseInt(input.getScan());
//        out.println("Weight in kgs:");
//        this.weight = Integer.parseInt(input.getScan());
//    }
    public Integer getAge() {
        return age;
    }

    public Integer getHeight() {
        return height;
    }

    public Integer getWeight() {
        return weight;
    }

    public String getGender() {
        return gender;
    }

    public String getName() {
        return name;
    }
}
