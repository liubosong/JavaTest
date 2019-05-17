package byteCode;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: liubosong
 * @version: 1.0
 * @date: 2019-04-29 14:57
 **/
public class SplitFile {
    private String fileName;
    private String filePath;
    private int size;
    private long blockSize;
    private long length;
    private List<String> blockPath;

    public SplitFile() {
        blockPath = new ArrayList<String>();
    }

    public SplitFile(String filePath) {
        this(filePath, 1024);
    }

    public SplitFile(String filePath, long blockSize) {
        this();
        this.filePath = filePath;
        this.blockSize = blockSize;
        init();
    }

    public void init() {
        File srcFile = null;
        if (null == filePath) {
            return;
        }
        srcFile = new File(filePath);
        if (!srcFile.exists()) {
            return;
        }
        if (srcFile.isDirectory()) {
            return;
        }
        this.fileName = srcFile.getName();
        this.length = srcFile.length();
        if (this.blockSize > length) {
            this.blockSize = length;
        }
        size = (int) (Math.ceil(length * 1.0 / this.blockSize));

    }

    private void initPathName(String descPath) {
        for (int i = 0; i < size; i++) {
            this.blockPath.add(descPath + this.fileName + ".part" + i);
        }
    }


    public void split(String descpath) {
        initPathName(descpath);
        long beginPos = 0;
        long actualBlockSize = this.blockSize;
        for (int i = 0; i < size; i++) {
            if (i == size - 1) {
                actualBlockSize = this.length - beginPos;
            }
            splitDetail(i, beginPos, actualBlockSize);
            beginPos += actualBlockSize;
        }
    }

    private void splitDetail(int index, long beginPos, long actualBlockSize) {
        File srcFile = new File(filePath);
        File descFile = new File(this.blockPath.get(index));
        RandomAccessFile raf = null;
        BufferedOutputStream bops = null;
        try {
            raf = new RandomAccessFile(srcFile, "r");
            bops = new BufferedOutputStream(new FileOutputStream(descFile));
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(descFile)));
            raf.seek(beginPos);
            int len = 0;
            byte[] flush = new byte[1024];
            while (-1 != (len = raf.read(flush))) {
                if (len < actualBlockSize) {
                    bops.write(flush, 0, len);
                }
                bops.write(flush, 0, (int) actualBlockSize);
                break;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                raf.close();
                bops.flush();
                bops.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }


    }


}
