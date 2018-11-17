package mr.partitionsAndSerize;

import org.apache.hadoop.io.Writable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

/**
 * 实现了Hadoop的序列化的类。
 *  实际上实现Writable类是只有序列化的
 *  实现WritableComparable<实现这个借口的类>是不仅有序列化类还提供了比较规则
 */
public class FlowBean implements Writable {
    private long upflow;
    private long downflow;
    private long total;

    public FlowBean() {
    }

    public FlowBean(long upflow, long downflow) {
        this.upflow = upflow;
        this.downflow = downflow;
        this.total = upflow+downflow;
    }

    public long getUpflow() {
        return upflow;
    }

    public void setUpflow(long upflow) {
        this.upflow = upflow;
    }

    public long getDownflow() {
        return downflow;
    }

    public void setDownflow(long downflow) {
        this.downflow = downflow;
    }

    /**
     * 序列化方法
     * @param dataOutput
     * @throws IOException
     */
    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeLong(upflow);
        dataOutput.writeLong(downflow);
        dataOutput.writeLong(total);
    }

    /**
     * 反序列化方法
     * 序列化字段的顺序就是反序列化的顺序
     * @param dataInput
     * @throws IOException
     */
    @Override
    public void readFields(DataInput dataInput) throws IOException {
        upflow = dataInput.readLong();
        downflow = dataInput.readLong();
        total = dataInput.readLong();
    }

    @Override
    public String toString() {
        return "上行流量是："+upflow+",下行流量是："+downflow+"，总流量是："+total+"。";
    }
}
