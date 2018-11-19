package mr.joinmr;

import org.apache.hadoop.io.Writable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class InfoBean implements Writable {
    private String id;
    private String date;
    private String pname;
    private double price;
    private char flag;

    public InfoBean() {
    }

    public InfoBean(String id, String date, String pname, double price, char flag) {
        this.id = id;
        this.date = date;
        this.pname = pname;
        this.price = price;
        this.flag = flag;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public char getFlag() {
        return flag;
    }

    public void setFlag(char flag) {
        this.flag = flag;
    }


    // 这是序列化和反序列化的方法
    @Override
    public void write(DataOutput out) throws IOException {
        out.writeUTF(id);
        out.writeUTF(date);
        out.writeUTF(pname);
        out.writeDouble(price);
        out.writeChar(flag);
    }

    @Override
    public void readFields(DataInput in) throws IOException {
        id=in.readUTF();
        date=in.readUTF();
        pname=in.readUTF();
        price=in.readDouble();
        flag=in.readChar();
    }

    @Override
    public String toString() {
        return "id:"+id+"\tdate:"+date+"\tpname:"+pname+"\tprice:"+price;
    }
}
