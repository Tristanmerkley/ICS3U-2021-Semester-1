package week13;

import java.util.ArrayList;

public class MusicDownloads {

    private ArrayList<DownloadInfo> downloadList;

    public MusicDownloads() {
        downloadList = new ArrayList<DownloadInfo>();
    }

    public DownloadInfo getDownloadInfo(String title) {
        for (DownloadInfo di : downloadList) {
            if (title.equals(di.getTitle()))
                return di;
        }
        return null;
    }

    public void updateDownloads(ArrayList<String> titles) {
        for (String title : titles) {
            DownloadInfo di = getDownloadInfo(title);
            if (di == null) {
                di = new DownloadInfo(title);
                downloadList.add(di);
            }
            di.incrementTimesDownloaded();
        }
    }
}
