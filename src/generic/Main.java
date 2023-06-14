package generic;

import generic.enums.Gender;
import generic.model.Animal;
import generic.model.Person;
import generic.service.serviceImpl.AnimalServiceImpl;
import generic.service.serviceImpl.PersonServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*1) Жаны проект тузунуз.
        2) 3 жаны пакет тузунуз - model, service
        3) model пакеттин ичине Person,Animal деген класс тузунуз, свойствалары - id, name, age, Gender .
        - Genderди enum кылып башка пакетке тузуп койсонуз болот.
        5) service пакеттин ичине GenericService деген generic interface тузунуз жана impl деген пакет тузуп коюнуз.
        6) GenericServiceтин ичинде 7 метод болот:
        String add(List<T>t);
        T getById(Long id);
        List<T> getAll();
        List<T> sortByName(); 1 ди басканда ascending, 2 ни басканда descending кылып сорттосун
        List<T> filterByGender(); 1 ди басканда female, 2 ни басканда male кылып фильтрлесин
        List<T> clear();
        7) impl пакеттин ичине PersonServiceImpl, AnimalServiceImpl деген класстарды тузунуз, бул класстар GenericService интерфейсин ишке ашырат .
        9) Main класста бардык методдорду чакырып иштетиниз.*/
public class Main {
    public static void main(String[] args) {
        List<Person> people = new ArrayList<>(
                List.of(new Person("Aibek", 21, Gender.MALE),
                        new Person("Sultan", 19, Gender.MALE),
                        new Person("Abil", 20, Gender.MALE),
                        new Person("Aizada", 23, Gender.FEMALE),
                        new Person("Aikanysh", 14,Gender.FEMALE))
        );
        List<Animal> animals = new ArrayList<>(
                List.of(new Animal("Dog", 4, Gender.MALE),
                        new Animal("Cat", 7, Gender.FEMALE),
                        new Animal("Сow", 6, Gender.FEMALE),
                        new Animal("Horse", 8, Gender.MALE))
        );
        PersonServiceImpl personService = new PersonServiceImpl();
        AnimalServiceImpl animalService = new AnimalServiceImpl();

        int num;
        do {
            System.out.println("1. Add persons");
            System.out.println("2. Get by id person");
            System.out.println("3. remove by name person");
            System.out.println("4. Get all person");
            System.out.println("5. Sort by name persons");
            System.out.println("6. Filter by gender person");
            System.out.println("7. Clear all person");
            System.out.println("8. Add animals");
            System.out.println("9. Get by id animal");
            System.out.println("10. remove by name animal");
            System.out.println("11. Get all animal");
            System.out.println("12. Sort by name animal");
            System.out.println("13. Filter by gender animal");
            System.out.println("14. Clear all animal");
            System.out.println("15. EXIT");
            Scanner scanner = new Scanner(System.in);
            num = scanner.nextInt();
            switch (num){
                case 1:
                    System.out.println(personService.add(people));
                    break;
                case 2:
                    Scanner scanner1 = new Scanner(System.in);
                    System.out.println("Введите id: ");
                    long id = scanner1.nextLong();
                    System.out.println(personService.getById(id));
                    break;
                case 3:
                    Scanner scanner2 = new Scanner(System.in);
                    System.out.println("Введите имя: ");
                    String name = scanner2.nextLine();
                    System.out.println(personService.removeByName(name));
                    break;
                case 4:
                    System.out.println(personService.getAll());
                    break;
                case 5:
                    System.out.println(personService.sortByName());
                    break;
                case 6:
                    System.out.println(personService.filterByGender());
                    break;
                case 7:
                    System.out.println(personService.clear());
                    break;
                case 8:
                    System.out.println(animalService.add(animals));
                    break;
                case 9:
                    Scanner scanner3 = new Scanner(System.in);
                    System.out.println("Введите id: ");
                    long AnimalId = scanner3.nextLong();
                    System.out.println(animalService.getById(AnimalId));
                    break;
                case 10:
                    Scanner scanner4 = new Scanner(System.in);
                    System.out.println("Введиет имя животных: ");
                    String AnimalName = scanner4.nextLine();
                    System.out.println(animalService.removeByName(AnimalName));
                    break;
                case 11:
                    System.out.println(animalService.getAll());
                    break;
                case 12:
                    System.out.println(animalService.sortByName());
                    break;
                case 13:
                    System.out.println(animalService.filterByGender());
                    break;
                case 14:
                    System.out.println(animalService.clear());
                    break;
                case 15:
                    System.out.println("EXIT");
                    break;
                default:
                    System.out.println("Не правильно выыбран режим");
            }
        }while (num!=15);
    }
}
