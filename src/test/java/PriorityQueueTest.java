import java.util.IllformedLocaleException;
import java.util.NoSuchElementException;
import java.util.PriorityQueue;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.*;

public class PriorityQueueTest {

    static Stream<Arguments> stringIntAndListProvider(){
        return Stream.of(
                Arguments.of(new int[]{3,2,1}, new int[]{1,2,3}),
                Arguments.of(new int[]{-3,-1,-2}, new int[]{-3,-2,-1}),
                Arguments.of(new int[]{-6,-8,2,5,3}, new int[]{-8,-6,2,3,5}),
                Arguments.of(new int[]{0,-1,1,-2,2}, new int[]{-2,-1,0,1,2}),
                Arguments.of(new int[]{8,5,-2,0}, new int[]{-2,0,5,8})
        );
    }

    @ParameterizedTest(name = "#{index} - Test with Argument = {0}, {1}")
    @MethodSource("stringIntAndListProvider")
    public void priorityQueue_RunTest(int [] random_array, int[] correct_array){
        PriorityQueue<Integer> test = new PriorityQueue<>();
        int index = 0;
        Integer s;
        int[] result = new int[random_array.length];

        //ToDo random_array add to PriorityQueue
        for(int i = 0; i < random_array.length; i++){
            test.offer(random_array[i]+1);
        }

        //ToDo get PriorityQueue result
        for(int i = 0; i < random_array.length; i++){
            result[i] = test.poll();
        }

        assertArrayEquals(correct_array, result);
    }

    //ToDo 3 unique Exceptions

    @Test
    public void whenExceptionThrown_NoSuchElementException1() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            PriorityQueue test = new PriorityQueue<>(0);
        });
    }

    @Test
    public void whenExceptionThrown_NoSuchElementException2(){
        Exception exception = assertThrows(NullPointerException.class, ()->{
            PriorityQueue test = new PriorityQueue<>();
            test.offer(null);
        });
    }

    @Test
    public void whenExceptionThrown_NoSuchElementException(){
        Exception exception = assertThrows(NullPointerException.class, ()->{
            PriorityQueue test = new PriorityQueue<>();
            test.add(null);
        });
    }

}
