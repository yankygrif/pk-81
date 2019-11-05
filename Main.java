package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        String example = "Аристотель написал для Александра Македонского книгу о том, как надо царствовать и как необходимо для царя быть добрым. И вот" + ", кажется, Аристотель выполнил свою задачу. Сегодня я не царствовал, говорил иной раз Александр" + ", ведь я никому не делал добра. Участие Аристотеля в воспитании Александра Македонского помогло тому стать человеком, " + "обладающим глубокими знаниями в различных областях, но в целом попытка философа оказалась столь же неудачной, " + "как и стремление Платона создать идеальное государство в Сицилии. По мере того, как Александр Македонский завоевывал одну страну за другой, " + "он становился все более коварным, невоздержанным и скорым на расправу с теми, кто смел ему возражать. Уроки Аристотеля забывались, " + "а дурной нрав Александра брал верх. Вместо благородного царя из Александра Македонского получился коварный завоеватель. Может быть, " + "именно этот неудачный педагогический эксперимент и привел Аристотеля к убеждению, " + "вопреки Сократу, что знание же имеет малое значение или вовсе его не имеет по отношению к добродетели и что большее значение имеют привычки, " + "сформировавшиеся с первых лет жизни ребенка.";
        Text sorted = new Text(example);
        System.out.println(sorted.toSortedString());
    }
}

class Text {
    public List<Sentence> text = new ArrayList<>();

    Text(String information) {
        String[] sentences = information.split("[.!?]");
        for (String a : sentences) {
            a = a.toLowerCase().replace(",", "").trim();
            if (!a.isEmpty()) {
                text.add(new Sentence(a));
            }
        }
    }

    String toSortedString() {
        ArrayList<String> temporary = new ArrayList<String>();
        for (int i = 0; i < text.size(); i++) {
            String[] var = ((text.get(i)).toString()).split("[ ]");
            for (int j = 0; j < var.length; j++) {
                temporary.add(var[j]);
            }
        }
        Collections.sort(temporary, Comparator.comparing(o -> o.length() > 1 ? o.charAt(1) : 0));
        return temporary.toString();
    }
}

class Sentence {
    private StringBuffer words = new StringBuffer();

    Sentence(String sentence) {
        String[] wordsInSentence = sentence.split("[ ]");
        for (String a : wordsInSentence) {
            if (a.length() > 2 && a.matches("^(?i:[аеёиоуюяы]).*")) {
                words.append(a + " ");
            }
        }
    }

 public String toString() {
        String res = words.toString();
        return res;
    }
}

