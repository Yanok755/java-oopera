import java.util.ArrayList;
import java.util.List;

class Show {
    protected String title;
    protected int duration; // в минутах
    protected Director director;
    protected List<Actor> listOfActors = new ArrayList<>();

    public Show(String title, int duration, Director director) {
        this.title = title;
        this.duration = duration;
        this.director = director;
    }

    public void printDirectorInfo() {
        System.out.println("Режиссёр: " + director.toString());
    }

    public void printActors() {
        if (listOfActors.isEmpty()) {
            System.out.println("Список актёров пуст.");
            return;
        }
        System.out.println("Актёры спектакля \"" + title + "\":");
        for (Actor actor : listOfActors) {
            System.out.println("- " + actor.toString());
        }
    }

    public void addActor(Actor actor) {
        if (listOfActors.contains(actor)) {
            System.out.println("Актёр " + actor.getName() + " " + actor.getSurname() + " (" + actor.getHeight() + " см) уже присутствует в спектакле \"" + title + "\".");
            return;
        }
        listOfActors.add(actor);
        System.out.println("Актёр " + actor.getName() + " " + actor.getSurname() + " добавлен в спектакль \"" + title + "\".");
    }

    public void replaceActor(Actor newActor, String oldActorSurname) {
        boolean found = false;
        for (int i = 0; i < listOfActors.size();i++) {
            if (listOfActors.get(i).getSurname().equalsIgnoreCase(oldActorSurname)) {
                listOfActors.set(i, newActor);
                System.out.println("Актёр с фамилией \"" + oldActorSurname + "\" заменён на " + newActor.getName() + " " + newActor.getSurname() + " в спектакле \"" + title + "\".");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Актёр с фамилией \"" + oldActorSurname + "\" не найден в спектакле \"" + title + "\".");
        }
    }
}
