package generic.service.serviceImpl;

import generic.enums.Gender;
import generic.model.Animal;
import generic.model.Person;
import generic.service.GenericService;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class AnimalServiceImpl implements GenericService<Animal> {
    private List<Animal> animals = new ArrayList<>();

    @Override
    public String add(List<Animal> t) {
        animals.addAll(t);
        return "Успешно добавлен";
    }

    @Override
    public Animal getById(Long id) {
        for (Animal animal: animals){
            if (animal.getId()==id){
                return animal;
            }
        }
        return null;
    }

    @Override
    public String removeByName(String name) {
        for (Animal animal: animals){
            if (animal.getName().equalsIgnoreCase(name)){
                animals.remove(animal);
                return "Успешно удален";
            } else {
                return "Не найден";
            }
        }
        return null;
    }

    @Override
    public List<Animal> getAll() {
        return animals;
    }

    @Override
    public List<Animal> sortByName() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите 1 для вывода ascending, введите 2 для вывода descending");
        int num = scanner.nextInt();
        if (num==1){
            animals.sort(sortByName);
        } else {
            animals.sort(sortByNameD);
        }
        return animals;
    }

    @Override
    public List<Animal> filterByGender() {
        List<Animal> animalMALE = new ArrayList<>();
        List<Animal> animalFEMALE = new ArrayList<>();
        for (Animal animal: animals) {
            if (animal.getGender()== Gender.MALE){
               animalMALE.add(animal);
            } else {
                animalFEMALE.add(animal);
            }
        }
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите 1 для вывода всех MALE, введите 2 для вывода всех FEMALE");
        int num = scanner.nextInt();
        if (num ==1){
            return animalMALE;
        } else if (num ==2) {
            return animalFEMALE;
        }
        return null;
    }

    @Override
    public List<Animal> clear() {
        animals.clear();
        return animals;
    }


    public Comparator<Animal> sortByName = new Comparator<Animal>() {
        @Override
        public int compare(Animal o1, Animal o2) {
            return o1.getName().compareTo(o2.getName());
        }
    };


    public Comparator<Animal> sortByNameD = new Comparator<Animal>() {
        @Override
        public int compare(Animal o1, Animal o2) {
            return o2.getName().compareTo(o1.getName());
        }
    };
}
