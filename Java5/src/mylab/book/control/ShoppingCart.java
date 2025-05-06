package mylab.book.control;

import mylab.book.entity.Publication;
import mylab.book.entity.Magazine;
import mylab.book.entity.Novel;
import mylab.book.entity.ReferenceBook;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private List<Publication> items = new ArrayList<>();

    /**
     * ��ٱ��Ͽ� ���ǹ��� �߰�
     */
    public void addItem(Publication item) {
        items.add(item);
        System.out.printf("'%s' �������� ��ٱ��Ͽ� �߰��Ǿ����ϴ�.%n", item.getTitle());
    }

    /**
     * ������ ��ġ�ϴ� ���ǹ��� �����ϰ�, ���� ���� ��ȯ
     */
    public boolean removeItem(String title) {
        for (Publication p : items) {
            if (p.getTitle().equals(title)) {
                items.remove(p);
                System.out.printf("'%s' �������� ��ٱ��Ͽ��� ���ŵǾ����ϴ�.%n", title);
                return true;
            }
        }
        System.out.printf("'%s' �������� ã�� �� �����ϴ�.%n", title);
        return false;
    }

    /**
     * ���� �հ� ���
     */
    public int calculateTotalPrice() {
        return items.stream()
                    .mapToInt(Publication::getPrice)
                    .sum();
    }

    /**
     * Ÿ�Ժ� ������ ���� �� �Ѿ� ���
     * Magazine 10%, Novel 15%, ReferenceBook 20%
     */
    public int calculateDiscountedPrice() {
        int sum = 0;
        for (Publication p : items) {
            int price = p.getPrice();
            if (p instanceof Magazine) {
                sum += (int)(price * 0.90);
            } else if (p instanceof Novel) {
                sum += (int)(price * 0.85);
            } else if (p instanceof ReferenceBook) {
                sum += (int)(price * 0.80);
            } else {
                sum += price;
            }
        }
        return sum;
    }

    /**
     * ��ٱ��� �׸�� ���� ������ �ֿܼ� ���
     */
    public void displayCart() {
        System.out.println("=== ��ٱ��� ���� ===");
        for (Publication p : items) {
            // �� Publication�� toString()�� �� ������ ��ȯ�մϴ�.
            System.out.println(p);
        }
        System.out.printf("�� ����: %d��%n", calculateTotalPrice());
        System.out.printf("���� ���밡: %d��%n", calculateDiscountedPrice());
        System.out.println("===================");
    }
}
