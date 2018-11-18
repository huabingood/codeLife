package mr.sortmr;

import org.apache.hadoop.io.WritableComparable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class SortFlowBean implements WritableComparable<SortFlowBean> {
    private long upFlow;
    private long downFlow;
    private long sumFlow;

    public SortFlowBean() {
    }

    public SortFlowBean(long upFlow, long downFlow, long sumFlow) {
        this.upFlow = upFlow;
        this.downFlow = downFlow;
        this.sumFlow = upFlow + downFlow;
    }

    public long getUpFlow() {
        return upFlow;
    }

    public void setUpFlow(long upFlow) {
        this.upFlow = upFlow;
    }

    public long getDownFlow() {
        return downFlow;
    }

    public void setDownFlow(long downFlow) {
        this.downFlow = downFlow;
    }

    /**
     * 根据何种规则比较两个对象的大小
     * 返回1 表示升序 从小到大
     * 返回-1 表示降序 从大到小
     * @param o
     * @return
     */
    @Override
    public int compareTo(SortFlowBean o) {
        return this.sumFlow>o.sumFlow?-1:1;
    }

    @Override
    public void write(DataOutput out) throws IOException {
        out.writeLong(upFlow);
        out.writeLong(downFlow);
        out.writeLong(sumFlow);
    }

    @Override
    public void readFields(DataInput in) throws IOException {
        upFlow = in.readLong();
        downFlow = in.readLong();
        sumFlow = in.readLong();
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
