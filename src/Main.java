import java.util.*;

import static java.util.Collections.addAll;

public class Main {
    private final Random random = new Random();
    private List<String> getSomeObjects() {
        int count = random.nextInt(10);
        List<String> values = new ArrayList<>(count);
        int b = 0;
        for (int i = 0; i <= count; i++) {
            String v = "Some string" + b++;
            values.add(v);
        }
        return values;
    }

    public Set<Person> getAll() throws InterruptedException {
        Set<Person> persons = null;
        try {
            connectToDb("my_db");
            persons = collectPersons(persons);

        } catch (Exception e) {
            wait(1000);
            try {
                connectToDb("my_db2");
                persons = collectPersons(persons);
            } catch (Exception e1) {
                persons = new HashSet<>(0);
                System.out.println("Sorry. Db in in used now!");
            }
        } finally {
            return  persons;
        }

    }

    private Set<Person> collectPersons(Set<Person> persons) {
        List<Person> personList = getPersonsFromDb();
        persons = new HashSet<>();
        addAll(personList);
        return persons;
    }

    public void connectToDb(String dbName) throws NullPointerException {
        System.out.println("Waiting for connect...");
        System.out.println(String.format("Connection to db %s successful!", dbName));
    }
    public static void main(String[] args) {
        Main m = new Main();
        List<String> persons = m.getSomeObjects();
        for (String s : persons) {
            System.out.println(s);
        }
        //persons.forEach(p -> System.out.println(p));
    }

    public List<Person> getPersonsFromDb() {
        List<Person> persons = new ArrayList<>();
        for (int i = 0; i <= 2; i++) {
            persons.add(new Person("Pavlo", "Smok", 31));
            persons.add(new Person("Arctem", "Kucheruk", 27));
        }

        return persons;
    }
}
