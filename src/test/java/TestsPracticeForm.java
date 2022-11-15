import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.selector.ByText;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class TestsPracticeForm {

    @BeforeAll
    static void setUp(){
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = true;
    }

    @Test
    void practiceFormTest(){
        String userName = "Дейнерис";
        String lastName = "Таргариен";
        String email = "Khaleesi@queen.com";
        String mobile = "89997779977";
        String subjects = "History";
        String currentAddress = "Dragonstone";

        open("/automation-practice-form");

        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");

        $("#firstName").setValue(userName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(email);
        $("#genterWrapper").$(new ByText("Female")).click();
        $("#userNumber").setValue(mobile);
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("October");
        $(".react-datepicker__year-select").selectOption("1986");
        $(".react-datepicker__day--023:not(.react-datepicker__day--outside-month)").click();
        $("#subjectsInput").setValue(subjects).pressEnter();
        $("#hobbiesWrapper").$(new ByText("Sports")).click();
        $("#hobbiesWrapper").$(new ByText("Music")).click();
        $("#hobbies-checkbox-1").parent().click();
        $("#uploadPicture").uploadFile(new File("src/test/resources/Daenerys.jpg"));
        $("#currentAddress").setValue(currentAddress);
        $("#state").click();
        $("#stateCity-wrapper").$(new ByText("NCR")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(new ByText("Gurgaon")).click();
        $("#submit").click();

        $(".modal-title").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(text(userName +" "+ lastName), text(email), text("23 October,1986"), text("Female"), text(subjects), text(currentAddress));

        $("#closeLargeModal").click();
    }
}
