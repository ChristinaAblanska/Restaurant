package restaurant;

public class HistoryLog {
    private final StringBuilder data = new StringBuilder();

    public void addData(String data) {
        this.data.append(data).append("<>");
    }

    public void print() {
        String[] text = String.valueOf(data).split("<>");
        for (String s : text) {
            System.out.println(s);
        }
    }
}
