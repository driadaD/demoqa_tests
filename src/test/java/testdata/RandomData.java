package testdata;

import com.github.javafaker.Faker;

import java.text.SimpleDateFormat;
import java.util.*;

public class RandomData {
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMMM yyyy", Locale.ENGLISH);
    public String[] birthday = dateFormat.format(faker.date().birthday()).split(" ");

    static Random random = new Random();
    static Faker faker = new Faker();

    public static String getRandomFirstName() {
        return faker.name().firstName();
    }

    public static String getRandomLastName() {
        return faker.name().lastName();
    }

    public static String getRandomEmail() {
        return faker.internet().emailAddress();
    }

    public static String getRandomPhone(int len) {
        return faker.number().digits(len);
    }

    public static String getRandomAddress() {
        return faker.address().fullAddress();
    }

    public static String getRandomGender() {
        String[] arrayGenders = {
                "Male",
                "Female",
                "Other"
        };
        return arrayGenders[random.nextInt(arrayGenders.length)];
    }

    public static String getRandomSubject() {
        String[] arraySubjects = {
                "Maths",
                "Accounting",
                "Arts",
                "Social Studies",
                "History",
                "Economics",
                "Biology",
                "Computer Science",
                "English",
                "Chemistry",
                "Physics",
                "Commerce",
                "Hindi",
                "Civics"
        };
        return arraySubjects[random.nextInt(arraySubjects.length)];
    }

    public static String getRandomHobbies() {
        String[] arrayHobbies = {
                "Sports",
                "Reading",
                "Music"
        };
        return arrayHobbies[random.nextInt(arrayHobbies.length)];
    }

    public static String getRandomPicture() {
        String[] arrayPicture = {
                "885565472.jpg",
                "c48cad7a7260a951cb8d2236462cc538.jpg",
                "Daenerys.jpg"
        };
        return arrayPicture[random.nextInt(arrayPicture.length)];
    }

    public static String getRandomState() {
        String[] arrayStates = {
                "NCR",
                "Uttar Pradesh",
                "Haryana",
                "Rajasthan"
        };
        return arrayStates[random.nextInt(arrayStates.length)];
    }

    public static String getRandomCity(String key) {
        Map<String, String[]> mapStateCity = new HashMap<>();
        mapStateCity.put("NCR", new String[]{"Delhi", "Gurgaon", "Noida"});
        mapStateCity.put("Uttar Pradesh", new String[]{"Agra", "Lucknow", "Merrut"});
        mapStateCity.put("Haryana", new String[]{"Karnal", "Panipat"});
        mapStateCity.put("Rajasthan", new String[]{"Jaipur", "Jaiselmer"});

        String[] arrayCities = mapStateCity.get(key);
        return arrayCities[random.nextInt(arrayCities.length)];
    }
}
