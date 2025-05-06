package mylab.book.control;

import mylab.book.entity.*;

public class ManageBook {

    public static void modifyPrice(Publication p) {
        int original = p.getPrice();
        int discounted;
        if (p instanceof Magazine) {
            discounted = (int)(original * 0.60);
        } else if (p instanceof Novel) {
            discounted = (int)(original * 0.80);
        } else if (p instanceof ReferenceBook) {
            discounted = (int)(original * 0.90);
        } else {
            return;
        }
        p.setPrice(discounted);
    }

    public static void main(String[] args) {
        Publication[] pubs = new Publication[] {
            new Magazine("마이크로소프트",   "2007-10-01", 328,  9900, "매월"),
            new Magazine("경영과컴퓨터",     "2007-10-03", 316,  9000, "매월"),
            new Novel(   "빠삐용",         "2007-07-01", 396,  9800, "베르나르베르베르", "현대소설"),
            new Novel(   "남한산성",       "2007-04-14", 383, 11000, "김훈",           "대하소설"),
            new ReferenceBook("실용주의프로그래머","2007-01-14",496,25000, "소프트웨어공학"),
            new Novel(   "소년이온다",     "2014-05-01", 216, 15000, "한강",           "장편소설"),
            new Novel(   "작별하지않는다", "2021-09-09", 332, 15120, "한강",           "장편소설")
        };

        System.out.println("==== 도서 정보 출력 ====");
        for (int i = 0; i < pubs.length; i++) {
            System.out.printf("%d. %s%n", i+1, pubs[i]);
        }
        System.out.println();

        System.out.println("==== 가격 변경 ====");
        Publication target = pubs[6];
        int before = target.getPrice();
        System.out.printf("%s 변경 전 가격: %d원%n", target.getTitle(), before);
        modifyPrice(target);
        int after = target.getPrice();
        System.out.printf("%s 변경 후 가격: %d원%n", target.getTitle(), after);
        System.out.printf("차액: %d원%n", before - after);
        System.out.println();

        // 통계 분석
        StatisticsAnalyzer analyzer = new StatisticsAnalyzer();
        analyzer.printStatistics(pubs);
    }
}
