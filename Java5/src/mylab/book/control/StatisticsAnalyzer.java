package mylab.book.control;

import mylab.book.entity.Magazine;
import mylab.book.entity.Novel;
import mylab.book.entity.ReferenceBook;
import mylab.book.entity.Publication;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

public class StatisticsAnalyzer {

    public Map<String, Double> calculateAveragePriceByType(Publication[] pubs) {
        Map<String, Double> sumMap = new HashMap<>();
        Map<String, Integer> countMap = new HashMap<>();

        for (Publication p : pubs) {
            String type = getType(p);
            sumMap.put(type, sumMap.getOrDefault(type, 0.0) + p.getPrice());
            countMap.put(type, countMap.getOrDefault(type, 0) + 1);
        }

        Map<String, Double> avgMap = new HashMap<>();
        for (String type : sumMap.keySet()) {
            avgMap.put(type, sumMap.get(type) / countMap.get(type));
        }
        return avgMap;
    }

    public Map<String, Double> calculatePublicationDistribution(Publication[] pubs) {
        Map<String, Integer> countMap = new HashMap<>();
        int total = pubs.length;

        for (Publication p : pubs) {
            String type = getType(p);
            countMap.put(type, countMap.getOrDefault(type, 0) + 1);
        }

        Map<String, Double> distMap = new HashMap<>();
        for (String type : countMap.keySet()) {
            distMap.put(type, countMap.get(type) * 100.0 / total);
        }
        return distMap;
    }

    public double calculatePublicationRatioByYear(Publication[] pubs, String year) {
        int match = 0;
        for (Publication p : pubs) {
            if (p.getPublishDate().startsWith(year)) {
                match++;
            }
        }
        return match * 100.0 / pubs.length;
    }

    private String getType(Publication p) {
        if (p instanceof Novel)          return "�Ҽ�";
        if (p instanceof ReferenceBook)  return "����";
        if (p instanceof Magazine)       return "����";
        return "��Ÿ";
    }

    public void printStatistics(Publication[] pubs) {
        DecimalFormat moneyFmt = new DecimalFormat("#,###");
        DecimalFormat pctFmt   = new DecimalFormat("0.00");

        System.out.println("===== ���ǹ� ��� �м� =====");

        // 1) ��� ����
        System.out.println("1. Ÿ�Ժ� ��� ����:");
        Map<String, Double> avg = calculateAveragePriceByType(pubs);
        for (String type : new String[]{"�Ҽ�", "����", "����"}) {
            if (avg.containsKey(type)) {
                System.out.printf("   - %s: %s��%n",
                    type, moneyFmt.format(avg.get(type).intValue()));
            }
        }
        System.out.println();

        // 2) ����
        System.out.println("2. ���ǹ� ���� ����:");
        Map<String, Double> dist = calculatePublicationDistribution(pubs);
        for (String type : new String[]{"�Ҽ�", "����", "����"}) {
            if (dist.containsKey(type)) {
                System.out.printf("   - %s: %s%%%n",
                    type, pctFmt.format(dist.get(type)));
            }
        }
        System.out.println();

        // 3) ������ ����
        double ratio2007 = calculatePublicationRatioByYear(pubs, "2007");
        System.out.printf("3. 2007�⿡ ���ǵ� ���ǹ� ����: %s%%%n",
            pctFmt.format(ratio2007));

        System.out.println("=============================");
    }
}
