import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FunctionalExample {

    public static void main(String[] args) {
        new FunctionalExample();
    }

    private FunctionalExample() {
        List<Object> objectList = List.of("Hey", "Ho", "Ha", "Hey", 1);
        for (Object part :
                objectList) {
            if (part instanceof String) {
                System.out.println(part.toString());
            }
            System.out.println(part);
        }
        objectList.stream().forEach(part -> System.out.println(part));
        Optional<Integer> hey = objectList.stream().filter(part -> part instanceof Integer).map(Integer.class::cast).findFirst();

        Function<Integer,Integer> add1 = x -> x + 1;
        List<Integer> numbers = List.of(1,2,4);
        System.out.println("Lambda example");
        numbers.forEach(n -> System.out.println(add1.apply(n)));

        List<AbstractFruit> fruits = List.of(new Mango(12), new Cherry(8), new Mango(9), new Cherry(7), new Cherry(6));
        List<Cherry> cherries = new ArrayList<>();
        List<Cherry> smallCherries = new ArrayList<>();

        for (AbstractFruit fruit: fruits) {
            if(fruit instanceof Cherry) {
                cherries.add((Cherry) fruit);
            }
        }
        for (Cherry cherry: cherries) {
            if(cherry.getWeight() <= 7) {
                smallCherries.add(cherry);
            }
        }
        System.out.println(cherries.size());
        System.out.println(smallCherries.size());

        List<Cherry> cherryList = fruits.stream().//
                filter(fruit -> fruit instanceof Cherry).//
                map(Cherry.class::cast).//
                filter(cherry -> cherry.getWeight() <= 7).//
                collect(Collectors.toList());

        System.out.println(cherryList.size());
    }

    class AbstractFruit {

        private int weight;

        AbstractFruit(int weight){
            this.weight = weight;
        }

        public int getWeight() {
            return weight;
        }
    }

    class Mango extends AbstractFruit {

        Mango(int weight) {
            super(weight);
        }
    }

    class Cherry extends AbstractFruit {

        Cherry(int weight) {
            super(weight);
        }
    }

}
