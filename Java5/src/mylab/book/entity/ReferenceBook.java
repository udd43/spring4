package mylab.book.entity;

public class ReferenceBook extends Publication {
    private String field;  // ��: "����Ʈ�������"

    public ReferenceBook(String title, String publishDate, int page,
                         int price, String field) {
        super(title, publishDate, page, price);
        this.field = field;
    }

    public String getField() {
        return field;
    }

    @Override
    public String toString() {
        return String.format("%s [����] �о�:%s, %d��, %d��, ������:%s",
            getTitle(), field, getPage(), getPrice(), getPublishDate());
    }
}
