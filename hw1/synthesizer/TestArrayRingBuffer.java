package synthesizer;
import org.junit.Test;
import static org.junit.Assert.*;

/** Tests the ArrayRingBuffer class.
 *  @author Josh Hug
 */

public class TestArrayRingBuffer {
    @Test
    public void someTest() {
        ArrayRingBuffer arb = new ArrayRingBuffer(10);
        arb.enqueue("a");
        arb.enqueue("b");
        arb.enqueue("c");
        arb.enqueue("d");
        arb.enqueue("e");
        arb.enqueue("f");
        arb.enqueue("g");
        arb.enqueue("h");
        arb.enqueue("i");
        arb.enqueue("j");
//        arb.enqueue("no");
        arb.peek();
        arb.dequeue();
        arb.dequeue();
        arb.dequeue();
        arb.dequeue();
        assertEquals("e", arb.peek());
    }

    /** Calls tests for ArrayRingBuffer. */
    public static void main(String[] args) {
        jh61b.junit.textui.runClasses(TestArrayRingBuffer.class);
    }
} 
