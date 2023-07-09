public class Main {
    public static void main(String[] args) {
        Person mom = new PersonBuilder()
                .setName("Аня")
                .setSurName("Петрова")
                .setAge(42)
                .setAddress("Москва, ул. Ленина,12")
                .build();
        if (mom.age >= 18) {
            Person son = mom.newChildBuilder()
                    .setName("Ваня")
                    .setSurName("Петров")
                    .setAddress("Москва, ул. Пушкина,14")
                    .build();
            son.happyBirthday();
            System.out.println("У " + mom + " есть сын, " + son);
        } else {
            System.out.println("У " + mom + " нет сына");
        }

    }
}
