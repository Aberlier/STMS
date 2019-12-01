package com.zy.user.domain;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;

/**
 * @Author ZZG
 * @Date 2019/9/28 16:49
 * @Version v1.0.0
 */
public class ScoreExcel  extends BaseRowModel {

    private String ename;



    @ExcelProperty(value = "学号", index = 0)
    private int sid;

    private int eid;

    private int exam;



    @ExcelProperty(value = "姓名", index = 1)
    private String sname;

    @ExcelProperty(value = "语文", index = 2)
    private String chinese;

    @ExcelProperty(value = "数学", index = 3)
    private String math;

    @ExcelProperty(value = "英语", index = 4)
    private String english;

    @ExcelProperty(value = "物理", index = 5)
    private String physics;

    @ExcelProperty(value = "化学", index = 6)
    private String chemistry;

    @ExcelProperty(value = "政治", index = 7)
    private String politics;

    @ExcelProperty(value = "历史", index = 8)
    private String history;

    @ExcelProperty(value = "地理", index = 9)
    private String geography;

    @ExcelProperty(value = "生物", index = 10)
    private String biology;

    @ExcelProperty(value = "平均分", index = 12)
    private String avg;
    @ExcelProperty(value = "总分", index = 11)
    private int sum;

    private String award;
    @ExcelProperty(value = "区域排名", index = 13)
    private String regionalranking;
    @ExcelProperty(value = "总排名", index = 14)
    private String provincialranking;
    private String headmaster;

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public int getEid() {
        return eid;
    }

    public void setEid(int eid) {
        this.eid = eid;
    }

    public int getExam() {
        return exam;
    }

    public void setExam(int exam) {
        this.exam = exam;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getChinese() {
        return chinese;
    }

    public void setChinese(String chinese) {
        this.chinese = chinese;
    }

    public String getMath() {
        return math;
    }

    public void setMath(String math) {
        this.math = math;
    }

    public String getEnglish() {
        return english;
    }

    public void setEnglish(String english) {
        this.english = english;
    }

    public String getPhysics() {
        return physics;
    }

    public void setPhysics(String physics) {
        this.physics = physics;
    }

    public String getChemistry() {
        return chemistry;
    }

    public void setChemistry(String chemistry) {
        this.chemistry = chemistry;
    }

    public String getPolitics() {
        return politics;
    }

    public void setPolitics(String politics) {
        this.politics = politics;
    }

    public String getHistory() {
        return history;
    }

    public void setHistory(String history) {
        this.history = history;
    }

    public String getGeography() {
        return geography;
    }

    public void setGeography(String geography) {
        this.geography = geography;
    }

    public String getBiology() {
        return biology;
    }

    public void setBiology(String biology) {
        this.biology = biology;
    }

    public String getAvg() {
        return avg;
    }

    public void setAvg(String avg) {
        this.avg = avg;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public String getAward() {
        return award;
    }

    public void setAward(String award) {
        this.award = award;
    }

    public String getRegionalranking() {
        return regionalranking;
    }

    public void setRegionalranking(String regionalranking) {
        this.regionalranking = regionalranking;
    }

    public String getProvincialranking() {
        return provincialranking;
    }

    public void setProvincialranking(String provincialranking) {
        this.provincialranking = provincialranking;
    }

    public String getHeadmaster() {
        return headmaster;
    }

    public void setHeadmaster(String headmaster) {
        this.headmaster = headmaster;
    }
    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    @Override
    public String toString() {
        return "ScoreExcel{" +
                "ename='" + ename + '\'' +
                ", sid=" + sid +
                ", eid=" + eid +
                ", exam=" + exam +
                ", sname='" + sname + '\'' +
                ", chinese='" + chinese + '\'' +
                ", math='" + math + '\'' +
                ", english='" + english + '\'' +
                ", physics='" + physics + '\'' +
                ", chemistry='" + chemistry + '\'' +
                ", politics='" + politics + '\'' +
                ", history='" + history + '\'' +
                ", geography='" + geography + '\'' +
                ", biology='" + biology + '\'' +
                ", avg='" + avg + '\'' +
                ", sum=" + sum +
                ", award='" + award + '\'' +
                ", regionalranking='" + regionalranking + '\'' +
                ", provincialranking='" + provincialranking + '\'' +
                ", headmaster='" + headmaster + '\'' +
                '}';
    }
}
