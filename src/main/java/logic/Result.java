package logic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Result {
    private String name;
    private String surmane;
    private Gender gender;
    private Course course;
    private Drink drink;

    private static List<Result> results = new ArrayList<>();

    private static Map<String, List<Result>> personalResults = new HashMap<>();


    public Result() {
        results.add(this);
    }

    public Result(String login){
        results.add(this);
        if(personalResults.containsKey(login))personalResults.get(login).add(this);
        else personalResults.put(login, new ArrayList<>(List.of(this)));
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurmane() {
        return surmane;
    }

    public void setSurmane(String surmane) {
        this.surmane = surmane;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Course getClas() {
        return course;
    }

    public void setClas(Course course) {
        this.course = course;
    }

    public Drink getDrink() {
        return drink;
    }

    public void setDrink(Drink drink) {
        this.drink = drink;
    }

    public static List<Result> getList(){
        return results;
    }

    public static Map<String, List<Result>> getMap(){
        return personalResults;
    }

    public static String getStat(List<Result> results){
        int m = 0, fm = 0, j = 0, fs = 0, b = 0, v = 0;
        for(Result result : results){
            if(result.getGender() != null){
                if (result.getGender().equals(Gender.male)) m++;
                else fm++;
            }
            if(result.getClas() != null){
                if(result.getClas().equals(Course.java)) j++;
                else fs++;
            }
            if(result.getDrink() != null){
                if(result.getDrink().equals(Drink.beer)) b++;
                else v++;
            }
        }
        return m + " male<br>" + fm + " female<br>" + j + " java<br>" + fs + " full-stack<br>" + b + " beer<br>" + v + " vine<br>";
    }

    public static void addPersonalResult(String login){

    }
}
