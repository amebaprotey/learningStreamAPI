import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        List<User> users = new ArrayList<>(100);
        for (int i = 0; i <= 100; i++){
            users.add(
                    new User(random.nextInt(20), i * random.nextInt(1000), "user" + i, random.nextInt(120),
                            random.nextInt(10) % 2 == 0 ? Sex.MALE : Sex.FEMALE));
        }

        Map<Integer, String> map = new HashMap<>();
        Set<User> set = new HashSet<>(users);
        System.out.println(set.size());
        for (User user : set){
            if (user.getSex().equals(Sex.FEMALE) && user.getAge() > 28){
                map.put(user.getPhone(), user.getName());
                user.setWinner(true);
            }
        }
        System.out.println(map.size());
        System.out.println(users.stream().distinct().filter(user -> user.getSex().equals(Sex.FEMALE) && user.getAge() > 28)
                .peek(user -> user.setWinner(true)).collect(Collectors.toList()).get(0).isWinner());

        users.stream();


    }

}
