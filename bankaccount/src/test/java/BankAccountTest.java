import org.junit.jupiter.api.Test;

import com.BankAccount;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;

    public class BankAccountTest {
        BankAccount account;
        @BeforeEach
        void setup() {
            account = new BankAccount(10000);
        }
        
        @Test
        public void testDepositNegativeQuantity() {
            try {
                account.deposit(-1);
                fail("Should have thrown an IllegalArgumentException");
            } catch (IllegalArgumentException e) {
                assertEquals("Amount cannot be negative", e.getMessage());
            }
        }

        @Test
        public void testDepositZeroQuantity() {
            account.deposit(0);
            assertEquals(10000, account.getBalance());
        }

        @Test
        public void testDeposit() {
            account.deposit(50);
            assertEquals(10050, account.getBalance());
        }

        // @Test
        // public void testWithdrawNegativeQuantity() {
        //     boolean ok = account.withdraw(-1);
        //     assertEquals(false, ok);
        // }

        @Test
        public void testWithdrawBiggerQuantity() {
            boolean ok = account.withdraw(10001);
            assertEquals(false, ok);
        }

        @Test
        public void testWithdraw() {
            account.withdraw(50);
            assertEquals(9950, account.getBalance());
        }

        @Test
        public void testWithdrawAll() {
            account.withdraw(10000);
            assertEquals(0, account.getBalance());
        }

        @Test
        public void testPayment() {
            assertEquals(838.759926, account.payment(10000, 0.001, 12), 0.01);
        }

        @Test
        public void testPending() {
            assertEquals(10000, account.pending(10000, 0.001, 12, 0), 0.01);
            assertEquals(8341.651389, account.pending(10000, 0.001, 12, 2), 0.01);
        }
    } 
