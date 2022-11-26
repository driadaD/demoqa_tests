package tests;

import org.junit.jupiter.api.Test;
import testdata.RandomData;
import testdata.RandomDataUserPracticeForm;

public class TestsPracticeFormRandomData extends TestBase {

    @Test
    void practiceFormTest() {

        RandomData randomData = new RandomData();
        RandomDataUserPracticeForm ranUserData = new RandomDataUserPracticeForm();
        String dateBirthDay = randomData.birthday[0],
                dateBirthMonth = randomData.birthday[1],
                dateBirthYear = randomData.birthday[2];

        practicePage.openPage()
                .setFirstName(ranUserData.firstName)
                .setLastName(ranUserData.lastName)
                .setEmail(ranUserData.email)
                .setGender(ranUserData.gender)
                .setPhone(ranUserData.mobile)
                .setBirthDate(dateBirthDay, dateBirthMonth, dateBirthYear)
                .setSubjects(ranUserData.subjects)
                .setHobbies(ranUserData.hobbies)
                .setPicture(ranUserData.picture)
                .setAddress(ranUserData.address)
                .setState(ranUserData.state)
                .setCity(ranUserData.city)
                .clickSubmit();

        practicePage.verifyResultsModalAppears()
                .verifyResult("Student Name", ranUserData.firstName + " " + ranUserData.lastName)
                .verifyResult("Student Email", ranUserData.email)
                .verifyResult("Gender", ranUserData.gender)
                .verifyResult("Mobile", ranUserData.mobile)
                .verifyResult("Date of Birth", dateBirthDay + " " + dateBirthMonth + "," + dateBirthYear)
                .verifyResult("Subjects", ranUserData.subjects)
                .verifyResult("Hobbies", ranUserData.hobbies)
                .verifyResult("Picture", ranUserData.picture)
                .verifyResult("Address", ranUserData.address)
                .verifyResult("State and City", ranUserData.state + " " + ranUserData.city);

        practicePage.clickCloseModal();
    }
}
