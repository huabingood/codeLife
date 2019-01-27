package udfSource;

import org.apache.hadoop.hive.ql.exec.UDF;
import org.apache.hadoop.io.BytesWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;

import java.util.Arrays;



public class SubString extends UDF {

    private final int[] index;
    private final Text r;

    public SubString() {
        index = new int[2];
        r = new Text();
    }

    public Text evaluate(Text t, IntWritable pos, IntWritable len) {

        if ((t == null) || (pos == null) || (len == null)) {
            return null;
        }

        r.clear();
        if ((len.get() <= 0)) {
            return r;
        }

        String s = t.toString();
        int[] index = makeIndex(pos.get(), len.get(), s.length());
        if (index == null) {
            return r;
        }

        r.set(s.substring(index[0], index[1]));
        return r;
    }

    private int[] makeIndex(int pos, int len, int inputLen) {
        if ((Math.abs(pos) > inputLen)) {
            return null;
        }

        int start, end;

        if (pos > 0) {
            start = pos - 1;
        } else if (pos < 0) {
            start = inputLen + pos;
        } else {
            start = 0;
        }

        if ((inputLen - start) < len) {
            end = inputLen;
        } else {
            end = start + len;
        }
        index[0] = start;
        index[1] = end;
        return index;
    }

    private final IntWritable maxValue = new IntWritable(Integer.MAX_VALUE);

    public Text evaluate(Text s, IntWritable pos) {
        return evaluate(s, pos, maxValue);
    }

    public BytesWritable evaluate(BytesWritable bw, IntWritable pos, IntWritable len) {

        if ((bw == null) || (pos == null) || (len == null)) {
            return null;
        }

        if ((len.get() <= 0)) {
            return new BytesWritable();
        }

        int[] index = makeIndex(pos.get(), len.get(), bw.getLength());
        if (index == null) {
            return new BytesWritable();
        }

        return new BytesWritable(Arrays.copyOfRange(bw.getBytes(), index[0], index[1]));
    }

    public BytesWritable evaluate(BytesWritable bw, IntWritable pos){
        return evaluate(bw, pos, maxValue);
    }
}