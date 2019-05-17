package refType;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author: liubosong
 * @version: 1.0
 * @date: 2019-05-01 10:14
 **/
public class NewsItem implements Comparable<NewsItem> {
    private String newsTitle;
    private int newsHits;
    private Date publishTime;

    /**
     * 先 时间降序，点击量升序，标题降序
     *
     * @param o
     * @return
     */
    @Override
    public int compareTo(NewsItem o) {
        int result = 0;
        result = -this.publishTime.compareTo(o.publishTime);
        if (0 == result) {
            result = -(this.newsHits - o.newsHits);
            if (0 == result) {
                result = -this.newsTitle.compareTo(o.newsTitle);
            }
        }
        return result;
    }


    public NewsItem() {
    }

    public NewsItem(String newsTitle, int newsHits, Date publishTime) {
        this.newsTitle = newsTitle;
        this.newsHits = newsHits;
        this.publishTime = publishTime;
    }


    @Override
    public String toString() {
        return "标题\t" + this.newsTitle + "\t点击量\t" + this.newsHits + "\t发布时间\t" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(this.publishTime) + "\n";
    }

    public String getNewsTitle() {
        return newsTitle;
    }

    public void setNewsTitle(String newsTitle) {
        this.newsTitle = newsTitle;
    }

    public int getNewsHits() {
        return newsHits;
    }

    public void setNewsHits(int newsHits) {
        this.newsHits = newsHits;
    }

    public Date getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Date publishTime) {
        this.publishTime = publishTime;
    }


}
