package domain;

public class Kindergarden {
    private int id;
    private int age;
    private String name;
    private String gender;
    private String group_name;
    private int group_number;

    public Kindergarden() {
    }

    public Kindergarden(String name, int age, String gender, String group_name, int group_number) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.group_name = group_name;
        this.group_number = group_number;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }

    public void setAge(int age){
        this.age = age;
    }
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getGroup_name() {
        return group_name;
    }

    public void setGroup_name(String group_name) {
        this.group_name = group_name;
    }

    public int getGroup_number() {
        return group_number;
    }

    public void setGroup_number(int group_number) {
        this.group_number = group_number;
    }

    @Override
    public String toString() {
        return "\nДетский сад{" +
                "id=" + id +
                ",ФИО='" + name + '\'' +
                ",Возраст='" + age + '\'' +
                ",Название группы='" + group_name + '\'' +
                ",Номер группы='" + group_number + '\'' +
                "}";
    }
}

