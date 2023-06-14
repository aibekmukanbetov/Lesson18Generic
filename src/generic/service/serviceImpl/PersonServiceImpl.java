package generic.service.serviceImpl;

import generic.enums.Gender;
import generic.model.Person;
import generic.service.GenericService;

import java.util.*;

public class PersonServiceImpl implements GenericService<Person> {

    private List<Person> persons = new ArrayList<>();
    @Override
    public String add(List<Person> t) {
        persons.addAll(t);
        return "Люди ддобавлены";
    }

    @Override
    public Person getById(Long id) {
        for (Person person: persons) {
            if (person.getId()==id){
                return person;
            }
        }
        return null;
    }

    @Override
    public String removeByName(String name) {
        for (Person person: persons) {
            if (person.getName().equalsIgnoreCase(name)){
                persons.remove(person);
                return "Успешно удален";
            } else {
                return "Не найден";
            }
        }
        return null;
    }

    @Override
    public List<Person> getAll() {
        return persons;
    }

    @Override
    public List<Person> sortByName() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите 1 для вывода ascending, введите 2 для вывода descending");
        int num = scanner.nextInt();
        if(num==1){
            persons.sort(sortByName);
        } else {
            persons.sort(sortByNameD);
        }
        return persons;
    }

    @Override
    public List<Person> filterByGender() {
        List<Person> personMALE = new ArrayList<>();
        List<Person> personFEMALE = new ArrayList<>();
        for (Person person: persons) {
            if (person.getGender()== Gender.MALE){
                personMALE.add(person);
            } else {
                personFEMALE.add(person);
            }
        }
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите 1 для вывода всех MALE, введите 2 для вывода всех FEMALE");
        int num = scanner.nextInt();
        if (num ==1){
            return personMALE;
        } else if (num ==2) {
            return personFEMALE;
        }
        return null;
    }

    @Override
    public List<Person> clear() {
        persons.clear();
        return persons;
    }

    public static Comparator<Person> sortByName = new Comparator<Person>() {
        @Override
        public int compare(Person o1, Person o2) {
            return o1.getName().compareTo(o2.getName());
        }
    };

    public static Comparator<Person> sortByNameD = new Comparator<Person>() {
        @Override
        public int compare(Person o1, Person o2) {
            return o2.getName().compareTo(o1.getName());
        }
    };

}
