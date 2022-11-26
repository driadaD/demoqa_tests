package testdata;

import static testdata.RandomData.*;

public class RandomDataUserPracticeForm {
    public  String firstName,
            lastName,
            email,
            gender,
            mobile,
            subjects,
            hobbies,
            picture,
            address,
            state,
            city;

    public RandomDataUserPracticeForm() {
        this.firstName = getRandomFirstName();
        this.lastName = getRandomLastName();
        this.email = getRandomEmail();
        this.gender = getRandomGender();
        this.mobile = getRandomPhone(10);
        this.subjects = getRandomSubject();
        this.hobbies = getRandomHobbies();
        this.picture = getRandomPicture();
        this.address = getRandomAddress();
        this.state = getRandomState();
        this.city = getRandomCity(state);
    }
}
