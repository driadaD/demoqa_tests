package pages;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.selector.ByText;
import pages.components.CalendarComponent;
import pages.components.PracticeResultsModal;

import java.io.File;

import static com.codeborne.selenide.Selenide.*;

public class PracticePage {
    private CalendarComponent calendarComponent = new CalendarComponent();
    private PracticeResultsModal practiceResultsModal = new PracticeResultsModal();
    private String roadFile = "src/test/resources/";

    private SelenideElement firstNameInput = $("#firstName"), lastNameInput = $("#lastName"), emailInput = $("#userEmail"), genderInput = $("#genterWrapper"), phoneInput = $("#userNumber"), birthDateInput = $("#dateOfBirthInput"), subjectsInput = $("#subjectsInput"), hobbiesInput = $("#hobbiesWrapper"), pictureInput = $("#uploadPicture"), addressInput = $("#currentAddress");


    public PracticePage openPage() {
        open("/automation-practice-form");

        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");

        return this;
    }

    public PracticePage setFirstName(String value) {
        firstNameInput.setValue(value);

        return this;
    }

    public PracticePage setLastName(String value) {
        lastNameInput.setValue(value);

        return this;
    }

    public PracticePage setEmail(String value) {
        emailInput.setValue(value);

        return this;
    }

    public PracticePage setGender(String value) {
        genderInput.$(new ByText(value)).click();

        return this;
    }

    public PracticePage setPhone(String value) {
        phoneInput.setValue(value);

        return this;
    }

    public PracticePage setBirthDate(String day, String month, String year) {
        birthDateInput.click();
        calendarComponent.setDate(day, month, year);

        return this;
    }

    public PracticePage setSubjects(String value) {
        subjectsInput.setValue(value).pressEnter();

        return this;
    }

    public PracticePage setHobbies(String value) {
        hobbiesInput.$(new ByText(value)).click();

        return this;
    }

    public PracticePage setPicture(String value) {
        pictureInput.uploadFile(new File(roadFile + value));

        return this;
    }

    public PracticePage setAddress(String value) {
        addressInput.setValue(value);

        return this;
    }

    public PracticePage setState(String value) {
        $("#state").click();
        $("#stateCity-wrapper").$(new ByText(value)).click();

        return this;
    }

    public PracticePage setCity(String value) {
        $("#city").click();
        $("#stateCity-wrapper").$(new ByText(value)).click();

        return this;
    }

    public PracticePage clickSubmit() {
        $("#submit").click();

        return this;
    }

    public PracticePage clickCloseModal() {
        $("#closeLargeModal").click();

        return this;
    }

    public PracticePage verifyResultsModalAppears() {
        practiceResultsModal.verifyModalAppears();

        return this;
    }

    public PracticePage verifyResult(String key, String value) {
        practiceResultsModal.verifyResult(key, value);

        return this;
    }
}
