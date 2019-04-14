package pbouda.asyncprofiler;

import com.google.gson.Gson;
import com.thedeanda.lorem.Lorem;
import com.thedeanda.lorem.LoremIpsum;

public class StringGenerator {

    public String generate() {
        Lorem LOREM = LoremIpsum.getInstance();
        var person = new Person(
                LOREM.getFirstName(),
                LOREM.getLastName(),
                LOREM.getEmail(),
                LOREM.getPhone(),
                LOREM.getTitle(5),
                LOREM.getUrl(),
                LOREM.getCity(),
                LOREM.getCountry(),
                LOREM.getZipCode());

        return new Gson().toJson(person);
    }

    private static class Person {
        private final String firstname;
        private final String lastname;
        private final String email;
        private final String phone;
        private final String title;
        private final String url;
        private final String city;
        private final String country;
        private final String zip;

        private Person(
                String firstname,
                String lastname,
                String email,
                String phone,
                String title,
                String url,
                String city,
                String country,
                String zip) {

            this.firstname = firstname;
            this.lastname = lastname;
            this.email = email;
            this.phone = phone;
            this.title = title;
            this.url = url;
            this.city = city;
            this.country = country;
            this.zip = zip;
        }
    }
}
