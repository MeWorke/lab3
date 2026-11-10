package lab;

/**
 * Класс EBook.
 * Электронная книга с указанием формата файла.
 *
 * ВАЖНО: электронные книги НЕ выдаются пользователям, а предоставляются
 * для онлайн-доступа, поэтому класс НЕ реализует интерфейс IBorrowable.
 */
public class EBook extends LibraryItem {
    private String fileFormat;

    public EBook(int id, String title, int year, String fileFormat) {
        super(id, title, year);
        this.fileFormat = fileFormat;
    }

    public String getFileFormat() {
        return fileFormat;
    }

    /**
     * Электронные книги всегда доступны для онлайн-доступа.
     *
     * @return true
     */
    public boolean isOnlineAvailable() {
        return true;
    }

    @Override
    public boolean matches(String query) {
        // Поиск по основным атрибутам: название, год, формат файла
        if (super.matches(query)) {
            return true;
        }
        return fileFormat.toLowerCase().contains(query.trim().toLowerCase());
    }

    @Override
    public String getInfo() {
        return String.format("[Электронная книга] id=%d | \"%s\" | год: %d | формат: %s | онлайн-доступ: да",
                id, title, year, fileFormat);
    }
}

