package org.ls_2023_12_14.ThreadAtomicExample;

//import generator.Sequence;
//import generator.SequenceGenerator;

import java.util.ArrayList;
import java.util.List;

/**
 * В примере SequenceGeneratorExample сначала создается генератор последовательности SequenceGenerator.
 * После этого в цикле формируется массив из десяти Sequence, которые в параллельных потоках по три раза обращаются к
 * генератору последовательности.
 */
public class SequenceGeneratorExample {
    public static void main(String[] args) {
//        SequenceGenerator sg = new SequenceGenerator();
//        List<Sequence> sequences = new ArrayList<Sequence>();
//        for (int i = 0; i < 10; i++) {
//            Sequence seq = new Sequence(i + 1, 3, sg);
//            sequences.add(seq);
//        }
//        System.out.println("\nРасчет последовательностей\n");
//        int summa;
//        // Ожидание завершения потоков
//        do {
//            summa = 0;
//            for (Sequence sequence : sequences) {
//                if (!sequence.getThread().isAlive()) {
//                    sequence.printSequence();
//                    summa++;
//                }
//            }
//            try {
//                Thread.sleep(100);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        } while (summa < sequences.size());
//        System.out.println("\n\nРабота потоков завершена");
//        System.exit(0);
    }
}