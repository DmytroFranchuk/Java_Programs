package org.loto.model;

import org.task3.NumberGeneratorForCard;

import java.util.*;

public class Card {
    private int [][] card;
    private static int count = 1;

    public Card() {
        this.card = NumberGeneratorForCard.init();
    }

    public int[][] getCard() {
        return card;
    }

    private int [][] init() {
        int [][] playingField = new int [3][9];
        boolean isGenerateAgain;
        do {
            isGenerateAgain = false;
            Set<Integer> set1 = new TreeSet<>();
            Set<Integer> set2 = new TreeSet<>();
            Set<Integer> set3 = new TreeSet<>();
            Set<Integer> set4 = new TreeSet<>();
            Map<Integer, List<Integer>> map1 = new HashMap<>();
            List<Integer> tempList = new ArrayList<>();
            while (set2.size() < 6) {
                int randomNum = new Random().nextInt(1, 9 + 1);
                set2.add(randomNum);
            }
            for (Integer column : set2) {
                int startValue = (column == 1) ? 1 : (column - 1) * 10;
                int endValue = (column == 9) ? column * 10 : column * 10 - 1;
                while (set3.size() < 2) {
                    int randomNum = new Random().nextInt(startValue, endValue + 1);
                    if (set3.add(randomNum)) {
                        tempList.add(randomNum);
                    }
                }
                map1.put(column, new ArrayList<>(tempList));
                set1.addAll(set3);
                tempList.clear();
                set3.clear();
            }
            set4.addAll(set2);
            for (int i = 1; i <= 9; i++) {
                if (!set4.add(i)) {
                    set4.remove(i);
                }
            }
            for (Integer column : set4) {
                int startValue = (column == 1) ? 1 : (column - 1) * 10;
                int endValue = (column == 9) ? column * 10 : column * 10 - 1;
                while (set3.size() < 1) {
                    int randomNum = new Random().nextInt(startValue, endValue + 1);
                    if (set3.add(randomNum)) {
                        tempList.add(randomNum);
                    }
                }
                map1.put(column, new ArrayList<>(tempList));
                set1.addAll(set3);
                tempList.clear();
                set3.clear();
            }
            //
//            System.out.println("Числа для карты в set1: " + Arrays.toString(set1.toArray()));
//            map1.forEach((key, value) -> {
//                System.out.print(key + ": ");
//                System.out.println(value);
//            });
            //
            Map<Integer, List<Integer>> summary = new HashMap<>();
            List<Integer> resultFromSet1 = new ArrayList<>(set1);
            int n = resultFromSet1.size();
            for (int i = 0; i < 3; i++) {
                if (resultFromSet1.size() == 5) {
                    Collections.sort(resultFromSet1);
                    summary.put(i, new ArrayList<>(resultFromSet1));
                    resultFromSet1.clear();
                    break;
                }
                List<Integer> numbersForRow = new ArrayList<>();
                while (numbersForRow.size() < 5) {
                    int position = new Random().nextInt(0, n);
                    int value = resultFromSet1.get(position);
                    int digit = value / 10;
                    boolean isDigit = false;
                    for (Integer elem : numbersForRow) {
                        if (digit == (elem / 10)) {
                            isDigit = true;
                            break;
                        }
                    }
                    if (!isDigit) {
                        numbersForRow.add(resultFromSet1.get(position));
                        resultFromSet1.remove(position);
                        n--;
                        if (numbersForRow.size() == 5) {
                            Collections.sort(numbersForRow);
                            summary.put(i, new ArrayList<>(numbersForRow));
                        }
                    }
                }
            }
            //
//            summary.forEach((key, value) -> {
//                System.out.print(key + ": ");
//                System.out.println(value);
//            });
            //
            for (int i = 0; i < 3; i++) {
                int tens = 0;
                int count = 0;
                for (int j = 0; j < 9; j++) {
                    if (count == 5) count = 0;
                    if (summary.get(i).get(count) / 10 == tens || (tens == 8 && summary.get(i).get(count) == 90)) {
                        playingField[i][j] = summary.get(i).get(count);
                        tens++;
                        count++;
                    } else {
                        tens++;
                        playingField[i][j] = -1;
                    }
                }
            }
            for (int i = 0; i < playingField.length; i++) {
                int countNumError = 0;
                for (int j = 0; j < playingField[0].length; j++) {
                    if (playingField[i][j] > 0) {
                        countNumError++;
                    }
                }
                if (countNumError < 5) {
                    isGenerateAgain = true;
                    break;
                }
            }
            System.out.println(count++ + " Поле карты: " + Arrays.deepToString(playingField));
        } while (isGenerateAgain);

        return playingField;
    }

}
