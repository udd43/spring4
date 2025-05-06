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
        if (p instanceof Novel)          return "소설";
        if (p instanceof ReferenceBook)  return "참고서";
        if (p instanceof Magazine)       return "잡지";
        return "기타";
    }

    public void printStatistics(Publication[] pubs) {
        DecimalFormat moneyFmt = new DecimalFormat("#,###");
        DecimalFormat pctFmt   = new DecimalFormat("0.00");

        System.out.println("===== 출판물 통계 분석 =====");

        // 1) 평균 가격
        System.out.println("1. 타입별 평균 가격:");
        Map<String, Double> avg = calculateAveragePriceByType(pubs);
        for (String type : new String[]{"소설", "참고서", "잡지"}) {
            if (avg.containsKey(type)) {
                System.out.printf("   - %s: %s원%n",
                    type, moneyFmt.format(avg.get(type).intValue()));
            }
        }
        System.out.println();

        // 2) 분포
        System.out.println("2. 출판물 유형 분포:");
        Map<String, Double> dist = calculatePublicationDistribution(pubs);
        for (String type : new String[]{"소설", "참고서", "잡지"}) {
            if (dist.containsKey(type)) {
                System.out.printf("   - %s: %s%%%n",
                    type, pctFmt.format(dist.get(type)));
            }
        }
        System.out.println();

        // 3) 연도별 비율
        double ratio2007 = calculatePublicationRatioByYear(pubs, "2007");
        System.out.printf("3. 2007년에 출판된 출판물 비율: %s%%%n",
            pctFmt.format(ratio2007));

        System.out.println("=============================");
    }
}
