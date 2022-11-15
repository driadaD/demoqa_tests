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
        String gender = "Female"; //Male;Female;Other
        String mobile = "9997779977";
        String dateBirthMonth = "October";
        String dateBirthYear = "1986";
        String dateBirthDay = "23";
        String subjects = "History";
        String hobbies = "Sports";
        String hobbies2 = "Music";
        String picture = "Daenerys.jpg";
        String currentAddress = "Dragonstone";

        open("/automation-practice-form");

        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");

        $("#firstName").setValue(userName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(email);
        $("#genterWrapper").$(new ByText(gender)).click();
        $("#userNumber").setValue(mobile);
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption(dateBirthMonth);
        $(".react-datepicker__year-select").selectOption(dateBirthYear);
        $(".react-datepicker__day--0"+ dateBirthDay +":not(.react-datepicker__day--outside-month)").click();
        $("#subjectsInput").setValue(subjects).pressEnter();
        $("#hobbiesWrapper").$(new ByText(hobbies)).click();
        $("#hobbiesWrapper").$(new ByText(hobbies2)).click();
        $("#uploadPicture").uploadFile(new File("src/test/resources/"+picture));
        $("#currentAddress").setValue(currentAddress);
        $("#state").click();
        $("#stateCity-wrapper").$(new ByText("NCR")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(new ByText("Gurgaon")).click();
        $("#submit").click();

        $(".modal-title").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(text(userName +" "+ lastName), text(email), text(gender), text(mobile), text(dateBirthDay+" "+dateBirthMonth+","+dateBirthYear), text(subjects), text(hobbies+ ", " +hobbies2), text(picture), text(currentAddress));

        $("#closeLargeModal").click();
    }
}
