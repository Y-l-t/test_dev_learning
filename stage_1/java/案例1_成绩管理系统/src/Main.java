import java.util.Scanner;
import java.util.Arrays;
public class Main {
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        System.out.println("请输入班级学生人数");
        int studentCount=scanner.nextInt();
        scanner.nextLine();
        String[] names=new String[studentCount];
        double[] scores=new double[studentCount];
//        录入学生成绩
        System.out.println("录入成绩");
        for(int i=0;i<studentCount;i++){
            System.out.println("请输入第"+(i+1)+"个学生姓名");
            names[i]= scanner.nextLine();
            System.out.println("请输入第"+(i+1)+"个学生成绩");
            scores[i]=scanner.nextDouble();
            scanner.nextLine();
        }
//        菜单交互
        while(true){
            System.out.println("=====成绩管理系统=====");
            System.out.println("1.查看所有学生成绩");
            System.out.println("2.统计最高分、平均分、最低分");
            System.out.println("3.按成绩排序（从高到低）");
            System.out.println("4.查询某个学生的成绩");
            System.out.println("5.退出系统");
            System.out.println("请选择操作");
            int choice=scanner.nextInt();
            switch (choice){
                case 1:
                    System.out.println("所有学生成绩如下：");
                    for(int i=0;i<studentCount;i++){
                        System.out.println(names[i]+":"+scores[i]+"分");
                    }break;
                case 2:
                    System.out.println("最高分、最低分、平均分如下：");
                    double max = scores[0], min = scores[0], sum = 0;
                    for(int i=0;i<studentCount;i++) {
                        if (scores[i] > max) max = scores[i];
                        if (scores[i] < min) min = scores[i];
                        sum += scores[i];
                    }
                        System.out.println("最高分："+max);
                        System.out.println("最低分："+min);
                        System.out.println("平均分："+sum/studentCount);
                        break;
                case 3:
                    System.out.println("排名如下");
//                    数组复制
                    double[] sortedscores=Arrays.copyOf(scores,scores.length);
                    String[] sortednames=Arrays.copyOf(names,names.length);
                    for(int i=0;i<studentCount-1;i++) {
                        for(int j=0;j<studentCount-1-i;j++){
                            if(sortedscores[j]<sortedscores[j+1]){
                                double temp=sortedscores[j];
                                sortedscores[j]=sortedscores[j+1];
                                sortedscores[j+1]=temp;
                                String tempname=sortednames[j];
                                sortednames[j]=sortednames[j+1];
                                sortednames[j+1]=tempname;
                            }
                        }
                    }
                    for(int i=0;i<sortednames.length;i++){
                        System.out.println("第"+(i+1)+"名"+sortednames[i]+":"+sortedscores[i]);
                    }break;

                case 4:
                    System.out.print("请输入查询学生姓名：");
                    scanner.nextLine();
                    String name=scanner.nextLine();
                    int index=-1;
                    for(int i=0;i<studentCount;i++) {
                        if (names[i].equals(name)) {
                            index = i;
                        }
                    }
                        if(index!=-1){
                            double score=scores[index];
                            String grade;
                            if(score>90)
                                grade="优秀";
                            if(score>80)
                                grade="良好";
                            if(score>60)
                                grade="及格";
                            else grade="不及格";
                            System.out.println(name+":成绩是"+score+"  等级:"+grade);
                        }else{
                            System.out.println("未找到该学生");
                        }
                    break;

                case 5:
                    System.out.println("感谢使用，再见");
                    scanner.close();
                    return;
                default:
                    System.out.println("无效选择");
            }
        }
    }
}