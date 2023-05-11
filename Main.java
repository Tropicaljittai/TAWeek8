import javax.lang.model.element.Element;
import javax.sound.midi.Soundbank;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Scanner;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

public class Main {

    public static <T> void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.add(1);
        bst.add(16);
        bst.add(3);
        bst.add(20);
        bst.add(6);
        bst.add(18);
        bst.add(9);
        bst.add(11);

        System.out.println(bst.size());
        System.out.println(bst.sumOfItems());
        System.out.println(bst.maxNum());
    }
}
