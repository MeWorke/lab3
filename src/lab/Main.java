package lab;
import java.util.List;
public class Main {
    public static void main(String[] args) {
        Library library = new Library();

        // --- Регистрация пользователей ---
        User ivan = new User(1, "Иван Петров");
        User maria = new User(2, "Мария Сидорова");
        library.addUser(ivan);
        library.addUser(maria);
        System.out.println();

        // --- Библиотекарь добавляет новые предметы в фонд ---
        Book book1 = new Book(101, "Война и мир", 1869, "Лев Толстой", 1225);
        Book book2 = new Book(102, "Преступление и наказание", 1866, "Федор Достоевский", 672);
        Book book3 = new Book(103, "Мастер и Маргарита", 1967, "Михаил Булгаков", 480);
        Journal journal1 = new Journal(201, "Наука и жизнь", 2024, 5);
        Journal journal2 = new Journal(202, "National Geographic", 2025, 1);
        EBook ebook1 = new EBook(301, "Java. Полное руководство", 2022, "PDF");
        EBook ebook2 = new EBook(302, "Clean Code", 2008, "EPUB");

        library.addItem(book1);
        library.addItem(book2);
        library.addItem(book3);
        library.addItem(journal1);
        library.addItem(journal2);
        library.addItem(ebook1);
        library.addItem(ebook2);
        System.out.println();

        // --- Краткие варианты использования ---

        // 1. Поиск книги по названию
        System.out.println(">>> Поиск по запросу \"Война\":");
        printSearchResult(library.find("Война"));

        // Поиск по автору
        System.out.println(">>> Поиск по автору \"Достоевский\":");
        printSearchResult(library.find("Достоевский"));

        // Поиск журнала по номеру выпуска
        System.out.println(">>> Поиск журнала по номеру выпуска \"5\":");
        printSearchResult(library.find("5"));

        // Поиск электронной книги по формату
        System.out.println(">>> Поиск электронной книги по формату \"PDF\":");
        printSearchResult(library.find("PDF"));
        System.out.println();

        // 2. Проверка доступности книги для выдачи
        System.out.println(">>> Проверка доступности \"" + book1.getTitle() + "\": "
                + book1.isAvailable());
        System.out.println();

        // 3. Выдача книги и журнала пользователю (если предмет доступен)
        System.out.println(">>> Выдача предметов пользователю " + ivan.getName() + ":");
        library.borrowItem(book1, ivan);
        library.borrowItem(journal1, ivan);
        System.out.println();

        // Электронные книги не выдаются — предоставляется онлайн-доступ.
        // EBook НЕ реализует IBorrowable, поэтому вызов вида
        // library.borrowItem(ebook1, ivan) не скомпилируется.
        System.out.println(">>> Электронная книга \"" + ebook1.getTitle()
                + "\" доступна онлайн: " + ebook1.isOnlineAvailable());
        System.out.println();

        // Повторная выдача той же книги другому пользователю — недоступна
        System.out.println(">>> Попытка выдать занятую книгу пользователю " + maria.getName() + ":");
        library.borrowItem(book1, maria);
        System.out.println(">>> Проверка доступности \"" + book1.getTitle() + "\": "
                + book1.isAvailable());
        System.out.println();

        // Выдача другой книги второму пользователю
        library.borrowItem(book2, maria);
        System.out.println();

        // 4. Возврат книги в библиотеку
        System.out.println(">>> Возврат книги \"" + book1.getTitle() + "\":");
        library.returnItem(book1, ivan);
        System.out.println(">>> Проверка доступности \"" + book1.getTitle() + "\": "
                + book1.isAvailable());
        System.out.println();

        // Попытка вернуть предмет, который не числится за пользователем
        System.out.println(">>> Попытка вернуть чужой предмет:");
        library.returnItem(book2, ivan);
        System.out.println();

        // 5. Информация о фонде и пользователях
        System.out.println(library.getCatalogInfo());
        System.out.println(library.getUsersInfo());
    }

    private static void printSearchResult(List<LibraryItem> result) {
        if (result.isEmpty()) {
            System.out.println("  Ничего не найдено.");
        } else {
            for (LibraryItem item : result) {
                System.out.println("  " + item.getInfo());
            }
        }
    }
}
