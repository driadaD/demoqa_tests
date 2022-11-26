package tests;

import com.codeborne.selenide.selector.ByText;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class TestsPracticeFormPageObjects extends TestBase {

    @Test
    void practiceFormTest() {
        String userName = "Дейнерис";
        String lastName = "Таргариен";
        String email = "Khaleesi@queen.com";
        String gender = "Female"; //Male;Female;Other
        String mobile = "9997779977";
        String dateBirthMonth = "October";
        String dateBirthYear = "1986";
        String dateBirthDay = "23";
        String subjects = "History";
        String hobbies = "Sports";
        String hobbies2 = "Music";
        String picture = "Daenerys.jpg";
        String address = "Dragonstone";
        String state = "NCR";
        String city = "Gurgaon";

        practicePage.openPage()
                .setFirstName(userName)
                .setLastName(lastName)
                .setEmail(email)
                .setGender(gender)
                .setPhone(mobile)
                .setBirthDate(dateBirthDay, dateBirthMonth, dateBirthYear)
                .setSubjects(subjects)
                .setHobbies(hobbies)
                .setHobbies(hobbies2)
                .setPicture(picture)
                .setAddress(address)
                .setState(state)
                .setCity(city)
                .clickSubmit();

        practicePage.verifyResultsModalAppears()
                .verifyResult("Student Name", userName + " " + lastName)
                .verifyResult("Student Email", email)
                .verifyResult("Gender", gender)
                .verifyResult("Mobile", mobile)
                .verifyResult("Date of Birth", dateBirthDay + " " + dateBirthMonth + "," + dateBirthYear)
                .verifyResult("Subjects", subjects)
                .verifyResult("Hobbies", hobbies + ", " + hobbies2)
                .verifyResult("Picture", picture)
                .verifyResult("Address", address)
                .verifyResult("State and City", state + " " + city);

        practicePage.clickCloseModal();
    }
}
