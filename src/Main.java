public class Main {
    public static void main(String[] args) {
        // Создаем актеров
        Actor actor1 = new Actor("Алексей", "Иванов", Gender.MALE, 180);
        Actor actor2 = new Actor("Мария", "Смирнова", Gender.FEMALE, 170);
        Actor actor3 = new Actor("Олег", "Кузнецов", Gender.MALE, 178);

        // Создаем режиссёров
        Director director1 = new Director("Иван", "Петров", Gender.MALE, 25);
        Director director2 = new Director("Анна", "Сидорова", Gender.FEMALE, 15);

        // Создаем автора музыки и хореографа
        String composer = "Петр Ильич Чайковский";
        String choreographer = "Надежда Бородина";

        // Создаем спектакли
        // Обычный спектакль
        Show show = new Show(
                "Ревизор",
                150,
                director1
        );

        // Оперный спектакль
        Opera opera = new Opera(
                "Евгений Онегин",
                180,
                director2,
                composer,
                "Либретто оперы Евгений Онегин",
                40 // размер хора
        );

        // Балет
        Ballet ballet = new Ballet(
                "Лебединое озеро",
                120,
                director1,
                composer,
                "Либретто балета Лебединое озеро",
                choreographer
        );

        // Распределяем актёров по спектаклям
        // Актёр 1 участвует в обычном спектакле и опере
        show.addActor(actor1);
        show.addActor(actor2);

        opera.addActor(actor1);
        opera.addActor(actor3);

        ballet.addActor(actor2);
        ballet.addActor(actor3);

        // Выводим списки актёров для каждого спектакля
        System.out.println("=== СПИСКИ АКТЁРОВ ПОСЛЕ РАСПРЕДЕЛЕНИЯ ===");

        System.out.println("\nОбычный спектакль \"" + show.title + "\":");
        show.printActors();

        System.out.println("\nОперный спектакль \"" + opera.title + "\":");
        opera.printActors();

        System.out.println("\nБалет \"" + ballet.title + "\":");
        ballet.printActors();

        // Заменяем актёра в одном из спектаклей на актёра из другого спектакля
        System.out.println("\n=== ЗАМЕНА АКТЁРА В БАЛЕТЕ ===");
        ballet.replaceActor(actor1, "Смирнова"); // Заменяем Марию Смирнову на Алексея Иванова

        // Выводим обновленный список актёров для балета
        System.out.println("\nБалет \"" + ballet.title + "\" после замены:");
        ballet.printActors();

        // Пытаемся заменить несуществующего актёра в опере
        System.out.println("\n=== ПОПЫТКА ЗАМЕНЫ НЕСУЩЕСТВУЮЩЕГО АКТЁРА ===");
        opera.replaceActor(actor2, "Петрова");

        // Выводим либретто для оперного и балетного спектаклей
        System.out.println("\n=== ЛИБРЕТТО СПЕКТАКЛЕЙ ===");

        System.out.println("\nОперный спектакль \"" + opera.title + "\":");
        opera.printLibretto();

        System.out.println("\nБалет \"" + ballet.title + "\":");
        ballet.printLibretto();

        // Дополнительная информация о режиссёрах
        System.out.println("\n=== ИНФОРМАЦИЯ О РЕЖИССЁРАХ ===");
        show.printDirectorInfo();
        opera.printDirectorInfo();
    }
}
