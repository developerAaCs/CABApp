package aacs.com.np.cabapp.SQLite;

/**
 * Created by Dell on 8/25/2017.
 */
public class Notification {
    public Notification(String title, String body) {
        this.setTitle(title);
        this.setBody(body);
    }

    private String title,body;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
