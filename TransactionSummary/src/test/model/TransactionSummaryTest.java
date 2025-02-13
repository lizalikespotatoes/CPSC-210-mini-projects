package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static model.TransactionType.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TransactionSummaryTest {

    private TransactionSummary testSummary;
    private Transaction t1;
    private Transaction t2;
    private Transaction t3;
    private Transaction t4;
    private Transaction t5;
    private Transaction t6;
    private Transaction t7;

    @BeforeEach
    public void setUp() {
        testSummary = new TransactionSummary("Donald Knuth");
        t1 = new Transaction("Movie", "May 1st", 10, ENTERTAINMENT);
        t2 = new Transaction("Restaurant", "May 11th", 20, FOOD);
        t3 = new Transaction("Clothes", "May 9", 40, SHOPPING);
        t4 = new Transaction("Textbooks", "May 8", 150, EDUCATION);
        t5 = new Transaction("Korean Food", "May 11", 11, FOOD);
        t6 = new Transaction("Vancouver Symphony", "May 15", 40, ENTERTAINMENT);
        t7 = new Transaction("Cake", "May 4", 5, FOOD);

        testSummary.addTransaction(t1);
        testSummary.addTransaction(t2);
        testSummary.addTransaction(t3);
        testSummary.addTransaction(t4);
        testSummary.addTransaction(t5);
        testSummary.addTransaction(t6);
        testSummary.addTransaction(t7);
    }

    @Test
    public void testConstructor() {
        assertEquals(testSummary.getName(), "Donald Knuth");
    }

    @Test
    public void testAddTransaction() {
        Transaction testTransaction = new Transaction("Test", "Test date", 0, FOOD);
        assertEquals(7, testSummary.getNumTransactions());
        testSummary.addTransaction(testTransaction);
        assertEquals(8, testSummary.getNumTransactions());
        assertTrue(testSummary.contains(testTransaction));
    }

    @Test
    public void testAverageTransactionCost() {
        TransactionSummary oneSummary = new TransactionSummary("Edsger Dijkstra");
        Transaction testTransaction = new Transaction("Food", "June 12", 5, FOOD);
        oneSummary.addTransaction(testTransaction);
        assertEquals(5, oneSummary.averageTransactionCost(), 0.05);
        assertEquals((10 + 20 + 40 + 150 + 11 + 40 + 5) / 7, testSummary.averageTransactionCost(), 0.05);
    }

    @Test
    public void testLargestTransaction() {
        assertEquals(t4, testSummary.largestTransaction());
        TransactionSummary oneSummary = new TransactionSummary("Edsger Dijkstra");
        Transaction testTransaction = new Transaction("Food", "June 12", 5, FOOD);
        oneSummary.addTransaction(testTransaction);
        assertEquals(testTransaction, oneSummary.largestTransaction());
    }

    @Test
    public void testspecificTypeAverage() {
        assertEquals((11 + 5 + 20) / 3, testSummary.specificTypeAverage(FOOD), 0.05);
        assertEquals(150, testSummary.specificTypeAverage(EDUCATION), 0.05);
    }


}