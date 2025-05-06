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
     * 장바구니에 출판물을 추가
     */
    public void addItem(Publication item) {
        items.add(item);
        System.out.printf("'%s' 아이템이 장바구니에 추가되었습니다.%n", item.getTitle());
    }

    /**
     * 제목이 일치하는 출판물을 제거하고, 성공 여부 반환
     */
    public boolean removeItem(String title) {
        for (Publication p : items) {
            if (p.getTitle().equals(title)) {
                items.remove(p);
                System.out.printf("'%s' 아이템이 장바구니에서 제거되었습니다.%n", title);
                return true;
            }
        }
        System.out.printf("'%s' 아이템을 찾을 수 없습니다.%n", title);
        return false;
    }

    /**
     * 원가 합계 계산
     */
    public int calculateTotalPrice() {
        return items.stream()
                    .mapToInt(Publication::getPrice)
                    .sum();
    }

    /**
     * 타입별 할인율 적용 후 총액 계산
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
     * 장바구니 항목과 가격 정보를 콘솔에 출력
     */
    public void displayCart() {
        System.out.println("=== 장바구니 내용 ===");
        for (Publication p : items) {
            // 각 Publication의 toString()이 상세 정보를 반환합니다.
            System.out.println(p);
        }
        System.out.printf("총 원가: %d원%n", calculateTotalPrice());
        System.out.printf("할인 적용가: %d원%n", calculateDiscountedPrice());
        System.out.println("===================");
    }
}
