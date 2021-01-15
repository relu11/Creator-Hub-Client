package Models;

import java.io.File;
import java.io.IOException;

public class ImagePost extends Post {
    private PostContent content;

    public ImagePost() {
        super();
    }

    public Object getContent() {
        return content;
    }

    public void setContent(PostContent content) {
        this.content = content;
    }


}
