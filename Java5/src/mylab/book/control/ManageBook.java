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
            new Magazine("����ũ�μ���Ʈ",   "2007-10-01", 328,  9900, "�ſ�"),
            new Magazine("�濵����ǻ��",     "2007-10-03", 316,  9000, "�ſ�"),
            new Novel(   "���߿�",         "2007-07-01", 396,  9800, "����������������", "����Ҽ�"),
            new Novel(   "���ѻ꼺",       "2007-04-14", 383, 11000, "����",           "���ϼҼ�"),
            new ReferenceBook("�ǿ��������α׷���","2007-01-14",496,25000, "����Ʈ�������"),
            new Novel(   "�ҳ��̿´�",     "2014-05-01", 216, 15000, "�Ѱ�",           "����Ҽ�"),
            new Novel(   "�ۺ������ʴ´�", "2021-09-09", 332, 15120, "�Ѱ�",           "����Ҽ�")
        };

        System.out.println("==== ���� ���� ��� ====");
        for (int i = 0; i < pubs.length; i++) {
            System.out.printf("%d. %s%n", i+1, pubs[i]);
        }
        System.out.println();

        System.out.println("==== ���� ���� ====");
        Publication target = pubs[6];
        int before = target.getPrice();
        System.out.printf("%s ���� �� ����: %d��%n", target.getTitle(), before);
        modifyPrice(target);
        int after = target.getPrice();
        System.out.printf("%s ���� �� ����: %d��%n", target.getTitle(), after);
        System.out.printf("����: %d��%n", before - after);
        System.out.println();

        // ��� �м�
        StatisticsAnalyzer analyzer = new StatisticsAnalyzer();
        analyzer.printStatistics(pubs);
    }
}
