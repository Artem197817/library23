package library;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;


public class Person implements Serializable {

    private static final long serialVersionUID = 5888800691746286271L;
    private final String name;
    private final int age;
    private static List<Person> people = new ArrayList<>();
    public static void setPeople(ArrayList<Person> p){
        people = p;
    }
    public static List<Person> getPeople(){
        return people;
    }
    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
    public Person(String name, int age) {
        this.name = name;
        this.age = age;

    }
    @Override
    public String toString() {
        return "Person{" +
                "Имя " + name + '\'' +
                ", возраст " + age +
                '}';
    }
    public static void personList (Person person){
        if (Decor.confirmPane("Зарегистрировать читателя?" + "\n" + person))
            people.add(person);
    }
    public static Person personNew() {
      String name =  Person.inputName();
        if (name.equals("Xrenas2"))
            name = "No name";
      int ageInt = Person.inputAge();
        return new Person(name, ageInt);
    }
    public static Person personName(){
        String name = Decor.inputPane("Введите имя читателя:");
        if (name == null) return null;
        List<Person> p = Person.getPeople().stream()
                .filter(person -> person.getName().toLowerCase().contains(name.toLowerCase()))
                .collect(Collectors.toList());
        if (p.isEmpty()) {
            System.out.println("Читатель незарегистрирован");
            return null;
        }
        if (p.size() == 1) {
            return p.get(0);
        } else {
            for (int i = 0; i < p.size(); i++)
                System.out.println("id - " + (i + 1) + "  " + p.get(i));
            System.out.println("Уточните имя указав id");
            int id = ActionLibrary.checkId(p.size());
                return p.get(id - 1);
        }
    }
    public static Person personNull () {
        if (Decor.confirmPane("Зврегистриоать нового читателя?"))
            return Person.personNew();
        if (Decor.confirmPane("Уточнить имя?")) {
            String name =  Decor.inputPane("Введите имя читателя:");
            if (name == null) return null;
            return Person.personName();
        }
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age && Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    public static String inputName() {
        String name = Decor.inputPane("Введите имя");
        if (name == null)
            return "Xrenas2";
        return name;
    }
    public static int inputAge() {
        String age;
        while (true) {
            age = Decor.inputPane(" Введите возраст");
            if (age != null)
                if (age.matches("[0-9]*"))
                    if (Integer.parseInt(age) > 3 & Integer.parseInt(age) < 110)
                         break;
        }
        return Integer.parseInt(age);
    }
    public static void deletePerson() {
        Person person = Person.personName();
        if (person == null) {
            Decor.messagePane("Читатель не найден");
            return;
        }
        if (Decor.confirmPane("Удалить?"+"\n"+person))
            Person.getPeople().remove(person);
    }
}
